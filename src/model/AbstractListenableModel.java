package model;

import java.util.ArrayList;
import vue.ModelListener;

/**
 * <b>AbstractListenableModel est utilisee pour les objets ecoutables</b>
 *<p>Des que une instance de AbstractListenableModel sera modifiee, la vue sera modifie en appelant fireChange()</p>
 *
 * @author Elodie RATOVOHERINJANAHARY, Pierre ROYER, Daniel MURRAY, Adrien KNELL
 */

public class AbstractListenableModel {
	
	/**
     * 	<b>ArrayList qui stock toutes les instances de vue a modifier lorsque on appelle fireChange() </b>
     */
	ArrayList<ModelListener> abonnes;
	
	/**
     * 	<b>Constructeur de la classe  </b>
     */
	public AbstractListenableModel() {
		this.abonnes = new ArrayList<>();
	}
	
	/**
	 * 	<b>Ajoute un objet de type ModelListener dans l ArrayList abonnes </b>
	 *
	 * @param a
	 * 			Instance de ModelListener.
	 */
	public void addModelListener(ModelListener a) {
		this.abonnes.add(a);
	}
	
	/**
	 * 	<b>Retire un objet de type ModelListener de l ArrayList abonnes </b>
	 *
	 * @param a
	 * 			Instance de ModelListener.
	 */
	public void removeModelListener(ModelListener a) {
		this.abonnes.remove(a);
	}
	
	/**
	 * 	<b>Applique les changements en appelant les methodes modelUpdated de chaque instance de ModelListener present dans l Arraylist abonnes.</b>
	 *
	 */
	protected void fireChange() {
		for(ModelListener ecouteur : this.abonnes) {
			ecouteur.modelUpdated(this);
		}
	}
	
}
