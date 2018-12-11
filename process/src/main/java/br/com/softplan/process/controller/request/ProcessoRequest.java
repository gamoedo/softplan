package br.com.softplan.process.controller.request;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.softplan.process.model.Processo;
import br.com.softplan.process.model.Usuario;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProcessoRequest {
    
    @JsonProperty("processoId")
    private Integer processoId;
    
    @NotNull
    @JsonProperty("titulo")
    private String titulo;
    
    @NotNull
    @JsonProperty("descricao")
    private String descricao;
    
    @JsonProperty("descricaoParecer")
    private String descricaoParecer;

    @JsonProperty("processoJaComParecer")
    private Boolean processoJaComParecer;
    
    @JsonProperty("usuariosComAcessoProcesso")
    private List<String> usuariosComAcessoProcesso;
    
	
    public Processo toModel() {
	
	Processo processo = new Processo();
	
	processo.setProcessoId(this.processoId);
	processo.setTitulo(this.titulo);
	processo.setDescricao(this.descricao);
	processo.setDescricaoParecer(this.descricaoParecer);
	processo.setProcessoJaComParecer(this.processoJaComParecer);

	List<Usuario> listaUsuariosComAcessoAoParecer = new ArrayList<Usuario>();
	
	
	if (this.usuariosComAcessoProcesso != null) {	    
	    
	    for (String usuarioIdString : this.usuariosComAcessoProcesso) {
		Usuario usuario = new Usuario();
		usuario.setUsuarioId(new Integer(usuarioIdString));
		listaUsuariosComAcessoAoParecer.add(usuario);
	    }	    
	} else {
	    listaUsuariosComAcessoAoParecer = null;
	}
	
	processo.setUsuariosComAcessoProcesso(listaUsuariosComAcessoAoParecer);	
	
	return processo;
    }
    
}
