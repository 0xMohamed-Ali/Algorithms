    public class MergeSort {

        public static void main(String[] args){
            int arr[] = {90, 8, 3, 5, 2, 6, 10, 39, 1, 55, 3, 7, 9, 0};

            merge_sort(arr);

            for (int i = 0; i < arr.length; i++)
                System.out.printf(", %d", arr[i]);
        }
        public static void merge_sort(int[] arr){
            int len = arr.length;
            if (len <= 1) return;
        
            int mid = len / 2;
            int[] leftArr = new int[mid];
            int[] rightArr = new int[len - mid];
        
            for (int i = 0; i < len; i++) {
                if (i < mid)
                    leftArr[i] = arr[i];
                else
                    rightArr[i - mid] = arr[i];
            }
        
            merge_sort(leftArr);
            merge_sort(rightArr);
            merge(leftArr, rightArr, arr);
        }
        
        public static void merge(int[] leftArr, int[] rightArr, int[] arr){
            int leftLen = leftArr.length;
            int rightLen = rightArr.length;
            int i = 0, l = 0, r = 0;
        
            while (l < leftLen && r < rightLen) {
                if (leftArr[l] < rightArr[r]) {
                    arr[i++] = leftArr[l++];
                } else {
                    arr[i++] = rightArr[r++];
                }
            }
        
            while (l < leftLen) {
                arr[i++] = leftArr[l++];
            }
        
            while (r < rightLen) {
                arr[i++] = rightArr[r++]; // ✅ fixed from leftArr[r] to rightArr[r]
            }
        }
    }