package manager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * This class represents a non leaf node of a tree
 */
public class GroupNode<T> extends AbstractTreeNode<T> {
    
    protected List<TreeNode<T>> childrenList;
    
    public GroupNode(T data) {
      super(data);
      childrenList = new LinkedList<TreeNode<T>>();
    }
    
    @Override
    public TreeNode<T> addChild(Predicate<T> identifier, TreeNode<T> child) {
      if (identifier.test(this.data)) {
        this.childrenList.add(child);
        return this;
      }
      for (int i = 0; i < this.childrenList.size(); i++) {
        this.childrenList.set(i, this.childrenList.get(i).addChild(identifier, child));
      }
      return this;
    }
    
    @Override
    public List<T> toList(Predicate<T> predicate) {
      List<T> result = new ArrayList<>();
      if (predicate.test(this.data)) {    
        result.add(this.data);
      }
      for (TreeNode<T> child: childrenList) {
        result.addAll(child.toList(predicate));
      }
      return result;
    }
    
    @Override
    public <R> TreeNode<R> map(Function<T,R> transform) {
      GroupNode<R> newNode = new GroupNode<R>(transform.apply(this.data));
      for (TreeNode<T> child:childrenList) {
        newNode.childrenList.add(child.map(transform));
      }
      return newNode;
    }
    
    @Override
    public T reduce(T initialValue, BiFunction<T,T,T> combiner) {
      T result = this.data;
      for (TreeNode<T> child:childrenList) {
        result = child.reduce(result,combiner);
      }
      return combiner.apply(initialValue,result); 
    }
    

  


}
