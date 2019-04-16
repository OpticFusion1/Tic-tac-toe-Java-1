import java.util.Scanner;

public class Player {
	
private char symbol;// X or O
private String name;

static private int playercount = 1;
static private boolean isSymbolIdentical=false;

public String getName() {return name;}
public char getSymbol() {return symbol;}
static public boolean getIsSymbolIdentical() {return isSymbolIdentical;}

Player() {
	this.setName();//works as expected.
	this.setSymbol();//works as expected.
	}

void setName() {//works for 2 players as expected.
	System.out.println("Player "+playercount+" please enter your name:");
	Scanner choice = new Scanner(System.in);
	this.name=choice.next();
	Player.playercount++;
}

public void setSymbol() {//works as expected.
System.out.println(this.name+", please select your symbol as X or O:");

	char a;
	Scanner choice2 = new Scanner(System.in);
	a=choice2.next().charAt(0);
	
	if((a=='X')||(a=='O')) {
		this.symbol=a;
		System.out.println("Your symbol is: "+this.getSymbol());
	}
	else {
		System.out.println("Invalid selection!");
		setSymbol();
	}
	//System.out.println("End of setSymbol execution");
}

static public void sameSymbolTest(Player player1 ,Player player2) {//this will be called after player2 chooses their symbol.
	if(player1.getSymbol()==player2.getSymbol()) {
		System.out.println("You cannot choose the same symbol as player1!");
		player2.setSymbol();
	}
}

}
