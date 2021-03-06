﻿namespace BankKata.Domain
{
    public class AccountService
    {
        private readonly ITransactionRepository _transactionRepository;
        private readonly IStatementPrinter _statementPrinter;
        private readonly IClock _clock;

        public AccountService(ITransactionRepository transactionRepository, IStatementPrinter statementPrinter, IClock clock)
        {
            _transactionRepository = transactionRepository;
            _statementPrinter = statementPrinter;
            _clock = clock;
        }
        
        public void Deposit(int amount)
        {
            AddTransactionFor(amount);
        }

        public void Withdraw(int amount)
        {
            AddTransactionFor(-amount);
        }

        public void PrintStatement()
        {
            _statementPrinter.Print(_transactionRepository.All());
        }
        
        private void AddTransactionFor(int amount)
        {
            var transaction = new Transaction(_clock.GetTodayAsString(), amount);
            _transactionRepository.Add(transaction);
        }
    }
}
