package br.com.softplan.process.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.softplan.process.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
   
    @Query("SELECT u FROM tb_usuario u WHERE u.isAtivo = ?1")
    public List<Usuario> findByIsAtivoTrue(@Param("active") Boolean ativo);
    
    @Query("SELECT u FROM tb_usuario u WHERE u.login = ?1 and u.senha = ?2")
    public Usuario findByLoginSenha(String login, String senha);
    
    
}
