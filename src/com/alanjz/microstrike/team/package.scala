package com.alanjz.microstrike

import java.awt.Color

import scala.util.Random

package object team {

  trait TeamGroup {
    val group : TeamGroup
  }

  trait GroupA extends TeamGroup {
    override val group = this
  }
  trait GroupB extends TeamGroup {
    override val group = this
  }

  sealed abstract class Team(color : Color) extends TeamGroup {
    def toAwtColor = color
  }

  case object Red extends Team(Color.red) with GroupB
  case object Blue extends Team(Color.blue) with GroupA
  case object Green extends Team(Color.green) with GroupA
  case object Yellow extends Team(Color.yellow) with GroupB
  case object Pink extends Team(Color.pink) with GroupA
  case object Orange extends Team(new Color(255, 114, 20)) with GroupB
  case object White extends Team(Color.white) with GroupA
  case object Cyan extends Team(Color.cyan) with GroupB
  case object Magenta extends Team(Color.magenta) with GroupB
  case object Brown extends Team(new Color(150, 75, 0)) with GroupA

  object Team {
    implicit def toAwtColor(lhs : Team) : Color = lhs.toAwtColor

    def randomTeam = Random.nextInt(10) match {
      case 0 => Red
      case 1 => Blue
      case 2 => Green
      case 3 => Yellow
      case 4 => Pink
      case 5 => Orange
      case 6 => White
      case 7 => Cyan
      case 8 => Magenta
      case 9 => Brown
    }
  }
}
