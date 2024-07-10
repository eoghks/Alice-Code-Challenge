import java.util.*;
class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String s = sc.next();
       char[] arr = s.toCharArray();
       int result =  decode(arr);
       System.out.println(result);
    }

    public static int decode(char [] s) {
        int result = 0 ;
        int start =0;
        int count = 0;
        int temp = 0;
        for(int i = 1; i < s.length; i ++) {
            if(count == 0) {
                if(s[i] == '(') {
                    temp = Character.getNumericValue(s[i-1]);
                    start = i +1;
                    count ++;
                } else {
                    result ++;
                }
            } else {
                if(s[i] == '(') {
                    count ++;
                } else if(count == 1 && s[i] == ')') {
                    result += temp * decode(Arrays.copyOfRange(s, start, i));
                } else if(s[i] == ')') {
                    count --;
                }
            }
        } 
        
        if(s[s.length-1] != '(' && s[s.length-1] != ')')
            result ++;

        return result;
    } 
}
