package dev.kasima.pay.me.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_contas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal saldo;

    @OneToOne(mappedBy = "conta", cascade = CascadeType.ALL)
    private Usuario usuario;

    @OneToMany(mappedBy = "transacao")
    private Transacao transacao;


}
