package com.allaboutscala.chapter.one.tutorial_04

import java.awt.datatransfer._
import java.util.TimeZone

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.mutable

/**
  *
  * @author ikomissarov 
  */
object Arrays {

  def main(args: Array[String]): Unit = {
    val a = Array(1, 2, 3, 4, 5)

    val b = for (i <- a.indices by 2; j <- (i to Array(a.length - 1, i + 1).min).reverse) yield a(j)
    println(b.mkString("[", ", ", "]"))

    for (i <- 0 until a.length - 1 by 2) {
      val tmp = a(i + 1)
      a(i + 1) = a(i)
      a(i) = tmp
    }
    println(a.mkString("[", ", ", "]"))

    val c = Array(-5, 6, 1, -3, 2, -4, -7, 1)
    val parts = c.partition(_ > 0)
    val d = parts._1 ++ parts._2
    println(d.mkString("[", ", ", "]"))

    val e = Array(1.0, 2.0, 3.0)
    val avg = e.sum / e.length
    println("Avg = " + avg)

    val f = c.sorted.reverse
    println(f.mkString("[", ", ", "]"))

    println(TimeZone.getAvailableIDs.filter(_.contains("America/")).map(_.drop(8)).sorted
      .mkString("[", ", ", "]"))

    val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
    val res: mutable.Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
  }
}
