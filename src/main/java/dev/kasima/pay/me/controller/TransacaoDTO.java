package dev.kasima.pay.me.controller;

import java.math.BigDecimal;

public record TransacaoDTO(BigDecimal valor, Long pagador, Long recebedor) {
}
