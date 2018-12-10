import { Component, OnInit } from '@angular/core';
import { Perfil } from 'app/perfil/perfil';
import { ListaPerfilService } from './lista-perfil.service';

@Component({
  selector: 'app-lista-perfil',
  templateUrl: './lista-perfil.component.html',
  styleUrls: ['./lista-perfil.component.css'],
  providers: [ListaPerfilService]
})
export class ListaPerfilComponent implements OnInit {

  listaPerfis: Perfil;

  constructor(private listaPerfilService: ListaPerfilService) { 

   }

  ngOnInit() {

    this.listaPerfilService.listarPerfis()
    .subscribe(
      perfis => this.listaPerfis = perfis,
      error => console.log("erro"));
  }

}
