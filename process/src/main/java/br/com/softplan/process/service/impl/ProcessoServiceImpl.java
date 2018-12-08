package br.com.softplan.process.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softplan.process.model.Processo;
import br.com.softplan.process.repository.ProcessoRepository;
import br.com.softplan.process.service.ProcessoService;
import javassist.NotFoundException;

@Service
public class ProcessoServiceImpl implements ProcessoService {

    Logger logger = LoggerFactory.getLogger(this.getClass());    

    @Autowired
    ProcessoRepository processoRepository;

    
    @Override
    public Processo salvarProcesso(Processo processo) {

	logger.info("salvarProcesso: Salvando processo no repositório");
	processoRepository.save(processo);

	logger.info("salvarProcesso: Retornando processo com ID '" + processo.getProcessoId() + "' já salvo");
	return processo;
	
    }

    @Override
    public List<Processo> listarTodosProcessos() {

	logger.info("listarTodosProcessos: Buscando todos os processos no repositório");
	List<Processo> listaProcessos = processoRepository.findAll();
	logger.info("listarTodosProcessos: Retornando a lista dos processos. Tamanho da Lista: " + listaProcessos.size());

	return listaProcessos;
	
    }
    
    @Override
    public List<Processo> listarProcessosSemParecer() {

	Integer isSemParecer = 0;
	
	logger.info("listarProcessosSemParecer: Buscando todos os processos sem parecer no repositório");
	List<Processo> listaProcessos = processoRepository.findByIsParecerFalse(isSemParecer);
	logger.info("listarProcessosSemParecer: Retornando a lista dos processos sem parecer. Tamanho da Lista: " + listaProcessos.size());

	return listaProcessos;
	
    }
    

    @Override
    public Processo buscaProcesso(Integer processoId) throws NotFoundException {
	return buscaProcessoPorId(processoId);
    }
    
    @Override
    public void emitirParecer(Integer usuarioId, Processo processo) throws NotFoundException {
	
	processo = buscaProcessoPorId(processo.getProcessoId());
	
	if (processo != null) {
	   
	    logger.info("emitirParecer: Emitindo parecer no processo '" + processo.getProcessoId() + "'. já salvo");

	    processo.setUsuarioParecerId(usuarioId);
	    
	    logger.info("emitirParecer: Salvando parecer no processo '" + processo.getProcessoId() + "'. com o usuário " + usuarioId + ".");
	    processoRepository.save(processo);
	
	} else {
	    throw new NotFoundException("");
	}
	
    }
  
    protected Processo buscaProcessoPorId(Integer processoId) throws NotFoundException {

	Processo processo = null;

	if (processoId != null) {

	    logger.info("buscaProcessoPorId: Buscando processoId '" + processoId + "' no repositório");

	    processo = processoRepository.getOne(processoId.toString());

	    if (processo == null) {
		throw new NotFoundException("");
	    }

	    logger.info("buscaProcessoPorId: Retornando processoId '" + processoId + "'");

	} else {
	    throw new NotFoundException("");
	}

	return processo;

    }

    
}