package lanceur;

import java.util.*;

import controller.ActionResults;
import model.*;
import vue.*;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		ActionResults partie = new ActionResults();
		
		System.out.println("Voulez vous voir l exemple en console ? (0)");
		int mode = scanner.nextInt();
		
		if(mode == 0){
			
        	partie.game.Bfield1.currentPlayer.viser(new Coords(0,0), partie.game.Bfield2);
        	partie.game.Bfield1.currentPlayer.viser(new Coords(8,6), partie.game.Bfield2);
        	partie.game.Bfield1.currentPlayer.viser(new Coords(4,9), partie.game.Bfield2);
        	partie.game.Bfield1.currentPlayer.viser(new Coords(2,3), partie.game.Bfield2);
        	
        	partie.game.Bfield2.currentPlayer.viser(new Coords(8,8), partie.game.Bfield1);
        	partie.game.Bfield2.currentPlayer.viser(new Coords(4,2), partie.game.Bfield1);
        	partie.game.Bfield2.currentPlayer.viser(new Coords(6,4), partie.game.Bfield1);
        	partie.game.Bfield2.currentPlayer.viser(new Coords(1,9), partie.game.Bfield1);
        	
        	System.out.println("Plateau du joueur 1 :");
        	String str = "";
    		for(int i=0 ; i<10 ; i++) {
    			System.out.println(str);
    			str = "";
    			for(int j=0 ; j<10 ; j++) {
    				if(partie.game.Bfield1.field[i][j].presenceBoat != null) {
    					str += " x ";
    				}else if(partie.game.Bfield1.field[i][j].touched != null) {
    					str += " ! ";
    				}
    				else {
    					str += " . ";
    				}
    			}
    		}
    		
    		System.out.println(str);
    		
    		System.out.println(" ");
    		System.out.println("Plateau du joueur 2 :");
    		String str2 = "";
    		for(int i=0 ; i<10 ; i++) {
    			System.out.println(str2);
    			str2 = "";
    			for(int j=0 ; j<10 ; j++) {
    				if(partie.game.Bfield2.field[i][j].presenceBoat != null) {
    					str2 += " x ";
    				}else if(partie.game.Bfield2.field[i][j].touched != null) {
    					str2 += " ! ";
    				}
    				else {
    					str2 += " . ";
    				}
    			}
    		}
    		System.out.println(str2);
        	
    		System.out.println("Coordonnees des cases touchees sur le plateau du random : ");
        	for(int i=0 ; i<10 ; i++) {
    			for(int j=0 ; j<10 ; j++) {
    				if(partie.game.Bfield2.field[i][j].touched != null) {
    					System.out.println("(" + j + "," + i +")");
    				}
    			}
        	}
        	
        	System.out.println("Coordonnees des cases touchees sur le plateau du joueur : ");
        	for(int i=0 ; i<10 ; i++) {
    			for(int j=0 ; j<10 ; j++) {
    				if(partie.game.Bfield1.field[i][j].touched != null) {
    					System.out.println("(" + j + "," + i +")");
    				}
    			}
        	}
        	
        	System.out.println("Bateaux touches sur le plateau du random : ");
        	for(Boat i : partie.game.Bfield2.listBoat) {
        		if(i.nbrHits != 0) {
        			System.out.println("la bateau qui se trouve a la position (" +i.position.x + "," + i.position.y + ")" + " de taille " + i.size + " a ete touche ");
        		}
        	}
        	
        	System.out.println("Bateaux touches sur le plateau du joueur : ");
        	for(Boat i : partie.game.Bfield1.listBoat) {
        		if(i.nbrHits != 0) {
        			System.out.println("la bateau qui se trouve a la position (" +i.position.x + "," + i.position.y + ")" + " de taille " + i.size + " a ete touche ");
        		}
        	}

        }
	}

}
