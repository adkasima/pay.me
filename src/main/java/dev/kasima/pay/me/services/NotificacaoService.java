package dev.kasima.pay.me.services;

import dev.kasima.pay.me.infrastructure.clients.NotificacaoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificacaoService {

    private final NotificacaoClient notificacaoClient;

    public void enviarNotificacao() {
        notificacaoClient.enviarNotificacao();
    }
}
