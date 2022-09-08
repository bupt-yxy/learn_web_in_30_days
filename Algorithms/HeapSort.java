import java.util.Arrays;

public class HeapSort {
    public void heapAdjust(int[] list, int parent, int length) {
        int tmp = list[parent];
        int child = 2 * parent + 1;
        while (child < length) {
            if (child + 1 < length && list[child+1] > list[child])
                child++;
            if (tmp >= list[child])
                break;
            list[parent] = list[child];
            parent = child;
            child = 2 * child + 1;
        }
        list[parent] = tmp;
    }

    public void heapSort(int[] list) {
        int length = list.length;
        for (int i = length / 2;i >= 0;i--) {
            heapAdjust(list, i, length);
            System.out.println("第" + (length/2-i) + "次调整堆：" + Arrays.toString(list));
        }
        for (int i = length-1; i >= 0;i--) {
            System.out.println("当前堆为" + Arrays.toString(list));
            int tmp = list[i];
            list[i] = list[0];
            list[0] = tmp;
            heapAdjust(list, 0, i);
        }
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
        int[] arr = new HeapSort().generateArray(10,100);
//        int[] arr = {98, 5, 99, 44, 69, 53, 33, 96, 84, 72};
        new HeapSort().heapSort(arr);
    }
}
