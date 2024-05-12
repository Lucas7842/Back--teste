package org.example.Service;


import org.example.Model.UsuarioDTO;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Model.Usuario;
import org.example.Model.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Cadastro não encontrado")
        );
    }

    @Transactional
    public Usuario editarSenha(long id, String password) {
        Usuario user = buscarPorId(id);
        user.setSenha(password);
        return user;
    }

    @Transactional
    public Usuario deletarCadastro(long id) {
        Usuario user = buscarPorId(id);
        usuarioRepository.delete(user);
        return user;
    }

    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();


    }

    @Transactional(readOnly = true)
    public List<Usuario> listaDeUsuarios() {
        return buscarTodos();

    }

    public Usuario dtoParaUsuario(UsuarioDTO c) {
        return new Usuario(c.usuario(),c.nome(),c.email(),c.senha(),c.datadenascimento());

    }
    public UsuarioDTO usuarioDTO(Usuario c) {
        return new UsuarioDTO(c.getUsuario(),c.getNome(),c.getEmail(),c.getSenha(),c.getDatadenascimento());
    }
}

