package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.ActionResults;
import model.*;
/**
 * <b>Background est une JFrame qui affiche les deux champs de batailles</b>
 * 
 * 
 * @author  Daniel MURRAY, Pierre ROYER, Adrien KNELL, Elodie RATOVOHERINJANAHARY.
 */
public class Background extends JFrame{
	/**
     * 	<b>Une instance de modelContent contenant les informations sur les champs de batailles. </b>
*/
	public ModelContent model;
	
	/**
     * 	<b>Constructeur de la classe  </b>
     *
     * <p>Creation de deux champs de batailles {@link vue.MyField} et {@link vue.OpponentField} mis en place cote a cote grace a un GridLayout separe par un setHgap.</p>
     *<p> Ajout d'un modelListener pour chaque bateau enemi afin de mettre a jour le JFrame des qu'un bateau est detruit. 
     * @param model
     * 			Instance de ModelContent.
     * @param controller
     * 		Instance de ActionResults.
     */
		public Background(ModelContent model, ActionResults controller) {
			this.model = model;
			GridLayout layout = new GridLayout(0,2);
			String result = JOptionPane.showInputDialog(this, "Entrez votre nom:");
            this.model.Bfield1.currentPlayer.name = result;
			this.add(new MyField(model.Bfield1));
			OpponentField enemy = new OpponentField(model.Bfield2, controller);
			this.model.Bfield2.listBoat[0].addModelListener(enemy);
			this.model.Bfield2.listBoat[1].addModelListener(enemy);
			this.model.Bfield2.listBoat[2].addModelListener(enemy);
			this.model.Bfield2.listBoat[3].addModelListener(enemy);
			this.model.Bfield2.listBoat[4].addModelListener(enemy);
			this.setLayout(layout);
			this.add(enemy);
			layout.setHgap(100);
			
			this.setSize(1100,500);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setVisible(true);
		    this.setResizable(false);

		}
		
		/**
		 * <b> Affichage message popUp </b>
		 * <p>Affiche un popUp lorsque la partie est finie.</p>
		 */
		 public void endGamePopUp()
		    {
			 	String message = this.model.winner.name + " a gagne la partie";
		        JOptionPane.showMessageDialog(null, message,"FELICITATIONS",JOptionPane.INFORMATION_MESSAGE);
		        System.exit(0);
		    }
}
