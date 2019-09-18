  object TicTacToe {
  
    import Array._
    
    class Player
    case object O extends Player
    case object X extends Player
    
    var player: Player = _
    var turn: Int = 1
    var turnX = 0
    var turnY = 0
    
    def optPlayerToChar(p: Option[Player]): Char = p match {
      case None    => ' '
      case Some(O) => 'O'
      case Some(X) => 'X'
    }
    
    private var grid: Array[Array[Option[Player]]] = ofDim[Option[Player]](3,3)
  
    /**
     * Reset the grid to an initial state.  All the cells are blank.
     * Player X always starts the game
     */
    def reset() {
      player = X
      turn = 1
      for (i <- 0 to 2; j <- 0 to 2)
        grid(i)(j) = None
    }
    
    def showGrid() {
      println()
      for(j <- 0 to 2) {
          print("  "  + optPlayerToChar(grid(0)(j)))
          print(" | " + optPlayerToChar(grid(1)(j)))
          print(" | " + optPlayerToChar(grid(2)(j)))
          println()
          if (j<2) println(" ---+---+--- ")
      }
      println()
    }
    
    def winner(p: Player): Boolean = {
      //vars
      var winCounter = 0
      var winCondition = false
      
      //horizontal rows
      for(j <- 0 to 2) {
        for(i <- 0 to 2) {
          if (grid(i)(j) == Some(p)) winCounter +=1
          if (winCounter == 3) winCondition = true
          if ((i == 2) && winCounter < 3) winCounter = 0  
        }
      }
      
      //vertical rows
      for(i <- 0 to 2) {
        if (grid(i)(2) == Some(p)) winCounter +=1
        if (grid(i)(1) == Some(p)) winCounter +=1
        if (grid(i)(0) == Some(p)) winCounter +=1
        if (winCounter == 3) winCondition = true
        if (winCounter < 3) winCounter = 0
      }
      
      //diagonal rows
      for(i <- 0 to 2) {
        if (grid(i)(i) == Some(p)) winCounter +=1
        if (winCounter == 3) winCondition = true
        if ((i == 2) && winCounter < 3) winCounter = 0 
      }
      if (grid(2)(0) == Some(p)) winCounter +=1
      if (grid(1)(1) == Some(p)) winCounter +=1
      if (grid(0)(2) == Some(p)) winCounter +=1
      if (winCounter == 3) winCondition = true
      
      //check win condition
      if (winCondition == true) true else false
    }
    
    def inputMove() {
      if (turn%2==0) player = O else player = X
      do {
        print("X: ")
        turnX = readInt()
      } while (turnX < 0 || turnX > 2)
      do {
        print("Y: ")
        turnY = readInt()
      }  while (turnY < 0 || turnY > 2)
      grid(turnX)(turnY) = Some(player)
      turn += 1
    }
    
    def main(args: Array[String]): Unit = {
      reset()
      while(turn < 9 && !winner(X) && !winner(O)) {
      if (turn%2==0) player = O else player = X
      println(s"It is ${optPlayerToChar(Some(player))}'s turn")
        showGrid()
        inputMove()
      }
      showGrid()
      if (winner(X))
        println(s"${optPlayerToChar(Some(X))} won")
      else if (winner(O))
        println(s"${optPlayerToChar(Some(O))} won")
      else
        println("It's a draw")
    }
  
  }