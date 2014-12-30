package com.alanjz.microstrike.app.game

import java.awt.{Point, Color, Graphics2D}
import com.alanjz.microstrike.map.MapInstance

class MSMapChunker(val map : MapInstance) {
  def paint(g2d : Graphics2D) : Unit = {
    g2d.setColor(new Color(210, 180, 140))
    val p = map.perspective
    val center = if(p.isDefined) {
      p.get.getPoint
    }
    else {
      new Point()
    }

  }
}
