import { Component, OnInit } from '@angular/core';
import { Perfil } from './perfil';
import { PerfilService } from './perfil.service';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css'],
  providers: [PerfilService]
})
export class PerfilComponent implements OnInit {

  perfil = new Perfil(null, "");    

  constructor(private perfilService: PerfilService) {
  } 

  ngOnInit() {
  }
  salvarPerfil(){
    this.perfilService.salvarPerfil(this.perfil);
  }

}
