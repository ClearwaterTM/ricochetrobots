package model;

/**
 * <b> ModelContent.java est la classe qui stocke toute les donnees et variables liees à la gestion du jeu. Elle herite de AbstractListenableModel. </b>
 * 
 * @author Daniel MURRAY, Elodie RATOVOHERINJANAHARY, Pierre ROYER, Adrien KNELL
 *
 */

public class ModelContent{

	/**
     * 	<b>Champ de bataille de l utilisateur</b>
     */
	public Battlefield Bfield1;
	
	/**
     * 	<b>Champ de bataille du random</b>
     */
	public Battlefield Bfield2;
	
	/**
     * 	<b>Boolean qui permet de savoir si la partie est finie ou non.</b>
     */
	public Boolean Over=false;
	
	/**
     * 	<b>Instance de player qui correspond au vainqueur de la partie.</b>
     */
	public Player winner = null;
	/**
	 * <b> Constructeur de la classe. </b>
	 * 
	 * <p> Stocke tous les informations et variables liees au jeu. </p>
	 * 
	 * @param Bfield1
	 * 		Le plateau du jeu de l utilisateur. (Objet de classe Battlefield)
	 * 
	 * @param Bfield2
	 *  	Le plateau du jeu du random. (Objet de classe Battlefield)
	 * 
	 * @author Daniel MURRAY, Elodie RATOVOHERINJANAHARY, Pierre ROYER, Adrien KNELL
	 *
	 */
	public ModelContent(Battlefield Bfield1, Battlefield Bfield2) {
		this.Bfield1 = Bfield1;
		this.Bfield2 = Bfield2;
	}
	
	
	/**
	 * <b> Methode que l on appelle si la partie est finie et que l on connait le vainqueur. </b>
	 * 
	 * @param Bfield
	 * 		Le plateau de jeu de la partie. Objet de classe Battlefield.
	 * @author Daniel MURRAY, Elodie RATOVOHERINJANAHARY, Pierre ROYER, Adrien KNELL
	 */
	public void win(Battlefield Bfield) {
		this.Over = true;
		this.winner = Bfield.currentPlayer;
	}
	
}
