package core

import core.entity.Account
import core.entity.Person

class TransactionManager(private val accounts: List<Account>) {

    /**
     * Returns amount of money available on the person's account
     * @return Int amount
     */
    fun getAccountTotal(person: Person): Int = findAccount(person).amount

    /**
     * Deposit some money on person's account
     */
    fun deposit(person: Person, amount: Int) {
        findAccount(person).amount += amount
    }

    /**
     * Withdraw some amount of money from person's account
     * If there is not enough money, then it will be declined
     * @return Boolean: true if succeeded
     */
    fun withdraw(person: Person, amount: Int): Boolean {
        val account = findAccount(person)
        val canWithdraw = account.amount >= amount
        if (canWithdraw) account.amount -= amount
        return canWithdraw
    }

    /**
     * Transfer some money between two persons' accounts
     * @return Boolean: true if succeeded
     */
    fun transfer(person: Person, targetPerson: Person, amount: Int): Boolean {
        var success = false
        val personAccount = findAccount(person)
        if (personAccount.amount >= amount) {
            personAccount.amount -= amount
            findAccount(targetPerson).amount += amount
            success = true
        }
        return success
    }

    private fun findAccount(person: Person): Account = accounts.first { it.holder == person }
}