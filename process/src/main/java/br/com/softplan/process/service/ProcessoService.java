package br.com.softplan.process.service;

import java.util.List;

import br.com.softplan.process.model.Processo;
import javassist.NotFoundException;

public interface ProcessoService {

    Processo salvarProcesso(Processo processo);

    List<Processo> listarTodosProcessos();
    
    List<Processo> listarProcessosSemParecer();   
        
    void emitirParecer(Integer processoId, Processo processoRequest) throws NotFoundException;

}
