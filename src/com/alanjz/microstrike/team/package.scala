package com.alanjz.microstrike

import java.awt.Color

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
  case object Orange extends Team(Color.orange) with GroupB
  case object White extends Team(Color.white) with GroupA
  case object Cyan extends Team(Color.cyan) with GroupB
  case object Magenta extends Team(Color.magenta) with GroupB
  case object Brown extends Team(new Color(150, 75, 0)) with GroupA

  object Team {
    implicit def toAwtColor(lhs : Team) : Color = lhs.toAwtColor
  }
}
