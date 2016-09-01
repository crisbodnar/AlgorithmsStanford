import java.io.BufferedReader;
import java.io.FileReader;
import java.util.NoSuchElementException;

public class Median {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("/Users/cbbodnar/AlgorithmsStanford/2-sum/src/input2.txt"));
        Heap minHeap = new Heap((int a, int b) -> a < b);
        Heap maxHeap = new Heap((int a, int b) -> a > b);

        int sol = 0;
        for(String line; (line = in.readLine()) != null; ) {
            int number = Integer.parseInt(line);
            if(maxHeap.isEmpty()) {
                maxHeap.insert(number);
            }
            else {
                if(number <= maxHeap.top())
                    maxHeap.insert(number);
                else
                    minHeap.insert(number);
            }

            if(maxHeap.size() - minHeap.size() > 1)
                minHeap.insert(maxHeap.pop());
            else if(minHeap.size() - maxHeap.size() > 1)
                maxHeap.insert(minHeap.pop());

            if(minHeap.size() <= maxHeap.size())
                sol = (sol + maxHeap.top()) % 10000;
            else
                sol = (sol + minHeap.top()) % 10000;

            //System.out.println(sol);

            /*if(!minHeap.isEmpty())
                System.out.println("min " + minHeap.top());
            if(!maxHeap.isEmpty())
                System.out.println("max " + maxHeap.top());
            */
            if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                //System.out.println(maxHeap.top() + " " + minHeap.top());
                assert (minHeap.top() >= maxHeap.top());
            }
        }

        System.out.println(sol);
    }


    private static class Heap {
        private static int NMAX = 10005;

        //underlying array of the heap
        private int[] heapArray = new int[NMAX];

        //Size of the heap
        private int size;

        //Relation which establishes the order between the elements
        private relation rel;

        public Heap(relation rel) {
            this.size = 0;
            this.rel = rel;
        }

        private void swap(int poza, int pozb) {
            int temp = heapArray[poza];
            heapArray[poza] = heapArray[pozb];
            heapArray[pozb] = temp;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void insert(int elem) {
            heapArray[++size] = elem;

            int poz = size;
            int father = poz >> 1;
            while(father > 0 && !rel.compare(heapArray[father], heapArray[poz])) {
                swap(father, poz);
                poz = father;
                father = poz >> 1;
            }
        }

        public int pop() {
            if(size == 0)
                throw new NoSuchElementException("Nothing to pop");

            int top = heapArray[1];
            heapArray[1] = heapArray[size--];

            int oldPoz = -1, poz = 1;
            while(poz != oldPoz) {
                oldPoz = poz;

                int child1 = poz << 1, child2 = child1 + 1;
                if(child1 <= size && !rel.compare(heapArray[poz], heapArray[child1])) poz = child1;
                if(child2 <= size && !rel.compare(heapArray[poz], heapArray[child2])) poz = child2;

                swap(oldPoz, poz);
            }

            return top;
        }

        public int top() {
            if(size > 0)
                return heapArray[1];
            else
                throw new NoSuchElementException("No top element");
        }

        public int size() {
            return size;
        }

        public interface relation {
            boolean compare(int a, int b);
        }
    }
}
