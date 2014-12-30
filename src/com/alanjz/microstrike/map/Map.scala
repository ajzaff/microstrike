package com.alanjz.microstrike.map

import java.awt.Dimension

import com.alanjz.microstrike.Player

import scala.collection.mutable.ListBuffer

abstract class Map {
  val bounds : Dimension
}

class MapInstance(map : Map) {
  private val _players = ListBuffer.empty[Player]
  private var _perspective : Option[Int] = None

  def perspective : Option[Player] =
    if(_perspective.isDefined)
      Some(players(_perspective.get))
    else None

  def players = _players.toList

  def N : Int = _players.length
  def addPlayer(player : Player, focus : Boolean = false) = {
    _players += player
    player.setX(0)
    player.setY(0)
    if(focus) _perspective = Some(N-1)
  }
  def removePlayer(player : Player) = _players -= player

  def cycle() : Unit = {
    if(N == 0) return
    if(_perspective == None) {
      _perspective = Some(0)
    } else _perspective = Some((_perspective.get + 1) % N)
  }
}