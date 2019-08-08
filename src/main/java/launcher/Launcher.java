package launcher;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;

public class Launcher {
    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("Welcome to Project Euler!");

        System.out.println("Choose a problem to begin: (1-667)");
        int choosenProblem = LauncherHelper.getValidIntegerInput(
            "Please input a problem between 1 and 667.",
            1,
            25
        );

        Executable problem = getCorrespondingExecutableProblem(choosenProblem);
        long startMillis = System.currentTimeMillis();
        long result = problem.execute();
        long endMillis = System.currentTimeMillis();

        System.out.println(
            String.format(
                "The answer for the problem %03d is: %d (Computed in approx. %dms)",
                choosenProblem,
                result,
                endMillis - startMillis
            )
        );
    }

    @SneakyThrows
    private static Executable getCorrespondingExecutableProblem(int problem) {
        Class<?> clazz = Class.forName(String.format("problem.Problem%03d", problem));
        Constructor<?> constructor = clazz.getConstructor();
        return (Executable) constructor.newInstance();
    }
}
