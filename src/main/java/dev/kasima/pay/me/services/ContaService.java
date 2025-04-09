package dev.kasima.pay.me.services;

import dev.kasima.pay.me.entity.Conta;
import dev.kasima.pay.me.repository.ContaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContaService {

    private final ContaRepository contaRepository;

    public void salvar(Conta conta) {
        contaRepository.save(conta);

    }
}
