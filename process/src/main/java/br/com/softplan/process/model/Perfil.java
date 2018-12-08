package br.com.softplan.process.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name="tb_perfil")
@EqualsAndHashCode
public class Perfil {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_perfil")
    private Integer perfilId;
    
    @Column(name="ds_perfil")
    private String descricao;
    
    //@OneToMany(mappedBy = "perfil", cascade = CascadeType.ALL)
    //private List<Usuario> usuarios;

}
