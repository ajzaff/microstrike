package com.alanjz.microstrike.app.overlay

import java.awt._
import java.awt.geom.Ellipse2D

import com.alanjz.microstrike.app.MSApp
import com.alanjz.microstrike.app.game.MSPlayer

class MSMiniMapOverlay extends MSOverlay {
  val size = new Dimension(150,150)

  val scaleFactor = 5

  private val clip = new Ellipse2D.Double(0, 0, size.width, size.height)
  private def scale(i : Int) = i/scaleFactor
  private def scale(p : Point) = new Point(p.x/scaleFactor,p.y/scaleFactor)
  private def scale(d : Dimension) = new Dimension(d.width/scaleFactor, d.height/scaleFactor)

  this.setLocation(20, 35)
  this.setSize(size.width, size.height)

  override def paintOverlay(g2d: Graphics2D): Unit = {
    g2d.setClip(clip)

    val center = scale (MSApp.mapInstance.perspectivePoint)
    val mapCenter = new Point(size.width / 2, size.height / 2)
    val mapSize = scale (MSApp.map.bounds)

    g2d.setColor(Color.black)
    g2d.fillRect(0, 0, size.width, size.height)

    g2d.setColor(Color.gray)
    g2d.fillRect(
      mapCenter.x - center.x,
      mapCenter.y - center.y,
      mapSize.width, mapSize.height)


    g2d.setStroke(new BasicStroke(4))
    g2d.setColor(Color.black)
    g2d.draw(clip)


    for(player <- MSApp.mapInstance.players) {
      g2d.setColor(player.team)
      g2d.fillOval(
        mapCenter.x - center.x + scale(player.point.x) - scale(MSPlayer.playerDiameter / 2),
        mapCenter.y - center.y + scale(player.point.y) - scale(MSPlayer.playerDiameter / 2),
        scale(MSPlayer.playerDiameter),
        scale(MSPlayer.playerDiameter))
    }
  }
}
