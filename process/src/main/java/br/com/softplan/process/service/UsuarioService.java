package br.com.softplan.process.service;

import java.util.List;

import br.com.softplan.process.model.Usuario;

public interface UsuarioService {

    Usuario salvarUsuario(Usuario usuario);

    List<Usuario> listarTodosUsuarios();
    
    void excluirUsuario(Integer usuarioId);
    
    Usuario retornaDadosUsuario(Integer usuarioId);
        
    Usuario logarUsuario(String login, String senha);    
    
}
