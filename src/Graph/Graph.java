package Graph;

import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class Graph<T> implements Iterable<T>{
	protected boolean directed = false;
	protected int size = 0;//number of edges 
	protected int order = 0;//number of vertices 
	Graph(){
		
	}
	Graph(boolean d){
		directed = d;
	}
	public abstract void insert(T t);
	public abstract void connect(T t1, T t2, int weight);
	public abstract void delete(T t);
	public abstract void disconnect(T t1, T t2);
	public abstract boolean connected(T t1, T t2);
	public boolean isDirected() {
		return directed;
	}
	public int getSize() {
		return size;
	}
	public int getOrder() {
		return order;
	}

}
