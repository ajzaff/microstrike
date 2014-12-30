package com.alanjz.microstrike.app.game

import java.awt.{Color, Graphics, Graphics2D}
import javax.swing.JPanel

import com.alanjz.microstrike.app.util.Rendering

class MSGamePane {
  private val panel = new JPanel {
    override def paint(g : Graphics) = _paint(g)
  }

  private def _paint(g : Graphics): Unit = {
    val g2d = g.asInstanceOf[Graphics2D]

    Rendering.setRenderingHints(g2d)

    g2d.setColor(Color.black)
    g2d.fillRect(0,0,this.getWidth,this.getHeight)
  }

  def toJPanel = panel
}

object MSGamePane {
  implicit def toJPanel(lhs : MSGamePane) : JPanel = lhs.toJPanel
}