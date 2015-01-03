package com.alanjz.microstrike.app.overlay

import java.awt.{Graphics, Graphics2D}
import javax.swing.JPanel

import com.alanjz.microstrike.app.util.Rendering

abstract class MSOverlay {
  private val panel = new JPanel {
    override def paintComponent(g : Graphics): Unit = {
      val g2d = g.asInstanceOf[Graphics2D]

      Rendering.setRenderingHints(g2d)
      paintOverlay(g2d)
    }
  }

  this.setOpaque(false)

  def paintOverlay(g2d : Graphics2D)

  def toJPanel = panel
}

object MSOverlay {
  implicit def toJPanel(lhs : MSOverlay) : JPanel = lhs.toJPanel
}