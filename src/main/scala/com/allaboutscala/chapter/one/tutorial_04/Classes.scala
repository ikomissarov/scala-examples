package com.allaboutscala.chapter.one.tutorial_04

import scala.beans.BeanProperty

/**
  *
  * @author ikomissarov 
  */
object Classes extends App {
  val acc = new BankAccount
  println(acc.balance)
  acc.deposit(20)
  println(acc.balance)
  acc.withdraw(15)
  println(acc.balance)

  val time1 = new Time(5, 50)
  println(time1.hours + ":" + time1.minutes)
  val time2 = new Time(12, 10)
  println(time2.hours + ":" + time2.minutes)
  println(time1.before(time2))

  val student = new Student(1, "John")
  println(student.getId + " - " + student.getName)
  println(student.id + " - " + student.name)
  student.setId(2)
  student.name = "Jack"
  println(student.getId + " - " + student.getName)
  println(student.id + " - " + student.name)

  val person = new Person("John Snow")
  println(person.firstName + " - " + person.lastName)

  var car = new Car("Skoda", "Octavia", 2005, "01B")
  printf("%-10s%-10s%-5d%-10s%n", car.manufacturer, car.modelName, car.modelYear, car.licensePlate)
  car = new Car("Ford", "Focus", 2010)
  printf("%-10s%-10s%-5d%-10s%n", car.manufacturer, car.modelName, car.modelYear, car.licensePlate)
  car = new Car("Ford", "Mondeo", "02C")
  printf("%-10s%-10s%-5d%-10s%n", car.manufacturer, car.modelName, car.modelYear, car.licensePlate)
  car = new Car("Daewoo", "Nexia")
  printf("%-10s%-10s%-5d%-10s%n", car.manufacturer, car.modelName, car.modelYear, car.licensePlate)
  car.licensePlate = "03D"
  //car.modelYear = 2010

  val emp = new Employee("John", 25.0)
  println(emp.name + " - " + emp.salary)
}

class BankAccount {
  private var _balance: Int = 0

  def deposit(amount: Int): Unit = _balance += amount

  def withdraw(amount: Int): Unit = _balance -= amount

  def balance: Int = _balance
}

class Time(hrs: Int, mins: Int) {
  private val minSinceMidnight: Int = hrs * 60 + mins

  def hours: Int = minSinceMidnight / 60

  def minutes: Int = minSinceMidnight % 60

  def before(other: Time): Boolean = minSinceMidnight < other.minSinceMidnight
}

class Student(@BeanProperty var id: Long, @BeanProperty var name: String) {}

class Person(name: String) {
  val Array(firstName, lastName) = name.split(" ")
}

class Car(val manufacturer: String, val modelName: String, val modelYear: Int, var licensePlate: String) {

  def this(manufacturer: String, modelName: String, modelYear: Int) {
    this(manufacturer, modelName, modelYear, "")
  }

  def this(manufacturer: String, modelName: String, licensePlate: String) {
    this(manufacturer, modelName, -1, licensePlate)
  }

  def this(manufacturer: String, modelName: String) {
    this(manufacturer, modelName, -1, "")
  }
}

class Employee {
  private var _name: String = "John Snow"
  var salary: Double = 0.0

  def this(name: String, salary: Double) {
    this()
    this._name = name
    this.salary = salary
  }

  def name: String = _name
}
