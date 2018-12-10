import { Component, OnInit } from '@angular/core';
import { Processo } from './processo';
import { Usuario } from 'app/usuario/usuario';
import { ProcessoService } from './processo.service';

@Component({
  selector: 'app-processo',
  templateUrl: './processo.component.html',
  styleUrls: ['./processo.component.css'],
  providers: [ProcessoService]
})
export class ProcessoComponent implements OnInit {

  processo = new Processo(null, "", "", "", false, null, null);  
  listaUsuariosFinalizadores : Usuario [] = [];

  constructor(private processoService: ProcessoService) { }

  ngOnInit() {
    this.retornaUsuariosFinalizadores();
  }

  podeAcessarParecer(){    
    // if (perfil === 3) && (processoJaComParecer === 0) 
    return false;
  }

  podeDarAcessoAUsuarioFinalizador(){
    // if (perfil === 2) && (processoJaComParecer === 0) 
    return false;
  }

  retornaUsuariosFinalizadores(){
    let usuario1 = new Usuario(1, "gamoedo", "teste123", true, 1);  
    let usuario2 = new Usuario(3, "trest", "asdasda", true, 2);  
    let usuario3 = new Usuario(4, "andrios", "123123", true, 1);  

    this.listaUsuariosFinalizadores.push(usuario1,usuario2,usuario3);
  
    //return this.listaUsuariosFinalizadores;
  }

  salvarProcesso(){
    this.processoService.salvarProcesso(this.processo);
  }

}
