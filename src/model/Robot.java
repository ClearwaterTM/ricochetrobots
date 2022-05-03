package model;

public class Robot { 

    public int coordX; 
    public int coordY; 
    public String color; 

    public Robot(int coordX, int coordY, String color){ 
        this.coordX = coordX; 
        this.coordY = coordY; 
        this.color = color;
    }
    
    
    // 0 : haut 
    // 1 : bas
    // 2 : gauche
    // 3 : droite
    public void MoveRobot(Case[][] grid, int sens) {
        Case c = grid[this.coordX][this.coordY];
        String direction = "";
        int[] dir = {0,0};
        switch(sens) {
        
        // Problem with movement directions here.
        //Moving north works fine, but other movement positions are all jumbled up?
        
        //North
        case 0:
            direction = "NorthWall";
            dir[0] = -1;
            break;
         case 1:
              direction = "SouthWall";
              dir[0] = 1;
              break;
          case 2:
              direction = "WestWall";
              dir[1] = -1;
              break;
          case 3:
              direction = "EastWall";
              dir[1] = 1;
              break;
          default:
              break;
        }
          
          
          while(!(c.wallLocations.get(direction)) && (0 <= (this.coordX + dir[0]) && (this.coordX + dir[0]) <= 15) && (0 <= (this.coordY + dir[1])) && ((this.coordY + dir[1]) <= 15)) {
              c = grid[this.coordX + dir[0]][this.coordY + dir[1]];
              this.coordX += dir[0];
              this.coordY += dir[1];
      }
        }
          /*while ((!(c.wallLocations.get(direction))) || (this.coordX > 0))
          {
        	//North+South movement is stopped at the following cases: a,c,e,f,g,h,i
        	//East+West movement is stopped at the following cases: b,d,e,f,h,i,j
        	  
        	  
        	System.out.println("Moving north");
          	this.coordX += dir[0];
          	this.coordY += dir[1];
          	System.out.println("(" + this.coordX + "," + this.coordY + ")");
          	if(this.coordX == 0)
          	{
          		break;
          	}
          }
          break;
        case 1:
        	direction = "SouthWall";
        	dir[0] = 1;
          break;
        case 2:
        	direction = "WestWall";
        	dir[1] = -1;
            break;
        case 3:
        	direction = "EastWall";
        	dir[1] = 1;
            break;
        default:
        	direction = "NorthWall";
        	dir[0] = -1;
      }
        //Main move function
        
        
        
        
     /*   while((!(c.wallLocations.get(direction)) || (this.coordX){
        	c = grid[this.coordX + dir[0]][this.coordY + dir[1]];
        	this.coordX += dir[0];
        	this.coordY += dir[1];
        	*/

    /* Accesseurs */
    public int getCoordX() {
        return this.coordX;
    }
    public int getCoordY() {
        return this.coordY;
    }
    public String getColor() {
        return this.color;
    }
}
