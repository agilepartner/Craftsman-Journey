﻿using System.Collections.Generic;
using BankKata.Domain;
using NSubstitute;
using NUnit.Framework;

namespace BankKata.Tests
{
    public class AccountTest
    {
        private ITransactionRepository _transactionRepository;
        private IStatementPrinter _statementPrinter;
        private IClock _clock;
        private AccountService _account;

        [SetUp]
        public void Setup()
        {
            _transactionRepository = Substitute.For<ITransactionRepository>();
            _statementPrinter = Substitute.For<IStatementPrinter>();
            _clock = Substitute.For<IClock>();
            _account = new AccountService(_transactionRepository, _statementPrinter, _clock);
        }

        [Test]
        public void Deposit_PositiveAmount_StoresTransaction()
        {
            _clock.GetTodayAsString().Returns("12/05/2017");

            _account.Deposit(100);

            _transactionRepository.Received().Add(new Transaction("12/05/2017", 100));
        }

        [Test]
        public void Withdraw_PositiveAmount_StoresTransactionForNegativeAmount()
        {
            _clock.GetTodayAsString().Returns("1/08/2017");

            _account.Withdraw(50);

            _transactionRepository.Received().Add(new Transaction("1/08/2017", -50));
        }

        [Test]
        public void PrintStatement_MultipleTransactionsInRepo_PrintsAllTransactions()
        {
            var transactionList = new List<Transaction>().AsReadOnly();
            _transactionRepository.All().Returns(transactionList);
            
            _account.PrintStatement();

            _statementPrinter.Received().Print(transactionList);
        }
    }
}