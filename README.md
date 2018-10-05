# projeto-OrangeHRM
Projeto de Teste utilizando a ferramenta Selenium WebDriver em conjunto com o padrão Page Object, para a disciplina de Teste de Software II.

O projeto será feito em cima do site OrangeHRM (https://opensource-demo.orangehrmlive.com/), um gerenciador de RH open source.

O fluxo de teste a ser implementado é o seguinte:
→ Cadastrar uma vaga X de emprego;
   '→ Inscrever um candidado Y para a vaga;
   '→ Aceitar a inscrição do candidato Y;
   '→ Marcar entrevista com o candidato Y;
   '→ Passar o candidato Y na entrevista;
   '→ Oferecer a vaga de emprego ao candidato Y;
   '→ Contratar o candidato Y;
   '→ Criar o user para o funcionário Y logar na plataforma;
   '→ Logar com Y;

Dentre os testes a serem feitos estão:
- Verificar os dados adicionados;
- Verificar se o histórico bate com os dados adicionados em cada etapa;
- Verificar se o status do processo se altera em cada etapa;
- Verificar se o candidato é adicionado na lista de empregados;
- Ao logar verificar os dados...
