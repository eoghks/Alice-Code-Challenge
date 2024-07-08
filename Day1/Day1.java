import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = in.nextInt();
        int prev = n%10;
        n = n/10;
        int num = 10;
        int temp = 0;

        while(n > 0) {
            pq.add(prev);
            temp = n% 10;
            n /= 10;
            num *= 10;
            if(temp < prev) {
               break;
            }
            prev = temp;
        }

        int result = n * num;
        num /= 10;
        int tempNum = num;
        boolean check = true;
        while(!pq.isEmpty()) {
            int i = pq.remove();
            num /= 10;
            if(check && i > temp) {
                result = result + i * tempNum + temp * num;
                check = false;
            } else {
                result = result + i * num;
            }
        }
        System.out.println(result);
    }
}
