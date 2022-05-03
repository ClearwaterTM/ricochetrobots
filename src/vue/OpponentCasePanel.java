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
 * <b>OpponentCasePanel est la classe qui permet de representer une case du modele par un JPanel pour l'adversaire</b>
 * <p> Implemente ModelListener pour pouvoir mettre a jour la case des qu'il y a un changement dans le modele</p>

 * <p>Cette classe redefinit les methodes suivantes  :</p>
 * <ul>
 * 		
 * 		<li>mousePressed()</li>
 * </ul>
 * @author  Daniel MURRAY, Pierre ROYER, Adrien KNELL, Elodie RATOVOHERINJANAHARY.
 */
public class OpponentCasePanel extends CasePanel implements MouseListener{
	
	/**
     * 	<b>Couleur de chaque cercle que l'on peut viser. </b>
     */
	public Color currentColor = Color.WHITE;

	/**
     * 	<b>Instance de ActionResults qui est le controller, qui permet de lier le Model et la Vue. </b>
     */
	public ActionResults controller;
	/**
     * 	<b>Constructeur de la classe  </b>
     *
     * <p>Initialise la taille du JPanel en 50x50, et fait que le JPanel soit transparent.</p>
     *<p>Lie le JPanel et les clics de souris</p>
     * @param c
     * 			Une case du modele.
     * @param controller
     * 			Instance de ActionResults.
     */
	public OpponentCasePanel(Case c, ActionResults controller) {
		super(c);
		this.setSize(50,50);	
		this.setOpaque(false);
		addMouseListener(this);
		this.controller = controller;
	}
	
	/**
	 * 	<b>Capte les clics fait par l'utilisateur sur le JPanel. </b>
	 *
	 * @param e
	 * 			Instance de MouseEvent.
	 *
	 */
	@Override
    public void mousePressed(MouseEvent e) {
		controller.Mouseclick(this.c);
		controller.shoot();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	
}