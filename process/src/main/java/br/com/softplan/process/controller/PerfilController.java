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

import br.com.softplan.process.exception.UnprocessableEntityException;
import br.com.softplan.process.model.Perfil;
import br.com.softplan.process.service.PerfilService;
import javassist.NotFoundException;

@RestController
public class PerfilController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PerfilService perfilService;

    @PostMapping(value = "/rest/perfil/salvar", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Perfil salvarPerfil(@RequestBody @Valid Perfil perfil) throws UnprocessableEntityException {
	
	logger.info("salvarPerfil: Recebendo perfil");

	perfil = perfilService.salvarPerfil(perfil);	
	
	logger.info("salvarPerfil: Retornando perfil salvo");
	
	return perfil;
    }

    @GetMapping(value = "/rest/perfil/listar", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Perfil> listarPerfis() {
	logger.info("listarPerfis: Gerando lista de perfis");
	List<Perfil> listaPerfis = perfilService.listarTodosPerfis();
	return listaPerfis;
    }

    @DeleteMapping(value = "/rest/perfil/excluir/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluirPerfil(@RequestBody @PathVariable(name = "perfilId") Integer perfilId) throws NotFoundException {

	logger.info("excluirPerfil: Recebendo perfilId");
	perfilService.excluirPerfil(perfilId);
    
    }

}
