/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { ProcessoService } from './processo.service';

describe('ProcessoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ProcessoService]
    });
  });

  it('should ...', inject([ProcessoService], (service: ProcessoService) => {
    expect(service).toBeTruthy();
  }));
});
