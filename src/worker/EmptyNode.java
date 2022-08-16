package worker;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * This class represents an empty node.
 */
public class EmptyNode<T> implements Node<T> {
  
    @Override
    public int count() {
        return 0;
    }
    public int countHelp(int acc) {
        return acc;
    }
    
    @Override
    public String toString() {
        return "";
    }
    public String toStringHelper(String result) {
      return result;
    }
    
    @Override
    public Node<T> addFront(T object) {
      return new ElementNode<>(object, this);
    }
    
    @Override
    public Node<T> addBack(T object) {
      return new ElementNode<>(object, this);
    }
    
    @Override
    public Node<T> addIndex(int index, T object) throws IllegalArgumentException {
      if (index == 0) {
        return addFront(object);
      }
      throw new IllegalArgumentException("Invalid index.");
    }
    
    @Override
    public T get(int index) throws IllegalArgumentException {
     throw new IllegalArgumentException("Empty list");
    }
    
    @Override
    public Node<T> remove(T object) {
      return this;
    }
    
    @Override
    public <R> Node<R> map(Function<T, R> converter) {
      return new EmptyNode<>();
    }
    
    @Override
    public T reduce(T initialValue, BiFunction<T,T,T> combiner) {
      return null;//不确定写的对不对
    }
    
    @Override
    public Node<T> filter(Predicate<T> predicate) {
      return new EmptyNode<>();   
    }
    

}
