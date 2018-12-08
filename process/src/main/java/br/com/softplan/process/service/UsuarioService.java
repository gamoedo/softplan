package br.com.softplan.process.service;

import java.util.List;

import br.com.softplan.process.model.Usuario;
import javassist.NotFoundException;

public interface UsuarioService {

    Usuario salvarUsuario(Usuario usuario);

    List<Usuario> listarTodosUsuarios();
    
    void excluirUsuario(Integer usuarioId) throws NotFoundException;
    
    Usuario retornaDadosUsuario(Integer usuarioId) throws NotFoundException;
        
    Usuario logarUsuario(String login, String senha) throws NotFoundException;    
    
}
