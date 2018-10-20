# Projeto OrangeHRM
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

### Asserts
Dentre os testes(*Asserts*) feitos, estão:
- Verificar os dados adicionados nos cadastros;
- Verificar se o histórico do candidato/funcionário bate com os dados adicionados em cada etapa do seu processo de seleção e contratação;
- Verificar se o status do processo se altera em cada etapa;
- Verificar se o candidato é adicionado na lista de empregados;
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

## Dificuldades
-   Sem acesso a documentação do Sistema;  
-   Sistema remove dados cadastrados periodicamente;  
-   Organização, comunicação e comprometimento da equipe;  
-   Sistema instável:
	-   Dados cadastrados no sistema alterados de forma imprevisível    
		-   e.g. Cadastros de usuários apagados (incluindo os empregados default)  
-   Listas e Alertas;

### Informações Importantes

Todo o código do trabalho se encontra no github, através do link [https://github.com/candinhojr/projeto-OrangeHRM/](https://github.com/candinhojr/projeto-OrangeHRM/)

A descrição do projeto, seu objetivo e metodologia estão descritos no arquivo [README](https://github.com/candinhojr/projeto-OrangeHRM/blob/master/README.md), que se encontra no diretório base do projeto.

A apresentação do trabalho se encontra do diretório base do projeto, e se intitula "[Project-OrangeHRM-Presentation"](https://github.com/candinhojr/projeto-OrangeHRM/blob/master/Project-OrangeHRM-Presentation.pdf);


