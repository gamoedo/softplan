import { Injectable } from '@angular/core';
import { Usuario } from '../usuario/usuario';
import { HttpModule, Http, Headers, RequestOptions, Response} from '@angular/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { ListaUsuario } from './lista-usuario';

@Injectable()
export class ListaUsuarioService {

  listaUsuarios: ListaUsuario [] = [];

  constructor(public http: Http) {
  }

  listarUsuarios(): Observable<ListaUsuario>{
    
    let headers = new Headers ({ 'Content-Type': 'application/json' });

    headers.append('Access-Control-Allow-Origin', 'http://localhost:4200');
    headers.append('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, PATCH, DELETE');
    headers.append('Access-Control-Allow-Headers', 'X-Requested-With,content-type');
    headers.append('Access-Control-Allow-Credentials', 'true');        

    let options = new RequestOptions({ headers: headers }); 

    return this.http.get('http://localhost:4200/rest/usuario/listar', options)
                    .map(res=>res.json())
                    .catch(err=> Observable.throw(err.message));
  
  
    
    //.pipe(map(res=>res.json()))
    //.catch(err=> Observable.throw(err.message));

    //return null;

    /**
       this.http.get('http://localhost:4200/rest/usuario/listar', options)
      .toPromise()
      .then((response) => {return response.text() ? response.json() : {}})
      .then((response) => {return response.json().subscribe(result => this.result =result);})
      .catch(error => {
        console.log( error );
      });      

           */      
    }

}

