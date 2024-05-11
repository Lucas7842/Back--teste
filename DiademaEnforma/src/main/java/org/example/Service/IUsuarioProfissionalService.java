package org.example.Service;

import org.example.Model.UsuarioProfissional;

import java.util.Optional;

public interface IUsuarioProfissionalService {
    public Optional<UsuarioProfissional> salvar(UsuarioProfissional usuarioProfissional);
    public Optional<UsuarioProfissional> buscarPorId(Long id);
    public Optional<UsuarioProfissional> editarSenha(long id, String password);
    public Optional<UsuarioProfissional> deletarCadastro(long id);
    public Optional<UsuarioProfissional> buscarTodos();




}
