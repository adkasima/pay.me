package dev.kasima.pay.me.repository;

import dev.kasima.pay.me.entity.Conta;
import dev.kasima.pay.me.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
