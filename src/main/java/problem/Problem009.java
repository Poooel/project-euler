package problem;

import launcher.Executable;

import java.util.ArrayList;
import java.util.List;

public class Problem009 implements Executable {
    @Override
    public long execute() {
        return findPythagoreanTripletWithSumEquals1000();
    }

    // https://en.wikipedia.org/wiki/Formulas_for_generating_Pythagorean_triples#Dickson's_method
    private long findPythagoreanTripletWithSumEquals1000() {
        for (int r = 2; r < 1000; r += 2) {
            List<long[]> factorsPair = findFactorsPair(square(r) / 2);

            for (long[] pair : factorsPair) {
                long s = pair[0];
                long t = pair[1];

                long x = r + s;
                long y = r + t;
                long z = r + s + t;

                if (x + y + z == 1000) {
                    return x * y * z;
                }
            }
        }

        return 0;
    }

    private long square(int x) {
        return (long) Math.pow(x, 2);
    }

    private List<long[]> findFactorsPair(long x) {
        List<long[]> factorsPair = new ArrayList<>();

        for (long i = 1; i <= x; i++) {
            if (x % i == 0) {
                long a = i;
                long b = x / i;

                if (a < b) {
                    factorsPair.add(new long[] {a, b});
                }
            }
        }

        return factorsPair;
    }
}
