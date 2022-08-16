package manager;

import dao.UnitList;

/**
 * This class represents a non supervisor employee.
 */
public class NonSupervisor extends GenericEmployee {
  
  public NonSupervisor(String number, String name, UnitList unitList, double pay) {
    super(number, name, unitList, pay);
  }
  
  @Override
  public GenericEmployee addSupervisee(String supervisorName, IEmployee supervisee) {
    if (this.name.equals(supervisorName)) {
      Supervisor newSelf = new Supervisor(this.number, this.name, this.unitList, this.pay);
      newSelf.addSupervisee(newSelf.getName(), supervisee);
      return newSelf;
    }
    return this;
  }

}
