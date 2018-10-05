import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * Aluno: Candinho Luiz Dalla Brida Junior
 * Documentação utilizada: 
 * https://www.seleniumhq.org/docs/03_webdriver.jsp
 * https://docs.seleniumhq.org/docs/06_test_design_considerations.jsp#page-object-design-pattern
 */

public class LoginPage {
	// Fica a cargo do Page Object identificar e interagir com os elementos da tela

	// Declaração de variáveis
	private WebDriver driver;
	 
	 public LoginPage(WebDriver driver) {
	   this.driver = driver;
	 }
	 
	 public LoginPage visit(String url) {
		// Acessa a página inicial que nos redireciona para a página de login
		driver.get(url);
		return this;
	 }
	 
	 public LoginPage login(String name, String password) {
		// Informa o usuário/senha e clica no botão de login
		driver.findElement(By.name("login")).sendKeys(name);
      	driver.findElement(By.name("password")).sendKeys(password);
      	driver.findElement(By.name("commit")).click();
      	
      	return this;
	 }
	 
	 public boolean loginWithSucess() {
		 return containsProjetosInTitleOfPage() && containsTheOptionProjetosInHeaderOfPage();
	 }
	 
	 public boolean containsProjetosInTitleOfPage() {
		 // Verifica se o titulo da página contém a palavra 'Projetos'
		 return driver.getTitle().contains("Projetos");
	 }
	 
	 public boolean containsTheOptionProjetosInHeaderOfPage() {
		 // Verifica se na barra de navegação existe a opção 'Projetos'
		 return driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[5]/a/span")).getText().contains("Projetos");
	 }

}
