package model;

/**
 * This class represents description of amenity.
 * Amenity includes wash&dryer, air conditioner, Internet and furniture.
 */
public class Amenity {
  private boolean washdryer;
  private boolean ac;
  private boolean internet;
  private boolean furniture;
  
  /**
   * Construct an amenity and initialize it with the given boolean value of 
   * wash and dryer, ac, Internet, furniture.
   * @param washdryer if a unit contains wash and dryer
   * @param ac if a unit contains ac
   * @param internet if a unit contains Internet
   * @param furniture if a unit contains furniture
   */
  public Amenity(boolean washdryer, boolean ac, boolean internet, boolean furniture) {
    this.washdryer = washdryer;
    this.ac = ac;
    this.internet = internet;
    this.furniture = furniture;
  }
  
  public boolean getWashdryer() {
    return this.washdryer;
  }
  public boolean getAc() {
    return this.ac;
  }
  public boolean getInternet() {
    return this.internet;
  }
  public boolean getFurniture() {
    return this.furniture;
  }
  
  

}
