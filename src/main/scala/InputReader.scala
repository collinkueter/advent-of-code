package com.collinkueter

import scala.io.{BufferedSource, Source}
import scala.util.Using

object InputReader {
  def readLines[A](dayString: String, fileName: String, parser: (String) => A = a => a): List[A] = Using
    .Manager { _ =>
      val source: BufferedSource =
        Source.fromFile(s"src/main/resources/$dayString/$fileName")
      source
        .getLines()
        .map(parser)
        .toList
    }
    .getOrElse(List.empty)
}
