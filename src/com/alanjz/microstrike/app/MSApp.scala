package com.alanjz.microstrike.app

import com.alanjz.microstrike.Player
import com.alanjz.microstrike.app.game.MSMapChunker
import com.alanjz.microstrike.app.launch.MSLaunchFrame
import com.alanjz.microstrike.map.{MapInstance, EmptyMap}
import com.alanjz.microstrike.team.Red

object MSApp extends App {
  val version = "0.0.1 UNRELEASED"
  val launch = new MSLaunchFrame
  val frame = new MSFrame
  val map = new EmptyMap
  val alan = new Player("Alan", Red)
  val mapInstance = new MapInstance(map)
  mapInstance.addPlayer(alan, focus=true)
  val mapChunker = new MSMapChunker(mapInstance)
}
