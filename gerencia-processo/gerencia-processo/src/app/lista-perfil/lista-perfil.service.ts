import { Injectable } from '@angular/core';
import { Perfil } from 'app/perfil/perfil';
import { HttpModule, Http, Headers, RequestOptions, Response} from '@angular/http';
import { Observable } from 'rxjs';

@Injectable()
export class ListaPerfilService {

  listaPerfis: Perfil [] = [];

  constructor(public http: Http) {
  }

  listarPerfis(): Observable<Perfil>{
    
    let headers = new Headers ({ 'Content-Type': 'application/json' });

    headers.append('Access-Control-Allow-Origin', 'http://localhost:4200');
    headers.append('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, PATCH, DELETE');
    headers.append('Access-Control-Allow-Headers', 'X-Requested-With,content-type');
    headers.append('Access-Control-Allow-Credentials', 'true');        

    let options = new RequestOptions({ headers: headers }); 

    return this.http.get('http://localhost:4200/rest/perfil/listar', options)
                    .map(res=>res.json())
                    .catch(err=> Observable.throw(err.message));
    }

}
