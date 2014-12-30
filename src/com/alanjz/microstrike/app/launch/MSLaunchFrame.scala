package com.alanjz.microstrike.app.launch

import java.awt.BorderLayout
import javax.swing.JFrame

import com.alanjz.microstrike.app.MSApp
import com.alanjz.microstrike.app.launch.setup.MSSetupPane

class MSLaunchFrame {
  private val frame = new JFrame(s"microsrike\t[${MSApp.version}]")

  this.setLayout(new BorderLayout)
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  this.add(new MSSplashPane, BorderLayout.NORTH)
  this.add(new MSProfilePane, BorderLayout.WEST)
  this.add(new MSSetupPane, BorderLayout.EAST)
  this.setResizable(false)
  this.pack()
  this.setVisible(true)
  this.setLocationRelativeTo(null)

  def toJFrame = frame
}

object MSLaunchFrame {
  implicit def toJFrame(lhs : MSLaunchFrame) : JFrame = lhs.toJFrame
}