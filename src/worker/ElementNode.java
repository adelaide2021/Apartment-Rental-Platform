package worker;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

import manager.GroupNode;
import manager.TreeNode;

/**
 * This class represents an generic node in a linked list.
 * The node saves it's own data and the rest of the data
 */
public class ElementNode<T> implements Node<T> {
  
    private T object;
    private Node<T> rest;
    
    public ElementNode() {} 

    public ElementNode(T object, Node<T> rest) {
        this.object = object;
        this.rest = rest;
    }

    @Override
    public int count() {
        return countHelp(0);
    }
    public int countHelp(int acc) {
        return this.rest.countHelp(1+acc);
    }
    
    @Override
    public String toString() {
        String objString = this.object.toString();
        String restString = this.rest.toString();
        if (restString.length() > 0) {
          return objString + " " + restString;
        }
        else {
          return objString;
        }
    }
    
    @Override
    public Node<T> addFront(T object) {
      return new ElementNode<>(object, this);    
    }
    
    @Override
    public Node<T> addBack(T object) {
      this.rest = this.rest.addBack(object);
      return this;    
    }
    
    @Override
    public Node<T> addIndex(int index, T object) {
      if (index == 0) {
        return addFront(object);
      }
      else {
        this.rest = this.rest.addIndex(index - 1, object);
        return this;
      }
    }
    
    @Override
    public T get(int index) throws IllegalArgumentException {
      if (index == 0) {
        return this.object;
      }
      else {
        return this.rest.get(index - 1);
      }
    }
    
    @Override
    public Node<T> remove(T object) {
      if (this.object.equals(object)) {
        return this.rest;
      }
      else {
        this.rest = this.rest.remove(object);
        return this;
      }
    }
    
    @Override
    public <R> Node<R> map(Function<T, R> converter) {
      return new ElementNode<>(
          converter.apply(this.object),
          this.rest.map(converter)
          );
    }
    //不确定map写的对不对
    @Override
    public T reduce(T initialValue, BiFunction<T,T,T> combiner) {
      T result = this.object;
      result = this.rest.reduce(result,combiner);
      return combiner.apply(initialValue,this.rest.reduce(initialValue, combiner)); 
    }
    
    @Override
    public Node<T> filter(Predicate<T> predicate) {
      if (predicate.test(object)) {
        return new ElementNode<T>(this.object, this.rest.filter(predicate));
      }
      else {
        return this.rest.filter(predicate);
      }   
    }
    
}
