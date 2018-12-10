import { Injectable } from '@angular/core';
import { Processo } from './processo';
import { HttpModule, Http, Headers, RequestOptions, Response} from '@angular/http';

@Injectable()
export class ProcessoService {

  constructor(public http: Http) {
  }

  salvarProcesso(processo: Processo){
    
    let headers = new Headers ({ 'Content-Type': 'application/json' });

    headers.append('Access-Control-Allow-Origin', 'http://localhost:4200');
    headers.append('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, PATCH, DELETE');
    headers.append('Access-Control-Allow-Headers', 'X-Requested-With,content-type');
    headers.append('Access-Control-Allow-Credentials', 'true');        

    let options = new RequestOptions({ headers: headers }); 
    
    console.log(processo);

    if (processo != null){   
      
      let body = JSON.stringify(processo);

      return this.http.post('http://localhost:4200/rest/processo/salvar', body, options)
      .toPromise()
      .then((response) => {return response.json()})
      .catch(error => {
        console.log( error );
      });
    }      
  }

}
