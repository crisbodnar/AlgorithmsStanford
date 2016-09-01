import java.io.*;
import java.util.*;

public class Main {

    private static long computeInversionsAndSort(ArrayList<Character> array, int n) {
       if(n == 1) return 0;

       int middle = n / 2;
       ArrayList<Character> leftArray = new ArrayList<Character>(array.subList(0, middle));
       ArrayList<Character> rightArray = new ArrayList<Character>(array.subList(middle, array.size()));

       long leftInversions = computeInversionsAndSort(leftArray, leftArray.size());
       long rightInversions = computeInversionsAndSort(rightArray, rightArray.size()); 
       long splitInversions = merge(leftArray, rightArray, array); 

       return leftInversions + rightInversions + splitInversions;       
    }

    private static long merge(ArrayList<Character> left, ArrayList<Character> right,
                                                       ArrayList<Character> sorted) {
       int leftIndex = 0;
       int rightIndex = 0;
       int sortedIndex = 0;
       long inversions = 0;
       
       for(;sortedIndex < sorted.size() && leftIndex < left.size() && rightIndex < right.size(); 
           sortedIndex++) {
           if(left.get(leftIndex).compareTo(right.get(rightIndex)) <= 0) {
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
        BufferedReader reader = new BufferedReader(new FileReader("litere.in"));
        PrintWriter printer = new PrintWriter(new FileWriter("litere.out"));


        reader.readLine();
        char[] charArray = reader.readLine().toCharArray();
        Character[] characterArray = new Character[charArray.length];
        for(int i = 0; i < charArray.length; i++)
            characterArray[i] = charArray[i];

        ArrayList<Character> array = new ArrayList<Character>(Arrays.asList(characterArray));

        printer.println(computeInversionsAndSort(array, array.size()));
        printer.close();
    }
}