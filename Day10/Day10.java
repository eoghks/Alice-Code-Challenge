import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 1;
        int N = sc.nextInt();
        int[] data = new int[N+1];
        for(int i=1; i<=N; i++) {
            data[i] = sc.nextInt();
        }

        int left =1;
        int arr[] = new int[N+1];
        for(int right = 1; right <= N; right++) {
            int cur = right - left + 1;
            updateArr(arr, data[right], 1);

            while(validate(arr, cur) == false) {
                updateArr(arr, data[left], -1);
                left++;
                cur--;
            }
            answer = Math.max(cur , answer);
        }

        System.out.println(answer);
    }

    private static void updateArr(int[] arr, int end, int increment) {
        for(int i = 1; i <= end; i++) {
            arr[i] += increment;
        }
    }

    private static boolean validate(int[] arr, int cur) {
        for (int idx = 1; idx <= cur; ++idx) {
            if (arr[idx] < cur - idx + 1) // idx보다 큰 숫자가 몇개 있어
                return false;
        }
        return true;
    }
}
