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
    int interval = n.intValue() / num_threads;
    
    Result res = CheckCollatzMT.check(n);
    if (res.valid) {
      System.out.println("Valid for n="+args[0]);
      System.out.println("Sequence:");
      for (BigInteger s: res.sequence) {
        System.out.print(s + ", ");
      }
      System.out.println();
    }
    // Thread[] threads = new Thread[num_threads];
    // for(int i = 0; i < num_threads; i++){
    //   final int lower = i * interval + 1;
    //   final int upper = i == num_threads - 1 ? (i + 1) * interval : n.intValue();

    //   threads[i] = new Thread(new Runnable() {
    //     public void run() {
    //       for(int j = lower; j <= upper; j++){
    //         Result res = Collatz.check(BigInteger.valueOf(j));
    //         if (res.valid) {
    //           System.out.println("Valid for n="+j);
    //           System.out.println("Sequence:");
    //           for (BigInteger s: res.sequence) {
    //             System.out.print(s + ", ");
    //           }
    //           System.out.println();
    //         }
    //       }
    //     }
    //   });
    //   threads[i].start();
    // }
    // for(int i = 0; i < num_threads; i++){
    //   try {
    //     threads[i].join();
    //   } catch (InterruptedException e) {
    //     e.printStackTrace();
    //   }
    // }
  }

  private static Result check(BigInteger n) {
   Thread[] threads = new Thread[num_threads];
    for(int i = 0; i < num_threads; i++){
      final int lower = i * interval + 1;
      final int upper = i == num_threads - 1 ? (i + 1) * interval : n.intValue();

      threads[i] = new Thread(new Runnable() {
        public void run() {
          for(int j = lower; j <= upper; j++){
            Result res = Collatz.check(BigInteger.valueOf(j));
            if (res.valid) {
              System.out.println("Valid for n="+j);
              System.out.println("Sequence:");
              for (BigInteger s: res.sequence) {
                System.out.print(s + ", ");
              }
              System.out.println();
            }
          }
        }
      });
      threads[i].start();
   
    return null;
  }
}