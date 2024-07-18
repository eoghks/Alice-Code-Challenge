import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[][][] dp = new int[301][301][301];
    static int[] need = new int[301];

    // dp[i][j][k]는 i번째 시간에 친구 j명이 투입되고
    // 친구 k명이 남아있을 때 현재 + 앞으로 가능한 최대 강림 시간
    static int makeDP(int x, int y, int z) {
        //기저 케이스에 도달하면 리턴
        if (dp[x][y][z] != -1) {
            return dp[x][y][z];
        }
        
        if (need[x] > 0 && need[x + 1] > 0) {//오늘과 내일 모두 친구가 필요한 경우
            dp[x][y][z] = makeDP(x + 1, y, z);
        } else if (need[x] > 0 && need[x + 1] <= 0) {//오늘은 친구가 필요하나 내일은 친구가 모두 떠나는 경우 따라서 y=0
            dp[x][y][z] = makeDP(x + 1, 0, z);
        } else if (need[x] <= 0 && need[x + 1] > 0) { //오늘은 친구가 필요없으나 내일은 친구가 필요한 경우
            for (int i = 0; i <= z; i++) { //일반 신도 수 > T때가지 들어간 친구수는 유지된다.
                dp[x][y][z] = Math.max(dp[x][y][z], makeDP(x + 1, i, z - i));
            }
        } else if (need[x] <= 0 && need[x + 1] <= 0) { // 오늘과 내일 모두 친구가 필요없는 경우
            dp[x][y][z] = makeDP(x + 1, y, z);
        }
        if (y >= need[x]) {// 이미 투입된 친구가 필요한 사람보다 많으면
            dp[x][y][z] += 1;
        }
        return dp[x][y][z];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int T = sc.nextInt();

        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }
        Arrays.fill(need, T);
        need[0] = 0;

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            for (int j = a; j < b; j++) {
                need[j]--;
            }
        }

        //베이스 사례 만들기
        for (int i = 0; i <= 300; i++) {
            for (int j = 0; j <= 300; j++) {
                if (i >= need[N]) {
                    dp[N][i][j] = 1;
                } else {
                    dp[N][i][j] = 0;
                }
            }
        }

        System.out.println(makeDP(0, 0, K) - 1);
    }
}
