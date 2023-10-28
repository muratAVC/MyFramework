package avci.murat.step_definitions;

import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;

public class MyTasks {
    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int sum_1=0,sum_2=0;
        for (int i = 0; i < arr.size(); i++) {
                sum_1 += arr.get(i).get(i);
        }
        for (int i = arr.size()-1; i >=0 ; i--) {
            for (int j = 0; j < arr.size(); j++) {
                sum_2+=arr.get(i).get(j);
            }
        }
        return (sum_1-sum_2);
    }

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        double pozitive=0,negative=0,zero=0;
        for (int i = 0; i < arr.size(); i++) {
             if (arr.get(i)<0){
                 negative++;
             } else if (arr.get(i)>0){
                 pozitive++;
             }else {
                 zero++;
             }
        }
        double a=pozitive/ arr.size();
        double b=negative/ arr.size();
        double c=zero/ arr.size();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    public static void staircase(int n) {
        // Write your code here
        int a=n;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n-i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    @Test
    public static void min_Max_Sum() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(501893267, 649027153, 379408215, 452968170, 487530619));
        List<Long> arr1=new ArrayList<>();
        for (Integer i: arr) {
            arr1.add((long)i);
        }
        long sum=0;
        List<Long> sumList = new ArrayList<>();
        for (Long l : arr1) {
            sum += l;
        }
        for (Long l :arr1) {
            sumList.add(sum-l);
        }

        System.out.println(sumList.stream().mapToInt(Long::intValue).min().orElseThrow()+" "+ sumList.stream().mapToInt(Long::intValue).max().orElseThrow());
    }
}
