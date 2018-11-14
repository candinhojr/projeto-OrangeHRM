# Projeto OrangeHRM
![GitHub](https://img.shields.io/github/license/mashape/apistatus.svg)
![GitHub top language](https://img.shields.io/github/languages/top/badges/shields.svg)
O presente projeto foi desenvolvido utilizando a ferramenta *Selenium Web Driver* em conjunto com o *padrão Page Object*, para a disciplina de **Teste de Software II**, ofertada pela **Universidade Federal do Rio Grande do Norte** (*UFRN*) em parceria com o **Instituito Metropole Digital** (*IMD*) e ministrada pela professora **Roberta de Souza Coelho**.

## Descrição do Sistema
O sistema escolhido para o desenvolvimento deste projeto foi o **[OrangeHRM](https://opensource-demo.orangehrmlive.com/)**, um *sistema para **Gestão de Recursos Humanos*** disponível como uma plataforma open-source. Dividido em três releases (open-source, professional e enterprise), o sistema conta com inúmeros serviços que auxiliam o trabalho do RH de uma empresa oferecendo diversas funcionalidades tais como gerenciamento de funcionários, controle de horários de trabalho, recrutamento, entre outros. A versão utilizada no trabalho foi a demo do sistema open-source.

## Fluxo e Casos de Teste
O **fluxo de teste** implementado com base nas *funcionalidades do sistema* é o apresentado a seguir, junto da classe de teste que contém os **casos de testes** de cada *funcionalidade* testada:
- **Cadastrar uma vaga de emprego**:
			- [AddVacancyTest](https://github.com/candinhojr/projeto-OrangeHRM/blob/master/OrangeHRM/src/tests/vacancy/AddVacancyTest.java);
- **Inscrever um candidado para a vaga**:
			- [AddCandidateForVacancieTest](https://github.com/candinhojr/projeto-OrangeHRM/blob/master/OrangeHRM/src/tests/vacancy/AddCandidateForVacancieTest.java);
- **Aceitar a inscrição do candidato**:
			- [ShortlistCandidateTest](https://github.com/candinhojr/projeto-OrangeHRM/blob/master/OrangeHRM/src/tests/candidate/ShortlistCandidateTest.java);
- **Marcar entrevista com o candidato**:
			- [ScheduleInterviewCandidateTest](https://github.com/candinhojr/projeto-OrangeHRM/blob/master/OrangeHRM/src/tests/candidate/ScheduleInterviewCandidateTest.java);
- **Passar o candidato na entrevista**:
			- [MarkInterviewPassedTest](https://github.com/candinhojr/projeto-OrangeHRM/blob/master/OrangeHRM/src/tests/candidate/MarkInterviewPassedTest.java);
- **Oferecer a vaga de emprego ao candidato**:
			- [OfferJobTest](https://github.com/candinhojr/projeto-OrangeHRM/blob/master/OrangeHRM/src/tests/candidate/OfferJobTest.java);
- **Contratar o candidato**:
			- [HireCandidateTest](https://github.com/candinhojr/projeto-OrangeHRM/blob/master/OrangeHRM/src/tests/candidate/HireCandidateTest.java);
- **Criar o user para o funcionário logar na plataforma**:
			- [AddUsersTest](https://github.com/candinhojr/projeto-OrangeHRM/blob/master/OrangeHRM/src/tests/user/AddUsersTest.java);
- **Logar com o funcionário recém contratado e cadastrado**:
			- [LoginTest](https://github.com/candinhojr/projeto-OrangeHRM/blob/master/OrangeHRM/src/tests/login/LoginTest.java).

Foi criada uma suite de testes, que contém o caminho feliz do fluxo acima. Ela pode ser encontrada no arquivo [FullTest](https://github.com/candinhojr/projeto-OrangeHRM/blob/master/OrangeHRM/src/tests/FullTest.java). Para rodar a suite de testes, basta executar o arquivo com JUnit.

## Casos de Teste
Segue abaixo os casos de teste para cada uma das funcionalidades do sistema que estavam dentro do escopo deste projeto.
- Cadastrar uma vaga de emprego:
	> - Criar vaga com todos os campos preenchidos corretamente;
	> - Criar vaga com apenas os campos obrigatórios preenchidos; 
	> - Tentar cadastrar vaga sem preencher os campos obrigatórios;
	> - Inserir um coordenador inválido;
	> - Tentar cadastrar uma vaga com  o mesmo nome de outra vaga já publicada;
	> - No campo referente ao Nº de vagas inserir texto;

- Inscrever um candidado para a vaga:
	> - Cadastrar um candidato com todos os campos preenchidos corretamente;
	> - Cadastrar um candidato apenas com os campos obrigatórios preenchidos;
	> - Tentar cadastrar um candidato sem preencher os campos obrigatórios;
	> - Tentar cadastrar um candidato informando um e-mail inválido;
	> - Tentar anexar um documento com mais de 1 mega de tamanho;
	> - Tentar anexar um documento com exatamente 1 mega de tamanho;
	> - Tentar anexar um documento com extensão não suportada;

- Aceitar a inscrição do candidato:
	> - Aceitar inscrição do candidato;
	> - Rejeitar inscrição do candidato; 

- Adicionar usuário:
	> - Adicionar usuário com nome inválido
	> - Adicionar usuário com username inválido;
	> - Adicionar usuário com os dados corretos;

### Asserts
Dentre os testes(*Asserts*) feitos, estão:
- Verificar os dados adicionados nos cadastros;
- Verificar se o histórico do candidato/funcionário bate com os dados adicionados em cada etapa do seu processo de seleção e contratação;
- Verificar se o status do processo se altera em cada etapa;
- Verificar se o candidato é adicionado na lista de empregados;
- Verificar se o usuário foi criado com sucesso;
- Ao logar verificar os dados, entre outros...

## Critérios de Teste Utilizados
Os critérios de teste utilizados na confecção dos casos de teste  afim de testar as funcionalidades do sistema são:
- **Análise do Valor Limite** e
- **Divisão em classes de equivalência**.

## Bugs Encontrados
Após a execução dos testes foram encontrados os seguintes bugs:
-   É possível um funcionário ter mais de um cadastro de usuário;  
-   É possível cadastrar o mesmo candidato para a mesma vaga;  
-   Campos de inserção de documentos não aceita documentos com exatamente 1M nos formulários, quando não deveria aceitar documentos com mais de 1M;
-   É possível a inserção de dois usuários distintos para um mesmo funcionário;

## Dificuldades
-   Sem acesso a documentação do Sistema;  
-   Sistema remove dados cadastrados periodicamente;  
-   Organização, comunicação e comprometimento da equipe;  
-   Sistema instável:
	-   Dados cadastrados no sistema alterados de forma imprevisível    
		-   e.g. Cadastros de usuários apagados (incluindo os empregados default)  
-   Listas e Alertas;

## Informações Importantes

Todo o código do trabalho se encontra no github, através do link [https://github.com/candinhojr/projeto-OrangeHRM/](https://github.com/candinhojr/projeto-OrangeHRM/).

A descrição do projeto, seu objetivo e metodologia estão descritos no arquivo [README](https://github.com/candinhojr/projeto-OrangeHRM/blob/master/README.md), que se encontra no diretório base do projeto.

A apresentação do trabalho se encontra do diretório base do projeto, e se intitula "[Project-OrangeHRM-Presentation"](https://github.com/candinhojr/projeto-OrangeHRM/blob/master/Project-OrangeHRM-Presentation.pdf).

Para executar os testes do projeto é necessário fazer o download do projeto, descompactar e importar o projeto na IDE de desenvolvimento preferida e após isso executar os testes.
 
Caso ocorra problema na execução do projeto, é necessário checar a versão do chromedriver, e caso seja necessário atualizar o mesmo, basta atualizar o arquivo "chromedriver" na pasta [dependences](https://github.com/candinhojr/projeto-OrangeHRM/tree/master/OrangeHRM/dependences) do projeto. 

## Referências
<p align="left">
<img src="https://cdn-images-1.medium.com/max/982/1*AiTBjfsoj3emarTpaeNgKQ.png" width="14%"  />
</p>

<p align="left">
<img src="https://www.seleniumhq.org/images/big-logo.png" width="14%" />
</p>

:link: <https://junit.org/junit5/>   
:link: <https://www.seleniumhq.org/docs/03_webdriver.jsp>
:link: <https://github.com/SeleniumHQ/selenium/wiki>

## Autores
Candinho Luiz Dalla Brida Junior (<candinholuiz@gmail.com>)
Pedro Paulo Paiva De Medeiros
Victor Simplício Brandão de Lima
