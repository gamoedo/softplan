import { Component, OnInit } from '@angular/core';
import { Usuario } from './usuario';
import { PerfilService } from 'app/perfil/perfil.service';
import { UsuarioService } from './usuario.service';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css'],
  providers: [UsuarioService]
})
export class UsuarioComponent implements OnInit {

  usuario = new Usuario(null, "", "", true, 0);
  perfis: Array<{perfilId: number, descricao: string}>;

  constructor(private perfilService: PerfilService, private usuarioService: UsuarioService) { 

    this.perfis = perfilService.retornaListaPerfis();
    
  }

  ngOnInit() {
  }

  salvarUsuario(){
    this.usuarioService.salvarUsuario(this.usuario);
  }

}
