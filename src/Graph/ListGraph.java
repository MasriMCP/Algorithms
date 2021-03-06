package Graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ListGraph<T> extends Graph<T> {
    HashMap<T, HashMap<T, Integer>> list = new HashMap<>();

    public ListGraph() {
    }

    public ListGraph(boolean d) {
        super(d);
    }

    public void insert(T t) {
        list.put(t, new HashMap<T, Integer>());
        order++;
    }

    public void connect(T t1, T t2, int weight) {
        adjacent(t1).put(t2, weight);
        size++;
        if (!directed)
            adjacent(t2).put(t1, weight);
    }

    public void delete(T t) {
        for (T v : this) {
            if (connected(v, t)) {
                disconnect(v, t);
            }
        }
        size -= adjacent(t).keySet().size();
        list.remove(t);

        order--;
    }

    public void disconnect(T t1, T t2) {
        if (!connected(t1, t2)) return;
        adjacent(t1).remove(t2);
        size--;
        if (!directed)
            adjacent(t2).remove(t1);

    }


    public HashMap<T, Integer> adjacent(T t) {
        return list.get(t);
    }


    public void rename(T t1,T t2) {
        HashMap<T, Integer> temp = adjacent(t1);
        insert(t2);
        for (T i : temp.keySet()) {
            connect(t2, i, temp.get(i));
        }
        delete(t1);

    }

    public int getWeight(T t1, T t2) {
        try {
            return adjacent(t1).get(t2);
        } catch (NullPointerException ex) {
            throw new NoSuchElementException("no element " + t2.toString() + " is conneted to element " + t1.toString());
        }
    }

    public String dijkstra(T t1, T t2) {
        LinkedList<T> unvisited = new LinkedList<>();
        for (T t : list.keySet()) { //initialize unvisited list
            unvisited.add(t);
        }
        HashMap<T, Integer> weights = new HashMap<>();
        HashMap<T, T> previous = new HashMap<>();
        for (T t : list.keySet()) {//initialize all vertices to infinity
            weights.put(t, Integer.MAX_VALUE);
        }
        weights.put(t1, 0);//initialize source to zero
        T current = t1;
        previous.put(t2, null);
        while (!unvisited.isEmpty()) {

            for (T t : adjacent(current).keySet()) {
                int n = getWeight(current, t) + weights.get(current);
                if (n < weights.get(t)) {
                    weights.put(t, n);
                    previous.put(t, current);
                }
            }
            unvisited.remove(current);
            T min;
            try {
                min = unvisited.get(0);
            } catch (Exception ex) {
                break;
            }
            for (T t : unvisited) {
                if (weights.get(t) < weights.get(min)) {
                    min = t;
                }
            }

            current = min;
        }
        String ret = t2.toString();
        T prev = previous.get(t2);
        while (prev != null) {
            ret += " " + prev.toString();
            prev = previous.get(prev);
        }
        return ret;
    }

    public boolean connected(T t1, T t2) {
        return adjacent(t1).containsKey(t2);
    }
    public boolean isConnected(){
        List<T> temp = new LinkedList<>(list.keySet());
        for(T i:this){
            temp.remove(i);
        }
        return temp.isEmpty();
    }
    public boolean contains(T t){
        return list.keySet().contains(t);
    }
    @Override
    public String toString() {
        return list.toString();
    }

    @Override
    public Iterator iterator() {
        return new GraphIterator();
    }

    private class GraphIterator implements Iterator<T> {
        private int index = 0;
        private LinkedList<T> visited = new LinkedList<>();
        Stack<T> s = new Stack<>();
        T current = order>0?list.keySet().iterator().next():null;

        public GraphIterator() {
            s.push(current);
        }

        @Override
        public boolean hasNext() {
            return index < order&&!s.isEmpty();
        }

        @Override
        public T next() {
            //using Depth First Search
            if (!s.isEmpty()) {
                current = s.peek();
                s.pop();
                if (!visited.contains(current)) {
                    visited.add(current);
                }
                for (T t : adjacent(current).keySet()) {
                    if (!visited.contains(t) && !s.contains(t)) {
                        s.push(t);
                    }
                }
                index++;
                return current;

            }
            return null;
        }

    }

    public static ListGraph<String> readGraph(String fileName) {
        /*
        files should be written in the following format:

        directed/undirected
        *(asterisk)
        vertex 1: list of vertices (case sensitive, must be alphanumerical strings)
        Paris
        London
        etc...
        *(asterisk)
        vertex1 vertex2 weight : space separated
        Paris London 2500
        etc...
        *(asterisk)
         */
        ListGraph<String> g = new ListGraph<String>(true);
        try (BufferedReader s = new BufferedReader(new FileReader(new File(fileName)))) {
            boolean d = s.readLine().toLowerCase().equals("directed");
            g = new ListGraph<String>(d);
            String str = "";
            s.readLine();
            while (!(str = s.readLine()).equals("*")) {
                if(str.matches("[A-Za-z0-9]+"))
                g.insert(str);
            }
            String[] temp;

            while (!(str = s.readLine()).equals("*")) {
                if(str.matches("[A-Za-z\\d]+\\s+[A-Za-z\\d]+\\s+\\d+")){
                temp = str.split("\\s+");
                g.connect(temp[0], temp[1], Integer.parseInt(temp[2]));
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NoSuchElementException ex) {
            throw ex;
        }
        return g;
    }
}
