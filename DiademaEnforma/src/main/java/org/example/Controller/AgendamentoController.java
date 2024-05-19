package org.example.Controller;


import lombok.RequiredArgsConstructor;
import org.example.Model.Agendamento;
import org.example.Model.Usuario;
import org.example.Service.AgendamentoService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.List;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/agendamento")


public class AgendamentoController {
    Logger logger = LogManager.getLogger(this.getClass());
    private final AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<Agendamento> create(@RequestBody Agendamento agendamento) {
        logger.info("Create acessado AgendamentoController");

        Agendamento user = agendamentoService.salvar(agendamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);


    }

    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> getById(@PathVariable Long id) {
        Agendamento user = agendamentoService.buscarPorId(id);
        return ResponseEntity.ok(user);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Agendamento> update(@PathVariable long id, @RequestBody Agendamento agendamento) {
        Agendamento user = agendamentoService.editar(id, agendamento.getData(), agendamento.getHorario(), agendamento.getLocal());
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Agendamento> delete(@PathVariable long id){
        Agendamento user= agendamentoService.deletar(id);
        return ResponseEntity.ok(user);
    }
    @GetMapping
    public ResponseEntity<List<Agendamento>> getAll(){
        List<Agendamento> users = agendamentoService.buscarTodos();
        return ResponseEntity.ok(users);
    }
}
