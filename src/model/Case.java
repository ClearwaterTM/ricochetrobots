package model;
import java.util.*; //We'll need this for HashMaps

public class Case {

	public HashMap<String,Boolean> wallLocations = new HashMap<String,Boolean>();
	public String caseType = "-";
	
	public String calculateWalls()
	{
		//An idea of wall representation: Use different numbers for different combinations. NESW
		//a - North
		//b - East
		//c - South
		//d - West
		//e - North+West
		//f - North+East
		//g - North+South
		//h - South+East
		//i - South+West
		//j - East+West
		
		boolean north = this.wallLocations.get("NorthWall");
		boolean south = this.wallLocations.get("SouthWall");
		boolean east = this.wallLocations.get("EastWall");
		boolean west = this.wallLocations.get("WestWall");
		
		//Multiple walls have higher priority due to how comparaison works.
		//NOTE - Multiple walls are only used around 
		
		//For the center
		if (north && south && east && west) {return "O";}
		
		if (north && west) {return "e";}
		if (north && east) {return "f";}
		if (north && south) {return "g";}
		if (south && east) {return "h";}
		if (south && west) {return "i";}
		if (east && west) {return "j";}
		
		if (north){return "a";}
		if (east){return "b";}
		if (south){return "c";}
		if (west){return "d";}
		

		
		//If the square doesn't have any walls
		else
			{return "-";}
	}
	
	//NSWE
	public Case(boolean nWall, boolean sWall, boolean wWall, boolean eWall)
	{
		wallLocations.put("NorthWall", nWall);
		wallLocations.put("SouthWall", sWall);
		wallLocations.put("WestWall", wWall);
		wallLocations.put("EastWall", eWall);
		this.caseType = this.calculateWalls();
	}
	public Case()
	{
		this(false,false,false,false);
	}
}

