package manager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import dao.UnitList;

/** 
 * This class represents a supervisor.
 * A supervisor has a list of supervisee.
 */
public class Supervisor extends GenericEmployee {
    
    private List<IEmployee> superviseeList;
    
    public Supervisor (String number, String name, UnitList unitList, double pay){
      super(number, name, unitList, pay);
      superviseeList = new LinkedList<IEmployee>();
    }
    
    public Supervisor (String number, String name, UnitList unitList, double pay, List<IEmployee> list){
      super(number, name, unitList, pay);
      superviseeList = list;
    }
    
    @Override
    public IEmployee addSupervisee(String supervisorName, IEmployee supervisee) {
      if (this.name.equals(supervisorName)) {
        this.superviseeList.add(supervisee);
        return this;
      }
      for (int i = 0; i < this.superviseeList.size(); i++) {
        this.superviseeList.set(i, 
            this.superviseeList.get(i).addSupervisee(
                supervisorName, supervisee));
      }
      return this;
    }

    @Override
    public int count(Predicate<IEmployee> predicate) {
      return this.superviseeList.stream()
                                .mapToInt(e -> e.count(predicate))
                                .sum()
             + super.count(predicate);
    }
    
    @Override
    public List<IEmployee> toList(Predicate<IEmployee> predicate) {
      List<IEmployee> resultList = new ArrayList<IEmployee>();
      resultList.add(this);
      for (IEmployee e : superviseeList) {
        resultList.addAll(e.toList(predicate));
      }
      return resultList;
    }


}
