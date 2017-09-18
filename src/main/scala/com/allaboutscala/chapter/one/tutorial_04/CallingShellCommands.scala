package com.allaboutscala.chapter.one.tutorial_04

/**
  *
  * @author ikomissarov 
  */
object CallingShellCommands extends App {

  import scala.sys.process._

  "ls -al ..".!

  val asString = "ls -al ..".!!
  println("As string:")
  println(asString)

  ("ls -al .." #| "grep scala").!
}
