import java.util.*;
class Main {
    static int [][] point = new int [6][2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] weights = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                weights[i][j] = sc.nextInt();
            }
        }

        for(int i=1; i<6; i++) {
            point[i][0] = sc.nextInt();
            point[i][1] = sc.nextInt();
        }
        
        point[0][0] = 1;
        point[0][1] = 1;
        
        ArrayList<Info> list = new ArrayList<>();

        for(int i=0; i < 5; i++) {
            list.add(makeInfo(i, i+1));
        }
        list.add(makeInfo(0, 5));
        list.add(makeInfo(5, 2));
        list.add(makeInfo(4, 1));

        Map<Info, Integer> map = new HashMap<>();

        for(Info in: list) {
            int weight = Integer.MAX_VALUE;
            PriorityQueue<Info> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
            pq.add(in);
            while(!pq.isEmpty()) {
                Info info = pq.poll();
                if(info.x1 == info.x2 && info.y1 == info.y2) {
                    weight = Math.min(weight, info.weight);
                    continue;
                }

                if(info.weight > weight) {
                    continue;
                }

                int tempWeight = info.weight + weights[info.x1][info.y1];

                if(info.x1 < n) {
                    pq.add(new Info(info.x1 + 1, info.y1, info.x2, info.y2, tempWeight + weights[info.x1 + 1][info.y1]));
                } 

                if(info.x1 > 1) {
                    pq.add(new Info(info.x1 - 1, info.y1, info.x2, info.y2, tempWeight + weights[info.x1 - 1][info.y1]));
                }

                if(info.y1 < n) {
                    pq.add(new Info(info.x1, info.y1 + 1, info.x2, info.y2, tempWeight + weights[info.x1][info.y1 + 1]));
                } 

                if(info.y1 > 1) {
                    pq.add(new Info(info.x1, info.y1 - 1, info.x2, info.y2, tempWeight + weights[info.x1][info.y1 - 1]));
                }
            }

            map.put(in, weight);
        }


        int[] path1 = {0, 1, 2, 3, 4};
        int[] path2 = {5, 6, 2, 3, 7};
        int answer1 = 0;
        int answer2 = 0;
        for(int i=0; i<5; i++) {
            answer1 += map.get(list.get(path1[i]));
        }
        for(int i=0; i<5; i++) {
            answer2 += map.get(list.get(path2[i]));
        }

        System.out.println(Math.min(answer1, answer2));

    }

    public static class Info{
        int x1;
        int y1;
        int x2;
        int y2;
        int weight;

        public Info(int x1, int y1, int x2, int y2, int weight) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.weight = weight;
        }
    }

    public static Info makeInfo(int i, int j) {
        return new Info(point[i][0], point[i][1], point[j][0], point[j][1], 0);
    }
}
