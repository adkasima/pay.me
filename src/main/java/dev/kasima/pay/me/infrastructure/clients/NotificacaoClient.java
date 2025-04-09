package dev.kasima.pay.me.infrastructure.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "notificacao", url = "https://util.devi.tools/api/v1/notify")
public interface NotificacaoClient {

    @PostMapping
    void enviarNotificacao();
}
