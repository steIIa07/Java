import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.Math.random;

public class PiCalc {
    private static final int NUM_POINTS = 99999999;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        double piParallel = calculatePiParallel();
        long parallelTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        double piSequential = calculatePiSequential();
        long sequentialTime = System.nanoTime() - startTime;

        System.out.println("Running time by parallel exec. = " + parallelTime);
        System.out.println(piParallel + " delta-abs: " + Math.abs(Math.PI - piParallel));
        System.out.println("Running time by sequential exec. = " + sequentialTime);
        System.out.println(piSequential + " delta-abs: " + Math.abs(Math.PI - piSequential));
        System.out.println("Ratio = " + (double) sequentialTime / parallelTime);
    }

    private static double calculatePiParallel() {
        return 4.0 * IntStream.range(0, NUM_POINTS)
                .parallel()
                .mapToDouble((a) -> 4.0 * 1.0 / NUM_POINTS * 
                (sqrt(pow(ThreadLocalRandom.current().nextDouble(),2)+pow(ThreadLocalRandom.current().nextDouble(),2)) <= 1 ? 1 : 0))
                .sum() / 4;
    }

    private static double calculatePiSequential() {
        return 4.0 * IntStream.range(0, NUM_POINTS)
                .mapToDouble((a) -> 4.0 * 1.0 / NUM_POINTS * (sqrt(pow(random(),2)+pow(random(),2)) <= 1 ? 1 : 0))
                .sum() / 4;
    }
}