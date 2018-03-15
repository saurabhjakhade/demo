package com.example.tesobe.obp.transaction;

import com.example.obp.account.Account;
import com.example.obp.account.AccountService;
//import com.example.obp.account.Transaction;
import com.example.obp.transaction.MonetaryTransactionsService;
import com.example.tesobe.obp.AbstractTestSupport;
import com.example.model.transaction.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MonetaryTransactionsServiceTest extends AbstractTestSupport {

    @Autowired private AccountService accountService;
    @Autowired private MonetaryTransactionsService monetaryTransactionsService;

    @Test
    public void fetchTransactionListOk() throws Exception {
        List<Account> accounts = accountService.fetchPrivateAccounts(authToken, false);
        Assert.assertTrue(accounts.size() > 0);

        List<Transaction> transactions = monetaryTransactionsService.fetchTransactionList(authToken, accounts.get(0));
        Assert.assertTrue(transactions.size() > 0);
    }

}