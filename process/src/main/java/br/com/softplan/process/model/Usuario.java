package br.com.softplan.process.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name="tb_usuario")
@EqualsAndHashCode
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Integer usuarioId;
    
    @Column(name="ds_login")
    private String login;
    
    @Column(name="ds_senha")
    private String senha;

    @Column(name="fl_ativo")
    private Boolean isAtivo;
    
    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;
    
    //@ManyToMany(mappedBy = "usuariosComAcessoProcesso")
    //private List<Processo> processosComAcesso = new ArrayList<>();

}
