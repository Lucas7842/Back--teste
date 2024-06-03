package org.example.Service;

import java.util.List;

import org.example.Model.Usuario;
import org.example.Model.UsuarioDTO;
import org.example.Model.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Cadastro não encontrado")
        );
    }

    public Usuario editarSenha(long id, String password) {
        Usuario user = buscarPorId(id);
        user.setSenha(password);
        return usuarioRepository.save(user);
    }

    public Usuario deletarCadastro(long id) {
        Usuario user = buscarPorId(id);
        usuarioRepository.delete(user);
        return user;
    }

    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }



    public UsuarioDTO usuarioDTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getUsuario(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha()
        );
    }
}