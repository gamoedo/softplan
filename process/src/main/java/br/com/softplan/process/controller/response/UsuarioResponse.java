package br.com.softplan.process.controller.response;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.softplan.process.model.Perfil;
import br.com.softplan.process.model.Usuario;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioResponse {
    
    @JsonProperty("usuarioId")
    private Integer usuarioId;
    
    @NotNull
    @JsonProperty("login")
    private String login;
    
    @NotNull
    @JsonProperty("senha")
    private String senha;
    
    @NotNull
    @JsonProperty("isAtivo")
    private Boolean isAtivo;

    @NotNull
    @JsonProperty("perfilDescricao")
    private String perfilDescricao;
	
    
    public UsuarioResponse(Usuario usuario) {
 	this.usuarioId = usuario.getUsuarioId();
 	this.login = usuario.getLogin();
 	this.senha = usuario.getSenha();
 	this.isAtivo = usuario.getIsAtivo();
 	this.perfilDescricao = usuario.getPerfil().getDescricao();
     }

    
}
