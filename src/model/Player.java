package model;

/**
 * <b> Player correspond aux joueurs jouant au jeu Battleship.</b>
 * 
 * @author Daniel MURRAY, Elodie RATOVOHERINJANAHARY, Pierre ROYER, Adrien KNELL
 */
public class Player
{
	/**
     * 	<b>String correspondant au nom du joueur.</b>
     */
	public String name;
	
	public Player(String name) {
		this.name = name;
	}
	
	/**
	 * 	<b>Permet au joueur de placer un bateau sur un champ de bataille.</b>
	 *
	 * @param b
	 * 			Le bateau a placer.
	 * @param Bfield
	 * 			Le champ de bataille sur lequel on place le bateau.
	 */
	public void placeBoat(Boat b, Battlefield Bfield){
		Bfield.placeBoat(b);
	}
	
	/**
	 * 	<b>Permet au joueur de tirer sur un champ de bataille.</b>
	 *
	 * @param c
	 * 			La coordonnee de la case a viser.
	 * @param Bfield
	 * 			Le champ de bataille sur lequel on va tirer.
	 */
	public void viser(Coords c, Battlefield Bfield) {
		Bomb a = new Bomb();
		Bfield.viser(c, a);
	}
	}