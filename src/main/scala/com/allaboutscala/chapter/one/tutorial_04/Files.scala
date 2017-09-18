package com.allaboutscala.chapter.one.tutorial_04

import java.io.PrintWriter

import scala.io.Source

/**
  *
  * @author ikomissarov 
  */
object Files extends App {
  test1()
  test2()
  Source.fromFile("testfile3.txt", "utf-8").mkString.split("\\s+").filter(_.length > 4).foreach(println)

  def test1() = {
    val source = Source.fromFile("testfile.txt", "utf-8")
    val lines = source.getLines().toArray
    source.close()

    val writer = new PrintWriter("testfile.txt", "utf-8")
    lines.reverse.foreach(writer.println)
    writer.close()
  }

  def test2() = {
    val source = Source.fromFile("testfile2.txt", "utf-8")
    val numbers = source.mkString.split("\\s+").map(_.toDouble)
    source.close()
    println(numbers.max)
    println(numbers.min)
    println(numbers.sum)
  }
}
