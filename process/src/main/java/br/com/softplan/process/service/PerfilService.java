package br.com.softplan.process.service;

import java.util.List;

import br.com.softplan.process.model.Perfil;
import javassist.NotFoundException;

public interface PerfilService {

    Perfil salvarPerfil(Perfil perfil);

    List<Perfil> listarTodosPerfis();
    
    void excluirPerfil(Integer perfilId) throws NotFoundException;
    
}
