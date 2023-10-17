package bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionRepository {
    private final Clock clock;
    private final List<Transaction> transactions;

    public TransactionRepository(Clock clock) {
        this.clock = clock;
        this.transactions = new ArrayList<Transaction>();
    }

    public void addDeposit(int amount) {
        Transaction deposit = new Transaction(clock.todayAsString(), amount);
        transactions.add(deposit);
    }

    public void addWithdraw(int amount) {
        Transaction withdraw = new Transaction(clock.todayAsString(), -amount);
        transactions.add((withdraw));
    }

    public List<Transaction> allTransactions() {
        return Collections.unmodifiableList(transactions);
    }
}
