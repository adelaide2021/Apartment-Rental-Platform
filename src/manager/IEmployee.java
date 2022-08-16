package manager;

import java.util.List;
import java.util.function.Predicate;

import dao.UnitList;

public interface IEmployee {
    /**
     * Get the number of employee.
     * @return the number of employee
     */
    String getNumber();
    
    /**
     * Get the name of employee
     * @return the name of employee
     */
    String getName();
    
    /**
     * Get the unit list the the employee in charge of.
     * @return the unit list the the employee in charge of.
     */
    UnitList getUnitList();
    
    /**
     * Get the pay of this employee.
     * @return the pay of this employee
     */
    double getPay();
    
    /**
     * Add supervisee to the employee
     * @param supervisorName
     * @param newEmployee
     * @return
     */
    IEmployee addSupervisee(String supervisorName, IEmployee newEmployee);
    
    /**
     * Count the number of the employee from current node.
     * @param predicate
     * @return the number of employee
     */
    int count(Predicate<IEmployee> predicate);
    
    /**
     * Convert employees to a list.
     * @param predicate
     * @return the list of employee
     */
    List<IEmployee> toList(Predicate<IEmployee> predicate);


}
