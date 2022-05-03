package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.ActionResults;
import model.Battlefield;
import model.Boat;

/**
 * <b>OpponentField est un JPanel qui permet de representer le champ de bataille du random de facon graphique.</b>
 * 
 * <p>il redefinit la methode suivante :</p>
 * <ul>
 * 		<li>paintComponent()</li>
 * 		<li>modelUpdated()</li>
 * </ul>
 * @author Elodie RATOVOHERINJANAHARY, Pierre ROYER, Daniel MURRAY, Adrien KNELL
 */
public class OpponentField extends JPanel implements ModelListener{
	
	/**
     * 	<b>Une instance de Battlefield correspondant au champ de bataille du random</b>
     */
	public Battlefield Bfield2;
	
	/**
     * 	<b>Constructeur de la classe  </b>
     *
     * <p>Affiche le champ de bataille graphiquement avec un GridLayout</p>
     *
     * @param Bfield2
     * 			Le champ de bataille du random.
     * @param controller
     * 			Instance de ActionResults.
     */
	public OpponentField(Battlefield Bfield2, ActionResults controller) {
		this.Bfield2 = Bfield2;  
		GridLayout test = new GridLayout(10,10,0,0);
		test.setVgap(0);
		test.setHgap(0);
		this.setLayout(test);
		for(int i=0 ; i<10 ; i++) {
			for(int j=0 ; j<10 ; j++) {
				OpponentCasePanel tmp = new OpponentCasePanel(this.Bfield2.field[i][j], controller);
				tmp.setSize(new Dimension(50, 50));
				this.Bfield2.field[i][j].addModelListener(tmp);
				this.add(tmp);
			}
		}
		
		this.setSize(500,500);
	    this.setVisible(true);
	   
}
	
	/**
	 * 	<b>Redefinition de la methode paintComponent afin d afficher ce que l on souhaite sur ce JPanel</b>
	 * <p>Elle nous permet de dessinner les bateaux sur le champ de bataille.</p>
	 *
	 * @param g
	 * 			graphics g.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(29,193,63));
		ArrayList<Boat> list = new ArrayList();
		list.add(this.Bfield2.listBoat[0]);list.add(this.Bfield2.listBoat[1]);list.add(this.Bfield2.listBoat[2]);list.add(this.Bfield2.listBoat[3]);list.add(this.Bfield2.listBoat[4]);
		for(Boat i : list) {
			if(!(i.aLive)) {
				if(i.direction==false) {
					g.drawRoundRect(i.position.x*48, i.position.y*46, i.size*49, 45, 20 , 20);
				}else {
					g.drawRoundRect(i.position.x*49, i.position.y*47,45 , i.size*45, 20 , 20);
				}
			}
		}
		
		
	}
	
	/**
	 * 	<b>Redefinition de la methode modelUpdated qui met a jour le cote graphique du champ de bataille.</b>
	 * <p>On appelle cette methode lorsque un bateau est touche.</p>
	 *
	 * @param source
	 * 			Object.
	 */
	@Override
	public void modelUpdated(Object source) {	
		repaint();
	}
	
	
}
