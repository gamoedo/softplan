/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { ListaUsuarioService } from './lista-usuario.service';

describe('ListaUsuarioService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ListaUsuarioService]
    });
  });

  it('should ...', inject([ListaUsuarioService], (service: ListaUsuarioService) => {
    expect(service).toBeTruthy();
  }));
});
