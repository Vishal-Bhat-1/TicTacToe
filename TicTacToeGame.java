public class TicTacToeGame {
		/**
		* The board of the game, stored as a single array.
		*/

		private CellValue[] board;


		/**
		* level records the number of rounds that have been
		* played so far. Starts at 0.
		*/
		private int level;

		/**
		* gameState records the current state of the game.
		*/
		private GameState gameState;


		/**
		* lines is the number of lines in the grid
		*/
		private final int lines;

		/**
		* columns is the number of columns in the grid
		*/
		private final int columns;


		/**
		* sizeWin is the number of cell of the same type
		* that must be aligned to win the game.
		* For simplicity, it will be always 3 in this assignment.
		*/
		private final int sizeWin;


		/**
	 * default constructor, for a game of 3x3, which must
	 * align 3 cells
	 */
		 public TicTacToeGame(){
				 // your code here
				 this.lines = 3;
				 this.columns = 3;
				 this.sizeWin = 3;
				 this.gameState = GameState.PLAYING;
				 this.board = new CellValue[9];
				 for (int i  =0; i<this.board.length; i++){
					 board[i] = CellValue.EMPTY;
				 }
			}

		/**
		 * constructor allowing to specify the number of lines
		 * and the number of columns for the game. 3 cells must
		 * be aligned.
				* @param lines
		 *  the number of lines in the game
		 * @param columns
		 *  the number of columns in the game
			 */
		 public TicTacToeGame(int lines, int columns){
				 this.lines = lines;
				 this.columns = columns;
				 this.sizeWin =3;
				 this.gameState = GameState.PLAYING;
				 board = new CellValue[this.lines*this.columns];
				 for (int i  =0; i<this.board.length; i++){
					 board[i] = CellValue.EMPTY;
				 }
		 }

		/**
		 * constructor allowing to specify the number of lines
		 * and the number of columns for the game, as well as
		 * the number of cells that must be aligned to win.
				* @param lines
		 *  the number of lines in the game
		 * @param columns
		 *  the number of columns in the game
		 * @param sizeWin
		 *  the number of cells that must be aligned to win.
			 */


		 public TicTacToeGame(int lines, int columns, int sizeWin){
				 // your code here
				 this.columns = columns;
				 this.lines = lines;
				 this.sizeWin = 3;
				 this.gameState = GameState.PLAYING;
				 //Intiialize and fill the game board
				 this.board = new CellValue[this.columns*this.lines];
				 for (int i  =0; i<this.board.length; i++){
					 board[i] = CellValue.EMPTY;
				 }
		 }



	/**
	 * getter for the variable lines
	 * @return
	 *     the value of lines
	 */
	 public int getLines(){
			return lines;
	 }

	/**
	 * getter for the variable columns
	 * @return
	 *     the value of columns
	 */
	 public int getColumns(){
			 // your code here
	 	 return columns;

	 }

	/**
	 * getter for the variable level
	 * @return
	 *     the value of level
	 */
	 public int getLevel(){
			//level++;
	 	return level;

	 }


	/**
	 * getter for the variable gameState
	 * @return
	 *     the value of gameState
	 */
	 public GameState getGameState(){
	 	 return gameState;
	 }

	/**
	 * getter for the variable sizeWin
	 * @return
	 *     the value of sizeWin
	 */
	 public int getSizeWin(){
			 return sizeWin;
	 }

	/**
	 * returns the cellValue that is expected next,
	 * in other word, which played (X or O) should
	 * play next.
	 * This method does not modify the state of the
	 * game.
	 * @return
	 *  the value of the enum CellValue corresponding
	 * to the next expected value.
		 */
	 public CellValue nextCellValue(){
			 if (level % 2==0){
					 return CellValue.X; //changed O to X
			 } else{
					 return CellValue.O; //same here
			 }

		}

	/**
	 * returns the value  of the cell at
	 * index i.
	 * If the index is invalid, an error message is
	 * printed out. The behavior is then unspecified
			* @param i
	 *  the index of the cell in the array board
	 * @return
	 *  the value at index i in the variable board.
		 */
	 public CellValue valueAt(int i) {
			for(int x=0; x<board.length; x++ ) {
			 if (i==x) {
					 return board[i];
			 }
	 	}
			 System.out.println("Error: Input is invalid. Please enter an existing cell(1-9)");
			 return null;
	 }


	/**
	 * This method is called by the next player to play
	 * at the cell  at index i.
	 * If the index is invalid, an error message is
	 * printed out. The behaviour is then unspecified
	 * If the chosen cell is not empty, an error message is
	 * printed out. The behaviour is then unspecified
	 * If the move is valide, the board is updated, as well
	 * as the state of the game.
	 * To faciliate testing, it is acceptable to keep playing
	 * after a game is already won. If that is the case, the
	 * a message should be printed out and the move recorded.
	 * the  winner of the game is the player who won first
			* @param i
	 *  the index of the cell in the array board that has been
	 * selected by the next player
		 */
	 public void play(int i) {
	 	/*
	 	if (gameState.equals(GameState.XWIN) || gameState.equals(GameState.OWIN)){
	 		System.out.println("Game already finished!");
	 	}
		valueAt(i);
		if (valueAt(i) != null) {
			nextCellValue();
			if (valueAt(i).equals(CellValue.EMPTY)){
				level++;
				setGameState(i);
			} else {
				System.out.println("Please choose an empty cell(1-9).");
			}
		} 
		*/
		
		
		 try{
            if (board[i].equals(CellValue.EMPTY)){
                 if (gameState.equals(GameState.XWIN) || gameState.equals(GameState.OWIN)){
                         System.out.println("Game already finished");
                         if (level%2==0){
                           board[i] = CellValue.X;
                           //level++;
                           setGameState(i);

                                 }
                                 else{
                                         board[i] = CellValue.O;
                                         //level++;
                                         setGameState(i);

                                 }
                         }
                         else{
                                 if (level%2==0){
                                         board[i] = CellValue.X;
                                         //level++;
                                         setGameState(i);

                                 }
                                 else{
                                         board[i] = CellValue.O;
                                         //level++;
                                         setGameState(i);

                                 }
                         }

                 }
                 else{
                         System.out.println("Please choose an empty cell(1-9).");
                 }
         }
         catch(IndexOutOfBoundsException e) {
                 System.out.println("Please enter a existing cell(1-9).");//Cell that doesn't exist
         }
		

	 }

	 /**
	 * A helper method which updates the gameState variable
	 * correctly after the cell at index i was just set.
	 * The method assumes that prior to setting the cell
	 * at index i, the gameState variable was correctly set.
	 * it also assumes that it is only called if the game was
	 * not already finished when the cell at index i was played
	 * (the the game was playing). Therefore, it only needs to
	 * check if playing at index i has concluded the game
	 * So check if 3 cells are formed to win.
//       * @param i
	 *  the index of the cell in the array board that has just
	 * been set
		 */
		    
		 private void setGameState(int i){ //changed index to i
		 	//i=i-1;
		 	int a = i+1;
		 	int b = a%columns;
		 	level++;
		 	//javac TicTacToe.java
		 	System.out.println("level: " + level + " board length: " + board.length);
		 	if (level == board.length) {
					gameState = GameState.DRAW;
			 	}
        	if (board[i].equals(CellValue.O)) {
        		if (b==0) {
        			b=columns;
        			System.out.println("In here");
        		}
        		//((a+columns*2) <= board.length) + ((a-columns*2) > 0) +
       		System.out.println("O:"+ board[i] + a + (b+2 <= columns) + (b-2 > 0) +  (board[i]) + (board[i-columns+1]) + (board[i-columns*2+2])+i + (b-2 > 0) + (i-columns*2) );
       		//System.out.println("Sups"+ board[i]+""+board[i+1]+""+board[i+2]+""+board[i-1]+""+board[i-2]+""+board[i+columns]+""+board[i+2*columns]+""+board[i-columns]+""+board[i-2*columns]);
       		
            if (b+2 <= columns && board[i].equals(board[i+1]) && board[i].equals(board[i+2])) { //left to right
                gameState = GameState.OWIN;
            } else if (b-2 > 0 && board[i].equals(board[i-1]) && board[i].equals(board[i-2])){ //right to left
                gameState = GameState.OWIN;
            } else if ((a+columns*2) <= board.length && board[i].equals(board[i+columns]) && board[i].equals(board[i+2*columns])){ //up to down
            	 System.out.println("What" + board[i]+""+board[i+1]+""+board[i+2]+""+board[i-1]+""+board[i-2]+""+board[i+columns]+""+board[i+2*columns]+""+board[i-columns]+""+board[i-2*columns]);
                gameState = GameState.OWIN;
            } else if ((a-columns*2) > 0 && board[i].equals(board[i-columns]) && board[i].equals(board[i-2*columns])){ //down to up
                gameState = GameState.OWIN;
            } else if (b+2 <= columns && (a-columns*2) > 0 && board[i].equals(board[i-columns+1]) && board[i].equals(board[i-columns*2+2])){ //downleft to upright
                gameState = GameState.OWIN;
            } else if (b-2 > 0 && (i+columns*2) <= board.length && board[i].equals(board[i+columns-1]) && board[i].equals(board[i+columns*2-2])){ //upright to downleft
                gameState = GameState.OWIN;
            } else if (b-2 > 0 && (i-columns*2) > 0 && board[i].equals(board[i-columns-1]) && board[i].equals(board[i-columns*2-2])){ //downright to upleft
                gameState = GameState.OWIN;
            } else if (b+2 <= columns && (i+columns*2) <= board.length && board[i].equals(board[i+columns+1]) && board[i].equals(board[i+columns*2+2])){ //upleft to downright
                gameState = GameState.OWIN;
            } else if (b+1 <= columns && (a%columns)-1 > 0 && board[i].equals(board[i+1]) && board[i].equals(board[i-1])) { //right and left
            	 gameState = GameState.OWIN;
            } else if ((a+columns) <= board.length && (a-columns) > 0  && board[i].equals(board[i+columns]) && board[i].equals(board[i-columns])){ //up and down
            	 gameState = GameState.OWIN;
            } else if (b+1 <= columns && (a%columns)-1 > 0 && (a+columns) <= board.length && (a-columns) > 0  && board[i].equals(board[i+columns-1]) && board[i].equals(board[i-columns+1])){ //upright and downleft
            	 gameState = GameState.OWIN;
            } else if (b+1 <= columns && (a%columns)-1 > 0 && (a+columns) <= board.length && (a-columns) > 0  && board[i].equals(board[i+columns+1]) && board[i].equals(board[i-columns-1])){ //upleft and downright
            	 gameState = GameState.OWIN;
            } else if (level == board.length) {
			 				 gameState = GameState.DRAW;
			 	}
       	} else if (board[i].equals(CellValue.X)) {
        		if (b==0) {
        			b=columns;
        			System.out.println("In here");
        		}
        		//((a+columns*2) <= board.length) + ((a-columns*2) > 0) +
       		//System.out.println("O:"+ board[i] + a + (b+2 <= columns) + (b-2 > 0) +  (board[i]) + (board[i-columns+1]) + (board[i-columns*2+2])+i + (b-2 > 0) + (i-columns*2) );
       		//System.out.println("Sups"+ board[i]+""+board[i+1]+""+board[i+2]+""+board[i-1]+""+board[i-2]+""+board[i+columns]+""+board[i+2*columns]+""+board[i-columns]+""+board[i-2*columns]);
       		System.out.println("XXXXX:");
       		
            if (b+2 <= columns && board[i].equals(board[i+1]) && board[i].equals(board[i+2])) { //left to right
                gameState = GameState.XWIN;
            } else if (b-2 > 0 && board[i].equals(board[i-1]) && board[i].equals(board[i-2])){ //right to left
                gameState = GameState.XWIN;
            } else if ((a+columns*2) <= board.length && board[i].equals(board[i+columns]) && board[i].equals(board[i+2*columns])){ //up to down
            	 System.out.println("What" + board[i]+""+board[i+1]+""+board[i+2]+""+board[i-1]+""+board[i-2]+""+board[i+columns]+""+board[i+2*columns]+""+board[i-columns]+""+board[i-2*columns]);
                gameState = GameState.XWIN;
            } else if ((a-columns*2) > 0 && board[i].equals(board[i-columns]) && board[i].equals(board[i-2*columns])){ //down to up
                gameState = GameState.XWIN;
            } else if (b+2 <= columns && (a-columns*2) > 0 && board[i].equals(board[i-columns+1]) && board[i].equals(board[i-columns*2+2])){ //downleft to upright
                gameState = GameState.XWIN;
            } else if (b-2 > 0 && (a+columns*2) <= board.length && board[i].equals(board[i+columns-1]) && board[i].equals(board[i+columns*2-2])){ //upright to downleft
                gameState = GameState.XWIN;
            } else if (b-2 > 0 && (a-columns*2) > 0 && board[i].equals(board[i-columns-1]) && board[i].equals(board[i-columns*2-2])){ //downright to upleft
                gameState = GameState.XWIN;
            } else if (b+2 <= columns && (a+columns*2) <= board.length && board[i].equals(board[i+columns+1]) && board[i].equals(board[i+columns*2+2])){ //upleft to downright
                gameState = GameState.XWIN;
            } else if (b+1 <= columns && (a%columns)-1 > 0 && board[i].equals(board[i+1]) && board[i].equals(board[i-1])) { //right and left
            	 gameState = GameState.XWIN;
            } else if ((a+columns) <= board.length && (a-columns) > 0  && board[i].equals(board[i+columns]) && board[i].equals(board[i-columns])){ //up and down
            	 gameState = GameState.XWIN;
            } else if (b+1 <= columns && (a%columns)-1 > 0 && (a+columns) <= board.length && (a-columns) > 0  && board[i].equals(board[i+columns-1]) && board[i].equals(board[i-columns+1])){ //upright and downleft
            	 gameState = GameState.XWIN;
            } else if (b+1 <= columns && (a%columns)-1 > 0 && (a+columns) <= board.length && (a-columns) > 0  && board[i].equals(board[i+columns+1]) && board[i].equals(board[i-columns-1])){ //upleft and downright
            	 gameState = GameState.XWIN;
            } else if (level == board.length) {
			 				 gameState = GameState.DRAW;
			 	}
			}

    }
		final String NEW_LINE = System.getProperty("line.separator");
	 // returns the OS dependent line separator

	/**
	 * Returns a String representation of the game matching
	 * the example provided in the assignment's description
	 *
			* @return
	 *  String representation of the game
		 */

		 public String toString(){
			 // your code here
			 // use NEW_LINE defined above rather than \n
			 String gameBoard;
			 gameBoard=""+NEW_LINE;
			 int j = 0;
			 for (int i = 1;i<=lines; i++){
					 int k = 1;



					 while (k<=columns) {

							 if (k == columns) {
									 if (board[j].equals(CellValue.EMPTY)){
											 gameBoard += "   ";
											 j++;
											 k++;
									 }
									 else if (board[j].equals(CellValue.X)){
											 gameBoard += " X ";
											 j++;
											 k++;
									 }
									 else if (board[j].equals(CellValue.O)){
											 gameBoard += " O ";
											 j++;
											 k++;

									 }

							 } else {
									 if (board[j].equals(CellValue.EMPTY)){
											 gameBoard += "   ";
											 j++;
											 k++;
									 }
									 else if (board[j].equals(CellValue.X)){
											 gameBoard += " X ";
											 j++;
											 k++;
									 }
									 else if (board[j].equals(CellValue.O)){
											 gameBoard += " O ";
											 j++;
											 k++;
									 }
									 gameBoard += "|";


							 }
					 }
					 gameBoard+=NEW_LINE;
					 if (i!=lines) {
							 for (int y = 0; y < columns; y++) {
									 gameBoard += "----";
							 }
					 }
					 gameBoard+=NEW_LINE;

			 }
			 return gameBoard;
 }








}
                                                                                
