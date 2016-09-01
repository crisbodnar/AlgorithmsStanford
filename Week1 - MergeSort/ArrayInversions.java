import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ArrayInversions {

    private static long computeInversionsAndSort(ArrayList<Integer> array, int n) {
       if(n == 1 || n == 0) return 0;

       int middle = n / 2;
       ArrayList<Integer> leftArray = new ArrayList<Integer>(array.subList(0, middle));
       ArrayList<Integer> rightArray = new ArrayList<Integer>(array.subList(middle, array.size()));

       long leftInversions = computeInversionsAndSort(leftArray, leftArray.size());
       long rightInversions = computeInversionsAndSort(rightArray, rightArray.size()); 
       long splitInversions = merge(leftArray, rightArray, array); 

       return leftInversions + rightInversions + splitInversions;       
    }

    private static long merge(ArrayList<Integer> left, ArrayList<Integer> right,
                                                       ArrayList<Integer> sorted) {
       int leftIndex = 0;
       int rightIndex = 0;
       int sortedIndex = 0;
       long inversions = 0;
       
       for(;sortedIndex < sorted.size() && leftIndex < left.size() && rightIndex < right.size(); 
           sortedIndex++) {
           if(left.get(leftIndex) < right.get(rightIndex)) {
               sorted.set(sortedIndex, left.get(leftIndex));
               leftIndex++;
           }
           else {
               sorted.set(sortedIndex, right.get(rightIndex));
               rightIndex++;
               
               inversions += left.size() - leftIndex;
           }  
       }

       for(; leftIndex < left.size(); leftIndex++)
           sorted.set(sortedIndex++, left.get(leftIndex));  
    
       for(; rightIndex < right.size(); rightIndex++)
           sorted.set(sortedIndex++, right.get(rightIndex));

       return inversions; 
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("test.txt"));

        String line = null;
        ArrayList<Integer> array = new ArrayList<Integer>();
        while((line = reader.readLine()) != null) {
            array.add(Integer.parseInt(line));
        }

        System.out.println(computeInversionsAndSort(array, array.size()));
    }
}