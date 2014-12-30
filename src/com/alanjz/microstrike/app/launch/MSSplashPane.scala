package com.alanjz.microstrike.app.launch

import java.awt.{Dimension, Graphics, Graphics2D}
import java.io.File
import javax.imageio.ImageIO
import javax.swing.JPanel

import com.alanjz.microstrike.app.util.Rendering

class MSSplashPane {
  private val panel = new JPanel() {
    override def paint(g : Graphics): Unit = {
      val g2d = g.asInstanceOf[Graphics2D]
      Rendering.setRenderingHints(g2d)
      g2d.drawImage(splash, 0, 0, null)
    }
  }
  val splash = ImageIO.read(new File("images/splash.png"))
  this.setPreferredSize(new Dimension(splash.getWidth, splash.getHeight))

  def toJPanel = panel
}

object MSSplashPane {
  implicit def toJPanel(lhs : MSSplashPane) : JPanel = lhs.toJPanel
}
