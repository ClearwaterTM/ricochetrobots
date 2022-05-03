package controller;

import java.util.ArrayList;
import java.util.Random;

import model.Battlefield;
import model.Boat;
import model.Case;
import model.Coords;
import model.ModelContent;
import model.Player;
import vue.Background;

public class ActionResults {
	
	public ModelContent game;
	private Background fenetre;
	
	public ActionResults() {
		Boat b2P1 = new Boat(2);
		Boat b3P1 = new Boat(3);
		Boat b3BisP1 = new Boat(3);
		Boat b4P1 = new Boat(4);
		Boat b5P1 = new Boat(5);
		
		Boat b2P2 = new Boat(2);
		Boat b3P2 = new Boat(3);
		Boat b3BisP2 = new Boat(3);
		Boat b4P2 = new Boat(4);
		Boat b5P2 = new Boat(5);
		
		Player joueur = new Player("null");
		Player random = new Player("Le joueur aleatoire");
		
		Battlefield fa = new Battlefield(joueur,b2P1,b3P1,b3BisP1,b4P1,b5P1);
		Battlefield fa1 = new Battlefield(random,b2P2,b3P2,b3BisP2,b4P2,b5P2);
		
		joueur.placeBoat(b2P1, fa);
		joueur.placeBoat(b3P1, fa);
		joueur.placeBoat(b3BisP1, fa);
		joueur.placeBoat(b4P1, fa);
		joueur.placeBoat(b5P1, fa);
		
		random.placeBoat(b2P2, fa1);
		random.placeBoat(b3P2, fa1);
		random.placeBoat(b3BisP2, fa1);
		random.placeBoat(b4P2, fa1);
		random.placeBoat(b5P2, fa1);
		
		this.game = new ModelContent(fa,fa1);
		this.fenetre = new Background(this.game, this);
		
	}
	
	public void Mouseclick(Case c) {
		this.game.Bfield1.currentPlayer.viser(c.position, this.game.Bfield2); 
		while(true) {
			Random random = new Random();
			int x = random.nextInt(10);
			int y = random.nextInt(10);
			if(this.game.Bfield1.field[y][x].touched == null) {
				this.game.Bfield2.currentPlayer.viser(new Coords(x,y), this.game.Bfield1);
				break;
			}
		}
		
	}
	
	public void endGame() {
		this.fenetre.endGamePopUp();
	}
	
	public void shoot() {
		int compteur1 = 0;
		int compteur2 = 0;
		ArrayList<Boat> list = new ArrayList();
		list.add(this.game.Bfield1.listBoat[0]);list.add(this.game.Bfield1.listBoat[1]);list.add(this.game.Bfield1.listBoat[2]);list.add(this.game.Bfield1.listBoat[3]);list.add(this.game.Bfield1.listBoat[4]);
		for(Boat i : list) {
			if(!(i.aLive)) {
				compteur1++;
			}
		}
		ArrayList<Boat> list2 = new ArrayList();
		list2.add(this.game.Bfield2.listBoat[0]);list2.add(this.game.Bfield2.listBoat[1]);list2.add(this.game.Bfield2.listBoat[2]);list2.add(this.game.Bfield2.listBoat[3]);list2.add(this.game.Bfield2.listBoat[4]);
		for(Boat i : list2) {
			if(!(i.aLive)) {
				compteur2++;
			}
		}
		
		if(compteur1==5) {
			this.game.win(this.game.Bfield2);
			this.endGame();
		}
		if(compteur2==5) {
			this.game.win(this.game.Bfield1);
			this.endGame();
		}
	}

}
