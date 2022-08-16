package manager;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * This class represents a leaf node of the tree.
 */
public class LeafNode<T> extends AbstractTreeNode<T> {
    
    public LeafNode(T leaf) {
      super(leaf);
    }
    
    @Override
    public TreeNode<T> addChild(Predicate<T> identifier, TreeNode<T> child) {
      if (identifier.test(this.data)) {
        GroupNode<T> newGroupNode = new GroupNode<>(this.data);
        newGroupNode.childrenList.add(child);
        newGroupNode.addChild(identifier, child);
        return newGroupNode;
      }
      return this;

    }
    
    @Override
    public List<T> toList(Predicate<T> predicate) {
      List<T> result = new ArrayList<T>();
      if (predicate.test(data)) {       
        result.add(this.data);
      }
      return result;
    }
    
    @Override
    public <R> TreeNode<R> map(Function<T,R> transform) {
      return new LeafNode<R>(transform.apply(this.data));
    }
    
    @Override
    public T reduce(T initialValue, BiFunction<T, T,T> combiner) {
      return combiner.apply(initialValue,this.data);
    }


}
