package com.alanjz.microstrike.app

import java.awt.Toolkit
import java.awt.event.{InputEvent, KeyEvent, KeyListener}
import javax.swing.{JDialog, JFrame}

import com.alanjz.microstrike.app.game.MSGamePane

class MSFrame {
  private val frame = new JFrame(s"microstrike\t[${MSApp.version}]")

  this.setSize(Toolkit.getDefaultToolkit.getScreenSize)
  this.add(new MSGamePane)
  this.setLocation(0, 0)
  this.setUndecorated(true)
  this.setResizable(false)

  def toJFrame = frame
}

object MSFrame {
  implicit def toJFrame(lhs : MSFrame) : JFrame = lhs.toJFrame
}