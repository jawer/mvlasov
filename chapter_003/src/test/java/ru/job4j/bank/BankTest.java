package ru.job4j.bank;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by hed1n on 24.11.2017.
 */
public class BankTest {
    @Test
    public void whenAddUserThenUserInMap() {
        Bank bank = new Bank();
        User user1 = new User("Mike", "AB1234");
        bank.addUser(user1);
        assertThat(bank.getUsersAndAccounts().containsKey(user1),
                is(true));
    }

    @Test
    public void whenDeleteUserThenEmptyMap() {
        Bank bank = new Bank();
        User user1 = new User("Mike", "AB1234");
        bank.addUser(user1);
        bank.deleteUser(user1);
        assertThat(bank.getUsersAndAccounts().containsKey(user1),
                is(false));
    }

    @Test
    public void whenAddAccountToUserThenUserWithAccount() {
        Bank bank = new Bank();
        User user1 = new User("Mike", "AB1234");
        Account account1 = new Account(12345, 10D);
        Account account2 = new Account(67890, 20D);
        bank.addUser(user1);
        bank.addAccountToUser(user1, account1);
        assertThat(bank.getUsersAndAccounts().get(user1).contains(account1),
                is(true));
    }

    @Test
    public void whenDeleteAccountFromUserThenUserWithoutAccount() {
        Bank bank = new Bank();
        User user1 = new User("Mike", "AB1234");
        Account account1 = new Account(12345, 10D);
        Account account2 = new Account(67890, 20D);
        bank.addUser(user1);
        bank.addAccountToUser(user1, account1);
        bank.addAccountToUser(user1, account2);
        bank.deleteAccountFromUser(user1, account1);
        assertThat(bank.getUsersAndAccounts().get(user1).contains(account1),
                is(false));
    }

    @Test
    public void whenGetUserAccountsThenUserAccountsList() {
        Bank bank = new Bank();
        User user1 = new User("Mike", "AB1234");
        Account account1 = new Account(12345, 10D);
        Account account2 = new Account(67890, 20D);
        bank.addUser(user1);
        bank.addAccountToUser(user1, account1);
        bank.addAccountToUser(user1, account2);
        List<Account> expectedAccountList = new ArrayList<>();
        expectedAccountList.add(account1);
        expectedAccountList.add(account2);
        assertThat(bank.getUserAccounts(user1), is(expectedAccountList));
    }

    @Test
    public void whenTransferMoneyThenMoneyTransferred() {
        Bank bank = new Bank();
        User user1 = new User("Mike", "AB1234");
        Account account1 = new Account(12345, 10D);
        Account account3 = new Account(99999, 30D);
        bank.addUser(user1);
        bank.addAccountToUser(user1, account1);

        User user2 = new User("Alex", "BM1234");
        Account account2 = new Account(11111, 20D);
        bank.addUser(user2);
        bank.addAccountToUser(user2, account2);

        assertThat(bank.transferMoney(user1, account1, user2, account2, 5D),
                is(true));
    }

}
