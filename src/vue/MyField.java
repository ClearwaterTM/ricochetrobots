package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import model.Battlefield;
import model.Boat;

/**
 * <b>Myfield est un JPanel qui permet de representer le champ de bataille de l utilisateur de facon graphique.</b>
 * 
 * <p>il redefinit la methode suivante :</p>
 * <ul>
 * 		<li>paintComponent()</li>
 * </ul>
 * @author Elodie RATOVOHERINJANAHARY, Pierre ROYER, Daniel MURRAY, Adrien KNELL
 */
public class MyField extends JPanel{
	
	/**
     * 	<b>Une instance de Battlefield correspondant au champ de bataille de l utilisateur</b>
     */
	public Battlefield Bfield1;
	
	/**
     * 	<b>Constructeur de la classe  </b>
     *
     * <p>Affiche le champ de bataille graphiquement avec un GridLayout</p>
     *
     * @param Bfield1
     * 			Le champ de bataille de l utilisateur.
     */
	public MyField(Battlefield Bfield1) {
		this.Bfield1 = Bfield1;  
		GridLayout test = new GridLayout(10,10,0,0);
		test.setVgap(0);
		test.setHgap(0);
		this.setLayout(test);
		for(int i=0 ; i<10 ; i++) {
			for(int j=0 ; j<10 ; j++) {
				CasePanel tmp = new CasePanel(this.Bfield1.field[i][j]);
				tmp.setSize(new Dimension(50, 50));
				this.Bfield1.field[i][j].addModelListener(tmp);
				this.add(tmp);
			}
		}
		
		this.setSize(500,500);;
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
		list.add(this.Bfield1.listBoat[0]);list.add(this.Bfield1.listBoat[1]);list.add(this.Bfield1.listBoat[2]);list.add(this.Bfield1.listBoat[3]);list.add(this.Bfield1.listBoat[4]);
		for(Boat i : list) {
			if(i.direction==false) {
				g.drawRoundRect(i.position.x*48,i.position.y*46, i.size*49, 45, 20 , 20);
			}else {
				g.drawRoundRect(i.position.x*49, i.position.y*47,45 , i.size*45, 20 , 20);
			}
		}
		
		
	}
		
	
	
}
