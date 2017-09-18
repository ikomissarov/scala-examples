package com.allaboutscala.chapter.one.tutorial_04

/**
  *
  * @author ikomissarov 
  */
object Packages extends App {
  random.setSeed(1)
  println(random.nextDouble())
  println(random.nextDouble())
  println(random.nextDouble())
  random.setSeed(5)
  println(random.nextInt())
  println(random.nextInt())
  println(random.nextInt())

  def copyMap() = {
    import java.util.{HashMap => JavaHashMap}

    import scala.collection.mutable.{HashMap => ScalaHashMap}

    val javaHashMap = new JavaHashMap[String, Int]()
    javaHashMap.put("1", 1)
    javaHashMap.put("2", 2)
    javaHashMap.put("3", 3)
    val scalaHashMap = new ScalaHashMap[String, Int]()
    val iterator = javaHashMap.entrySet().iterator()
    while (iterator.hasNext) {
      val next = iterator.next()
      scalaHashMap.put(next.getKey, next.getValue)
    }
    println(scalaHashMap)
  }

  copyMap()
}
