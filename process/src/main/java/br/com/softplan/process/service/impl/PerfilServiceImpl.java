package br.com.softplan.process.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softplan.process.model.Perfil;
import br.com.softplan.process.repository.PerfilRepository;
import br.com.softplan.process.service.PerfilService;
import javassist.NotFoundException;

@Service
public class PerfilServiceImpl implements PerfilService {

    Logger logger = LoggerFactory.getLogger(this.getClass());    

    @Autowired
    PerfilRepository perfilRepository;

    
    @Override
    public Perfil salvarPerfil(Perfil perfil) {

	logger.info("salvarPerfil: Salvando perfil no repositório");
	perfilRepository.save(perfil);

	logger.info("salvarPerfil: Retornando perfil com ID '" + perfil.getPerfilId() + "' já salvo");
	return perfil;
	
    }

    @Override
    public List<Perfil> listarTodosPerfis() {

	logger.info("listarTodosPerfis: Buscando todos os perfis no repositório");
	List<Perfil> listaPerfis = perfilRepository.findAll();
	logger.info("listarTodosPerfis: Retornando a lista dos perfis. Tamanho da Lista: " + listaPerfis.size());

	return listaPerfis;
	
    }

    @Override
    public void excluirPerfil(Integer perfilId) throws NotFoundException {

	Perfil perfil = buscaPerfilPorId(perfilId);
	
	if(perfil != null) {
	    	
	    logger.info("excluirPerfil: Deletando perfil com perfilId '" + perfilId + "' no repositório");
            perfilRepository.delete(perfil);	
	    
	}else {
	    throw new NotFoundException("");
	}
	
    }
    
    protected Perfil buscaPerfilPorId(Integer perfilId) throws NotFoundException {

	Perfil perfil = null;

	if (perfilId != null) {

	    logger.info("buscaPerfilPorId: Buscando perfilId '" + perfilId + "' no repositório");

	    perfil = perfilRepository.getOne(perfilId.toString());

	    if (perfil == null) {
		throw new NotFoundException("");
	    }

	    logger.info("buscaPerfilPorId: Retornando perfilId '" + perfilId + "'");

	} else {
	    throw new NotFoundException("");
	}

	return perfil;

    }
    
}