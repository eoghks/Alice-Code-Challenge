import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int T = sc.nextInt();
        int [] start = new int[N+1];
        int [] end = new int[N+2];
        
        for(int i=0; i<M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            start[a] += 1;
            end[b] += 1;
        }

        int time = 1;
        int total = 0;
        int friend = 0;
        int answer = N;
        for(; time <= N; time++) {
            total = total + start[time] - end[time];
            if(total - friend >= T) {
                total = total - friend;
                friend = 0;
            } else if(total < T) {
                int need = T - total;
                if(K < need) {
                    answer --;
                    continue;
                }
                K = K - need;
                friend = friend + need;
                total = T;
            } 
        }
        System.out.println(answer);
    }
}
