import java.util.*;
import java.io.*;
 
public class Main {
    static final int MAX = 2000100;
    static final long INF = (long) 1e18;
    static final int[] dirY = {-1, 0, 1, 0};
    static final int[] dirX = {0, 1, 0, -1};
    static int N;
    static long[] A = new long[MAX];
    static List<List<Pair>> v = new ArrayList<>();
    static long[][] dist = new long[MAX][5];
 
    static class Pair {
        int index;
        long cost;
        Pair(int index, long cost) {
            this.index = index;
            this.cost = cost;
        }
    }
 
    public static int get(int y, int x) {
        return y * N + x;
    }
 
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        N = sc.nextInt();
       
        for (int i = 0; i < MAX; i++) {
            v.add(new ArrayList<>());
        }
       
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int a = sc.nextInt();
                A[get(i, j)] = a;
            }
        }
 
        List<int[]> elice = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            elice.add(new int[]{y, x});
        }
 
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int current = get(i, j);
                for (int k = 0; k < 4; k++) {
                    int y = i + dirY[k];
                    int x = j + dirX[k];
                    if (y < 1 || y > N || x < 1 || x > N) {
                        continue;
                    }
                    int next = get(y, x);
                    v.get(current).add(new Pair(next, A[current] + A[next]));
                }
            }
        }
 
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < MAX; j++) {
                dist[j][i] = INF;
            }
            int[] start = elice.get(i);
            int now = get(start[0], start[1]);
            dist[now][i] = 0;
 
            PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(p -> p.cost));
            pq.add(new Pair(now, 0));
 
            while (!pq.isEmpty()) {
                Pair p = pq.poll();
                long curDist = p.cost;
                int curIndex = p.index;
 
                for (Pair next : v.get(curIndex)) {
                    if (dist[next.index][i] > curDist + next.cost) {
                        dist[next.index][i] = curDist + next.cost;
                        pq.add(new Pair(next.index, curDist + next.cost));
                    }
                }
            }
        }
 
        long answer1 = dist[get(1, 1)][0];
        for (int i = 1; i < 5; i++) {
            answer1 += dist[get(elice.get(i)[0], elice.get(i)[1])][i - 1];
        }
 
        long answer2 = dist[get(1, 1)][4];
        answer2 += dist[get(elice.get(1)[0], elice.get(1)[1])][4];
        answer2 += dist[get(elice.get(2)[0], elice.get(2)[1])][1];
        answer2 += dist[get(elice.get(3)[0], elice.get(3)[1])][2];
        answer2 += dist[get(elice.get(0)[0], elice.get(0)[1])][3];
 
        System.out.println(Math.min(answer1, answer2));
    }
 
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
        double nextDouble() {
            return Double.parseDouble(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
