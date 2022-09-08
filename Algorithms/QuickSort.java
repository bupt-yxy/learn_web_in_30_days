import java.util.Arrays;

public class QuickSort {
    public void quickSort(int[] list, int left, int right) {
        int low = left;
        int high = right;
        int tmp = list[low];
        if (low >= high) {
            return;
        }
        while (low < high) {
            while (low < high && list[high] >= tmp) {
                high--;
            }
            list[low] = list[high];
            while (low < high && list[low] <=tmp) {
                low++;
            }
            list[high] = list[low];
        }
        list[low] = tmp;
        quickSort(list, left, low-1);
        quickSort(list, low+1, right);
    }

    public int[] generateArray(int len, int max) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int)(Math.random()*max);
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static void main(String[] args) {
        int[] list = new QuickSort().generateArray(10, 100);
        new QuickSort().quickSort(list, 0, list.length-1);
        System.out.println(Arrays.toString(list));
    }
}
