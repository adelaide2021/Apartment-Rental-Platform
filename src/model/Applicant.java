package model;

import java.time.LocalDate;

/**
 * This class represents an applicant.
 * An applicant should provide her/his annual income, credit score,
 * expected move in date and expected lease term.
 * An applicant has an application status.
 */
public class Applicant extends User{
  private double annualIncome;
  private double creditScore;
  private LocalDate expMoveInDate;
  private int term;
  private ApplicationStatus status;
  
  /**
   * Construct an applicant and initialize it with the given user, annual income, 
   * credit score, expected move in date and term.
   * Change the user type to applicant.
   * @param user the given user information
   * @param annualIncome annual income of this applicant
   * @param creditScore credit score of this applicant
   * @param expMoveInDate move in date of this applicant
   * @param term lease term of this applicant
   */
  public Applicant(User user, double annualIncome, double creditScore, 
      LocalDate expMoveInDate, int term) {
    super(user);
    this.setUserType(UserType.applicant);
    this.annualIncome = annualIncome;
    this.creditScore = creditScore;
    this.expMoveInDate = expMoveInDate;
    this.term = term;
    this.status = ApplicationStatus.NotAppl;
  }

  /**
   * Get the annual income of this applicant
   * @return annual income of this applicant
   */
  public double getAnnualIncome() {
    return annualIncome;
  }

  /**
   * Set the annual income of this applicant
   */
  public void setAnnualIncome(double annualIncome) {
    this.annualIncome = annualIncome;
  }

  /**
   * Get the credit score of this applicant
   * @return credit score of this applicant
   */
  public double getCreditScore() {
    return creditScore;
  }

  /**
   * Set the credit score of this applicant
   */
  public void setCreditScore(double creditScore) {
    this.creditScore = creditScore;
  }

  /**
   * Get the move in date of this applicant
   * @return move in date of this applicant
   */
  public LocalDate getExpMoveInDate() {
    return expMoveInDate;
  }

  /**
   * Set the move in date of this applicant
   */
  public void setExpMoveInDate(LocalDate expMoveInDate) {
    this.expMoveInDate = expMoveInDate;
  }
  
  /**
   * Get the term of this applicant
   * @return term of this applicant
   */
  public int getTerm() {
    return term;
  }

  /**
   * Set the term of this applicant
   */
  public void setTerm(int term) {
    this.term = term;
  }

  /**
   * Get the application status of this applicant
   * @return application status of this applicant
   */
  public ApplicationStatus getStatus() {
    return status;
  }

  /**
   * Set the application status of this applicant
   */
  public void setStatus(ApplicationStatus status) {
    this.status = status;
  }


  

}
