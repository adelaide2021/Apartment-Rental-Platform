package worker;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Node<T> {
  /**
   * Count the number of the nodes
   */
  int count();
  int countHelp(int acc);
  
  /**
   * Convert the node to String type
   * @return the node of String 
   */
  String toString();
  
  /**
   * Add the node to the front
   * @param d
   * @return
   */
  Node<T> addFront(T d);
  
  /**
   * Add the node to the back
   * @param d
   * @return
   */
  Node<T> addBack(T d);
  
  /**
   * Add the node to the given index
   * @param index
   * @param d
   * @return
   * @throws IllegalArgumentException
   */
  Node<T> addIndex(int index, T d) throws IllegalArgumentException;
  
  /**
   * Get the node of the given index
   * @param index
   * @return
   * @throws IllegalArgumentException
   */
  T get(int index) throws IllegalArgumentException;
  
  /**
   * Remove node from the index
   * @param d
   * @return
   */
  Node<T> remove(T d);
  
  <R> Node<R> map(Function<T, R> converter);
  
  T reduce(T initialValue, BiFunction<T,T,T> combiner);
  
  Node<T> filter(Predicate<T> predicate);

}
