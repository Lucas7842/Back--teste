package org.example.Controller;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import lombok.RequiredArgsConstructor;
import org.example.Model.Usuario;
import org.example.Service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    Logger logger = LogManager.getLogger(this.getClass());
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Usuario usuario) {
        logger.info("Create acessado UsuarioController");
        try {
            Usuario user = usuarioService.salvar(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } catch (Exception e) {
            logger.error("Erro ao criar usuário: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar usuário: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            Usuario user = usuarioService.buscarPorId(id);
            if (user == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
            }
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            logger.error("Erro ao buscar usuário por ID: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar usuário: " + e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updatePassword(@PathVariable long id, @RequestBody Usuario usuario) {
        try {
            Usuario user = usuarioService.editarSenha(id, usuario.getSenha());
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            logger.error("Erro ao atualizar senha do usuário: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar senha: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        try {
            Usuario user = usuarioService.deletarCadastro(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            logger.error("Erro ao deletar usuário: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar usuário: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            List<Usuario> users = usuarioService.buscarTodos();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            logger.error("Erro ao buscar todos os usuários: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar usuários: " + e.getMessage());
        }
    }
}
