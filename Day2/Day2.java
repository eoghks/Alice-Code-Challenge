import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int l=0; l< m; l++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();
            int[] temp = Arrays.copyOfRange(arr, i-1, j);
            Arrays.sort(temp);
            System.out.println(temp[k-1]);
        }
    }
}
