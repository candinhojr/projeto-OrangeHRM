package tests;

import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import tests.login.LoginTest;
import tests.user.AddUsersTest;
import tests.vacancy.AddVacancyTest;
import tests.vacancy.ApplyForVacancieTest;
import utils.Success;

@RunWith(Suite.class)
@IncludeCategory(Success.class)
@Suite.SuiteClasses({
  AddVacancyTest.class,
  ApplyForVacancieTest.class,
  // TODO: AcceptSubscriptionTest.class,
  // TODO: Interview.class, -> markInterviewTest, passInterviewTest
  // TODO: OfferJob.class,
  // TODO: HireCandidate.class,
  AddUsersTest.class, // TODO: add the new candidate
  LoginTest.class // TODO: with new candidate
})
public class FullTest {

}