package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;


/**.
 * Class Account implements account.
 * @author Mikhail Vlasov
 * @since 11.24.2017
 * @version 1
 */
public class Bank {
    /**.
     * Map of users and List of accounts for each of them.
     */
    private Map<User, List<Account>> usersAndAccounts = new HashMap<>();

    /**.
     * Getter for usersAndAccounts.
     * @return Map<User, List<Account>> usersAndAccounts.
     */
    public Map<User, List<Account>> getUsersAndAccounts() {
        return usersAndAccounts;
    }

    /**.
     * Добавление пользователя.
     * @param user to be added.
     */
    public void addUser(User user) {
        usersAndAccounts.putIfAbsent(user, new ArrayList<>());
    }

    /**.
     * Удаление пользователя.
     * @param user to be deleted.
     */
    public void deleteUser(User user) {
        usersAndAccounts.remove(user);
    }

    /**.
     * Добавление счёта пользователю.
     * @param user которому добовляем.
     * @param account который добавляем.
     */
    public void addAccountToUser(User user, Account account) {
        usersAndAccounts.get(user).add(account);
    }

    /**.
     * Удаление одного счёта пользователя.
     * @param user которому удаляем.
     * @param account который удаляем.
     */
    public void deleteAccountFromUser(User user, Account account) {
        usersAndAccounts.get(user).remove(account);
    }

    /**.
     * Получаем список счетов для пользователя.
     * @param user для которого получаем.
     * @return List<Account> список счетов.
     */
    public List<Account> getUserAccounts(User user) {
        return usersAndAccounts.get(user);
    }

    /**.
     * Метод для перечисления денег с одного счёта на другой счёт:
     * если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.
     * @param srcUser отправитель.
     * @param srcAccount счёт отправителя.
     * @param dstUser получатель.
     * @param dstAccount счёт получателя.
     * @param amount сумма перевода.
     * @return boolean true, если перевод прошёл.
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        List<Account> srcAccountList = usersAndAccounts.get(srcUser);
        List<Account> dstAccountList = usersAndAccounts.get(dstUser);
        Integer srcAccountIndex = null, dstAccountIndex = null;

        srcAccountIndex = srcAccountList.indexOf(srcAccount);
        dstAccountIndex = dstAccountList.indexOf(dstAccount);
        //Проверяем, запрашиваемый счёт, с которого отправляем. Существует ли,
        //Принадлежит ли пользователю.
        //Проверяем также, хватает ли средств на счёте отправителя.
        //Проверяем, запрашиваемый счёт, на который отправляем. Существует ли,
        // Принадлежит ли пользователю.
        if (srcAccountIndex == null
                || srcAccountIndex < 0
                || srcAccountList.get(srcAccountIndex).getValue() < amount
                || dstAccountIndex == null
                || dstAccountIndex < 0) {
            return false;
        }

        //Делаем перевод.
        srcAccountList.get(srcAccountIndex).setValue(srcAccountList.get(srcAccountIndex).getValue() - amount);
        dstAccountList.get(dstAccountIndex).setValue(dstAccountList.get(dstAccountIndex).getValue() + amount);
        return true;
    }

}
