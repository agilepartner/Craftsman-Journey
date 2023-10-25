package bank.unit;

import bank.Account;
import bank.StatementPrinter;
import bank.Transaction;
import bank.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AccoutShould {

    @Mock
    TransactionRepository transactionRepository;
    @Mock StatementPrinter statementPrinter;
    private Account account;

    @BeforeEach
    public void init() {
        account = new Account(transactionRepository, statementPrinter);
    }

    @Test
    public void store_a_deposit_transaction() {
        account.deposit(100);

        verify(transactionRepository).addDeposit(100);
    }

    @Test
    public void store_a_withdraw_transaction() {
        account.withdraw(100);

        verify(transactionRepository).addWithdraw(100);
    }

    @Test
    public void print_a_statement() {
        List<Transaction> transactions = asList(new Transaction("11/07/2023", 100));
        given(transactionRepository.allTransactions()).willReturn(transactions);

        account.printStatement();

        verify(statementPrinter).print(transactions);
    }
}
