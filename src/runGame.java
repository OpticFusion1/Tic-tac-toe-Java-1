
public class runGame {
	static public void main(String [] args) {
		Board board = new Board();
		board.display();//welcomes.
		Player player1 = new Player();//works
		Player player2 = new Player();//works
		Player.sameSymbolTest(player1, player2);
		System.out.println("Welcome "+player1.getName()+" and "+player2.getName()+"!");
		board.clear();//clears board.
		Game.play(board,player1,player2);//done!
		System.out.println("End of program execution.");
	}
}
