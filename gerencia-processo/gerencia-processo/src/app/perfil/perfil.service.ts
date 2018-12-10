import { Injectable } from '@angular/core';
import { Perfil } from './perfil';

import { HttpModule, Http, Headers, RequestOptions, Response} from '@angular/http';

@Injectable()
export class PerfilService {

  constructor(public http: Http) {
  }

  salvarPerfil(perfil: Perfil){
    
    let headers = new Headers ({ 'Content-Type': 'application/json' });

    headers.append('Access-Control-Allow-Origin', 'http://localhost:4200');
    headers.append('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, PATCH, DELETE');
    headers.append('Access-Control-Allow-Headers', 'X-Requested-With,content-type');
    headers.append('Access-Control-Allow-Credentials', 'true');        

    let options = new RequestOptions({ headers: headers }); 
    
    console.log(perfil);

    if (perfil != null){   

      let Perfil = perfil;
      let body = JSON.stringify(perfil);

      return this.http.post('http://localhost:4200/rest/perfil/salvar', body, options)
      .toPromise()
      .then((response) => {return response.json()})
      .catch(error => {
        console.log( error );
      });
    }      
  }

  retornaListaPerfis() : any{

    const arr: Array<{perfilId: number, descricao: string}> = [{perfilId: 1, descricao: 'Usuário Administrador'},
    {perfilId: 2, descricao: 'Usuário Triador'},
    {perfilId: 3, descricao: 'Usuário Finalizador'}];

    return arr; 

  }

}
