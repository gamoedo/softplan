import { Component, OnInit } from '@angular/core';
import { Usuario } from './usuario';
import { PerfilService } from 'app/perfil/perfil.service';
import { UsuarioService } from './usuario.service';
import { ListaPerfilService } from 'app/lista-perfil/lista-perfil.service';
import { Perfil } from 'app/perfil/perfil';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css'],
  providers: [UsuarioService, ListaPerfilService]
})
export class UsuarioComponent implements OnInit {

  usuario = new Usuario(null, "", "", true, 0);  
  listaPerfis: Perfil;
  
    constructor(private perfilService: ListaPerfilService, private usuarioService: UsuarioService) { 

    //this.listaPerfis = perfilService.listarPerfis();
    
  }

  ngOnInit() {

    this.perfilService.listarPerfis().subscribe(perfis => this.listaPerfis = perfis,error => console.log("erro"));
  }

  salvarUsuario(){
    this.usuarioService.salvarUsuario(this.usuario);
  }

}

