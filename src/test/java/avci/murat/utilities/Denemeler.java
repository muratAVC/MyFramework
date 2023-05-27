package avci.murat.utilities;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class Denemeler {
    @Test
    public void dene(){
        int[] numbers={21, 3, 7, 2};
        System.out.println("twoSum(numbers,9) = " + Arrays.toString(twoSum(numbers, 9)));
    }

    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                int index = map.get(numbers[i]);
                result[0] = index ;
                result[1] = i;
                break;
            }
            else {
                map.put(target - numbers[i], i);
                System.out.println(target - numbers[i]+"--- "+ i);
            }
        }
        System.out.println(map.size());
        return result;
    }
}
