package bank.unit;

import bank.Clock;
import bank.Transaction;
import bank.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class TransactionRepositoryShould {

    public static final String TODAY = "11/07/2023";
    @Mock
    Clock clock;
    private TransactionRepository transactionRepository;

    @BeforeEach
    public void init() {
        transactionRepository = new TransactionRepository(clock);
        given(clock.todayAsString()).willReturn(TODAY);
    }

    @Test
    public void create_and_store_a_deposit_transaction() {
        transactionRepository.addDeposit(100);

        List<Transaction> transactions = transactionRepository.allTransactions();

        assertEquals(1, transactions.size());
        assertEquals(transaction(TODAY, 100), transactions.get(0));
    }
    @Test
    public void create_and_store_a_withdraw_transaction() {
        transactionRepository.addWithdraw(100);

        List<Transaction> transactions = transactionRepository.allTransactions();

        assertEquals(1, transactions.size());
        assertEquals(transaction(TODAY, -100), transactions.get(0));
    }

    private Transaction transaction(String date, int amount) {
        return new Transaction(date, amount);
    }
}
