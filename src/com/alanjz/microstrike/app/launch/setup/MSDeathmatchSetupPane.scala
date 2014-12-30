package com.alanjz.microstrike.app.launch.setup

import javax.swing.JPanel


class MSDeathmatchSetupPane {
  private val panel = new JPanel()

  def toJPanel = panel
}

object MSDeathmatchSetupPane {
  implicit def toJPanel(lhs : MSDeathmatchSetupPane) : JPanel = lhs.toJPanel
}