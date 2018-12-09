import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule, Http, Headers, RequestOptions, Response} from '@angular/http';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { PerfilComponent } from './perfil/perfil.component';
import { UsuarioComponent } from './usuario/usuario.component';
import { PerfilService } from './perfil/perfil.service';
import { UsuarioService } from './usuario/usuario.service';
import { DashboardComponent } from './dashboard/dashboard.component';

import { AppRoutingModule }     from './app-routing/app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    PerfilComponent,
    UsuarioComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,    
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [PerfilService, UsuarioService],
  bootstrap: [AppComponent]
})
export class AppModule { }
