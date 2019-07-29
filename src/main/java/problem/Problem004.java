package problem;

import launcher.Executable;

import java.util.ArrayList;
import java.util.List;

public class Problem004 implements Executable {
    @Override
    public long execute() {
        return findPalindrome();
    }

    private int findPalindrome() {
        List<Integer> palindromes = new ArrayList<>();

        for (int i = 999; i > 99; i--) {
            for (int j = 999; j > 99; j--) {
                String potentialPalindrome = String.valueOf(i * j);
                if (isPalindrome(potentialPalindrome)) {
                    palindromes.add(i * j);
                }
            }
        }

        return palindromes.stream().mapToInt(x -> x).max().getAsInt();
    }

    private boolean isPalindrome(String string) {
        return new StringBuilder(string).reverse().toString().equals(string);
    }
}
