import { Injectable } from '@angular/core';
import { Usuario } from './usuario';
import { HttpModule, Http, Headers, RequestOptions, Response} from '@angular/http';


@Injectable()
export class UsuarioService {

  constructor(public http: Http) {
  }

  salvarUsuario(usuario: Usuario){
    
    let headers = new Headers ({ 'Content-Type': 'application/json' });

    headers.append('Access-Control-Allow-Origin', 'http://localhost:8080');
    headers.append('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, PATCH, DELETE');
    headers.append('Access-Control-Allow-Headers', 'X-Requested-With,content-type');
    headers.append('Access-Control-Allow-Credentials', 'true');        

    let options = new RequestOptions({ headers: headers }); 
    
    console.log(usuario);

    if (usuario != null){   

      let Usuario = usuario;
      let body = JSON.stringify(usuario);

      return this.http.post('http://localhost:8080/rest/usuario/salvar', body, options)
      .toPromise()
      .then((response) => {return response.json()})
      .catch(error => {
        console.log( error );
      });
    }      
  }

}
