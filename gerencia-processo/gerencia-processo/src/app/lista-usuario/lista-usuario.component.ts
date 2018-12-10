import { Component, OnInit } from '@angular/core';
import { ListaUsuarioService } from './lista-usuario.service';
import { Usuario } from 'app/usuario/usuario';
import { ListaUsuario } from './lista-usuario';

@Component({
  selector: 'app-lista-usuario',
  templateUrl: './lista-usuario.component.html',
  styleUrls: ['./lista-usuario.component.css'],
  providers: [ListaUsuarioService]
})
export class ListaUsuarioComponent implements OnInit {
  
  listaUsuarios: ListaUsuario;

  constructor(private listaUsuarioService: ListaUsuarioService) { 

   }

  ngOnInit() {

    this.listaUsuarioService.listarUsuarios()
    .subscribe(
      users => this.listaUsuarios = users,
      error => console.log("erro"));
  }

}
