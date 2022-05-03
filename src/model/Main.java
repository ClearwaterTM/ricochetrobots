package model;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Stockage levelStorage = new Stockage();
		
		//Demander à l'utilisateur de choisir un niveau à charger.
		
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Veuillez choisir un niveau");
		
		int selectedLevel = myScanner.nextInt();
		
		if (selectedLevel == 1)
		{
			//Charger le niveau.
			Board gameBoard = new Board(levelStorage.level1);
			gameBoard.showBoard();
		}
		
		myScanner.close();
		

	}

}
