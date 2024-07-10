import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> seq = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            seq.add(sc.nextInt());
        }
        for (int cnt = 0; cnt < m; cnt++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();
            List<Integer> part = new ArrayList<>(seq.subList(i - 1, j));
            Collections.sort(part);
            System.out.println(part.get(k - 1));
        }
        sc.close();
    }
}
