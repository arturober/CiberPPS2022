package com.example.pruebaspring.usuarios;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.pruebaspring.usuarios.dto.LoginDto;

@Service
public class UsuariosService {
    private final UsuariosRepository usuariosRepository;

    public UsuariosService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    public Usuario registro(Usuario u) throws NoSuchAlgorithmException {
        u.setPassword(encodePassword(u.getPassword()));
        return this.usuariosRepository.save(u);
    }

    public String login(LoginDto loginDto) throws NoSuchAlgorithmException {
        Optional<Usuario> opt = usuariosRepository.findByEmailAndPassword(
                loginDto.getEmail(),
                encodePassword(loginDto.getPassword()));

        Usuario u = opt.orElseThrow(
                () -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Correo y/o contraseña no válidos"));

        return getToken(u);
    }

    private String getToken(Usuario u) {
        Algorithm algorithm = Algorithm.HMAC256("contraseña");
        String token = JWT.create()
                .withIssuer("arturo")
                .withClaim("id", u.getId())
                .withIssuedAt(new Date(System.currentTimeMillis()))
                .withExpiresAt(new Date(System.currentTimeMillis() + (24 * 60 * 60 * 1000))) // Caduca en un día
                .sign(algorithm);
        return token;
    }

    private String encodePassword(String pass) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(pass.getBytes(StandardCharsets.UTF_8));
        String encodedPass = Base64.getEncoder().encodeToString(hash);
        return encodedPass;
    }
}
