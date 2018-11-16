package main.core.entity

data class Person(var firstName:String, var lastName:String, var age:Int)
data class Account(var holder:Person, var amount:Int = 0)