package dev.kasima.pay.me.repository;

import dev.kasima.pay.me.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
