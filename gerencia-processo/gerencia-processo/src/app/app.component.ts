import { Component } from '@angular/core';
import { PerfilService } from './perfil/perfil.service';
import { UsuarioService } from './usuario/usuario.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app works!';

  constructor(private perfilService: PerfilService, private usuarioService: UsuarioService){

  }

  retornaListaPerfis() :void{
    this.perfilService.retornaListaPerfis();
  }
}
