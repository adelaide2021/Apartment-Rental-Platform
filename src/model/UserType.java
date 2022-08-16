package model;

/**
 * This Enum represents user type.
 * There are three types of user: guest, resident, applicant.
 * A user is a guest automatically after signing up,
 * and become an applicant after submitting application,
 * and finally can become a resident after application approved and 
 * paying her/his deposit
 */
public enum UserType {
  guest,
  resident,
  applicant;

}
