import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] charArray = s.toCharArray();
        
        if (nextPermutation(charArray)) {
            System.out.println(new String(charArray));
        } else {
            System.out.println(s);
        }
    }
    
    public static boolean nextPermutation(char[] array) {
        int i = array.length - 2;
        while (i >= 0 && array[i] >= array[i + 1]) {
            i--;
        }
        
        if (i < 0) {
            return false;
        }
        
        int j = array.length - 1;
        while (array[j] <= array[i]) {
            j--;
        }
        
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        
        reverse(array, i + 1, array.length - 1);
        return true;
    }
    
    private static void reverse(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
