import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = (int)Math.pow(2, n);
        ArrayList<Integer> sub = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        int [] arr = new int [n];
        for(int i = 0; i < len; i++) {
            sub.add(sc.nextInt());
        }
        Collections.sort(sub);
        sub.remove(0);
        for(int i=0; i< n; i++) {
            int min = sub.remove(0);
            for(int j=0; j<tempList.size(); j++) {
                int temp = tempList.get(j) + min;
                tempList.add(temp);
                sub.remove(Integer.valueOf(temp));
            }
            tempList.add(min);
            arr[i] = min;
        }
        for(int i=0; i<n; i++) {
            System.out.println(arr[i]);
        }
    }
}
