import { Component, OnInit } from '@angular/core';
import { Perfil } from './perfil';
import { PerfilService } from './perfil.service';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit {

  perfil = new Perfil(0, "");    

  ngOnInit() {
  }

  enviarDados() {
  //  alert(`A descrição do perfil é: ${this.perfil.descricao}`);   
  }

}
