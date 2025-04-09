package dev.kasima.pay.me.services;

import dev.kasima.pay.me.entity.Usuario;
import dev.kasima.pay.me.exceptions.UserNotFound;
import dev.kasima.pay.me.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario buscarUsuario(Long id) {
        return usuarioRepository.findById(id)
            .orElseThrow(() ->
                new UserNotFound("Usuário não foi encontrado!"));

    }
}
