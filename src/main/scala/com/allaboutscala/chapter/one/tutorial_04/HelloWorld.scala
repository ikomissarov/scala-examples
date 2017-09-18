package com.allaboutscala.chapter.one.tutorial_04

import com.typesafe.scalalogging.LazyLogging

/**
  *
  * @author ikomissarov 
  */
object HelloWorld extends App with LazyLogging {
  logger.info("Hello world!")

  var leastFavoriteDonut: String = _
  logger.info(leastFavoriteDonut)
  leastFavoriteDonut = "Plain Donut"
  logger.info(leastFavoriteDonut)

  val num = 2.5
  println(f"$leastFavoriteDonut%-20s $num%.2f ${num == 0}")

  def signum(n: Int) = if (n > 0) 1 else if (n < 0) -1 else 0

  println(signum(25))
  println(signum(0))
  println(signum(-25))

  for (i <- (0 to 10).reverse) print(i + " ")
  println()

  def countdown(n: Int) {
    var r = n
    while (r >= 0) {
      print(r + " ")
      r = r - 1
    }
  }

  countdown(5)
  println()

  def product(s: String): Int = {
    if (s.isEmpty) 1
    else s.head * product(s.tail)
  }

  println(product("Hello"))

  def pow(x: Double, n: Int): Double = {
    if (n == 0) 1.0
    else if (n < 0) 1.0 / pow(x, -1 * n)
    else x * pow(x, n - 1)
  }

  println(pow(3, -1))
}
