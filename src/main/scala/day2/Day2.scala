package com.collinkueter
package day2

import scala.io.{BufferedSource, Source}
import scala.util.Using

object Day2 extends App {
  val problemInput = InputReader.readLines("day2", "input.txt")
  val exampleInput = InputReader.readLines("day2", "example_input.txt")

  case class Submarine(depth: Int, horizontalPosition: Int)

  def part1(input: List[String]): Submarine = {
    input
      .foldLeft(Submarine(0, 0)) {
        (
            b: Submarine,
            a: String
        ) =>
          {
            val command: String = a.split(" ")(0)
            val multiplier: Int = a.split(" ")(1).toInt
            command match {
              case "forward" => Submarine(b.depth, b.horizontalPosition + multiplier)
              case "up"      => Submarine(b.depth - multiplier, b.horizontalPosition)
              case "down"    => Submarine(b.depth + multiplier, b.horizontalPosition)
            }
          }
      }
  }

  case class Submarine2(depth: Int, horizontalPosition: Int, aim: Int)

  def part2(input: List[String]): Submarine2 = {
    input
      .foldLeft(Submarine2(0, 0, 0)) {
        (
            b: Submarine2,
            a: String
        ) =>
          {
            val command: String = a.split(" ")(0)
            val multiplier: Int = a.split(" ")(1).toInt
            val submarine       = command match {
              case "forward" => Submarine2(b.depth + (b.aim * multiplier), b.horizontalPosition + multiplier, b.aim)
              case "up"      => Submarine2(b.depth, b.horizontalPosition, b.aim - multiplier)
              case "down"    => Submarine2(b.depth, b.horizontalPosition, b.aim + multiplier)
            }
            submarine
          }
      }
  }

  val exampleResult = part1(exampleInput)
  println(exampleResult)
  println(exampleResult.depth * exampleResult.horizontalPosition)

  val exampleResult2 = part2(exampleInput)
  println(exampleResult2)
  println(exampleResult2.depth * exampleResult2.horizontalPosition)

  val problemResult = part1(problemInput)
  println(problemResult)
  println(problemResult.depth * problemResult.horizontalPosition)

  val problemResult2 = part2(problemInput)
  println(problemResult2)
  println(problemResult2.depth * problemResult2.horizontalPosition)

}
