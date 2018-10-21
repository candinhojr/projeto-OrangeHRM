package tests;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import tests.candidate.HireCandidateTest;
import tests.candidate.MarkInterviewPassedTest;
import tests.candidate.OfferJobTest;
import tests.candidate.ScheduleInterviewCandidateTest;
import tests.candidate.ShortlistCandidateTest;
import tests.login.LoginTest;
import tests.user.AddUsersTest;
import tests.vacancy.AddVacancyTest;
import tests.vacancy.AddCandidateForVacancieTest;
import utils.Success;
import utils.OthersTests;

@RunWith(Categories.class)
@ExcludeCategory(OthersTests.class)
@IncludeCategory(Success.class)
@SuiteClasses({
  AddVacancyTest.class, 				// Add job vancancie
  AddCandidateForVacancieTest.class, 	// Add candidate to job vancancie
  ShortlistCandidateTest.class, 		// Accept subscription of candidate
  ScheduleInterviewCandidateTest.class, // Schedule interview with candidate
  MarkInterviewPassedTest.class, 		// Mark Interview Passed for candidate
  OfferJobTest.class, 					// Offer Job to candidate
  HireCandidateTest.class, 				// Hire candidate
  AddUsersTest.class, 					// Add the new employee
  LoginTest.class 						// Login with new employee
})
public class FullTest {

}