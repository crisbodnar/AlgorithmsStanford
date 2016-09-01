import java.io.*;
import java.util.*;

//QuickSort which also returns the number of comparisons
public class QuickSort {

    private static List<Integer> array = new ArrayList<Integer>();

    public static int pickPivotLeft(int left, int right) {
        return left;
    }

    public static int pickPivotRight(int left, int right) {
        return right;
    }

    public static int max(int i, int j) {
        if(array.get(i) > array.get(j))
            return i;
        else
            return j;
    }

    public static int min(int i, int j) {
        if(array.get(i) > array.get(j))
            return j;
        else
            return i;
    }

    public static int pickPivotAverage(int left, int right) {
        int middle = left + (right - left) / 2;
        return max(min(left, right), min(max(left, right), middle));
    }

    public static void swap(int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    public static int partition(int left, int right) {
        int leftMostRightPartition = left + 1;

        for(int front = left + 1; front <= right; front++)
            if(array.get(front) < array.get(left)) {
                swap(leftMostRightPartition, front);
                leftMostRightPartition++;
            }
        swap(left, leftMostRightPartition - 1);
        return leftMostRightPartition - 1;
    }

    public static int sort(int left, int right) {
        if(right <= left) return 0;

        int pivotIndex = pickPivotLeft(left, right);
        swap(left, pivotIndex);

        pivotIndex = partition(left, right);
        int leftComparisons = sort(left, pivotIndex - 1);
        int rightComparisons = sort(pivotIndex + 1, right);

        return right - left + leftComparisons + rightComparisons;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("QuickSort.txt"));

        for(String line; (line = reader.readLine()) != null;)
            array.add(Integer.parseInt(line));

        System.out.println(sort(0, array.size() - 1));
    }
}
