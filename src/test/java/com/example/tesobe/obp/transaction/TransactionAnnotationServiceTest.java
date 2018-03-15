package com.example.tesobe.obp.transaction;

import com.example.obp.account.Account;
import com.example.obp.account.AccountService;
//import com.example.obp.account.Transaction;
//import com.example.obp.account.Transaction.Tag;
import com.example.obp.transaction.MonetaryTransactionsService;
import com.example.obp.transaction.TransactionAnnotationService;
import com.example.tesobe.obp.AbstractTestSupport;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import com.example.model.transaction.*;


public class TransactionAnnotationServiceTest extends AbstractTestSupport {
/*    @Autowired private AccountService accountService;
    @Autowired private MonetaryTransactionsService monetaryTransactionsService;
    @Autowired private TransactionAnnotationService transactionAnnotationService;

    @Test
    public void addTagOk() {
        List<Account> accounts = accountService.fetchPrivateAccounts(authToken, true);
        Account ownAccount = accounts.get(0);
        List<Transaction> transactions = monetaryTransactionsService.fetchTransactionList(authToken, ownAccount);

        Transaction tx = transactions.get(0);

        String tagValue = "food";
        Tag tag = transactionAnnotationService.addTag(authToken, tx, tagValue);
        Assert.assertNotNull(tag.getId());
        Assert.assertEquals(tagValue, tag.getValue());
        List<Tag> newTags = monetaryTransactionsService.getTransactionById(authToken, ownAccount, tx.getId()).getMetadata().getTags();
        Assert.assertTrue(newTags.contains(tag));
    }

    @Test
    public void deleteTagOk() {
        List<Account> accounts = accountService.fetchPrivateAccounts(authToken, true);
        Account ownAccount = accounts.get(0);
        List<Transaction> transactions = monetaryTransactionsService.fetchTransactionList(authToken, ownAccount);

        Transaction tx = transactions.get(0);
        //tx.getMetadata().getTags().forEach(tag -> transactionAnnotationService.deleteTag(authToken, tx, tag));
        Tag tag = transactionAnnotationService.addTag(authToken, tx, "food");
        List<Tag> txTags = monetaryTransactionsService.getTransactionById(authToken, ownAccount, tx.getId()).getMetadata().getTags();
        Assert.assertTrue(txTags.contains(tag));

        transactionAnnotationService.deleteTag(authToken, tx, tag);
        txTags = monetaryTransactionsService.getTransactionById(authToken, ownAccount, tx.getId()).getMetadata().getTags();
        Assert.assertTrue(!txTags.contains(tag));
    }
*/
}