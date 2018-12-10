/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { ListaPerfilService } from './lista-perfil.service';

describe('ListaPerfilService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ListaPerfilService]
    });
  });

  it('should ...', inject([ListaPerfilService], (service: ListaPerfilService) => {
    expect(service).toBeTruthy();
  }));
});
