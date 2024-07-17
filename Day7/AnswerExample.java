import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.next();
        int K = scanner.nextInt();
        scanner.close();
        
        boolean[] digit = new boolean[10];
        int cnt = 0;
        
        if (K == 10) {
            System.out.println("1023456789");
        } else if (K == 9) {
            System.out.println("102345678");
        } else {
            while (cnt != K) {
                Arrays.fill(digit, false);
                cnt = 0;
                N = Integer.toString(Integer.parseInt(N) + 1);
                for (int i = 0; i < N.length(); i++) {
                    digit[N.charAt(i) - '0'] = true;
                }
                for (int i = 0; i < 10; i++) {
                    if (digit[i]) {
                        cnt++;
                    }
                }
            }
            System.out.println(N);
        }
    }
}
