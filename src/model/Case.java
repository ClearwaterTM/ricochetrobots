package model;

/**
 * <b>Case est la classe utlisee pour representer les cases du champ de bataille</b>

 * @author Elodie RATOVOHERINJANAHARY, Pierre ROYER, Daniel MURRAY , Adrien KNELL
 */

public class Case extends AbstractListenableModel{
	
	/**
     * 	<b> instance de Bomb qui indique si la case a ete touchee ou non par un tir. </b>
     */
	public Bomb touched = null;
	
	/**
     * 	<b> Une instance de Coords qui indique la position de la case </b>
     */
	public Coords position;
	
	/**
     * 	<b> instance de Boat pour savoir quel bateau est sur la case </b>
     */
	public Boat presenceBoat = null;
	
	/**
     * 	<b>Constructeur de la classe  </b>
     *
     * <p>Initialise la position de la case.</p>
     *
     * @param position
     * 			La position de la case dans le champ de bataille.
     */
	public Case(Coords position) {
		this.position = position;
	}
	
	
	/**
	 * 	<b>Assigne a la variable presenceBoat l'instance de Boat mis en argument</b>
	 * @param b
	 * 			Le bateau a assigner.
	 */
	public void placerbateau(Boat b){
		this.presenceBoat = b;
	}
	
	/**
	 * 	<b>Assure le fait que la case ai ete touchee et modifie les variables en consequence.</b>
	 * <p>Des qu'une case est touchee par un tir, on appelle cette methode.</p>
	 *
	 */
	public void viser(Bomb a) {
		if(this.touched == null) {
			this.touched = a;
			if(this.presenceBoat != null) {
				this.presenceBoat.nbrHits += 1;
				this.presenceBoat.checkLife();
			}
			fireChange();
		}
	}
	
	
	
}
