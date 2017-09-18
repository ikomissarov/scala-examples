package com.allaboutscala.chapter.one.tutorial_04

import java.awt.geom.Ellipse2D
import java.io.InputStream

/**
  *
  * @author ikomissarov 
  */
object Traits extends App {
  val egg = new Ellipse2D.Double(0, 0, 5, 10) with RectangleLike
  egg.grow(10, 5)
  egg.translate(5, 10)
  println(egg.x + ", " + egg.y + ", " + egg.width + ", " + egg.height)

  val p = new OrderedPoint(1, 2) with CryptoLogger
  p.log("(" + p.getX + ", " + p.getY + ")")

  val p1 = new OrderedPoint(2, 3) with CryptoLogger {
    override val key = 2
  }
  p1.log("(" + p1.getX + ", " + p1.getY + ")")

  val in = new IterableInputStream {
    var count = 10

    override def read(): Int = if (count > 0) {
      count -= 1; count
    } else -1
  }

  val iterator = in.iterator
  while (iterator.hasNext)
    println(iterator.next())
  //println(iterator.next())
}

trait RectangleLike {
  def getX: Double

  def getY: Double

  def getHeight: Double

  def getWidth: Double

  def setFrame(x: Double, y: Double, w: Double, h: Double)

  def grow(h: Double, v: Double): Unit = {
    setFrame(getX - h, getY - v, getWidth + 2 * h, getHeight + 2 * v)
  }

  def translate(dx: Double, dy: Double): Unit = {
    setFrame(getX + dx, getY + dy, getWidth, getHeight)
  }
}

class OrderedPoint(x: Int, y: Int) extends java.awt.Point(x, y) with Ordered[Point] {
  override def compare(that: Point) =
    if (x < that.x) -1
    else if (x > that.x) 1
    else y - that.y
}

trait CryptoLogger {
  protected val key: Int = 3

  def log(msg: String) = println(msg * key)
}

abstract class IterableInputStream extends InputStream with Iterable[Byte] {

  override def iterator = new Iterator[Byte]() {
    private var buf: Option[Byte] = None

    private def readNext(): Option[Byte] = {
      if (buf.isEmpty) {
        val next = read()
        if (next != -1) {
          buf = Some(next.toByte)
        }
      }
      buf
    }

    override def hasNext = readNext().isDefined

    override def next() = {
      val next = readNext()
      buf = None
      next.getOrElse(throw new NoSuchElementException)
    }
  }
}
