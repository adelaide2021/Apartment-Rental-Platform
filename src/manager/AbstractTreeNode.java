package manager;

import java.util.List;
import java.util.function.Predicate;

/**
 * This abstract class represents a tree node.
 */
public abstract class AbstractTreeNode<T> implements TreeNode<T> {

    
    protected T data;
    
    public AbstractTreeNode(T data) {
      this.data = data;
    }
    
    public abstract TreeNode<T> addChild(Predicate<T> identifier, TreeNode<T> child);
    
    public abstract List<T> toList(Predicate<T> predicate);
    

}
