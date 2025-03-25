package dev.kasima.pay.me.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String cpfCnpj;

    @Column(unique = true, nullable = false)
    private String email;

    private TipoUsuario tipoUsuario;

    @OneToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;

}
