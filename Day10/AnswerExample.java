import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        int leftIndex = 0;
        int maxLength = 0;
        int arraySize = Integer.parseInt(bufferedReader.readLine());
        tokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] dataArray = new int[50001];
        int[] freqArray = new int[50001];
        for (int idx = 0; idx < arraySize; ++idx) {
            dataArray[idx] = Integer.parseInt(tokenizer.nextToken());
        }
        for (int rightIndex = 0; rightIndex < arraySize; ++rightIndex) {
            updateFrequency(freqArray, 1, dataArray[rightIndex], 1);

            int currentLength = rightIndex - leftIndex + 1;
            while (!validate(freqArray, currentLength)) {
                updateFrequency(freqArray, 1, dataArray[leftIndex], -1);
                ++leftIndex;
                --currentLength;
            }
            maxLength = Math.max(maxLength, currentLength);
        }
        System.out.println(maxLength);
        bufferedReader.close();
    }

    private static void updateFrequency(int[] array, int start, int value, int increment) {
        for (int idx = start; idx <= value; ++idx) {
            array[idx] += increment;
        }
    }

    private static int computeSum(int[] array, int start, int end) {
        return java.util.Arrays.stream(array, start, end + 1).sum();
    }

    private static boolean validate(int[] freqArray, int currentLength) {
        for (int idx = 1; idx <= currentLength; ++idx) {
            if (freqArray[idx] < currentLength - idx + 1)
                return false;
        }
        return true;
    }

}
