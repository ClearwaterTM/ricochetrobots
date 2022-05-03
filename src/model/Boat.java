package model;

/**
 * <b>Boat est une classe qui represente les bateaux</b>
 * 
 * @author Elodie RATOVOHERINJANAHARY, Pierre ROYER, Daniel MURRAY, Adrien KNELL
 */
public class Boat extends AbstractListenableModel{

	/**
     * 	<b>Taille du bateau, correspond au nombre de cases que prend le bateau</b>
     */
    public int size;
    
    /**
     * 	<b>Position du bateau sur la champ de bataille</b>
     */
    public Coords position = null;
    
    /**
     * 	<b>Direction de la point du bateau, horizontal ou vertical</b>
     */
    public Boolean direction;
    
    /**
     * 	<b>Nombre de fois que le bateau a ete touche par un tir (sur des cases differentes)</b>
     */
    public int nbrHits = 0;
    
    /**
     * 	<b>Boolean permettant de verifier si le bateau est en vie ou non</b>
     */
    public Boolean aLive = true;

    /**
     * 	<b>Constructeur de la classe  </b>
     *
     * <p>Initalise la taille du bateau</p>
     *
     * @param sizeBoat
     * 			Taille du bateau.
     */
    public Boat(int sizeBoat) {
        this.size = sizeBoat;
    }
    
    /**
     * 	<b>Verifie si le bateau est toujours en vie ou non</b>
     * <p>Si son nombre de coups recu est egal a sa taille, alors le bateau est mort.</p>
     *
     */
    public void checkLife() {
    	if(this.nbrHits==this.size) {
    		this.aLive = false;
    	}
    	fireChange();
    }

}