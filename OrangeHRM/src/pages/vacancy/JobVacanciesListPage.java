package pages.vacancy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.BasePage;

public class JobVacanciesListPage extends BasePage {
  @FindBy(id = "btnAdd")
  private WebElement addJobVacancie;

  public JobVacanciesListPage() {
    super();
  }

  public AddVacancyPage goToAddJobVacanciePage() {
    this.addJobVacancie.click();

    return PageFactory.initElements(driver, AddVacancyPage.class);
  }
}