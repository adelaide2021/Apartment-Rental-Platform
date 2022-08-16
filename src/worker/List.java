package worker;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public interface List<T> {

  /**
   * Get the size of this list
   * @return the size of this list
   */
  int getSize();
  
  /**
   * Add node to the front.
   */
  void addFront(T d);
  
  /**
   * Add node to the back.
   * @param d
   */
  void addBack(T d);
  
  /**
   * Add node to the given index
   * @param index
   * @param d
   */
  void addIndex(int index, T d);
  
  /**
   * get the node from given index.
   * @param index
   * @return
   * @throws IllegalArgumentException
   */
  T get(int index) throws IllegalArgumentException;
  
  /**
   * Remove node from the list
   * @param d
   */
  void remove(T d);

  /**
   * Map the list to a new list
   * @param <R>
   * @param converter
   * @return new list
   */
  <R> List<R> map(Function<T, R> converter);
  
  /**
   * Reduce the list to a value
   * @param initialValue
   * @param combiner
   * @return
   */
  T reduce(T initialValue, BiFunction<T,T,T> combiner);
  
  /**
   * Filter the list
   * @param predicate
   * @return list after filtering
   */
  List<T> filter(Predicate<T> predicate);

}
