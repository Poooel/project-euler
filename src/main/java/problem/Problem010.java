package problem;

import launcher.Executable;
import util.MathUtils;

import java.util.Arrays;

public class Problem010 implements Executable {
    @Override
    public long execute() {
        return Arrays.stream(MathUtils.sieveOfAtkin(2_000_000)).mapToLong(i -> i).sum();
    }
}
