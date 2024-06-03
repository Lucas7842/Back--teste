package org.example.Controller;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import lombok.RequiredArgsConstructor;
import org.example.Model.Usuario;
import org.example.Service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    private static final Logger logger = LogManager.getLogger(UsuarioController.class);
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Usuario usuario) {
        logger.info("Requisição para criar usuário recebida");
        try {
            Usuario user = usuarioService.salvar(usuario);
            logger.info("Usuário criado com sucesso: {}", user);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } catch (Exception e) {
            logger.error("Erro ao criar usuário: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar usuário: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        logger.info("Requisição para buscar usuário por ID recebida: {}", id);
        try {
            Usuario user = usuarioService.buscarPorId(id);
            if (user == null) {
                logger.warn("Usuário não encontrado: {}", id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
            }
            logger.info("Usuário encontrado: {}", user);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            logger.error("Erro ao buscar usuário por ID: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar usuário: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Usuario usuario) {
        logger.info("Requisição para login recebida");

        try {
            // Verificar se o email e a senha foram fornecidos
            if (usuario.getEmail() == null || usuario.getSenha() == null) {
                logger.warn("Email ou senha não fornecidos");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email e senha são obrigatórios");
            }

            // Buscar usuário pelo email
            Usuario user = usuarioService.buscarPorEmail(usuario.getEmail());

            // Verificar se o usuário existe
            if (user == null) {
                logger.warn("Usuário não encontrado para o email fornecido: {}", usuario.getEmail());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
            }

            // Verificar se a senha está correta
            if (!usuario.getSenha().equals(user.getSenha())) {
                logger.warn("Senha incorreta para o usuário com o email: {}", usuario.getEmail());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta");
            }

            logger.info("Login bem-sucedido para o usuário: {}", user.getEmail());
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            logger.error("Erro ao realizar o login: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao realizar o login: " + e.getMessage());
        }
    }
}