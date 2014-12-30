package com.alanjz.microstrike

import java.awt.Point

import com.alanjz.microstrike.team.Team

class Player(name : String, team : Team) {
  private val _point = new Point()
  private var _health = 0
  private var _armor = 0

  def health = _health
  def armor = _armor
  def isAlive = health > 0
  def getPoint = new Object {
    def x = _point.x
    def y = _point.y
  }
  def x = _point.x
  def y = _point.y

  def setX(x : Int) = _point.setLocation(x,_point.y)
  def setY(y : Int) = _point.setLocation(_point.x,y)
  def setPoint(x : Int, y : Int) = _point.setLocation(x,y)
  def setHealth(health : Int) = _health = health
  def setArmor(armor : Int) = _armor = armor
}