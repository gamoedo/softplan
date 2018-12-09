package br.com.softplan.process.controller.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.softplan.process.model.Perfil;
import br.com.softplan.process.model.Usuario;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioRequest {
    
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
    @JsonProperty("perfilId")
    private Integer perfilId;
	
    public Usuario toModel() {
	Usuario usuario = new Usuario();

	usuario.setUsuarioId(this.usuarioId);
	usuario.setLogin(this.login);
	usuario.setSenha(this.senha);
	usuario.setIsAtivo(this.isAtivo);
	
	Perfil perfil = new Perfil();
	perfil.setPerfilId(this.perfilId);
	
	usuario.setPerfil(perfil);
		
	return usuario;
    }
    
}
