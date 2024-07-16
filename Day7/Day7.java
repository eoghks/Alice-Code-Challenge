import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int k = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        while(n> 0) {
            int temp = (int)n%10;
            stack.add(temp);
            n = n/10;
        }
        if(stack.size() < k){
            long result = 1023456789 / (long)Math.pow(10, 10-k);
            System.out.println(result);
        } else {
            solve(stack, k);
        }
    }

    public static void solve(Stack<Integer> list, int k) {
        List<Integer> element = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        while(element.size() < k && element.size() + list.size() > k) {
            int i = list.pop();
            if(!element.contains(i)) {
                element.add(i);
            }
            result.add(i);
        }
        //여기서 부터 모르겟다.. 

        System.out.println(element);
        System.out.println(list);

    }
}
