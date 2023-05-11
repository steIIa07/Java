public class BankTest {
	public static final int N_ACCOUNTS = 5;
	public static final int INIT_BALANCE = 1000;


	public static void main(String args[]) {
		// COMPLETE
        Bank bank = new Bank(N_ACCOUNTS, INIT_BALANCE);
        for (int i = 0; i < N_ACCOUNTS; i++) {
            Thread t = new Thread(new Transfer(bank, i, INIT_BALANCE));
            t.start();
        }
	}
}
