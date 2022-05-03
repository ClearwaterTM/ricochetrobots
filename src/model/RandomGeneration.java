package model;

// DEPRECATED - OLD RANDOM GENERATION CODE, NOT REQUIRED.
//Could give bonus points if we manage to implement it later though!

/*
public class RandomGeneration {
	
	
	//Initialise the grid.
	
	for (int a=0;a<this.grid.length;a++)
	{
		//int wallLimit = 0;
		for (int b=0;b<this.grid[a].length;b++)
		{
			//Check a bunch of different conditions to construct each case.
			//Along the top/bottom/left/right rows, there are either 1 or 2 seperating walls along the middles of them.
			//Top row
			if (a == 0 || a == (this.grid[a].length)-1)
			{
				int wallLimit = 0;
				//Check if we're in the middle of the row.
				if (b > 1 && b < 8)
				{
					if (numGen.nextInt(10) > 5)
					{
						//Each first/last row/column can have 2 walls MAX in them.
						//Check against a variable to make sure we haven't gone over this limit.
						if (wallLimit < 2)
						{
						this.grid[a][b] = new Case(false,true,false,false);
						wallLimit++;
						}
						else
						{
							this.grid[a][b] = new Case();
						}
					}
					else
					{
						this.grid[a][b] = new Case();
					}
				}
				else
				{
					this.grid[a][b] = new Case();
				}
			}
			
			
			//Default, used for empty cases.
			else
			{
				this.grid[a][b] = new Case();
			}
		}
	}
	
}
}
*/
