import java.util.ArrayList;
import java.util.Random;

public class TicTacToe {

	protected char[] board;
	protected char player1;
	protected char player2;
	protected char currentPlayer;
	protected char winner;
	
	//Creating a no parameter constructor
	public TicTacToe(){
	}
	
	//Creating accessor and mutator methods
	public void setPlayer1(char player1){
		this.player1=player1;
	}

	public void setPlayer2(char player2){
		this.player2=player2;
	}
	
	public char getPlayer1(){
		return player1;
	}
	
	public char getPlayer2(){
		return player2;
	}
	
	public char getCurrentPlayer(){
		return currentPlayer;
	}

	//Creating a constructor with parameters
	public TicTacToe(char player1,char player2){
		this.player1=player1;
		this.currentPlayer=player1;
		this.player2=player2;
		this.board=initializeBoard();
		this.winner=' ';
	}
	
	//Initializing the board with blank spaces
	public char[] initializeBoard(){
		char[] board= new char[9];
		for(int i=0;i<board.length;i++){
			board[i]=' ';
		}	
		System.out.println(board);
		return board;
	}
	
	//Creating how the tictactoe board should look like
	public void printBoard(){
		System.out.println();
		for(int i=0;i<9;i++){
			if(i%3 ==0 && i!=0){
				System.out.println();
				System.out.println("------------");		
			}
			System.out.print(board[i] +" | ");	
		}
		System.out.println();
	}
	
	//Creating the same board with numbers shown for players to see which numbers to choose
	public void printPlayerBoard(){
		System.out.println();
		for(int i=0;i<9;i++){
			if(i%3 ==0 && i!=0){
				System.out.println();
				System.out.println("------------");		
			}
			System.out.print(i +" | ");	
		}
		System.out.println();
	}
	
	//Check if the board is full or not
	public boolean isBoardFull(){
		boolean isFull = true;
		for(int i =0;i<9;i++){
			if(board[i]==' '){
				isFull = false;
			}
		}
		return isFull;
	}
	
	public boolean isValid(int spot){
		if(((spot>=0 && spot<=8)) && board[spot]==' '){
			return true;
		}
		else 
			return false;
	}
	
	//Switch the player from 1 to 2 or vice versa
	public char changePlayer(int spot){ 
		if(isValid(spot)){
			board[spot] = currentPlayer;
			if(currentPlayer==player1){
				currentPlayer=player2;
			}
			else
				currentPlayer=player1;
		}
		return currentPlayer;
	}
	
	//Check for a winner
	public boolean checkForWinner() {
		if ((rightDiag() || leftDiag() || midRow() || secCol()) && board[4] != ' '){
			this.winner = board[4];
			return true;
		} else if ((topRow() || firstCol()) && board[0] != ' ') {
			this.winner = board[0];
			return true;
		} else if ((bottomRow() || thirdCol()) && board[8] != ' ') {
			this.winner = board[8];
			return true;
		}
		return false;
	}

	public boolean topRow() {
		return board[0]==board[1] && board[1]==board[2];
	}	
	public boolean bottomRow() {
		return board[6]==board[7] && board[7]==board[8];
	}
	public boolean midRow() {	
		return board[3]==board[4] && board[4]==board[5];
	}	
	public boolean firstCol() {
		return board[0]==board[3] && board[3]==board[6];		
	}
	public boolean secCol() {
		return board[1]==board[4] && board[4]==board[7];
	}
	public boolean thirdCol() {
		return board[2]==board[5] && board[5]==board[8];
	}
	public boolean rightDiag() {
		return board[0]==board[4] && board[4]==board[8];
	}
	public boolean leftDiag() {
		return board[2]==board[4] && board[4]==board[6];
	}
	
	//Player2 picks a spot with random generation
	public int player2Spot() {
        ArrayList<Integer> p2spot = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++) {
            if (board[i] == ' ') {
            	p2spot.add(i);
            }
        }
        Random rand = new Random();
        int p2spotMark = p2spot.get(Math.abs(rand.nextInt() % p2spot.size()));
        return p2spotMark;
    }
	
	//Check if game is over or not
	public String gameOver(){
		if(checkForWinner()){
			return "Congratulations "+this.winner +"!!! You have won the game!";
		}
		else if(isBoardFull()){
			return "Draw game!";
		}
		else {
			return "Game not over!";
		}
	}
}


