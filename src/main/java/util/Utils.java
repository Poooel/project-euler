package util;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;

@UtilityClass
public class Utils {
    public int[] listToIntArray(List<Integer> ints) {
        return ints.stream().mapToInt(Integer::intValue).toArray();
    }

    public long[] listToLongArray(List<Long> longs) {
        return longs.stream().mapToLong(Long::longValue).toArray();
    }

    public long productOfArray(int[] array) {
        long product = 1;

        for (int value : array) {
            product *= value;
        }

        return product;
    }

    public int[] getDigits(String number) {
        int[] digits = new int[number.length()];

        for (int i = 0; i < number.length(); i++) {
            digits[i] = Character.getNumericValue(number.charAt(i));
        }

        return digits;
    }

    public int[] subArray(int[] array, int startIndex, int endIndex) {
        return Arrays.copyOfRange(array, startIndex, endIndex);
    }
}
