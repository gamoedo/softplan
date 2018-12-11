package br.com.softplan.process.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.softplan.process.controller.request.ProcessoRequest;
import br.com.softplan.process.exception.UnprocessableEntityException;
import br.com.softplan.process.model.Processo;
import br.com.softplan.process.service.ProcessoService;
import javassist.NotFoundException;

@RestController
public class ProcessoController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProcessoService processoService;

    @PostMapping(value = "/rest/processo/salvar", 
	    	consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
	    	produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Processo salvarProcesso(@RequestBody @Valid ProcessoRequest processoRequest) throws UnprocessableEntityException {
	
	logger.info("salvarProcesso: Recebendo processo");

	Processo processo;
	
	try {
	    logger.info("salvarProcesso: Convertendo processoRequest para processo");
	    processo = processoRequest.toModel();
	} catch (Exception e) {
	    logger.info("salvarProcesso: Conversão falhou.");
	    throw new UnprocessableEntityException();
	}
	
	processo = processoService.salvarProcesso(processo);		

	logger.info("salvarProcesso: Retornando processo salvo");
	
	return processo;
    }

    @GetMapping(value = "/rest/processo/listar", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Processo> listarProcessos() {
	logger.info("listarProcessos: Gerando lista de processos");
	List<Processo> listaProcessos = processoService.listarTodosProcessos();
	return listaProcessos;
    }
    
    @GetMapping(value = "/rest/processo/listarProcessosParecer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Processo> listarProcessosSemParecer() {
	logger.info("listarProcessos: Gerando lista de processos");
	List<Processo> listaProcessos = processoService.listarTodosProcessos();
	return listaProcessos;
    }
    
    
    @GetMapping(value = "/rest/processo/buscar/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public Processo buscarProcesso(@RequestBody @PathVariable(name = "processoId") Integer processoId) throws NotFoundException {

	logger.info("buscarProcesso: Recebendo processoId");
	Processo processo = processoService.buscaProcesso(processoId);
	logger.info("buscarProcesso: Retornando processo buscado");
	return processo;
    }
    
    
    @PostMapping(value = "/rest/processo/{id}/emiteParecer", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void emitirParecer(@RequestBody @Valid Processo processo, @PathVariable(name = "id") Integer usuarioId) throws NotFoundException {

	logger.info("emitirParecer: Recebendo processo e usuarioId");

	if (processo.getProcessoJaComParecer()) {
	    logger.info("emitirParecer: Processo já com parecer.");
	    throw new UnprocessableEntityException();
	}

	processoService.emitirParecer(usuarioId, processo);
    }

}
