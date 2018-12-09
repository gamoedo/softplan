export class Usuario {

    constructor(public usuarioId: number,
        public login: string,
        public senha: string,
        public isAtivo: boolean,
        public perfilId: number
        ){}
}
