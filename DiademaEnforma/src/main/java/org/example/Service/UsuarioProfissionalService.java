package org.example.Service;

import org.example.Model.UsuarioProfissional;
import org.example.Model.UsuarioProfissionalDTO;
import org.example.Model.UsuarioProfissionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioProfissionalService {
    private final UsuarioProfissionalRepository usuarioProfissionalRepository;

    @Transactional
    public UsuarioProfissional salvar(UsuarioProfissional usuarioProfissional) {
        return usuarioProfissionalRepository.save(usuarioProfissional);
    }

    @Transactional(readOnly = true)
    public UsuarioProfissional buscarPorId(Long id) {
        return usuarioProfissionalRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Cadastro não encontrado")
        );
    }

    @Transactional(readOnly = true)
    public UsuarioProfissional buscarPorEmail(String email) {
        return usuarioProfissionalRepository.findByEmail(email);
    }

    @Transactional
    public UsuarioProfissional editarSenha(long id, String password) {
        UsuarioProfissional user = buscarPorId(id);
        user.setSenha(password);
        return user;
    }

    @Transactional
    public UsuarioProfissional deletarCadastro(long id) {
        UsuarioProfissional user = buscarPorId(id);
        usuarioProfissionalRepository.delete(user);
        return user;
    }

    @Transactional(readOnly = true)
    public List<UsuarioProfissional> buscarTodos() {
        return usuarioProfissionalRepository.findAll();
    }

    // Método para buscar lista de usuários
    @Transactional(readOnly = true)
    public List<UsuarioProfissional> listaDeUsuarios() {
        return buscarTodos();  // Usando o método buscarTodos para buscar todos os usuários
    }

    public UsuarioProfissional dtoParaUsuarioProfissional(UsuarioProfissionalDTO c) {
        return new UsuarioProfissional(c.profissional(), c.nome(), c.telefone(), c.areadeatuacao(), c.cnpj(), c.email(), c.senha());
    }

    public UsuarioProfissionalDTO usuarioProfissionalDTO(UsuarioProfissional c) {
        return new UsuarioProfissionalDTO(c.getProfissional(), c.getNome(), c.getTelefone(), c.getAreadeatuacao(), c.getCnpj(), c.getEmail(), c.getSenha());
    }
}