package util;

import lombok.experimental.UtilityClass;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class MathUtils {
    public boolean isPrime(long x) {
        return BigInteger.valueOf(x).isProbablePrime(15);
    }

    public int[] sieveOfEratosthenes(int n) {
        int upperBoundSquareRoot = (int) Math.sqrt(n);

        boolean[] isComposite = new boolean[n + 1];

        for (int m = 2; m <= upperBoundSquareRoot; m++) {
            if (!isComposite[m]) {
                for (int k = m * m; k <= n; k += m) {
                    isComposite[k] = true;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();

        for (int m = upperBoundSquareRoot; m <= n; m++) {
            if (!isComposite[m]) {
                primes.add(m);
            }
        }

        return Utils.listToIntArray(primes);
    }

    public int[] sieveOfAtkin(int n) {
        boolean[] numbers = new boolean[n +1];
        int z;

        numbers[2] = true;
        numbers[3] = true;
        numbers[5] = true;

        for (int x = 1; x <= (int) Math.sqrt(n / 4); x++) {
            for (int y = 1; y <= (int) Math.sqrt(n - 4 * x * x); y++) {
                z = 4 * x * x + y * y;
                if (z % 60 == 1 ||
                    z % 60 == 13 ||
                    z % 60 == 17 ||
                    z % 60 == 29 ||
                    z % 60 == 37 ||
                    z % 60 == 41 ||
                    z % 60 == 49 ||
                    z % 60 == 53)
                    numbers[z] = !numbers[z];
            }
        }

        for (int x = 1; x <= (int) Math.sqrt(n / 3); x++) {
            for (int y = 1; y <= (int) Math.sqrt(n - 3 * x * x); y++) {
                z = 3 * x * x + y * y;
                if (z % 60 == 7 ||
                    z % 60 == 19 ||
                    z % 60 == 31 ||
                    z % 60 == 43)
                    numbers[z] = !numbers[z];
            }
        }

        for (int x = 1; x <= (int) Math.sqrt(n); x++) {
            for (int y = (int) Math.sqrt(3 * x * x - n); y <= (int) Math.sqrt(3) * x; y++) {
                z = 3 * x * x - y * y;

                if (z <= n) {
                    if (z % 60 == 11 ||
                        z % 60 == 23 ||
                        z % 60 == 47 ||
                        z % 60 == 59)
                        numbers[z] = !numbers[z];
                }
            }
        }


        for (int i = 5; i <= (int) Math.sqrt(n); i++) {
            for (int j = 1; j * i * i <= n; j++) {
                numbers[j * i * i] = false;
            }
        }

        List<Integer> primes = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (numbers[i]) {
                primes.add(i);
            }
        }

        return Utils.listToIntArray(primes);
    }

    public long[] findFactors(long x) {
        List<Long> factors = new ArrayList<>();

        for (long i = 1; i < Math.sqrt(x); i++) {
            if (x % i == 0) {
                if (x / i == i) {
                    factors.add(i);
                } else {
                    factors.add(i);
                    factors.add(x / i);
                }
            }
        }

        return Utils.listToLongArray(factors);
    }
}
