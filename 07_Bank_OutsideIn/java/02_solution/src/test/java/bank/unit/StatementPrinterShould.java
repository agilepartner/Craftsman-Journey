package bank.unit;

import bank.Console;
import bank.StatementPrinter;
import bank.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StatementPrinterShould {

    private static final List<Transaction> NO_TRANSACTIONS = Collections.emptyList();
    @Mock
    Console console;
    private StatementPrinter statementPrinter;

    @BeforeEach
    public void init() {
        statementPrinter = new StatementPrinter(console);
    }

    @Test
    public void always_print_the_header() {
        statementPrinter.print(NO_TRANSACTIONS);
        
        verify(console).printLine(StatementPrinter.STATEMENT_HEADER);
    }

    @Test
    public void print_transactions_in_reverse_chronological_order() {
        List<Transaction> transactions = transactionContainer(
                deposit("01/04/2014", 1000),
                withdraw("02/04/2014", 100),
                deposit("10/04/2014", 500)
        );
        statementPrinter.print(transactions);

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
        inOrder.verify(console).printLine("02/04/2014 | -100.00 | 900.00");
        inOrder.verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
    }

    private List<Transaction> transactionContainer(Transaction... transactions) {
        return Arrays.asList(transactions);
    }

    private Transaction withdraw(String date, int amount) {
        return new Transaction(date, -amount);
    }

    private Transaction deposit(String date, int amount) {
        return new Transaction(date, amount);
    }
}