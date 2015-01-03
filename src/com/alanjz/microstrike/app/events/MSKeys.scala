package com.alanjz.microstrike.app.events

import java.awt.event.{KeyEvent, KeyListener}
import java.awt.event.KeyEvent._

import com.alanjz.microstrike.Player

class MSKeys(val player : Player) extends KeyListener {

  private var wDown = false
  private var aDown = false
  private var sDown = false
  private var dDown = false

  def update(): Unit = {
    if(wDown) player.moveForward()
    if(aDown) player.moveLeft()
    if(sDown) player.moveBackward()
    if(dDown) player.moveRight()
  }

  override def keyTyped(e: KeyEvent): Unit = {
  }

  override def keyPressed(e: KeyEvent): Unit = {
    e.getKeyCode match {
      case VK_W => wDown = true
      case VK_A => aDown = true
      case VK_S => sDown = true
      case VK_D => dDown = true
      case _ =>
    }
  }

  override def keyReleased(e: KeyEvent): Unit = {
    e.getKeyCode match {
      case VK_W => wDown = false
      case VK_A => aDown = false
      case VK_S => sDown = false
      case VK_D => dDown = false
      case _ =>
    }
  }
}