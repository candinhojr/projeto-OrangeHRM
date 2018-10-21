package domain;

public class Vacancy {
	private String jobTitle = "IT Executive";
	private String vacancyName = "IT Executive Vacancy";
	private String hiringManager = "Thomas Fleming";
	private String numberOfPositions = "2";
	private String description = "Administrar a infraestrutura física e lógica dos locais informatizados";
	
	public Vacancy(String jobTitle, String vacancyName, String hiringManager, String numberOfPositions,
			String description) {
		this.jobTitle = jobTitle;
		this.vacancyName = vacancyName;
		this.hiringManager = hiringManager;
		this.numberOfPositions = numberOfPositions;
		this.description = description;
	}

	public Vacancy(String jobTitle, String vacancyName, String hiringManager) {
		this.jobTitle = jobTitle;
		this.vacancyName = vacancyName;
		this.hiringManager = hiringManager;
	}
	
	public Vacancy() {
		
	}

	/**
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * @return the vacancyName
	 */
	public String getVacancyName() {
		return vacancyName;
	}

	/**
	 * @param vacancyName the vacancyName to set
	 */
	public void setVacancyName(String vacancyName) {
		this.vacancyName = vacancyName;
	}

	/**
	 * @return the hiringManager
	 */
	public String getHiringManager() {
		return hiringManager;
	}

	/**
	 * @param hiringManager the hiringManager to set
	 */
	public void setHiringManager(String hiringManager) {
		this.hiringManager = hiringManager;
	}

	/**
	 * @return the numberOfPositions
	 */
	public String getNumberOfPositions() {
		return numberOfPositions;
	}

	/**
	 * @param numberOfPositions the numberOfPositions to set
	 */
	public void setNumberOfPositions(String numberOfPositions) {
		this.numberOfPositions = numberOfPositions;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}
