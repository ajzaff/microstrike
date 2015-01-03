package com.alanjz.microstrike.app

import java.awt.{Point,Toolkit}
import java.awt.image.BufferedImage
import javax.swing.JFrame

import com.alanjz.microstrike.app.game.MSGamePane
import com.alanjz.microstrike.app.overlay.MSMiniMapOverlay

class MSFrame {
  private val frame = new JFrame(s"microstrike\t[${MSApp.version}]")

  val gamePane = new MSGamePane
  val miniMap = new MSMiniMapOverlay

  this.setLocation(0, 0)
  this.setSize(Toolkit.getDefaultToolkit.getScreenSize)

  this.setLayout(null)
  this.add(miniMap)
  this.add(gamePane)


  this.setUndecorated(true)
  this.setResizable(false)

  // Transparent 16 x 16 pixel cursor image.
  val cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB)

  // Create a new blank cursor.
  val blankCursor = Toolkit.getDefaultToolkit.createCustomCursor(
    cursorImg, new Point(0, 0), "blank cursor")

  // Set the blank cursor to the JFrame.
  this.getContentPane.setCursor(blankCursor)

  def toJFrame = frame
}

object MSFrame {
  implicit def toJFrame(lhs : MSFrame) : JFrame = lhs.toJFrame
}