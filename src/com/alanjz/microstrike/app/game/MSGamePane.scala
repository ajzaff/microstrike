package com.alanjz.microstrike.app.game

import java.awt._
import javax.swing.JPanel

import com.alanjz.microstrike.app.{MSFrame, MSApp}
import com.alanjz.microstrike.app.util.Rendering

class MSGamePane {
  private val panel = new JPanel {
    override def paint(g : Graphics) = _paint(g)
  }

  this.setLocation(0, 0)
  this.setSize(Toolkit.getDefaultToolkit.getScreenSize)

  private def _paint(g : Graphics): Unit = {
    val g2d = g.asInstanceOf[Graphics2D]

    Rendering.setRenderingHints(g2d)

    g2d.setColor(Color.black)
    g2d.fillRect(0,0,this.getWidth,this.getHeight)

    MSApp.mapChunker.paint(g2d)
    val perspective = MSApp.mapInstance.perspective
    val center =
      if(perspective.isDefined) perspective.get.point
      else MSApp.map.center
    for(player <- MSApp.mapInstance.players) {
      MSPlayer.paint(g2d, player, center)
    }
  }

  def center = new Point(MSApp.frame.getWidth / 2, MSApp.frame.getHeight / 2)

  def toJPanel = panel
}

object MSGamePane {
  implicit def toJPanel(lhs : MSGamePane) : JPanel = lhs.toJPanel
}