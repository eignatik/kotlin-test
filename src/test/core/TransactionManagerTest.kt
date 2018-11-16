package core

import main.core.TransactionManager
import main.core.entity.Account
import main.core.entity.Person
import org.testng.Assert.*
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class TransactionManagerTest {

    private lateinit var transactionManager:TransactionManager
    private val amount:Int = 100
    private val person1:Person = Person("John", "Do", 24)

    @BeforeMethod
    fun init() {
        val accounts = listOf(
            Account(Person("John", "Do", 24), amount)
        )
        transactionManager = TransactionManager(accounts)
    }

    @Test
    fun testGetAccountTotal() {
        assertEquals(transactionManager.getAccountTotal(person1), amount)
    }

    @Test
    fun testDeposit() {
        val newAmount = 200
        with(transactionManager) {
            this.deposit(person1, 100)
            assertEquals(this.getAccountTotal(person1), newAmount)
        }
    }

    @Test
    fun testWithdraw() {
        val newAmount = 50
        with(transactionManager) {
            this.withdraw(person1, 50)
            assertEquals(this.getAccountTotal(person1), newAmount)
        }
    }

    @Test
    fun testTransfer() {
        val newAmountPerson1 = 50
        val newAmountPerson2 = 150
        val person2 = Person("Kate", "Do", 30)
        val accounts = listOf(
            Account(person1, amount),
            Account(person2, amount)
        )
        transactionManager = TransactionManager(accounts)
        transactionManager.transfer(person1, person2, 50)
        assertEquals(transactionManager.getAccountTotal(person1), newAmountPerson1)
        assertEquals(transactionManager.getAccountTotal(person2), newAmountPerson2)
    }
}