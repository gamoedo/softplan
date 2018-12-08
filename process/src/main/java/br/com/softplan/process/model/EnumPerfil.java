package br.com.softplan.process.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumPerfil {	
	
	USUARIO_ADMINISTRADOR(1), 
	USUARIO_TRIADOR(2), 
	USUARIO_FINALIZADOR(3);	
	public final Integer codigoPerfil;
}
