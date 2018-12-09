import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule, Http, Headers, RequestOptions, Response} from '@angular/http';

import { AppComponent } from './app.component';
import { PerfilComponent } from './perfil/perfil.component';
import { UsuarioComponent } from './usuario/usuario.component';
import { PerfilService } from './perfil/perfil.service';
import { UsuarioService } from './usuario/usuario.service';

@NgModule({
  declarations: [
    AppComponent,
    PerfilComponent,
    UsuarioComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [PerfilService, UsuarioService],
  bootstrap: [AppComponent]
})
export class AppModule { }
