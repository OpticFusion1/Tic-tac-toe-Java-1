public class Board{
private char [][] grid= {
	//	  0   1   2   3   4   5   6
		{'+','-','-','-','-','-','+'},//0
		{'|','W','|','E','|','L','|'},//1
		{'|','-','+','-','+','-','|'},//2
		{'|','C','|','O','|','M','|'},//3
		{'|','-','+','-','+','-','|'},//4
		{'|','E','|','!','|','!','|'},//5
		{'+','-','-','-','-','-','+'},//6
		};
public void setGrid(char newGrid[][]) {
	this.grid=newGrid;
}

public void setGridPosition(int a/*row#*/,int b/*column#*/,char c/*new char*/) {
	this.grid[a][b]=c;
}
/*
changeable: 1,1 , 1,3 , 1,5
			3,1 , 3,3 , 3,5
			5,1 , 5,3 , 5,5;
*/
public Board() {
	//this.display();//welcome!
}

public void display() {
for(int i=0;i<7;i++) {
	for(int j=0;j<7;j++) {
		System.out.print(grid[i][j]);
	}
	System.out.println();
}
}

public void clear() {
	for(int i=1;i<6;i+=2) {
		for(int j=1;j<6;j+=2) {
			grid[i][j]=' ';
		}
	}
}

public char[][] getGrid() {
	return this.grid;
}
}