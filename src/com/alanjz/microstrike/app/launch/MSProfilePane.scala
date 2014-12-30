package com.alanjz.microstrike.app.launch

import java.awt.{Dimension, FlowLayout}
import javax.swing.{JButton, JLabel, JPanel, JTextField}

class MSProfilePane {
  private val panel = new JPanel()

  val profileLabel = new JLabel("Profile")
  val profileField = new JTextField(18)
  val loadButton = new JButton("Load Profile")
  val createButton = new JButton("Create New Profile")

  this.setLayout(new FlowLayout)
  this.setPreferredSize(new Dimension(300, 400))
  this.add(profileLabel)
  this.add(profileField)
  this.add(loadButton)
  this.add(createButton)

  def toJPanel = panel
}

object MSProfilePane {
  implicit def toJPanel(lhs: MSProfilePane) : JPanel = lhs.toJPanel
}
