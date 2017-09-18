package com.allaboutscala.chapter.one.tutorial_04

/**
  *
  * @author ikomissarov 
  */
object Operators extends App {
  val name = "JohnSnow"
  val Name(firstName, lastName) = name
  println(firstName)
  println(lastName)
}

object Name {

  def unapply(input: String) = {
    val pos = input.indexOf(" ")
    if (pos == -1) None
    else Some((input.substring(0, pos), input.substring(pos + 1)))
  }
}
