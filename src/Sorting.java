
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
			int max = arr[0];
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
	public static void heapSort(int[] arr){
		//TODO حل المشكل ماي نيغا 
		for (int i = arr.length-1; i >= 0; i--) {
			for( int j = i/2; j >= 0; j-- ){
		        heapify( arr, j, i);
			}
			swap(arr,0,i);
		}
	}
	private static void heapify( int[ ] arr, int i,int max )
	{
	    int left = 2 * i + 1;
	    int right = 2 * i + 2;
	    int largest = i;

	    if( left < max && arr[ left ] > arr[ largest ] )
	        largest = left;
	    if( right < max && arr[ right ] > arr[ largest ] )
	        largest = right;
	    if( largest != i )
	    {
	        int temp = arr[ i ];
	        arr[ i ] = arr[ largest ];
	        arr[ largest ] = temp;
	        heapify( arr, largest, max );
	    }
	}
}
