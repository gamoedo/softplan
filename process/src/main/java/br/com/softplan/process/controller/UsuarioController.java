package br.com.softplan.process.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.softplan.process.controller.request.UsuarioRequest;
import br.com.softplan.process.exception.UnprocessableEntityException;
import br.com.softplan.process.model.Usuario;
import br.com.softplan.process.service.UsuarioService;
import javassist.NotFoundException;

@RestController
public class UsuarioController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UsuarioService usuarioService;

    @PostMapping(value = "/rest/usuario/salvar", 
	    	 consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
	    	 produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Usuario salvarUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest) throws UnprocessableEntityException {
	
	logger.info("salvarUsuario: Recebendo usuario");

	Usuario usuario;
	
	try {
	    logger.info("salvarUsuario: Convertendo usuarioRequest para usuario");
	    usuario = usuarioRequest.toModel();
	} catch (Exception e) {
	    logger.info("salvarUsuario: Conversão falhou.");
	    throw new UnprocessableEntityException();
	}
	
	usuario = usuarioService.salvarUsuario(usuario);	
	
	logger.info("salvarUsuario: Retornando usuario salvo");
	
	return usuario;
    }

    @GetMapping(value = "/rest/usuario/listar", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Usuario> listarUsuarios() {
	logger.info("listarUsuarios: Gerando lista de usuarios");
	List<Usuario> listaUsuarios = usuarioService.listarTodosUsuarios();
	return listaUsuarios;
    }

    @GetMapping(value = "/rest/usuario/buscar/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public Usuario buscarUsuario(@RequestBody @PathVariable(name = "usuarioId") Integer usuarioId) throws NotFoundException {

	logger.info("buscarUsuario: Recebendo usuarioId");
	Usuario usuario = usuarioService.retornaDadosUsuario(usuarioId);
	logger.info("buscarUsuario: Retornando usuario buscado");
	return usuario;
    }
    
    @DeleteMapping(value = "/rest/usuario/excluir/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluirUsuario(@RequestBody @PathVariable(name = "usuarioId") Integer usuarioId) throws NotFoundException {

	logger.info("excluirUsuario: Recebendo usuarioId");
	usuarioService.excluirUsuario(usuarioId);
    
    }

}
