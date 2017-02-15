import java.util.Scanner;

public class TicTacToeTest {

	public static void main(String[] args) {
		
		boolean startgame = true;
		System.out.println("Welcome to the game of TicTacToe");
		
		TicTacToe t1 = new TicTacToe();
		
		while(startgame){	
			System.out.println();
			System.out.println("Hi Player1! Choose whether you want to be X or O. Please type below");
			Scanner sc = new Scanner(System.in);
			
			//Asking the player to input either X or O
			t1.setPlayer1(sc.next().charAt(0));
			
			
			//If player1 chooses X, then player2 will be O else X
			if(t1.getPlayer1()=='X'){
				t1.setPlayer2('O');
			}
			else{
				t1.setPlayer2('X');
			}
			System.out.println();
			System.out.println("Hi Player2! You will be "+t1.getPlayer2());

			TicTacToe tc = new TicTacToe(t1.getPlayer1(),t1.getPlayer2());

			System.out.println("Let us start the game. Choose a number between 0 and 8");
			System.out.println();
			
			//Printing the game board for the players to choose the numbers
			tc.printPlayerBoard();

			while(tc.gameOver() .equals("Game not over!"))	{
				if(tc.getCurrentPlayer()==tc.getPlayer1()){
					System.out.println();
					System.out.println("Player1! Choose a number between 0 and 8!!");
					int p1spot = sc.nextInt();
					
					//if the spot chosen by the player is either already taken or an invalid number, ask to type again
					while(tc.isValid(p1spot)==false){
						System.out.println("This is an invalid choice or the number is already taken, choose another number between 0 and 8");
						p1spot= sc.nextInt();
					}
					
					System.out.println("Player1 chose the spot "+ p1spot);
					tc.changePlayer(p1spot);	//player1 has finished playing now switch to player2	
				}
				else {
					System.out.println();
					System.out.println("Player2! Choose a number between 0 and 8!!");
					int p2spot = tc.player2Spot();
					tc.changePlayer(p2spot);	//Since, player2 has finished playing, change to player1
					System.out.println("Player2 chose the spot " +p2spot);
				}
				System.out.println();
				tc.printBoard();	//After each player plays, display the board
			}
			System.out.println();
			System.out.println(tc.gameOver());	//Calling the method gameOver to print the result of the game
			System.out.println();	
			
			System.out.println("Do you want to play again? If yes, type Y else N");
			
			char result = sc.next().charAt(0);		//Enter either Y or N
			
			if(Character.toUpperCase(result)=='Y'){
				System.out.println("Let's play again!!!");
				startgame = true;	//start the first while loop again
			}
			else if (Character.toUpperCase(result)=='N'){
				System.out.println("Game Over!!!");	
				startgame = false;	//No more games
			}
			else{
				System.out.println("You have typed an invalid letter. Please type Y or N");
				result = sc.next().charAt(0);  //Asking for another letter
			}
		}
	}
}
