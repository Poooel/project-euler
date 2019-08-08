package problem;

import launcher.Executable;
import util.Utils;

import java.util.Map;

import static java.util.Map.entry;

public class Problem017 implements Executable {
    Map<Integer, String> numbersAsStrings = Map.ofEntries(
        entry(1, "one"),
        entry(2, "two"),
        entry(3, "three"),
        entry(4, "four"),
        entry(5, "five"),
        entry(6, "six"),
        entry(7, "seven"),
        entry(8, "eight"),
        entry(9, "nine"),
        entry(10, "ten"),
        entry(11, "eleven"),
        entry(12, "twelve"),
        entry(13, "thirteen"),
        entry(14, "fourteen"),
        entry(15, "fifteen"),
        entry(16, "sixteen"),
        entry(17, "seventeen"),
        entry(18, "eighteen"),
        entry(19, "nineteen"),
        entry(20, "twenty"),
        entry(30, "thirty"),
        entry(40, "forty"),
        entry(50, "fifty"),
        entry(60, "sixty"),
        entry(70, "seventy"),
        entry(80, "eighty"),
        entry(90, "ninety")
    );

    @Override
    public long execute() {
        return findSumOfNumberAsString();
    }

    private long findSumOfNumberAsString() {
        long counter = 0;

        for (int i = 1; i <= 1000; i++) {
            counter += Utils.removeSpaces(writeNumber(i)).length();
        }

        return counter;
    }

    private String writeNumber(int number) {
        String numberAsString = String.valueOf(number);

        if (numberAsString.length() == 4) {
            return "one thousand";
        } else if (numberAsString.length() == 3) {
            return writeThreeDigitsNumber(number);
        } else if (numberAsString.length() == 2) {
            return writeTwoDigitsNumber(number);
        } else {
            return writeSimpleNumber(number);
        }
    }

    private String writeThreeDigitsNumber(int number) {
        return writeThreeDigitsNumber(String.valueOf(number));
    }

    private String writeThreeDigitsNumber(String numberAsString) {
        int firstDigit = Character.getNumericValue(numberAsString.charAt(0));
        int secondDigit = Character.getNumericValue(numberAsString.charAt(1)) * 10;
        int thirdDigit = Character.getNumericValue(numberAsString.charAt(2));

        String twoDigits = writeTwoDigitsNumber(secondDigit + thirdDigit);

        if (twoDigits == null) {
            return String.format("%s hundred", writeSimpleNumber(firstDigit));
        } else {
            return String.format("%s hundred and %s", writeSimpleNumber(firstDigit), twoDigits);
        }
    }

    private String writeTwoDigitsNumber(int number) {
        return writeTwoDigitsNumber(String.valueOf(number));
    }

    private String writeTwoDigitsNumber(String numberAsString) {
        int number = Integer.parseInt(numberAsString);

        if (number == 0) {
            return null;
        } else if (number <= 20) {
            return writeSimpleNumber(numberAsString);
        } else {
            if (number % 10 == 0) {
                return writeSimpleNumber(numberAsString);
            } else {
                int firstDigit = Character.getNumericValue(numberAsString.charAt(0)) * 10;
                int secondDigit = Character.getNumericValue(numberAsString.charAt(1));
                return String.format("%s %s", writeSimpleNumber(firstDigit), writeSimpleNumber(secondDigit));
            }
        }
    }

    private String writeSimpleNumber(String number) {
        return numbersAsStrings.get(Integer.parseInt(number));
    }

    private String writeSimpleNumber(int number) {
        return numbersAsStrings.get(number);
    }
}
