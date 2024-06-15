package org.example.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Model.UsuarioProfissional;
import org.example.Service.UsuarioProfissionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioProfissionalController {
    Logger logger = LogManager.getLogger(this.getClass());

    private final UsuarioProfissionalService usuarioProfissionalService;

    @PostMapping
    public ResponseEntity<UsuarioProfissional> create(@RequestBody UsuarioProfissional usuarioProfissional) {
        logger.info("Create acessado UsuarioProfissionalController");
        UsuarioProfissional user = usuarioProfissionalService.salvar(usuarioProfissional);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioProfissional> getById(@PathVariable Long id) {
        UsuarioProfissional user = usuarioProfissionalService.buscarPorId(id);
        return ResponseEntity.ok(user);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UsuarioProfissional> updatePassword(@PathVariable long id, @RequestBody UsuarioProfissional usuarioProfissional) {
        UsuarioProfissional user = usuarioProfissionalService.editarSenha(id, usuarioProfissional.getSenha());
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioProfissional> delete(@PathVariable long id) {
        UsuarioProfissional user = usuarioProfissionalService.deletarCadastro(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioProfissional>> getAll() {
        List<UsuarioProfissional> users = usuarioProfissionalService.buscarTodos();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UsuarioProfissional usuarioProfissional) {
        logger.info("Requisição para login de usuário profissional recebida");
        try {
            // Verificar se o email e a senha foram fornecidos
            if (usuarioProfissional.getEmail() == null || usuarioProfissional.getSenha() == null) {
                logger.warn("Email ou senha não fornecidos");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email e senha são obrigatórios");
            }

            // Buscar usuário profissional pelo email
            UsuarioProfissional profissional = usuarioProfissionalService.buscarPorEmail(usuarioProfissional.getEmail());

            // Verificar se o usuário profissional existe
            if (profissional != null && usuarioProfissional.getSenha().equals(profissional.getSenha())) {
                logger.info("Login bem-sucedido para o usuário profissional: {}", profissional.getEmail());
                return ResponseEntity.ok(profissional);
            } else {
                logger.warn("Credenciais inválidas para o email: {}", usuarioProfissional.getEmail());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
            }
        } catch (Exception e) {
            logger.error("Erro ao realizar o login: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao realizar o login: " + e.getMessage());
        }
    }
}