package problem;

import launcher.Executable;

public class Problem005 implements Executable {
    @Override
    public long execute() {
        return findSmallestPositiveIntegerEvenlyDivisible();
    }

    private int findSmallestPositiveIntegerEvenlyDivisible() {
        for (int i = 20; i < Integer.MAX_VALUE; i += 20) {
            if (isEvenlyDivisibleFromOneToTwenty(i)) {
                return i;
            }
        }

        return 0;
    }

    private boolean isEvenlyDivisibleFromOneToTwenty(int x) {
        for (int i = 1; i <= 20; i++) {
            if (x % i != 0) {
                return false;
            }
        }

        return true;
    }
}
