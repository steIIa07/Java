
// COMPLETE
//
// "Transfer" threads select a random amount of money in [0, max_amount]
// and transfer it to a random account in the bank.
//

import java.util.Random;

public class Transfer implements Runnable{
	public Transfer(Bank bank, int from, int max_amount) {
		bank_ = bank;
		from_ = from;
		max_ = max_amount;
	}

	// COMPLETE

	private Bank bank_;
	private int from_;
	private int max_;

	@Override
	public void run() {
		Random rand = new Random();
		while (true) {
			int to = rand.nextInt(bank_.getNumberAccounts());
			int amount = rand.nextInt(max_);
			synchronized (bank_) {
				bank_.transfer(from_, to, amount);
			}
		}
	}
}
