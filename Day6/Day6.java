import java.util.*;
class Main {
    public static void main(String[] args) {
        int result = 0;
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Graph> asc = new PriorityQueue<>((a, b) -> a.vertexs - b.vertexs);
        PriorityQueue<Graph> desc = new PriorityQueue<>((a, b) -> b.vertexs - a.vertexs);
        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            Graph g = new Graph(1);
            asc.add(g);
            desc.add(g);
        }

        int[] color = new int[n-1];
        for(int i=0; i< n-1; i++) {
            color[i] = sc.nextInt();
        }

        for(int i=0; i<n-1; i++) {
            Graph g1 = null;
            Graph g2 = null;
            if(color[i] == 0) {
                g1 = asc.poll();
                g2 = asc.poll();
                desc.remove(g1);
                desc.remove(g2);
                result += (g1.vertexs * g2.vertexs);
            } else {
                g1 = desc.poll();
                g2 = desc.poll();
                asc.remove(g1);
                asc.remove(g2);
            }
            g2.vertexs += g1.vertexs;
            asc.add(g2);
            desc.add(g2);
        }
        System.out.println(result);
    }

    public static class Graph {
        int vertexs;

        public Graph(int vertexs) {
            this.vertexs = vertexs;
        }
    }
}
