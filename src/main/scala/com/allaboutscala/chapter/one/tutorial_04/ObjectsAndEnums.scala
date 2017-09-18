package com.allaboutscala.chapter.one.tutorial_04

/**
  *
  * @author ikomissarov 
  */
object ObjectsAndEnums extends App {
  val converters: Array[UnitConversion] = Array(InchesToSantimeters, MilesToKilometers)
  for (converter <- converters) println(converter.convert(50))
  println(MilesToKilometers.convert(50))

  var p: Point = _
  //p = new Point(1, 2) //can't access with private constructor
  //println(p.x + ", " + p.y)
  p = Point(2, 3)
  println(p.x + ", " + p.y)

  for (suit <- CardSuit.values) println(suit)
  println(CardSuit.Club)
  println(CardSuit.isRed(CardSuit.Diamond))
  println(CardSuit.isRed(CardSuit.Spade))
}

abstract class UnitConversion {

  def convert(value: Double): Double
}

object InchesToSantimeters extends UnitConversion {

  override def convert(value: Double): Double = value * 2.54
}

object MilesToKilometers extends UnitConversion {

  override def convert(value: Double): Double = value * 1.6
}

class Point private(val x: Int, val y: Int) {}

object Point {

  def apply(x: Int, y: Int): Point = new Point(x, y)
}

object CardSuit extends Enumeration {
  val Spade = Value("\u2660")
  val Heart = Value("\u2665")
  val Diamond = Value("\u2666")
  val Club = Value("\u2663")

  def isRed(suit: CardSuit.Value): Boolean = suit == Diamond || suit == Heart
}
