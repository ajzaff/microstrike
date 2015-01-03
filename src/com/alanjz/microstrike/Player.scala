package com.alanjz.microstrike

import java.awt.Point
import java.awt.geom.Point2D

import com.alanjz.microstrike.team.Team

class Player(val name : String, val team : Team) {
  private val _point = new Point2D.Double()
  private var _health = 0
  private var _armor = 0

  def point = new Point(x,y)

  def health = _health
  def armor = _armor
  def isAlive = health > 0
  def x : Int = _point.x.toInt
  def y : Int = _point.y.toInt

  def moveSpeed : Double = 2.7

  def setX(x : Double) = _point.setLocation(x,_point.y)
  def setY(y : Double) = _point.setLocation(_point.x,y)
  def setPoint(x : Double, y : Double) = _point.setLocation(x,y)
  def setHealth(health : Int) = _health = health
  def setArmor(armor : Int) = _armor = armor

  def moveLeft(): Unit = {
    setX(x - moveSpeed)
  }

  def moveForward(): Unit = {
    setY(y - moveSpeed)
  }

  def moveBackward(): Unit = {
    setY(y + moveSpeed)
  }

  def moveRight(): Unit = {
    setX(x + moveSpeed)
  }
}