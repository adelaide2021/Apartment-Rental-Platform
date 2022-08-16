package manager;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public interface TreeNode<T> {

  /**
   * Add child to the current tree
   * @param predicate
   * @param child
   * @return the new tree node
   */
    TreeNode<T> addChild(Predicate<T> predicate, TreeNode<T> child);
    
    /**
     * Convert the tree to a list
     * @param predicate
     * @return the list
     */
    List<T> toList(Predicate<T> predicate);

    /**
     * Map the tree
     * @param <R>
     * @param transform
     * @return tree after mapping
     */
    <R> TreeNode<R> map(Function<T,R> transform);
    
    /**
     * Reduce the tree
     * @param initialValue
     * @param combiner
     * @return tree after reducing
     */
    T reduce(T initialValue, BiFunction<T,T,T> combiner);
 

}
