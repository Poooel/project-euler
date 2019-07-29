package problem;

import launcher.Executable;

public class Problem003 implements Executable {
    @Override
    public long execute() {
        return maxPrimeFactor(600851475143L);
    }

    private long maxPrimeFactor(long x) {
        long maxPrime = -1;

        while (x % 2 == 0) {
            maxPrime = 2;
            x >>= 1;
        }

        for (int i = 3; i <= Math.sqrt(x); i += 2) {
            while (x % i == 0) {
                maxPrime = i;
                x /= i;
            }
        }

        if (x > 2) {
            maxPrime = x;
        }

        return maxPrime;
    }
}
