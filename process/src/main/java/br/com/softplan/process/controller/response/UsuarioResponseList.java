package br.com.softplan.process.controller.response;

import java.util.ArrayList;

import br.com.softplan.process.model.Usuario;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UsuarioResponseList extends ArrayList<UsuarioResponse> {

    private static final long serialVersionUID = 1L;

    public UsuarioResponseList(Iterable<Usuario> usuarios) {
	if (usuarios != null) {
	    for (Usuario usuario: usuarios) {
		add(new UsuarioResponse(usuario));
	    }
	}
    }

}
