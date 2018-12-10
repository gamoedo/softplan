export class ListaUsuario {

    constructor(
        public usuarioId: number,
        public login: string,
        public senha: string,
        public isAtivo: boolean,
        public perfilDescricao: string
        ){}
}
