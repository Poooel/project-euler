package problem;

import com.google.common.math.BigIntegerMath;
import launcher.Executable;

import java.math.BigInteger;

public class Problem015 implements Executable {
    @Override
    public long execute() {
        System.out.println(findNumberOfPaths(20));
        return -1;
    }

    private String findNumberOfPaths(int sizeOfGrid) {
        BigInteger upperPart = BigIntegerMath.factorial(2 * sizeOfGrid);
        BigInteger lowerPart = BigIntegerMath.factorial(sizeOfGrid).multiply(BigIntegerMath.factorial(sizeOfGrid));
        return upperPart.divide(lowerPart).toString();
    }
}
