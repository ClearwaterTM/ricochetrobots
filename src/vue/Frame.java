package vue;
import model.*;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class Frame {
	
	public JFrame window;
	public JPanel bluePanel, redPanel, yellowPanel, greenPanel, background;
	public JPanel imageBlue,imageRed,imageYellow,imageGreen,imageBack;
	
	public JPanel redGoal,greenGoal,yellowGoal,blueGoal;
	
	int height = 800;
	int width = 600;
	
	public Frame()
	{
		this.bluePanel = new JPanel();
		this.redPanel = new JPanel();
		this.yellowPanel = new JPanel();
		this.greenPanel = new JPanel();
		this.background = new JPanel();
		
		this.redGoal = new JPanel();
		this.greenGoal = new JPanel();
		this.yellowGoal = new JPanel();
		this.blueGoal = new JPanel();

		this.window = new JFrame();
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setSize(this.height, this.width);
		
		
	}
	
	public void update(GameLoop partie)
	{
		this.redPanel.setBounds((int)(partie.robots[0].getCoordY()*(height*0.05)),(int)(partie.robots[0].getCoordX()*(width*0.05)),50,50);
		this.greenPanel.setBounds((int)(partie.robots[1].getCoordY()*(height*0.05)),(int)(partie.robots[1].getCoordX()*(width*0.05)),50,50);
		this.yellowPanel.setBounds((int)(partie.robots[2].getCoordY()*(height*0.05)),(int)(partie.robots[2].getCoordX()*(width*0.05)),50,50);
		this.bluePanel.setBounds((int)(partie.robots[3].getCoordY()*(height*0.05)),(int)(partie.robots[3].getCoordX()*(width*0.05)),50,50);
	}

	public void affichage(GameLoop partie) {
		/*Création */
		JLayeredPane layer = new JLayeredPane();
		/* creation des panels pour les robots et l'image de fond */

		
		/* Import des images */
		JLabel imageBlue = new JLabel( new ImageIcon( "././image/Robot/robot_bleu.png"));
		JLabel imageRed = new JLabel( new ImageIcon( "././image/Robot/robot_rouge.png"));
		JLabel imageYellow = new JLabel( new ImageIcon( "././image/Robot/robot_jaune.png"));
		JLabel imageGreen = new JLabel( new ImageIcon( "././image/Robot/robot_vert.png"));
		JLabel imageBack = new JLabel( new ImageIcon( "././image/plateau/plateau1.png"));
		
		JLabel imageRedGoal = new JLabel( new ImageIcon( "././image/nourriture/chicken-leg.png"));
		JLabel imageGreenGoal = new JLabel( new ImageIcon( "././image/nourriture/chicken-leg.png"));
		JLabel imageYellowGoal = new JLabel( new ImageIcon( "././image/nourriture/chicken-leg.png"));
		JLabel imageBlueGoal = new JLabel( new ImageIcon( "././image/nourriture/chicken-leg.png"));
		
		/* Position des images */
		this.redPanel.setBounds((int)(partie.robots[0].getCoordY()*(height*0.05)),(int)(partie.robots[0].getCoordX()*(width*0.05)),50,50);
		this.greenPanel.setBounds((int)(partie.robots[1].getCoordY()*(height*0.05)),(int)(partie.robots[1].getCoordX()*(width*0.05)),50,50);
		this.yellowPanel.setBounds((int)(partie.robots[2].getCoordY()*(height*0.05)),(int)(partie.robots[2].getCoordX()*(width*0.05)),50,50);
		this.bluePanel.setBounds((int)(partie.robots[3].getCoordY()*(height*0.05)),(int)(partie.robots[3].getCoordX()*(width*0.05)),50,50);
		this.background.setBounds(0,0,560,560);
		
		/*Ajout des images dans les panels correspondants */
		this.background.add(imageBack);
		this.bluePanel.add(imageBlue);
		this.redPanel.add(imageRed);
		this.yellowPanel.add(imageYellow);
		this.greenPanel.add(imageGreen);
		
		/* Faire que les images n'aient pas de background */
		this.bluePanel.setBackground(new Color(0,0,0,0));
		this.redPanel.setBackground(new Color(0,0,0,0));
		this.yellowPanel.setBackground(new Color(0,0,0,0));
		this.greenPanel.setBackground(new Color(0,0,0,0));
		
		/* Ajout de tous les panels dans le layer */
		layer.add(bluePanel);
		layer.add(redPanel);
		layer.add(yellowPanel);
		layer.add(greenPanel);
		layer.add(background);
		
		this.window.setSize(height+200, width+200);
		this.window.add(layer);
		this.window.setVisible(true);
	}
	
}
