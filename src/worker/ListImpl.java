package worker;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * This class represents a linked list.
 * A list has a head point to the head of the list.
 */
public class ListImpl<T> implements List<T> {
  
    private Node<T> head;
    
    public ListImpl() {
      head = new EmptyNode<>();
    }
    
    private ListImpl(Node<T> head) {
      this.head = head;
    }

    @Override
    public int getSize() {
      return head.count();
    }

    @Override
    public String toString() {
      return "(" + head.toString() + ")";
    }
    
    @Override
    public void addFront(T d) {
      head = head.addFront(d);
    }
    
    @Override
    public void addBack(T d) {
      head = head.addBack(d);
    }
    
    @Override
    public void addIndex(int index,T d) throws IllegalArgumentException{
      head = head.addIndex(index, d);
    }
    
    @Override
    public T get(int index) throws IllegalArgumentException {
      if ((index >= 0) && (index <= this.getSize())) { 
        return head.get(index);
      }
      else {
        throw new IllegalArgumentException("Index exceeds the size!");
      }
    }
    
    @Override
    public void remove(T d) {
      head = head.remove(d);
    }
    
    @Override
    public <R> List<R> map(Function<T, R> converter) {
      return new ListImpl<>(head.map(converter));
    }
    
    //所有的reduce都不知道写的对不对
    @Override
    public T reduce(T initialValue, BiFunction<T,T,T> combiner) {
      return head.reduce(initialValue, combiner);
    }
    
    @Override
    public List<T> filter(Predicate<T> predicate) {
      return new ListImpl<>(head.filter(predicate)); 
    }


  


}
