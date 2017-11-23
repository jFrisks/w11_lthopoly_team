package lthopoly

import lthopoly._
import scala.collection.JavaConverters._
import scala.util.{Try, Success, Failure}

object Main {
  def main(args: Array[String]): Unit = {

    // 1. prompta angående spelare & sätt upp spelplan
    val players: Vector[Player] = TextUI.promptForPlayers
    val gameBoard = new GameBoard(players.asJava)
    var turn = 0;
    var action = -1;


    // Vill egentligen inte ha detta här, men var fan annars liksom?
    val possibleActionsSet = Map(
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
    while (action != 7){
      // sätt currentPlayer
      gameBoard.currentPlayer = players(turn % players.length)

      // presentera möjliga handlingar
      var possibleActions = gameBoard.getPossibleActions
      possibleActions.foreach(a =>
        println("[" + a + "]" + possibleActionsSet(a))
      )

      // Be användaren om ett värde och låt brädet utföra den motsvarande handlingen
      action = getAction(gameBoard)
      gameBoard.doAction(action)

      if (action == 4)
        turn += 1
    }
    /**
      * Retrieves all possible actions from a GameBoard and joins
      * them with corresponding description Strings into tuples.
      * The tuples are then sent to the promptForInput method in TextUI.
      *
      * @return the user's choice as given by promptForInput.
      */
    def getAction(board: GameBoard): Int = {
      // board -> int[] -> Array[Int] -> Array[(Int, String)] (tror jag)
      val actions = board.getPossibleActions.map(
        a => (a, possibleActionsSet(a)))

      TextUI.promptForInput(actions)
    }
  }
}
