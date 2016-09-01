import java.util.*;
import java.io.*;

public class StronglyConnectedComponents {

    private static final boolean[] visited = new boolean[900000];
    private static final int[] topo = new int[900000];
    private static int n = 0, n2;
    private static final Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
    private static final Map<Integer, LinkedList<Integer>> graph2 = new HashMap<>();


    private static void DFS(int vertex) {
        visited[vertex] = true;
        LinkedList<Integer> adj = graph.getOrDefault(vertex, new LinkedList<>());

        for(Integer vec : adj) {
            if(!visited[vec])
                DFS(vec);
        }

        topo[n--] = vertex;
    }

    private static int DFS2(int vertex) {
        visited[vertex] = false;
        LinkedList<Integer> adj = graph.getOrDefault(vertex, new LinkedList<>());

        int sum = 0;
        for(Integer vec : adj) {
            if(visited[vec])
                sum += DFS2(vec);
        }

        return 1 + sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

        Integer vertex1, vertex2;
        for(String line; (line = reader.readLine()) != null;) {
            vertex1 = Integer.parseInt(line.split(" ")[0]);
            vertex2 = Integer.parseInt(line.split(" ")[1]);

            //System.out.println(vertex1);
            //System.out.println(vertex2);

            n = Math.max(n, Math.max(vertex1, vertex2));

            if(graph.getOrDefault(vertex1, null) == null) {
                graph.put(vertex1, new LinkedList<>(Arrays.asList(vertex2)));
            }
            else {
                graph.get(vertex1).add(vertex2);
            }
        }

        n2 = n;
        Iterator<Integer> it = graph.keySet().iterator();

        while(it.hasNext()) {
            DFS(it.next());
        }

        List<Integer> comp = new ArrayList<Integer>();
        for(int index = 1; index <= n2; index++) {
            if(visited[topo[index]])
                comp.add(DFS2(topo[index]));
        }

        comp.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int com : comp)
            System.out.println(com);
    }
}