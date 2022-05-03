package lanceur;

import java.util.Scanner;

import model.*;

public class mainGame {
	
	
	public static void main(String[] args)
	{
		
		Stockage levelStorage = new Stockage();
		Scanner scanner = new Scanner(System.in);
		Board gameBoard;
		
		System.out.println("Veuillez choisir un niveau:");
		int levelSelect = 0;
		while (levelSelect < 99999999)
		{
			//try {
				levelSelect = scanner.nextInt();	
				if (levelSelect > levelStorage.levelStorage.size())
				{
					System.out.println("Over size");
				}
				else
				{
					gameBoard = new Board(levelStorage.levelStorage.get(levelSelect-1));
					GameLoop game = new GameLoop();
					game.prepareGame(gameBoard);
				}
			}
			/*catch(Exception e)
			{
				System.out.println("An error has occured");
				scanner.nextLine();
			}
			finally
			{
				;
			}
			*/
		}
		
	

}

//TODO:
// - Exterior border representation - Done
// - Wall representation - Done via tile-based hashmaps. Graphical representation will need to be done
// - Robot goal representation - Done via lists, and choosing a random color and goal. Same as above

// - Robot representation


// - Main game loop
