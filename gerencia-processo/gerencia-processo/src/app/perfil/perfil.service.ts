import { Injectable } from '@angular/core';

@Injectable()
export class PerfilService {

  constructor() { }

  retornaListaPerfis() : any{

    const arr: Array<{perfilId: number, descricao: string}> = [{perfilId: 1, descricao: 'Usuário Administrador'},
    {perfilId: 2, descricao: 'Usuário Triador'},
    {perfilId: 3, descricao: 'Usuário Finalizador'}];

    return arr; 

  }

}
