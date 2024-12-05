package com.collinkueter
package year2024.day1

import cats.effect.{IO, IOApp}
import fs2.io.file.{Files, Path}
import fs2.{Stream, text}

object Day1 extends IOApp.Simple {

  private val program: Stream[IO, Unit] = {
    def fahrenheitToCelsius(f: Double): Double =
      (f - 32.0) * (5.0 / 9.0)

    Files[IO]
      .readUtf8Lines(Path("testdata/fahrenheit.txt"))
      .filter(s => s.trim.nonEmpty && !s.startsWith("//"))
      .map(line => fahrenheitToCelsius(line.toDouble).toString)
      .intersperse("\n")
      .through(text.utf8.encode)
      .through(Files[IO].writeAll(Path("testdata/celsius.txt")))
  }

  def run: IO[Unit] = program.compile.drain
}
