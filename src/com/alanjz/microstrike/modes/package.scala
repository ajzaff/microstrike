package com.alanjz.microstrike

package object modes {
  trait GameMode {
    def settings : GameSettings
  }

  trait GameSettings

  class GameSetup(val mode : GameMode) {

  }

  object GameSetup {
    def newInstance(mode : GameMode) = new GameSetup(mode)
  }
  
  case object BombScenario extends GameMode {
    override def toString = "Bomb Scenario Mission"
    override def settings = new GameSettings {

    }
  }
  case object Deathmatch extends GameMode {
    override def toString = "Team Deathmatch"
    override def settings = new GameSettings {

    }
  }
}
