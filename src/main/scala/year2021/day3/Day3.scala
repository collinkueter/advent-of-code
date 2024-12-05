package com.collinkueter
package year2021.day3

object Day3 extends App {
  val problemInput = InputReader.readLines("day3", "input.txt", identity)
  val exampleInput = InputReader.readLines("day3", "example_input.txt", identity)

  val result = exampleInput
    .map(_.map(_.asDigit))
    .foldLeft(Map.empty[Int, List[Int]])((m, l) => l.zipWithIndex.foldLeft(m)((mm, ll: (Int, Int)) => mm.updated(ll._2, mm.getOrElse(ll._2, List.empty) :+ ll._1)))
//    .zipWithIndex
//    .groupBy(_._2)
//    .foldLeft(Map.empty[Int, List[Int]])((bitsByPosition: Map[Int, List[Int]], bitList: List[Int]) => {
//      bitList.zipWithIndex.foldLeft(bitsByPosition){ (bs: Map[Int, List[Int]], (b: Int, i: Int)) => ???}
//
//
////        map((a, i) => bitsByPosition.updated(1, bitsByPosition(1) ++ bitList.head))
//    })

  println(result)
}
