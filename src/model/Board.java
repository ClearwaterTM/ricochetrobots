package model;


//IMPORTANT
//Change of plan - instead of randomly generating a level, to save time, we'll just randomly choose from a small list of pre-made levels.

public class Board {

	public Case[][] grid;
	public Robot currentRobot;
	public Robot robotBlue;
	public Robot robotRed;
	public Robot robotGreen;
	public Robot robotYellow;
	
	public void showBoard()
	{
		for (int a = 0; a < 16; a++)
		{
			for (int b = 0; b < 16; b++)
			{
				
				System.out.print(this.grid[a][b].caseType + " ");
			}
			System.out.println(" ");
		}
	}
	
	public Board()
	{
		this.grid = new Case[16][16]; 
	}
	
	public Board(String[][] levelToLoad)
	{
		//Init the grid.
		this.grid = new Case[16][16];
		//For every square in the grid, copy the cases from the storage to the grid.
		for (int a = 0; a < 16; a++)
		{
			for (int b = 0; b < 16; b++)
			{
				//a - North
				//b - East
				//c - South
				//d - West
				//e - North+West
				//f - North+East
				//g - North+South
				//h - South+East
				//i - South+West
				//j - East+West
				
				
				//Import the wall locations for each square, based on its square type.
				//See Case.java for the full list.
				
				//NSWE
				
				switch(levelToLoad[a][b])
				{
					//NSWE
					case "a": {this.grid[a][b] = new Case(true, false, false, false); break;}
					case "b": {this.grid[a][b] = new Case(false, false, false, true); break;}
					case "c": {this.grid[a][b] = new Case(false,true,false,false);break;}
					case "d": {this.grid[a][b] = new Case(false,false,true,false);break;}
					case "e": {this.grid[a][b] = new Case(true,false,true,false);break;}
					case "f": {this.grid[a][b] = new Case(true,false,false,true);break;}
					case "g": {this.grid[a][b] = new Case(true,true,false,false);break;}
					case "h": {this.grid[a][b] = new Case(false,true,false,true);break;}
					case "i":{this.grid[a][b] = new Case(false,true,true,false);break;}
					case "j":{this.grid[a][b] = new Case(false,false,true,true);break;}
					case "O": {this.grid[a][b] = new Case(true,true,true,true);break;}
					default: {this.grid[a][b] = new Case();break;}
				}
				
			}
		}
		
	}
	
	
}


