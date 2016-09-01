import java.util.*;
import java.io.*;


public class Hash {

    private static int low = -10000;
    private static int high = 10000;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("/Users/cbbodnar/AlgorithmsStanford/2-sum/src/input.txt"));
        Map<Long, Boolean> hash = new HashMap<>();

        for(String line; (line = in.readLine()) != null; ) {
            long number = Long.parseLong(line);
            hash.put(number, true);
        }

        int sol = 0;
        for(int t = low; t <= high; t++) {
            for(Map.Entry<Long, Boolean> entry: hash.entrySet()) {
                long number = entry.getKey();
                long otherNumber = t - number;
                if(otherNumber != number && hash.get(otherNumber) != null) {
                    sol++;
                    break;
                }
            }
        }

        System.out.println(sol);
        //427
    }
}
