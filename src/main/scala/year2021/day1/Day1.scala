package com.collinkueter
package year2021.day1

import scala.io.{BufferedSource, Source}
import scala.util.Using

object Day1 extends App {

  case class Measurement(previous: Option[Int], increases: Int)

  val problemInput = InputReader.readLines("day1", "input.txt", _.toInt)
  val exampleInput = InputReader.readLines("day1", "example_input.txt", _.toInt)

  def part1(input: List[Int]): Measurement = {
    input.foldLeft(
      Measurement(None, 0)
    )((b: Measurement, a: Int) => {
      if (b.previous.isDefined && a > b.previous.get) {
        Measurement(Some(a), b.increases + 1)
      } else {
        Measurement(Some(a), b.increases)
      }
    })
  }

  def part2(input: List[Int]): Measurement = {
    input
      .sliding(3)
      .foldLeft(
        Measurement(None, 0)
      )((b: Measurement, a: List[Int]) => {
        val sum = a.sum
        if (b.previous.isDefined && sum > b.previous.get) {
          Measurement(Some(sum), b.increases + 1)
        } else {
          Measurement(Some(sum), b.increases)
        }
      })
  }

  println(part1(exampleInput))
  println(part1(problemInput))

  println(part2(exampleInput))
  println(part2(problemInput))

}
