package problem;

import launcher.Executable;

import java.util.stream.IntStream;

public class Problem001 implements Executable {
    @Override
    public long execute() {
        return IntStream.range(0, 1000)
            .filter(x -> x % 3 == 0 || x % 5 == 0)
            .sum();
    }
}
