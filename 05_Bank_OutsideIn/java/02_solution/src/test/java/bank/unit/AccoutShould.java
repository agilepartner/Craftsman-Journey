package bank.unit;

import bank.Account;
import bank.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AccoutShould {

    @Mock
    TransactionRepository transactionRepository;
    private Account account;

    @BeforeEach
    public void init() {
        account = new Account(transactionRepository);
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

}
