package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import controller.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.*;
/**
 * <b>CasePanel est la classe qui permet de representer une case du modele par un JPanel pour le joueur</b>
 * <p> Implemente ModelListener pour pouvoir mettre a jour la case des qu'il y a un changement dans le modele</p>

 * <p>Cette classe redefinit les methodes suivantes  :</p>
 * <ul>
 * 		
 * 		<li>paintComponent()</li>
 * 		<li>modelUpdated()</li>
 *
 * </ul>
 * @author  Daniel MURRAY, Pierre ROYER, Adrien KNELL, Elodie RATOVOHERINJANAHARY.
 */
public class CasePanel extends JPanel implements ModelListener{
	/**
     * 	<b>Case representant une case sur le plateau. </b>
*/
	public Case c;
	/**
     * 	<b>Couleur de chaque cercle que l'on peut viser. </b>
*/
	public Color currentColor = Color.WHITE;
	
	/**
     * 	<b>Constructeur de la classe  </b>
     *
     * <p>Initialise la taille du JPanel en 50x50, et fait que le JPanel soit transparent.</p>
     *
     * @param c
     * 			Une case du modele.
     */
	public CasePanel(Case c) {
		this.c = c;
		this.setSize(50,50);	
		this.setOpaque(false);
	}
	
	/**
	 * 	<b>Dessine un cercle de couleur blanc. </b>
	 * <p>Dessine un cercle de taille 25, et à la position (10,10).</p>
	 *
	 * @param g
	 * 			Instance de Graphics.
	 *
	 
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(this.currentColor);
		g.fillOval(10,10, 25, 25);
		
	}
	/**
	 * 	<b>Methode qui en fonction de l'etat du model va mettre a jour la case. </b>
	 * <p>S'il n'y a pas de bateau sur la case, on change la couleur du cercle en bleue sinon on colore en rouge  .</p>
	 *
	 * @param source
	 * 			Instance d'Object.
	 *
	 
	 */
	@Override
	public void modelUpdated(Object source) {	
		if(c.presenceBoat != null) {
			this.currentColor = new Color(229,35,35);
			repaint();
		}
		else {
			this.currentColor = new Color(0,142,183);
			repaint();
		}
	}
	
}