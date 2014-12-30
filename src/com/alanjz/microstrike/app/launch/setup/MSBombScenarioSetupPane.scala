package com.alanjz.microstrike.app.launch.setup

import java.awt.{Dimension, FlowLayout}
import javax.swing._

import com.alanjz.microstrike.team.{Blue, Red}

class MSBombScenarioSetupPane {
  private val panel = new JPanel()

  private val matchLengthLabel = new JLabel("Match length (seconds)")
  private val halftimeCheckBox = new JCheckBox("Full Match with Halftime")
  private val matchLengthSpinner = new JSpinner()
  private val roundsLabel = new JLabel("Rounds")
  private val roundsSpinner = new JSpinner()
  private val redRadio = new JRadioButton("Red (Offensive)")
  private val blueRadio = new JRadioButton("Blue (Defensive)")
  private val playLabel = new JLabel("I play")

  matchLengthSpinner.setValue(180)
  roundsSpinner.setValue(10)
  redRadio.setForeground(Red)
  blueRadio.setForeground(Blue)

  this.setLayout(new FlowLayout)
  this.setPreferredSize(new Dimension(300, 0))
  this.add(matchLengthLabel)
  this.add(matchLengthSpinner)
  this.add(roundsLabel)
  this.add(roundsSpinner)
  this.add(halftimeCheckBox)
  this.add(playLabel)
  this.add(redRadio)
  this.add(blueRadio)

  def toJPanel = panel
}

object MSBombScenarioSetupPane {
  implicit def toJPanel(lhs : MSBombScenarioSetupPane) : JPanel = lhs.toJPanel
}