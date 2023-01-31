package com.example.pruebaspring.usuarios;

import java.security.NoSuchAlgorithmException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruebaspring.usuarios.dto.LoginDto;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    public final UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto) throws NoSuchAlgorithmException {
        return usuariosService.login(loginDto);
    }

    @PostMapping("/registro")
    public void registro(@RequestBody Usuario usuario) throws NoSuchAlgorithmException {
        usuariosService.registro(usuario);
    }
}
