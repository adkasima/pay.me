package dev.kasima.pay.me.services;

import dev.kasima.pay.me.infrastructure.clients.AutorizacaoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AutorizacaoService {

    private final AutorizacaoClient client;

    public boolean validarTransferencia() {
        if (Objects.equals(client.validaAutorizacao().data().authorization(), "true")) {
            return true;
        }
        return false;
    }
}
