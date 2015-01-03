package com.alanjz.microstrike.app.game

import java.awt.Point
import java.awt.Graphics2D

import com.alanjz.microstrike.Player
import com.alanjz.microstrike.app.MSApp

object MSPlayer {
  val playerDiameter = 30

  def paint(g2d : Graphics2D, player : Player, center : Point): Unit = {
    g2d.setColor(player.team)
    g2d.fillOval(
      MSApp.frame.gamePane.center.x + player.x - center.x - playerDiameter / 2,
      MSApp.frame.gamePane.center.y + player.y - center.y - playerDiameter / 2,
      playerDiameter, playerDiameter)
  }
}