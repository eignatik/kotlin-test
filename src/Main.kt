import core.TransactionManager
import core.entity.Account
import core.entity.Person

fun main(args: Array<String>) {
    val accounts = listOf(
        Account(Person("John", "Do", 24)),
        Account(Person("Steve", "Riz", 35), 1000),
        Account(Person("Samanta", "Smith", 28))
    )
    val transactionManager = TransactionManager(accounts)

    val person1 = Person("John", "Do", 24)
    val person2 = Person("Steve", "Riz", 35)

    println(transactionManager.getAccountTotal(person1))
    transactionManager.deposit(person1, 200)
    println(transactionManager.getAccountTotal(person1))
    transactionManager.withdraw(person1, 50)
    println(transactionManager.getAccountTotal(person1))

    println(transactionManager.getAccountTotal(person2))
    transactionManager.transfer(person1, person2, 100)
    println(transactionManager.getAccountTotal(person1))
    println(transactionManager.getAccountTotal(person2))


}