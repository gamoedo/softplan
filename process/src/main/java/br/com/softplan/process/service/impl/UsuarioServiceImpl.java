package br.com.softplan.process.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softplan.process.model.Usuario;
import br.com.softplan.process.repository.UsuarioRepository;
import br.com.softplan.process.service.UsuarioService;
import javassist.NotFoundException;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    Logger logger = LoggerFactory.getLogger(this.getClass());    

    @Autowired
    UsuarioRepository usuarioRepository;

    
    @Override
    public Usuario salvarUsuario(Usuario usuario) {

	logger.info("salvarUsuario: Salvando usuario no repositório");
	usuarioRepository.save(usuario);

	logger.info("salvarUsuario: Retornando usuario com ID '" + usuario.getUsuarioId() + "' já salvo");
	return usuario;
	
    }
    
    @Override
    public List<Usuario> listarTodosUsuarios() {
	
	logger.info("listarTodosUsuarios: Buscando todos os usuários no repositório");
	List<Usuario> listaUsuarios = usuarioRepository.findByIsAtivoTrue(true);
	logger.info("listarTodosUsuarios: Retornando a lista dos usuários. Tamanho da Lista: " + listaUsuarios.size());

	return listaUsuarios;
	
	
    }

    @Override
    public Usuario retornaDadosUsuario(Integer usuarioId) throws NotFoundException {
	
	return buscaUsuarioPorId(usuarioId);
    }

    @Override
    public Usuario logarUsuario(String login, String senha) throws NotFoundException {

	Usuario usuario = null;

	if (login != null && senha != null) {

	    logger.info("buscaUsuarioPorId: Buscando usuário de login '" + login + "' no repositório");

	    usuario = usuarioRepository.findByLoginSenha(login, senha);

	    if (usuario == null) {
		throw new NotFoundException("");
	    }

	    logger.info("buscaUsuarioPorId: Retornando usuarioId '" + usuario.getUsuarioId() + "'");

	} else {
	    throw new NotFoundException("");
	}

	return usuario;

	
    }


    @Override
    public void excluirUsuario(Integer usuarioId) throws NotFoundException {

	Usuario usuario = buscaUsuarioPorId(usuarioId);
	
	if(usuario != null) {
	    	
	    logger.info("excluirUsuario: Deletando usuario com usuarioId '" + usuarioId + "' no repositório");
            usuarioRepository.delete(usuario);	
	    
	}else {
	    throw new NotFoundException("");
	}
	
    }
    
    protected Usuario buscaUsuarioPorId(Integer usuarioId) throws NotFoundException {

	Usuario usuario = null;

	if (usuarioId != null) {

	    logger.info("buscaUsuarioPorId: Buscando usuarioId '" + usuarioId + "' no repositório");

	    usuario = usuarioRepository.getOne(usuarioId.toString());

	    if (usuario == null) {
		throw new NotFoundException("");
	    }

	    logger.info("buscaUsuarioPorId: Retornando usuarioId '" + usuarioId + "'");

	} else {
	    throw new NotFoundException("");
	}

	return usuario;

    }


    
}