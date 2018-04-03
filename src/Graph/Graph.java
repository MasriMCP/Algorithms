package Graph;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Graph<T> implements Iterable{
	HashMap<T,HashMap<T,Integer>> list = new HashMap<>();
	public void insert(T t){
		list.put(t,new HashMap<T,Integer>());
	}
	public void connect(T t1, T t2,int weight){
		adjacent(t1).put(t2, weight);
		adjacent(t2).put(t1, weight);
	}
	public HashMap<T,Integer> adjacent(T t){
		return list.get(t);
	}
	public int getWeight(T t1,T t2){
		try{
		return adjacent(t1).get(t2);
		}
		catch(NullPointerException ex){
			throw new NoSuchElementException();
		}
	}
	public String dijkstra(T t1,T t2){
		
		LinkedList<T> unvisited = new LinkedList<>();
		for(T t: list.keySet()){ //initialize unvisited list
			unvisited.add(t);
		}
		HashMap<T,Integer> weights = new HashMap<>();
		HashMap<T,T> previous = new HashMap<>();
		for(T t:list.keySet()){//initialize all vertices to infinity 
			weights.put(t, Integer.MAX_VALUE);
		}
		weights.put(t2,0);//initialize source to zero
		T current = t2;
		previous.put(t1, null);
		while(!unvisited.isEmpty()){
			
			for(T t:adjacent(current).keySet()){
				int n = getWeight(current, t) + weights.get(current);
				if(n<weights.get(t)){
					weights.put(t, n);
					previous.put(t, current);
				}
			}
			unvisited.remove(current);
			T min;
			try{
			 min = unvisited.get(0);
			}
			catch(Exception ex){
				break;
			}
			for(T t: unvisited){
				if(weights.get(t)<weights.get(min)){
					min = t;
				}
			}
			
			current = min;
		}
		String ret = t1.toString();
		T prev = previous.get(t1);
		while(prev != null){
			ret += " "+prev.toString();
			prev = previous.get(prev);
		}
		return ret;
	}
	
	static Graph<Character> random(int size){
		Graph<Character> g = new Graph<>();
		for (int i = 0; i < size; i++) {
			g.insert((char)i);
		}
		
		return g;
	}
	@Override
	public Iterator iterator() {
		
		return null;
	}

}
