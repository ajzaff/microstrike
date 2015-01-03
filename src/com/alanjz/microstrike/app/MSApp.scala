package com.alanjz.microstrike.app

import com.alanjz.microstrike.Player
import com.alanjz.microstrike.app.events.{MSKeys, MSMouse}
import com.alanjz.microstrike.app.game.MSMapChunker
import com.alanjz.microstrike.app.launch.MSLaunchFrame
import com.alanjz.microstrike.map.{MapInstance, EmptyMap}
import com.alanjz.microstrike.team.{Team, Red}

import scala.util.Random

object MSApp extends App with Runnable {
  val version = "0.0.1 UNRELEASED"
  val launch = new MSLaunchFrame
  val frame = new MSFrame
  val map = new EmptyMap
  val alan = new Player("Alan", Red)
  val mapInstance = new MapInstance(map)
  mapInstance.addPlayer(alan, focus=true)
  val mapChunker = new MSMapChunker(mapInstance)
  val mouse = new MSMouse(alan)
  val keys = new MSKeys(alan)
  val th = new Thread(this)
  val fps = 100

  for(i <- 1 to 10) {
    val player = new Player(s"Player ${i.toString}", Team.randomTeam)
    player.setPoint(Random.nextInt(1000), Random.nextInt(1000))
    mapInstance.addPlayer(player)
  }

  frame.addKeyListener(keys)

  th.start()

  def run(): Unit = {
    val sleep = 1e9 / fps
    while(true) {
      val start = System.nanoTime()
      frame.repaint()
      keys.update()
      while(System.nanoTime() - start < sleep)
        Thread.sleep(0,10)
      //println(fps * (System.nanoTime() - start) / sleep)
    }
  }
}
