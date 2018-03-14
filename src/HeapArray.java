import java.util.Arrays;

public class HeapArray {
	Employee[] item = new Employee[10];
	private int size = 0;
	
	public void insert(Employee value){
		ensureCapacity();
		item[size++] = value;
		bubble(size-1);
	}
	private void bubble(int i) {
		if(i != 0){
			int parentIndex = (i-1)/2;
			if(item[parentIndex].compareTo(item[i])<0){
				swap(parentIndex,i);
			}
		}
		
	}
	public void serve(){
		if(size>0){
			item[0] = item[size-1];
			size--;
			trickle(0);
		}
	}
	private void trickle(int i) {
		int rightIndex=i*2,leftIndex=i*2+1;
		if(rightIndex>=size){
			return;
		}
		if(item[i].compareTo(item[rightIndex])<0||item[i].compareTo(item[leftIndex])<0){
			swap(i,max(rightIndex,leftIndex));
			trickle(max(rightIndex,leftIndex));
		}
	}
	private int max(int index1, int index2) {
		if(item[index1].compareTo(item[index2])>0){
			return index1;
		}
		else{
			return index2;
		}
	}
	private void swap(int index1, int index2) {
		Employee temp;
		temp = item[index1];
		item[index1] = item[index2];
		item[index2] = temp;
	}
	private void ensureCapacity(){
		if(size == item.length-1){
			Employee[] temp = new Employee[item.length*2];
			System.arraycopy(item, 0, temp, 0, item.length);
			item = temp;
		}
	}
	public String toString(){
		return Arrays.toString(item);
	}
}
