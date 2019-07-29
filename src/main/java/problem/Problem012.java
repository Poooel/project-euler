package problem;

import launcher.Executable;
import util.MathUtils;

import java.util.stream.LongStream;

public class Problem012 implements Executable {
    @Override
    public long execute() {
        return generateTriangleNumbers();
    }

    private long generateTriangleNumbers() {
        for (long i = 1; i < Long.MAX_VALUE; i++) {
            long sum = LongStream.range(1, i + 1).sum();

            if (MathUtils.findFactors(sum).length >= 5) {
                return sum;
            }
        }

        return 0;
    }
}
