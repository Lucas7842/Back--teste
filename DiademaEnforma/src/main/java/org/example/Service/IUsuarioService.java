package org.example.Service;

import org.example.Model.Usuario;

import java.util.Optional;

public interface IUsuarioService {
    public Optional<Usuario> salvar(Usuario usuario);
    public Optional<Usuario> buscarPorId(Long id);
    public Optional<Usuario> editarSenha(long id, String password);
    public Optional<Usuario> deletarCadastro(long id);
    public Optional<Usuario> buscarTodos();

}
