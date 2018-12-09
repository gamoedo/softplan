package br.com.softplan.process.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name="tb_processo")
@EqualsAndHashCode
public class Processo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_processo")
    private Integer processoId;
    
    @Column(name="ds_titulo")
    private String titulo;
    
    @Column(name="ds_descricao")
    private String descricao;
    
    @Column(name="ds_parecer")
    private String descricaoParecer;
    
    @Column(name="fl_parecer")
    private Boolean processoJaComParecer;
    
    @Column(name="id_usuario_parecer")
    private Integer usuarioParecerId;
    
    @ManyToMany(cascade = { 
	        CascadeType.PERSIST, 
	        CascadeType.MERGE
	    })
	    @JoinTable(name = "tb_usuario_processo",
	        joinColumns = @JoinColumn(name = "id_processo"),
	        inverseJoinColumns = @JoinColumn(name = "id_usuario")
	    )
    private List<Usuario> usuariosComAcessoProcesso = new ArrayList<>();

}
