package com.alanjz.microstrike.app.launch.setup

import java.awt.BorderLayout
import java.awt.event.{ActionEvent, ActionListener}
import java.beans.{PropertyChangeEvent, PropertyChangeListener}
import javax.swing.{JButton, JComboBox, JLabel, JPanel}

import com.alanjz.microstrike.app.MSApp
import com.alanjz.microstrike.modes._

class MSSetupPane {
  private val panel = new JPanel()

  private val gameTypeLabel = new JLabel("Game Type")
  private val gameTypeComboBox = new JComboBox[GameMode]() {
    addPropertyChangeListener(new PropertyChangeListener {
      override def propertyChange(e : PropertyChangeEvent) =
        if(e.getNewValue == BombScenario) {
          panel.remove(setupPane)
          setupPane = new MSBombScenarioSetupPane
          panel.add(setupPane)
        }
        else if(e.getNewValue == Deathmatch) {
          panel.remove(setupPane)
          setupPane = new MSDeathmatchSetupPane
          panel.add(setupPane)
        }
    })
  }
  private val startButton = new JButton("Start Match") {
    addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        MSApp.frame.setVisible(true)
      }
    })
  }
  private var setupPane : JPanel = new MSBombScenarioSetupPane

  gameTypeComboBox.addItem(BombScenario)
  gameTypeComboBox.addItem(Deathmatch)

  this.setLayout(new BorderLayout())
  this.add(gameTypeLabel, BorderLayout.NORTH)
  this.add(gameTypeComboBox, BorderLayout.NORTH)
  this.add(setupPane, BorderLayout.CENTER)
  this.add(startButton, BorderLayout.SOUTH)

  def toJPanel = panel
}

object MSSetupPane {
  implicit def toJPanel(lhs : MSSetupPane) : JPanel = lhs.toJPanel
}
