package Divide;

public class QuickSort {

    // 主排序方法
    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right); // 获取分区点
            quickSort(array, left, pivotIndex - 1);         // 递归排序左边
            quickSort(array, pivotIndex + 1, right);        // 递归排序右边
        }
    }

    // 分区方法
    private static int partition(int[] array, int left, int right) {
        int pivot = array[right]; // 选取最后一个元素作为基准
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j); // 把小于等于 pivot 的元素放到左边
            }
        }

        swap(array, i + 1, right); // 把 pivot 放到中间位置
        return i + 1;
    }

    // 交换两个元素
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // 测试代码
    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};
        quickSort(array, 0, array.length - 1);
        System.out.println("排序后的数组：");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}

