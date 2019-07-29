package problem;

import launcher.Executable;

public class Problem002 implements Executable {
    @Override
    public long execute() {
        return fibonacci(1, 2, 0);
    }

    private int fibonacci(int a, int b, int count) {
        int c = a + b;

        if (b % 2 == 0) {
            count += b;
        }

        if (c > 4_000_000) {
            return count;
        } else {
            return fibonacci(b, c, count);
        }
    }
}
