package com.allaboutscala.chapter.one.tutorial_04

/**
  *
  * @author ikomissarov 
  */
object HigherOrderFunctions extends App {

  val values = (fun: (Int) => Int, low: Int, high: Int) => for (i <- low to high) yield (i, fun(i))

  println(values(x => x * x, -3, 3))

  println(Array(1, 5, 3, 4, 2).reduceLeft((a, b) => if (a > b) a else b))

  val factorial = (n: Int) => (1 to n).product

  println(factorial(4))

  val largest = (fun: (Int) => Int, inputs: Seq[Int]) => inputs.map(x => (x, fun(x))).maxBy(_._2)._1

  println(largest(x => 10 * x - x * x, 1 to 10))

  val adjustToPair = (f: (Int, Int) => Int) => (p: (Int, Int)) => f(p._1, p._2)

  println(adjustToPair(_ * _)((6, 7)))
}
