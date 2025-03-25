package dev.kasima.pay.me.repository;

import dev.kasima.pay.me.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
