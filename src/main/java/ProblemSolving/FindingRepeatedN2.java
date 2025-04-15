package ProblemSolving;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindingRepeatedN2 {
    public static void main(String[] args) {


        int[] arr = {1, 3, 3, 3, 3};

        int requiredCount = arr.length / 2;
        // Brute Force Nested Loops
        // O(n²)
        for (int n : arr) {
            int inc = 0;
            for (int j = 0; j < arr.length; j++) {
                if (n == arr[j]) {
                    inc++;
                }
            }
            if (inc > requiredCount) {
                System.out.println(n + " reapeated " + inc + " times");

                break;
            }

        }

        //: Hash Map Frequency Count
        // O(n)
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n = 0; n < arr.length; n++) {
            frequencyMap.put(arr[n], frequencyMap.getOrDefault(arr[n], 0) + 1);
            //   if(frequencyMap.get(arr[n]) > requiredCount){
            if (frequencyMap.get(arr[n]) > requiredCount) {

                System.out.println(arr[n] + " reapeated requiredCount");
                break;
            }
        }

//        Boyer-Moore Voting Algorithm
        // O(n)

        int result = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; ++i) {
            if (count == 0) {
                result = arr[i];
                count = 1  ;
            } else if (arr[i] == result) {
                count++;
            } else {
                count--;
            }
        }
        int occurance =0;
        for (int i = 0; i < arr.length; ++i) {
            if(result == arr[i]){
                occurance++;
            }
        }
        if(occurance>requiredCount){
            System.out.println(result + " reapeated requiredCount");
        }
        //Sorting Approach
        // O()
        Arrays.sort(arr);


    }
}
