import java.util.Scanner;

public class Game {
static private boolean gameDone=false;
static public void setGameStatus(boolean condition) {
	gameDone=condition;
};
static public void play(Board board,Player player1,Player player2) {
	 while(gameDone==false) {
		 if(gameDone==false) {
			 System.out.println();
			 showChoices(board,player1);//works
			 //showNewBoard(board);
			 selectChoice(board,player1);
			 showNewBoard(board);//works
			 drawCheck(board,player1,player2);
			 winCheck(board.getGrid(),player1,player2);
			 System.out.println();
		 }
		 if(gameDone==false) {
			 System.out.println();
			 showChoices(board,player2);//works
			 // showNewBoard(board);
			 selectChoice(board,player2);
			 showNewBoard(board);//works
			 drawCheck(board,player1,player2);
			 winCheck(board.getGrid(),player1,player2);
			 System.out.println();
		 }
	 }
	 //System.out.println("Game over!"+"The winner is "+winnerName+"!");
	 System.out.println("Game over!");
}

static void showChoices(Board board,Player player) {
	System.out.println(player.getName()+"'s turn now:");
	
	Board numbers=new Board();
	numbers.clear();
	
	//storing current board start:
	char [][]temp1=board.getGrid();
	char[][]temp2={
		//    0   1   2   3   4   5   6
			{'+','-','-','-','-','-','+'},//0
			{'|','W','|','E','|','L','|'},//1
			{'|','-','+','-','+','-','|'},//2
			{'|','C','|','O','|','M','|'},//3
			{'|','-','+','-','+','-','|'},//4
			{'|','E','|','!','|','!','|'},//5
			{'+','-','-','-','-','-','+'},//6
			};
	
	for(int i=1;i<6;i+=2) {
		for(int j=1;j<6;j+=2) {
			temp2[i][j]=temp1[i][j];
		}
	}
	//storing current board done.
	//changing stored board to contain numbers based on occupied spaces:
	int placeCount=1;
	for(int i=1;i<6;i+=2) {//display the options
		for(int j=1;j<6;j+=2) {
			if(temp2[i][j]=='X'||temp2[i][j]=='O'){
			temp2[i][j]=' ';
			placeCount++;
			}
			else{
					//type-casting begin.
					final int ya=10;
					int lol=placeCount;
					char ch = Character.forDigit(lol,ya);
					//type-casting end.
					temp2[i][j]=ch;
					placeCount++;
			}
		}
	}
	//end of changing stored board to contain numbers based on occupied spaces.
	numbers.setGrid(temp2);
	numbers.display();
}

static public void selectChoice(Board board,Player player) {
	System.out.print("Please select your choice:");
	Scanner input = new Scanner(System.in);
	int a;
	a=input.nextInt();
	
	//storing the current board start:
	char[][] storage=board.getGrid();
	char[][] storage2={
		//    0   1   2   3   4   5   6
			{'+','-','-','-','-','-','+'},//0
			{'|','W','|','E','|','L','|'},//1
			{'|','-','+','-','+','-','|'},//2
			{'|','C','|','O','|','M','|'},//3
			{'|','-','+','-','+','-','|'},//4
			{'|','E','|','!','|','!','|'},//5
			{'+','-','-','-','-','-','+'},//6
			};
	
	for(int i=1;i<6;i+=2) {
		for(int j=1;j<6;j+=2) {
			storage2[i][j]=storage[i][j];
		}
	}
	//storing current board done.
	
	switch(a) {
	case 1:
		if(storage2[1][1]=='X'||storage2[1][1]=='O') {
			System.out.println("Invalid choice!");
			selectChoice(board,player);
		}
		else board.setGridPosition(1, 1, player.getSymbol());
		break;
	case 2:
		if(storage2[1][3]=='X'||storage2[1][3]=='O') {
			System.out.println("Invalid choice!");
			selectChoice(board,player);
		}
		else board.setGridPosition(1, 3, player.getSymbol());
		break;
	case 3:
		if(storage2[1][5]=='X'||storage2[1][5]=='O') {
			System.out.println("Invalid choice!");
			selectChoice(board,player);
		}
		else board.setGridPosition(1, 5, player.getSymbol());
		break;
	case 4:
		if(storage2[3][1]=='X'||storage2[3][1]=='O') {
			System.out.println("Invalid choice!");
			selectChoice(board,player);
		}
		else board.setGridPosition(3, 1, player.getSymbol());
		break;
	case 5:
		if(storage2[3][3]=='X'||storage2[3][3]=='O') {
			System.out.println("Invalid choice!");
			selectChoice(board,player);
		}
		else board.setGridPosition(3, 3, player.getSymbol());
		break;
	case 6:
		if(storage2[3][5]=='X'||storage2[3][5]=='O') {
			System.out.println("Invalid choice!");
			selectChoice(board,player);
		}
		else board.setGridPosition(3, 5, player.getSymbol());
		break;
	case 7:
		if(storage2[5][1]=='X'||storage2[5][1]=='O') {
			System.out.println("Invalid choice!");
			selectChoice(board,player);
		}
		else board.setGridPosition(5, 1, player.getSymbol());
		break;
	case 8:
		if(storage2[5][3]=='X'||storage2[5][3]=='O') {
			System.out.println("Invalid choice!");
			selectChoice(board,player);
		}
		else board.setGridPosition(5, 3, player.getSymbol());
		break;
	case 9:
		if(storage2[5][5]=='X'||storage2[5][5]=='O') {
			System.out.println("Invalid choice!");
			selectChoice(board,player);
		}
		else board.setGridPosition(5, 5, player.getSymbol());
		break;
	default:
		System.out.println("Invalid choice!");
		selectChoice(board,player);
	}
}

static void showNewBoard(Board board) {
	System.out.println("The board is now:");
	board.display();
}

static void winCheck(char grid[][], Player player1, Player player2) {
//begin player1 win check:
		 if(grid[1][1]==grid[3][3]&&grid[3][3]==grid[5][5]&&grid[5][5]==player1.getSymbol()) {System.out.println(player1.getName()+" wins!");Game.setGameStatus(true);}//diag1
	else if(grid[1][5]==grid[3][3]&&grid[3][3]==grid[5][1]&&grid[5][1]==player1.getSymbol()) {System.out.println(player1.getName()+" wins!");Game.setGameStatus(true);}//diag2
	else if(grid[1][1]==grid[3][1]&&grid[3][1]==grid[5][1]&&grid[5][1]==player1.getSymbol()) {System.out.println(player1.getName()+" wins!");Game.setGameStatus(true);}//vert1
	else if(grid[1][3]==grid[3][3]&&grid[3][3]==grid[5][3]&&grid[5][3]==player1.getSymbol()) {System.out.println(player1.getName()+" wins!");Game.setGameStatus(true);}//vert2
	else if(grid[1][5]==grid[3][5]&&grid[3][5]==grid[5][5]&&grid[5][5]==player1.getSymbol()) {System.out.println(player1.getName()+" wins!");Game.setGameStatus(true);}//vert3
	else if(grid[1][1]==grid[1][3]&&grid[1][3]==grid[1][5]&&grid[1][5]==player1.getSymbol()) {System.out.println(player1.getName()+" wins!");Game.setGameStatus(true);}//horiz1
	else if(grid[3][1]==grid[3][3]&&grid[3][3]==grid[3][5]&&grid[3][5]==player1.getSymbol()) {System.out.println(player1.getName()+" wins!");Game.setGameStatus(true);}//horiz2
	else if(grid[5][1]==grid[5][3]&&grid[5][3]==grid[5][5]&&grid[5][5]==player1.getSymbol()) {System.out.println(player1.getName()+" wins!");Game.setGameStatus(true);}//horiz3
//end of player1 win check.
//begin player2 win check:
		 if(grid[1][1]==grid[3][3]&&grid[3][3]==grid[5][5]&&grid[5][5]==player2.getSymbol()) {System.out.println(player2.getName()+" wins!");Game.setGameStatus(true);}//diag1
	else if(grid[1][5]==grid[3][3]&&grid[3][3]==grid[5][1]&&grid[5][1]==player2.getSymbol()) {System.out.println(player2.getName()+" wins!");Game.setGameStatus(true);}//diag2
	else if(grid[1][1]==grid[3][1]&&grid[3][1]==grid[5][1]&&grid[5][1]==player2.getSymbol()) {System.out.println(player2.getName()+" wins!");Game.setGameStatus(true);}//vert1
	else if(grid[1][3]==grid[3][3]&&grid[3][3]==grid[5][3]&&grid[5][3]==player2.getSymbol()) {System.out.println(player2.getName()+" wins!");Game.setGameStatus(true);}//vert2
	else if(grid[1][5]==grid[3][5]&&grid[3][5]==grid[5][5]&&grid[5][5]==player2.getSymbol()) {System.out.println(player2.getName()+" wins!");Game.setGameStatus(true);}//vert3
	else if(grid[1][1]==grid[1][3]&&grid[1][3]==grid[1][5]&&grid[1][5]==player2.getSymbol()) {System.out.println(player2.getName()+" wins!");Game.setGameStatus(true);}//horiz1
	else if(grid[3][1]==grid[3][3]&&grid[3][3]==grid[3][5]&&grid[3][5]==player2.getSymbol()) {System.out.println(player2.getName()+" wins!");Game.setGameStatus(true);}//horiz2
	else if(grid[5][1]==grid[5][3]&&grid[5][3]==grid[5][5]&&grid[5][5]==player2.getSymbol()) {System.out.println(player2.getName()+" wins!");Game.setGameStatus(true);}//horiz3
//end of player2 win check.
}

static void drawCheck(Board board, Player player1, Player player2) {
	//storing the current board start:
	char[][] storage=board.getGrid();
	char[][] storage2={
		//    0   1   2   3   4   5   6
			{'+','-','-','-','-','-','+'},//0
			{'|','W','|','E','|','L','|'},//1
			{'|','-','+','-','+','-','|'},//2
			{'|','C','|','O','|','M','|'},//3
			{'|','-','+','-','+','-','|'},//4
			{'|','E','|','!','|','!','|'},//5
			{'+','-','-','-','-','-','+'},//6
			};
	
	for(int i=1;i<6;i+=2) {
		for(int j=1;j<6;j+=2) {
			storage2[i][j]=storage[i][j];
		}
	}
	//storing current board done.
	
	//changing stored board to contain numbers based on occupied spaces:
		int placeCount=1;
		for(int i=1;i<6;i+=2) {//display the options
			for(int j=1;j<6;j+=2) {
				if(storage2[i][j]=='X'||storage2[i][j]=='O'){
				storage2[i][j]=' ';
				placeCount++;
				}
				else{
						//type-casting begin.
						final int ya=10;
						int lol=placeCount;
						char ch = Character.forDigit(lol,ya);
						//type-casting end.
						storage2[i][j]=ch;
						placeCount++;
				}
			}
		}
	//end of changing stored board to contain numbers based on occupied spaces.
	
		//checking if all spaces are ' ' then say draw if true.:
		if(		storage2[1][1]==' '&&
				storage2[1][3]==' '&&
				storage2[1][5]==' '&&
				storage2[3][1]==' '&&	
				storage2[3][3]==' '&&
				storage2[3][5]==' '&&
				storage2[5][1]==' '&&
				storage2[5][3]==' '&&
				storage2[5][5]==' ') {
			System.out.println("It's a draw!");
			Game.setGameStatus(true);
		}
		//end of checking if all spaces are ' ' then say draw if true.
	}
}