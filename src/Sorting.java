
public class Sorting {
	public static void bubbleSort(int[] arr){
		for (int i = arr.length; i > 0; i--) {
			for (int j = 0; j < i-1; j++) {
				if(arr[j]>arr[j+1]){
					swap(arr,j,j+1);
				}
			}
		}
	}
	public static void selectionSort(int[] arr){
		for (int i = arr.length-1; i > 0; i--) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if(arr[j]>arr[max]){
					max = j;
				}
			}
			swap(arr,max,i);
		}
	}
	public static void insertionSort(int[] arr){
		 int n = arr.length;
	        for (int i=1; i<n; ++i)
	        {
	            int key = arr[i];
	            int j = i-1;
	            while (j>=0 && arr[j] > key)
	            {
	                arr[j+1] = arr[j];
	                j = j-1;
	            }
	            arr[j+1] = key;
	        }
		}
	
	public static void mergeSort(int[] arr){
		if(arr.length<2) return;
		int[] left = new int[arr.length/2];
		int[] right = new int[arr.length-arr.length/2];
		System.arraycopy(arr, 0, left, 0, left.length);
		System.arraycopy(arr, arr.length/2, right, 0, right.length);
		mergeSort(left);
		mergeSort(right);
		merge(arr,left,right);
		
	}
	private static void merge(int[] arr, int[] left, int[] right) {
		int i = 0,j=0,k=0;
		while(i<left.length&&j<right.length){
			if(left[i]<=right[j]){
				arr[k] = left[i++];
			}
			else{
				arr[k] = right[j++];
			}
			k++;
		}
		while(i<left.length){
			arr[k++] = left[i++];
		}
		while(j<right.length){
			arr[k++] = right[j++];
		}
	}
	public static void quickSort(int[] arr){
		quickSort(arr,0,arr.length-1);
	}
	private static void quickSort(int[] arr,int low, int high){
		
		if(low<high){
			int p = partition(arr, low, high);
			quickSort(arr,low,p-1);
			quickSort(arr,p+1,high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int p = arr[high];
		int pi =low;
		for (int i = low; i < high ; i++) {
			if(arr[i]<=p){
				swap(arr,i,pi);
				pi++;
			}
		}
		swap(arr,pi,high);
		return pi;
	}
	
	private  static void swap(int[] arr,int index1,int index2){
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	static void heapSort(int[] a,int size){
		for (int i = a.length/2-1; i>=0; i--) {
			trickle(a,size,i);
		}
		
		for (int i = a.length-1; i >= 0; i--) {
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			trickle(a,0,i);
		}
	}
	public static void trickle(int[] a, int index,int size){
		int right = index*2+2,left = right -1;
		int max = index;
		if(left<size&&a[left]>a[max]) max = left;
		if(right<size&&a[right]>a[max]) max = right;
		if(max!=index){
			int temp = a[max];
			a[max] = a[index];
			a[index] = temp;
			trickle(a, max,size);
		}
	}
}
