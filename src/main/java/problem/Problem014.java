package problem;

import launcher.Executable;

public class Problem014 implements Executable {
    @Override
    public long execute() {
        return findLongestSequence();
    }

    private long computeCollatzSequence(long startingNumber) {
        long sequenceCounter = 1;

        while (startingNumber != 1) {
            if (startingNumber % 2 == 0) {
                startingNumber /= 2;
            } else {
                startingNumber = (startingNumber * 3) + 1;
            }

            sequenceCounter++;
        }

        return sequenceCounter;
    }

    private long findLongestSequence() {
        long maxSize = 0;
        int startingNumber = 0;

        for (int i = 1; i < 1_000_000; i++) {
            long size = computeCollatzSequence(i);

            if (size > maxSize) {
                maxSize = size;
                startingNumber = i;
            }
        }

        return startingNumber;
    }
}
