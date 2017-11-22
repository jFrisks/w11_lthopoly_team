package lthopoly

import lthopoly._
import scala.collection.JavaConverters._
import scala.util.{Try, Success, Failure}

object Main {
  def main(args: Array[String]): Unit = {

    // 1. prompta angående spelare & sätt upp spelplan
    val players: Vector[Player] = promptForPlayers
    val gameboard = new GameBoard(players)
    val possbileActionsSet = Map(
      0 -> "Throw Dice",
      1 -> "Draw Card",
      2 -> "Buy Property",
      3 -> "Pay Rent",
      4 -> "End Turn",
      5 -> "Default View",
      6 -> "Show Board",
      7 -> "Exit Game",
      )

    // 2. Huvud-loop
    while (!gameboard.isGameOver){

      // presentera möjliga handlingar
      possibleActions = gameboard.getPossibleActions
      possibleActions.foreach(a =>
        println("[" + a + "]" + possbileActionsSet(a))
      )
      gameboard.doAction(scala.io.StdIn.readLine("Choose an action: "))
    }


  }

  /**
    * Retrieves all possible actions from a GameBoard and joins
    * them with corresponding description Strings into tuples.
    * The tuples are then sent to the promptForInput method in TextUI.
    *
    * @return the user's choice as given by promptForInput.
    */
  def getAction(board: GameBoard): Int = {
    ???
    // används getPossibleActions (returnerar int[])
  }

}
