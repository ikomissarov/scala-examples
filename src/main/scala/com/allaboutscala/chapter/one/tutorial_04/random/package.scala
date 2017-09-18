package com.allaboutscala.chapter.one.tutorial_04

/**
  *
  * @author ikomissarov 
  */
package object random {
  private var previous: Double = _

  def nextInt(): Int = Math.round(nextDouble()).toInt

  def nextDouble(): Double = {
    previous = (previous * 1664525 + 1013904223) % Math.pow(2, 32)
    previous
  }

  def setSeed(seed: Int): Unit = previous = seed
}
