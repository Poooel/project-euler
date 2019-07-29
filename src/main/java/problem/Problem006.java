package problem;

import launcher.Executable;

import java.util.stream.LongStream;

public class Problem006 implements Executable {
    @Override
    public long execute() {
        return (LongStream.range(1, 101).sum() * LongStream.range(1, 101).sum())
            - LongStream.range(1, 101).map(x -> x * x).sum();
    }
}
