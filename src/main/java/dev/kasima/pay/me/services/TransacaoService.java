package dev.kasima.pay.me.services;

import dev.kasima.pay.me.controller.TransacaoDTO;
import dev.kasima.pay.me.entity.Conta;
import dev.kasima.pay.me.entity.TipoUsuario;
import dev.kasima.pay.me.entity.Transacao;
import dev.kasima.pay.me.entity.Usuario;
import dev.kasima.pay.me.exceptions.BadRequestException;
import dev.kasima.pay.me.repository.TransacaoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransacaoService {

    private final UsuarioService usuarioService;
    private final AutorizacaoService autorizacaoService;
    private final ContaService contaService;
    private final TransacaoRepository transacaoRepository;
    private final NotificacaoService notificacaoService;

    @Transactional
    public void transferirValores(TransacaoDTO transacaoDTO) {

        Usuario pagador = usuarioService.buscarUsuario(transacaoDTO.pagador());

        Usuario recebedor = usuarioService.buscarUsuario(transacaoDTO.recebedor());

        validaPagadorLojista(pagador);
        validarSaldoUsuario(pagador, transacaoDTO.valor());
        validarTransferencia();

        pagador.getConta().setSaldo(pagador.getConta().getSaldo().subtract(transacaoDTO.valor()));
        atualizarSaldoConta(pagador.getConta());
        recebedor.getConta().setSaldo(pagador.getConta().getSaldo().add(transacaoDTO.valor()));
        atualizarSaldoConta(recebedor.getConta());

        Transacao transacao = Transacao.builder()
                .valor(transacaoDTO.valor())
                .pagador(pagador)
                .recebedor(recebedor)
                .build();

        transacaoRepository.save(transacao);
        enviarNotificacao();
    }

    public void validaPagadorLojista(Usuario usuario) {
        try {
            if(usuario.getTipoUsuario().equals(TipoUsuario.LOJISTA)) {
                throw new IllegalArgumentException("Transação não autorizada para esse tipo de usuário!");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void validarSaldoUsuario(Usuario usuario, BigDecimal valor) {
        try {
            if (usuario.getConta().getSaldo().compareTo(valor) < 0) {
                throw new IllegalArgumentException("Transação não autorizada, saldo insuficiente");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void validarTransferencia() {
        try {
            if (!autorizacaoService.validarTransferencia()) {
                throw new IllegalArgumentException("Transação não autorizada pela API");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void atualizarSaldoConta(Conta conta) {
        contaService.salvar(conta);
    }

    private void enviarNotificacao() {
        try {
            notificacaoService.enviarNotificacao();
        } catch (HttpClientErrorException e) {
            throw new BadRequestException("Erro ao enviar notificação");
        }
    }
}
