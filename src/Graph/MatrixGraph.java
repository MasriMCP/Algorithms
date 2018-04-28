package Graph;

import java.util.Iterator;

public class MatrixGraph extends Graph<Integer>{
	private int[][] mat;
	public MatrixGraph(int x) {
		mat = new int[x][x];
		order = x;
		initializeMat();
	}
	public MatrixGraph(boolean d,int x){
		super(d);
		mat = new int[x][x];
		order = x;
		initializeMat();
	}
	@Override
	public void insert(Integer t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connect(Integer t1, Integer t2, int weight) {
		mat[t1-1][t2-1] = weight;
		size++;
		if(!directed)
		mat[t2-1][t1-1] = weight;
	}

	@Override
	public void delete(Integer t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disconnect(Integer t1, Integer t2) {
		mat[t1-1][t2-1] = -1;
		size++;
		if(!directed)
		mat[t2-1][t1-1] = -1;
	}

	@Override
	public boolean connected(Integer t1, Integer t2) {
		return mat[t1-1][t2-1]>=0;
	}
	public String toString(){
		String s = "";
		for (int i = 0; i < mat.length; i++) {
			s += java.util.Arrays.toString(mat[i])+"\n";
		}
		return s;
	}
	private void initializeMat(){
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if(i== j ) mat[i][j] = 0;
				else mat[i][j] = -1;
			}
		}
	}
	public int[][] floyd(){
		int[][] temp = new int[order][order];
		for (int k = 0; k < mat.length; k++) {
			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < mat.length; j++) {
					if((i==j)||(k==j)||(i==k)){
						temp[i][j] = mat[i][j];
					}
					else{
						int n = temp[i][k]+temp[k][j];
						if(n<temp[i][j]){
							temp[i][j] = n;
						}
						
					}
				}
			}
		}
		return temp;
	}
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
