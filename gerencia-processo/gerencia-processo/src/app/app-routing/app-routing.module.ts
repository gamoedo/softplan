import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DashboardComponent }   from '../dashboard/dashboard.component';
import { UsuarioComponent }      from '../usuario/usuario.component';
import { PerfilComponent } from '../perfil/perfil.component';

const routes: Routes = [
  // { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'usuario', component: UsuarioComponent },
  { path: 'perfil', component: PerfilComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})

export class AppRoutingModule { }
