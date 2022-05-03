package model;

import java.util.*;

import vue.CasePanel;

/**
 * <b> Battlefield est la classe pour representer les champs de batailles.</b>
 * 
 * @author Daniel MURRAY, Elodie RATOVOHERINJANAHARY, Pierre ROYER, Adrien KNELL
 */
public class Battlefield
{
	/**
     * 	<b>Tableau a deux dimensions de Case qui permet de representer le champ de bataille.</b>
     */
	public Case[][] field;
	
	/**
     * 	<b>Tableau de Boat qui stock les differents bateaux presents sur la champ de bataille.</b>
     */
	public Boat[] listBoat;
	
	/**
     * 	<b>Instance de Player qui correspond au joueur a qui appartient le plateau</b>
     */
	public Player currentPlayer;
	
	/**
     * 	<b>Constante correspondant a la taille du plateau.</b>
     */
	public final static int BOARDSIZE = 10;
	
	/**
	 * <b> Constructeur de la classe Battlefield. </b>
	 * 
	 * <p> Cree un plateau de taille 10x10, et cree les variables necessaires pour stocker chaque bateau, le joueur. <p>
	 * 
	 * @param currentPlayer
	 * 		l utilisateur.
	 * 
	 * @param b2
	 * 		Bateau de taille 2.
	 * 
	 * @param b3, b3Bis
	 * 		Bateaux de taille 3.
	 * 
	 * @param b4
	 * 		Bateau de taille 4.
	 * 
	 * @param b5
	 * 		Bateau de taille 5.
	 *
	 */
	public Battlefield(Player currentPlayer, Boat b2, Boat b3, Boat b3Bis, Boat b4, Boat b5)
	{
		this.field = new Case[BOARDSIZE][BOARDSIZE];
		
		for(int i=0 ; i<BOARDSIZE ; i++) {
			for(int j=0 ; j<BOARDSIZE ; j++) {
				this.field[j][i] = new Case(new Coords(i,j));
			}
		}
		
		this.listBoat = new Boat[5];
		this.listBoat[0] = b2;
		this.listBoat[1] = b3;
		this.listBoat[2] = b3Bis;
		this.listBoat[3] = b4;
		this.listBoat[4] = b5;
		
		this.currentPlayer = currentPlayer;
		
	}
	
	/**
	 * 	<b>Permet de tirer sur une case du champ de bataille</b>
	 * @param c
	 * 			la coordonnee de la case a viser.
	 * @param b
	 * 			la bombe pour attaquer la case en question.
	 * 
	 */
	public void viser(Coords c,Bomb b) {
		this.field[c.y][c.x].viser(b);
	}
	
	/**
	 * 	<b>Permet de placer un bateau sur le champ de bataille</b>
	 * @param boatToPlace
	 * 			Le bateau a placer.
	 * 
	 */
	public void placeBoat(Boat boatToPlace) {
		Random random = new Random();
		int direction = random.nextInt(2);
		Boolean var = true;
		
		if(direction==0) {
			while(var) {
				int x = random.nextInt(10);
				int y = random.nextInt(10);
				int test = 0;
				
				if(x+boatToPlace.size - 1 < BOARDSIZE) {
					for(int i = x; i < x+boatToPlace.size  ; i++) {
						if(this.field[y][i].presenceBoat != null) {
							test = 1;
							continue;
						}
					}
					if(test == 1) {
						continue;
					}
					
					boatToPlace.direction = false;
					boatToPlace.position = new Coords(x,y);
					for(int i = x; i < x+boatToPlace.size  ; i++) {
						this.field[y][i].placerbateau(boatToPlace);
					}
					var = false;
				}
				else {
					continue;
				}
			}	
		}
		
		else {
			while(var) {
				int x = random.nextInt(10);
				int y = random.nextInt(10);
				int test = 0;
				
				if(y+boatToPlace.size - 1 < BOARDSIZE) {
					for(int i = y; i < y+boatToPlace.size  ; i++) {
						if(this.field[i][x].presenceBoat != null) {
							test = 1;
							continue;
						}
					}
					if(test == 1) {
						continue;
					}
					
					boatToPlace.direction = true;
					boatToPlace.position = new Coords(x,y);
					for(int i = y; i < y+boatToPlace.size  ; i++) {
						this.field[i][x].placerbateau(boatToPlace);
					}
					var = false;
				}
				else {
					continue;
				}
			}
		}
		
		
	}
	
}
