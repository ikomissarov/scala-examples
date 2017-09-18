package com.allaboutscala.chapter.one.tutorial_04

import scala.collection.mutable

/**
  *
  * @author ikomissarov 
  */
object Inheritance extends App {
  val bankAccount = new BankingAccount(10)
  bankAccount.deposit(10)
  bankAccount.withdraw(5)
  println(bankAccount.balance)

  val checkingAccount = new CheckingAccount(10)
  checkingAccount.deposit(10)
  checkingAccount.withdraw(5)
  println(checkingAccount.balance)

  val savingsAccount = new SavingsAccount(10)
  savingsAccount.earnMonthlyInterest()
  println(savingsAccount.balance)
  savingsAccount.deposit(15)
  savingsAccount.withdraw(5)
  savingsAccount.withdraw(5)
  savingsAccount.withdraw(5)
  println(savingsAccount.balance)
  savingsAccount.earnMonthlyInterest()
  savingsAccount.deposit(10)
  savingsAccount.withdraw(10)
  println(savingsAccount.balance)

  val bundle = new Bundle()
  bundle.items += new SimpleItem(5.0, "Some shit")
  bundle.items += new SimpleItem(2.0, "Sausage")
  bundle.items += new SimpleItem(15.0, "Stick")
  println(bundle.price)
  bundle.items.foreach(i => printf("%5.2f %s%n", i.price, i.description))

  val p1 = new Pointik(1, 2)
  val p2 = new LabeledPointik("Label", 2, 3)
  println(p2.x + " " + p2.y + " " + p2.label)

  val circle = new Circle(new Pointik(2, 2), 10)
  val rectangle = new Rectangle(new Pointik(0, 5), new Pointik(5, 0))
  val shapes = List(circle, rectangle)
  shapes.foreach(s => println(s.centerPoint))
}

class BankingAccount(initialBalance: Double) {
  private var _balance: Double = initialBalance

  def deposit(amount: Double): Unit = _balance += amount

  def withdraw(amount: Double): Unit = _balance -= amount

  def balance: Double = _balance
}

class CheckingAccount(initialBalance: Double) extends BankingAccount(initialBalance) {

  override def deposit(amount: Double): Unit = super.deposit(amount - 1)

  override def withdraw(amount: Double): Unit = super.withdraw(amount + 1)
}

class SavingsAccount(initialBalance: Double) extends BankingAccount(initialBalance) {
  val freeTransactionCount = 3
  val monthlyInterest = 0.1
  private var currentTransactionCount = freeTransactionCount

  override def deposit(amount: Double): Unit =
    if (currentTransactionCount > 0) {
      super.deposit(amount)
      currentTransactionCount -= 1
    }
    else super.deposit(amount - 1)

  override def withdraw(amount: Double): Unit =
    if (currentTransactionCount > 0) {
      super.withdraw(amount)
      currentTransactionCount -= 1
    }
    else super.withdraw(amount + 1)

  def earnMonthlyInterest() = {
    super.deposit(balance * monthlyInterest)
    currentTransactionCount = freeTransactionCount
  }
}

abstract class Item {
  def price: Double

  def description: String
}

class SimpleItem(val price: Double, val description: String) extends Item {}

class Bundle extends Item {
  val items: mutable.MutableList[Item] = new mutable.MutableList[Item]()

  def price: Double = items.map(_.price).sum

  def description: String = "A bundle of items."
}

class Pointik(val x: Double, val y: Double) {
  override def toString: String = "(" + x + ", " + y + ")"
}

class LabeledPointik(val label: String, x: Double, y: Double) extends Pointik(x, y) {
  override def toString: String = label + super.toString
}

abstract class Shape {
  def centerPoint: Pointik
}

class Circle(val centerPoint: Pointik, val rad: Double) extends Shape {}

class Rectangle(val leftTop: Pointik, val rightBottom: Pointik) extends Shape {
  def centerPoint: Pointik = new Pointik(mid(leftTop.x, rightBottom.x), mid(leftTop.y, rightBottom.y))

  private def mid(start: Double, end: Double): Double = start + (end - start) / 2.0
}

class Square(val p: Point, width: Int) extends java.awt.Rectangle(p.x, p.y, width, width) {

  def this(width: Int) {
    this(Point(0, 0), width)
  }

  def this() {
    this(0)
  }
}
