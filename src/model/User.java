package model;

/**
 * This class represents a User. A user must have an email,
 * first name, last name and password.
 */

public class User {
  private String email;//One email address corresponds to one user, and can only be registered once
  private String firstName;
  private String lastName;  
  private String password;
  private UserType userType;
  
  /**
   * Constructs a User object when user registration and initialize it to the 
   * given email, first name, last name and password.
   * @param email  the email address of the user
   * @param firstName  the first name of the user
   * @param lastName   the last name of the user
   * @param password  the password of the user
   */
  public User(String email, String firstName, String lastName, String password) {
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
    this.userType = UserType.guest;
  }
  
  /**
   * Construct a User object and initialize it to the given user,
   * used when creating Applicant/Resident object
   * @param user the existing user object
   */
  public User(User user) {
    this.firstName = user.firstName;
    this.lastName = user.lastName;
    this.email = user.email;
    this.password = user.password;   
  }
  
  /**
   * Get the first name of this user
   * @return the first name of this user
   */
  public String getFirstName() {
    return this.firstName;
  }
  
  /**
   * Get the last name of this user
   * @return the last name of this user
   */
  public String getLastName() {
    return this.lastName;
  }
  
  /**
   * Get the email of this user
   * @return the email of this user
   */
  public String getEmail() {
    return this.email;
  }
  
  /**
   * Get the type of this user
   * @return the type of this user
   */
  public UserType getUserType() {
    return this.userType;
  }
  
  /**
   * Get the password of this user
   * @return the password of this user
   */
  public String getPassword() {
    return password;
  }
  
  /**
   * Set the first name of this user
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  
  /**
   * Set the last name of this user
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  /**
   * Set the last name of this user
   */
  public void setEmail(String email) {
    this.email = email;
  }
  
  /**
   * Set the password of this user
   */
  public void setPassword(String password) {
    this.password = password;
  }
  
  /**
   * Set the type of this user
   */
  public void setUserType(UserType userType) {
    this.userType = userType;
  }
 
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || !(o instanceof User)) {
      return false;
    }
    User other = (User) o;
    return this.email.equals(other.email)
          && this.firstName.equals(other.firstName)
          && this.lastName.equals(other.lastName);
  }
  
  @Override
  public String toString() {
    return "first name: " + firstName +  "\n" +
        "last name: " + lastName + "\n" +
        "email: " + email + "\n";
  }

 }
  
 

