package model;

/**
 * This enum represents an application status.
 * There are four status: not applied, applied,
 * applied but been refused and approved.
 */
public enum ApplicationStatus {

  NotAppl("Not Applied"), Appl("Applied"), Ref("Refused"), Appr("Approved");
  
  private final String statusString;
  
  /**
   * Construct an ApplicationStatus, it has 
   * a string to indicate the current status.
   * @param statusString the status in string
   */
  private ApplicationStatus(String statusString) {
    this.statusString = statusString;
  }
  
  @Override
  public String toString() {
    return statusString;
  }

}
