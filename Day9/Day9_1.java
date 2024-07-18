import java.util.*;
class Main {
    static int[][] weight = new int[1001][1001];
    static int [][] alpabet = new int [6][2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][][][] dp = new int[n+1][n+1][n+1][n+1]; //dp[i][j][k][l]

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                weight[i][j] = sc.nextInt();
            }
        }

        for(int i=1; i<6; i++) {
            alpabet[i][0] = sc.nextInt();
            alpabet[i][1] = sc.nextInt();
        }

        for (int[][][] i : dp) {
            for (int[][] j : i) {
                for (int[] k : j) {
                Arrays.fill(k, 2000);
            }
            }
        }

        alpabet[0][0] = 1;
        alpabet[0][1] = 1;
        
        int answer1 = solve(n, dp);
        switchArray();
        int answer2 = solve(n, dp);
        System.out.println(Math.min(answer1, answer2));
    }

    public static void switchArray() {
        int[] temp = alpabet[1];
        alpabet[1] = alpabet[5];
        alpabet[5] = temp;
    }

    public static int solve(int n, int [][][][] dp ) {
        int answer = 0;
        //System.out.println("--------");
        for(int i=0; i < 5; i++) {
            answer += makdeDp(alpabet[i][0], alpabet[i][1], alpabet[i+1][0], alpabet[i+1][1], dp);
           // System.out.println(answer);
        }
        return answer;
    }

    public static int makdeDp(int x1, int y1, int x2, int y2, int [][][][] dp ) {
        if(x1 == x2 && y1 == y2) {
            return 0;
        }

        if(dp[x1][y1][x2][y2] != 0 ) {
            if(x1 < x2) {
                dp[x1][y1][x2][y2] = Math.min(dp[x1][y1][x2][y2] , makdeDp(x1+1, y1, x2, y2, dp) + weight[x1][y1] + weight[x1+1][y1]);
            } else if(x2 < x1) {
                dp[x1][y1][x2][y2] = Math.min(dp[x1][y1][x2][y2] , makdeDp(x1-1, y1, x2, y2, dp) + weight[x1][y1] + weight[x1-1][y1]);
            }

            if(y1 < y2) {
                dp[x1][y1][x2][y2] = Math.min(dp[x1][y1][x2][y2] , makdeDp(x1, y1+1, x2, y2, dp) + weight[x1][y1] + weight[x1][y1+1]);
            } else if(y2 < y1) {
                dp[x1][y1][x2][y2] = Math.min(dp[x1][y1][x2][y2] , makdeDp(x1, y1-1, x2, y2, dp) + weight[x1][y1 ]+ weight[x1][y1-1]);
            }
        } 
        return dp[x1][y1][x2][y2];
    }
    
}
