import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import worker.List;
import worker.ListImpl;
import worker.Technician;

public class TestLinkedList {
  
  
  private Technician t1;
  private Technician t2;
  private Technician t3;
  private List<Technician> list;
  
  @Before
  public void setUp() {
    t1 = new Technician("bob", 100, 50.00);
    t2 = new Technician("bob", 100, 50.00);
    t3 = new Technician("bob", 100, 50.00);
    list = new ListImpl<>();
    list.addBack(t1);
    list.addBack(t2);
    list.addBack(t3);
    System.out.print(list);
  }
  
  @Test
  public void testSize() {
    assertEquals(3, list.getSize());
  }
  
  @Test
  public void testGet() {
    assertEquals(t2, list.get(1));
  }
  
  @Test  
  public void testRemove() {
    list.remove(t1);
    assertEquals(2, list.getSize());
  }
  
  @Test
  public void testAddIndex() {
    list.addIndex(0, t1);
    assertEquals(4, list.getSize());
  }
  

}
