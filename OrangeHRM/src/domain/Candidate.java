package domain;

import constants.domain.user.CandidateActions;
import constants.domain.user.CandidateStatus;

public class Candidate {

	private String firstName = "Teste";
	private String middleName = "Testiniano";
  	private String lastName = "Testando";
  	private String email = "teste@testando.com";
  	private String contactNumber = "99999999";
  	private String resume = "dependences/files/pdf_valid.pdf";
  	private String keyWords = "palavras chave";
  	private String notes = "Uso fruto de um teste";
  	private String candidateInitiatedStatus = CandidateStatus.INITIALIZED;
  	private String candidateShortlist = CandidateActions.SHORTLIST;
  	private String candidateShortlistedStatus = CandidateStatus.SHORTLISTED;
  	private String candidateScheduleInterview = CandidateActions.SCHEDULE_INTERVIEW;
  	private String candidateReject = CandidateActions.REJECT;
  	private String candidateMarkInterviewPassed = CandidateActions.MARK_INTERVIEW_PASSED;
  	private String candidateMarkInterviewFailed = CandidateActions.MARK_INTERVIEW_FAILED;
  	private String candidateOfferJob = CandidateActions.OFFER_JOB;
  	private String candidateDeclineOffer = CandidateActions.DECLINE_OFFER;
  	private String candidateHire = CandidateActions.HIRE;
  	
	public Candidate(String firstName, String middleName, String lastName, String email, String contactNumber, String resume, String keyWords, String notes) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.resume = resume;
		this.keyWords = keyWords;
		this.notes = notes;
	}
	
	public Candidate() {
		
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * @return the resume
	 */
	public String getResume() {
		return resume;
	}

	/**
	 * @param resume the resume to set
	 */
	public void setResume(String resume) {
		this.resume = resume;
	}

	/**
	 * @return the keyWords
	 */
	public String getKeyWords() {
		return keyWords;
	}

	/**
	 * @param keyWords the keyWords to set
	 */
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * @return the candidateActions
	 */
	public String getCandidateShortlist() {
		return candidateShortlist;
	}

	/**
	 * @return the candidateScheduleInterview
	 */
	public String getCandidateScheduleInterview() {
		return candidateScheduleInterview;
	}

	/**
	 * @return the candidateReject
	 */
	public String getCandidateReject() {
		return candidateReject;
	}

	/**
	 * @return the candidateMarkInterviewPassed
	 */
	public String getCandidateMarkInterviewPassed() {
		return candidateMarkInterviewPassed;
	}

	/**
	 * @return the candidateMarkInterviewFailed
	 */
	public String getCandidateMarkInterviewFailed() {
		return candidateMarkInterviewFailed;
	}

	/**
	 * @return the candidateOfferJob
	 */
	public String getCandidateOfferJob() {
		return candidateOfferJob;
	}

	/**
	 * @return the candidateDeclineOffer
	 */
	public String getCandidateDeclineOffer() {
		return candidateDeclineOffer;
	}

	/**
	 * @return the candidateHire
	 */
	public String getCandidateHire() {
		return candidateHire;
	}

	public String getCandidateFullName() {
		String fullName = this.getFirstName().concat(" "+this.getMiddleName().concat(" "+this.getLastName()));
		return fullName;
	}

	public String getCandidateShortlistedStatus() {
		return candidateShortlistedStatus;
	}
	
	public String getCandidateInitiatedStatus() {
		return candidateInitiatedStatus;
	}
  	
}
