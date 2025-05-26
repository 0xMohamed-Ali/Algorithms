public class SelectionSort {

    public static void main(String[] args) {
        int arr[] = {10, 2, 50, 60, 55, 22, 1, 0, 6, 90, 80, 80, 54};

        for(int i : arr)
            System.out.printf("%d, ", i);
        
        System.out.println(" ");
        selectionSort(arr);
        
        for(int i : arr)
            System.out.printf("%d, ", i);
        
    }
    public static void selectionSort(int[] arr){
        int len = arr.length - 1;
        int min, temp;

        for (int i = 0; i < len; i++){
            min = i;
            for(int j = i + 1; j < len; j++){
                if (arr[min] > arr[j])
                    min = j;
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}