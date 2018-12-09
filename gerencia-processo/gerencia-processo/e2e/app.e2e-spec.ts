import { GerenciaProcessoPage } from './app.po';

describe('gerencia-processo App', function() {
  let page: GerenciaProcessoPage;

  beforeEach(() => {
    page = new GerenciaProcessoPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
