package problem;

import launcher.Executable;
import util.MathUtils;

public class Problem007 implements Executable {
    @Override
    public long execute() {
        return MathUtils.sieveOfAtkin(200_000)[10_000];
    }
}
