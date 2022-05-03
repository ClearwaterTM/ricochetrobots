package model;

/**
 * <b>Coords permet de visualiser un x et un y sous forme de coordonnee.</b>
 * 
 * @author Elodie RATOVOHERINJANAHARY, Pierre ROYER, Daniel MURRAY, Adrien KNELL
 */
public class Coords {

	/**
     * 	<b>valeur de l abscisse x </b>
     */
	public int x;
	
	/**
     * 	<b>valeur de l ordonnee y </b>
     */
	public int y;
	
	/**
     * 	<b>Constructeur de la classe  </b>
     *
     * @param x
     * 			abscisse de la coordonnee.
     * @param y
     * 			ordonnee de la coordonnee.
     */
	public Coords(int x, int y){
		this.x = x;
		this.y = y;
	}
}
