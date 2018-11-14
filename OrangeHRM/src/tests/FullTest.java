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
	/**
	 * Add job vancancie
	 */
	AddVacancyTest.class, 			
	/**
	 * Add candidate to job vancancie
	 */
	AddCandidateForVacancieTest.class, 	
	/**
	 * Accept subscription of candidate
	 */
	ShortlistCandidateTest.class, 		
	/**
	 * Schedule interview with candidate
	 */
	ScheduleInterviewCandidateTest.class,
	/**
	 * Mark Interview Passed for candidate
	 */
	MarkInterviewPassedTest.class,
	/**
	 * Offer Job to candidate
	 */
	OfferJobTest.class,
	/**
	 * Hire candidate
	 */
	HireCandidateTest.class,
	/**
	 * Add the new employee
	 */
	AddUsersTest.class,
	/**
	 * Login with new employee
	 */
	LoginTest.class
})

public class FullTest {}