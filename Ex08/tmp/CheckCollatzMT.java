import java.math.BigInteger;
import java.util.Date;

// The implementation of CheckCollatz.check() will be extremely slow
// if we try very large values for n.
// It is actually easy to share the computation on multiple threads,
// by spawning as many threads as cores and running the checks
// for an interval [lower, upper] on 1 core.
//
public class CheckCollatzMT {

  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Usage:");
      System.out.println("java CheckCollatzMT n num_threads");
      System.out.println("where positive integers i: 1<= i <= n will be checked");
      System.out.println("and num_threads is the number of threads to use");
      System.exit(1);
    }

    // TODO complete
    // Spawn num_threads,
    // each of them will verify the conjecture for i in [lower, upper]
    // where lower and upper are determined such that each thread has
    // approximately the same amount of work to perform.
    //

    BigInteger n = new BigInteger(args[0]);
    int num_threads = Integer.parseInt(args[1]);
    BigInteger interval = n.divide(BigInteger.valueOf(num_threads));

    Thread[] threads = new Thread[num_threads];

    for (int i = 0; i < num_threads; i++) {
      final BigInteger lower = BigInteger.valueOf(i).multiply(interval).add(BigInteger.ONE);
      final BigInteger upper = i == num_threads - 1 ? n : lower.add(interval).subtract(BigInteger.ONE);

      threads[i] = new CollatzMT(lower, upper);

      threads[i].start();
    }
    for (int i = 0; i < num_threads; i++) {
      try {
        threads[i].join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

class CollatzMT extends Thread {
  private final BigInteger lower;
  private final BigInteger upper;

  public CollatzMT(BigInteger lower, BigInteger upper) {
    this.lower = lower;
    this.upper = upper;
    System.out.println(lower + " " + upper);
  }

  @Override
  public void run() {
    for (BigInteger i = lower; i.compareTo(upper) <= 0; i = i.add(BigInteger.ONE)) {
       Result res = Collatz.check(i);
      if (res.valid) {
        System.out.println("Valid for n="+i);
        System.out.println("Sequence:");
        for (BigInteger s: res.sequence) {
          System.out.print(s + ", ");
        }
        System.out.println();
      }
    }
  }

} 