import { Usuario } from "app/usuario/usuario";

export class Processo {

    constructor(
        public processoId: number,
        public titulo: string,
        public descricao: string,
        public descricaoParecer: string,
        public processoJaComParecer: boolean,
        public usuarioParecerId: number,
        public usuariosComAcessoProcesso: string[]
        ){}

}
