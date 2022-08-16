package daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dao.UtilityList;
import model.Utility;
import model.Unit;

/**
 * This class represents an utility list.
 */
public class UtilityListImpl implements UtilityList {
  
  private List<Utility> utilityList;
  
  public UtilityListImpl() {
    utilityList = new ArrayList<>();
  }
  
  @Override
  public void setUtilityList(List<Utility> utilities) {
    this.utilityList = utilities;
  }
  
  //所有这些判断是否存在，是判断有unit好呢，还是判断有这个utility本身好呢
  @Override
  public int addUtility(Utility utility) {
    if (utilityList.contains(utility)) {
      return 0;
    }
    else {
      utilityList.add(utility);  
      return 1;      
    }
  }

  @Override
  public int deleteUtility(Utility utility) {
    if (utilityList.contains(utility)) {
      utilityList.remove(utility);
      return 1;
    }
    else {
      return 0;
    } 
  }

  @Override
  public Utility getUtility(Unit unit) {
    Optional<Utility> result = utilityList.stream()
                              .filter(m -> m.getUnit() == unit)
                         .findFirst();
    return result.get();
  }
  
  

}
