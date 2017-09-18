package com.allaboutscala.chapter.one.tutorial_04

import java.util.Calendar

import scala.collection.JavaConversions.propertiesAsScalaMap
import scala.collection.{immutable, mutable}

/**
  *
  * @author ikomissarov 
  */
object Maps extends App {
  val a = Map("Book" -> 10.0, "Phone" -> 25.0, "Shoes" -> 22.5)
  val b = for ((k, v) <- a) yield (k, v * 0.9)
  println(b)

  val in = new java.util.Scanner(new java.io.File("build.sbt"))
  val c = mutable.Map[String, Int]().withDefaultValue(0)
  var d = Map[String, Int]().withDefaultValue(0)
  val e = mutable.SortedMap[String, Int]().withDefaultValue(0)
  while (in.hasNext()) {
    val word = in.next()
    c(word) = c(word) + 1
    e(word) = e(word) + 1
    d += (word -> (d(word) + 1))
  }
  println(c)
  println(d)
  println(e)

  val f = mutable.LinkedHashMap(
    "Monday" -> Calendar.MONDAY,
    "Tuesday" -> Calendar.TUESDAY,
    "Wednesday" -> Calendar.WEDNESDAY,
    "Thursday" -> Calendar.THURSDAY
  )
  println(f)

  val g: scala.collection.Map[String, String] = System.getProperties
  val max: Int = g.map(kv => kv._1.length).max
  for ((k, v) <- g) printf(s"%-${max}s| %s%n", k, v)

  def minmax(values: Array[Int]) = (values.min, values.max)

  println(minmax(Array(1, 2, 3, 4, 5)))

  def lteqgt(values: Array[Int], v: Int) =
    (values.count(_ < v), values.count(_ == v), values.count(_ > v))

  println(lteqgt(Array(1, 1, 2, 3, 4, 5, 2, 2, 3, 4, 2, 1, 0), 2))

  val tuples: immutable.IndexedSeq[(Char, Char)] = "Hello".zip("World")
  println(tuples)
}
