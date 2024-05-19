package org.example.Service;

import lombok.RequiredArgsConstructor;
import org.example.Model.Agendamento;
import org.example.Model.AgendamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AgendamentoService {
    private final AgendamentoRepository agendamentoRepository;

    @Transactional
    public Agendamento salvar(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }
    @Transactional(readOnly = true)
    public  Agendamento buscarPorId(Long id){
        return agendamentoRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Agendamento não encontrado")
        );
    }
    @Transactional
    public Agendamento editar( long id, String data, String horario, String local){
        Agendamento user = buscarPorId(id);
        user.setData(data);
        user.setHorario(horario);
        user.setLocal(local);
        return user;

    }
    @Transactional
    public Agendamento deletar(long id){
        Agendamento user = buscarPorId(id);
        agendamentoRepository.delete(user);
        return user;
    }
    @Transactional(readOnly = true)
    public List<Agendamento> buscarTodos(){
        return agendamentoRepository.findAll();
    }
}
