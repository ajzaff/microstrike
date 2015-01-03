package com.alanjz.microstrike.app.game

import java.awt.{Point, Color, Graphics2D}
import com.alanjz.microstrike.app.MSApp
import com.alanjz.microstrike.map.MapInstance

class MSMapChunker(val map : MapInstance) {
  def paint(g2d : Graphics2D) : Unit = {
    g2d.setColor(new Color(210, 180, 140))
    val center = map.perspectivePoint
    val screenCenter = MSApp.frame.gamePane.center

    g2d.setColor(Color.gray)
    g2d.fillRect(
      screenCenter.x - center.x,
      screenCenter.y - center.y,
      map.map.bounds.width,
      map.map.bounds.height)
  }
}
