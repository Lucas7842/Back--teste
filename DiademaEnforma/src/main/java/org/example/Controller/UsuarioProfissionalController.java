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
@RequestMapping("/api/v1/usuarioprofissional")


public class UsuarioProfissionalController {
    Logger logger = LogManager.getLogger(this.getClass());

    private final UsuarioProfissionalService usuarioProfissionalService;


    @PostMapping
    public ResponseEntity<UsuarioProfissional>create(@RequestBody UsuarioProfissional usuarioProfissional){
        logger.info("Create acessado UsuarioProfissionalController");

        UsuarioProfissional user = usuarioProfissionalService.salvar(usuarioProfissional);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioProfissional> getById(@PathVariable Long id){
        UsuarioProfissional user = usuarioProfissionalService.buscarPorId(id);
        return ResponseEntity.ok(user);
    }
    @PatchMapping("/{id}")
    public  ResponseEntity<UsuarioProfissional>updatePassword(@PathVariable long id, @RequestBody UsuarioProfissional usuarioProfissional){
        UsuarioProfissional user = usuarioProfissionalService.editarSenha(id, usuarioProfissional.getSenha());
        return ResponseEntity.ok(user);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioProfissional> delete(@PathVariable long id){
        UsuarioProfissional user = usuarioProfissionalService.deletarCadastro(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
   public ResponseEntity<List<UsuarioProfissional>>getAll(){
        List<UsuarioProfissional> users = usuarioProfissionalService.buscarTodos();
        return ResponseEntity.ok(users);
    }
}
