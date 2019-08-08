package problem;

import launcher.Executable;
import util.Utils;

import java.math.BigInteger;

public class Problem016 implements Executable {
    @Override
    public long execute() {
        return Utils.sumOfArray(Utils.getDigits(BigInteger.TWO.pow(1000).toString()));
    }
}
