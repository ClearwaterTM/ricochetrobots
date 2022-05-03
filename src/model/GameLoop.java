package model;

import java.util.*;
import java.awt.event.*;

import vue.*;


public class GameLoop
{
	public Robot[] robots;
	public Robot selectedRobot;
	public Board gameBoard;
	
	Random rand = new Random();
	
	String[] goals = {"RedGoal1", "RedGoal2", "RedGoal3", "RedGoal4",
					  "GreenGoal1", "GreenGoal2", "GreenGoal3", "GreenGoal4",
					  "BlueGoal1","BlueGoal2", "BlueGoal3", "BlueGoal4",
					  "YellowGoal1", "YellowGoal2", "YellowGoal3", "YellowGoal4"
	};
	
	
	long startTime;
	long endTime;
	float timeElapsed;
	
	
	HashMap<String, Coords> selectedGoal;
	
	
	public void showGrid(Board gameBoard)
	{
		//System.out.println("X X X X X X X X X");
		for (int a=0;a<gameBoard.grid.length;a++)
		{
			//System.out.print("X ");
			for (int b=0;b<gameBoard.grid[a].length;b++)
			{
				System.out.print(gameBoard.grid[a][b].caseType + " ");
			}
			//System.out.print("X ");
			System.out.println(" ");
		}
	//	System.out.println("X X X X X X X X X");
	}
	
	public HashMap<String,Coords> prepareGoals(Board gameBoard)
	{
		ArrayList<String> goals = new ArrayList<String>();
		
		goals.add("RedGoal1");
		goals.add("RedGoal2");
		goals.add("RedGoal3");
		goals.add("RedGoal4");
		goals.add("GreenGoal1");
		goals.add("GreenGoal2");
		goals.add("GreenGoal3");
		goals.add("GreenGoal4");
		goals.add("YellowGoal1");
		goals.add("YellowGoal2");
		goals.add("YellowGoal3");
		goals.add("YellowGoal4");
		goals.add("BlueGoal1");
		goals.add("BlueGoal2");
		goals.add("BlueGoal3");
		goals.add("BlueGoal4");
		
		
		ArrayList<Coords> coordsList = new ArrayList<Coords>();
		
		HashMap<String,Coords> finalCoordsList = new HashMap<String,Coords>();
		Random rand = new Random();
		
		//Loop through the array, and look for e,f,g,h,i,j.
		
		for (int a = 0; a < gameBoard.grid.length; a++)
		{
			for (int b = 0; b < gameBoard.grid[a].length; b++)
			{
				if (gameBoard.grid[a][b].caseType == "e"
					||gameBoard.grid[a][b].caseType == "f"
					|| gameBoard.grid[a][b].caseType == "g"
					||gameBoard.grid[a][b].caseType == "h"
					||gameBoard.grid[a][b].caseType == "i" ||
					gameBoard.grid[a][b].caseType == "j")
				{
					//If one is found, then add it to the list of coords.
					
					coordsList.add(new Coords(a,b));
					
				}
			}
		}
		
		
		//Make sure the coordsList size is at least 16, if not then the level is malformed.
		//NOTE - is this really necessary? Useful for sanity check but still
		
		if (coordsList.size() < 16)
		{
			System.out.println("COORDS LIST SMALLER THAN 16, THIS WILL CAUSE PROBLEMS.");
			System.out.println("ACTUAL SIZE: " + coordsList.size());
			System.exit(1);
		}
		
		//From here, randomly place the goals in the list of coords.
		while(goals.size() > 0)
		{
			int randomGoal = rand.nextInt(goals.size());
			int randomCoords = rand.nextInt(coordsList.size());
			finalCoordsList.put(goals.get(randomGoal), coordsList.get(randomCoords));
			goals.remove(randomGoal);
			coordsList.remove(randomCoords);
		}
		
		//Set<String> keyList = finalCoordsList.keySet();
		
		/*for (String currentKey : keyList)
		{
			System.out.println(currentKey + ": (" + finalCoordsList.get(currentKey).x + "," + finalCoordsList.get(currentKey).y + ")");
		}*/
		
		
		
		return finalCoordsList;
	}
	
	public void initialiseRobots()
	{
				//Initialise the 4 robots, and set their starting positions.
				//For this, get a list of all available blank spaces, and choose randomly from there.
				
				ArrayList<Coords> emptySpaceList = new ArrayList<Coords>();
				for (int a = 0; a < this.gameBoard.grid.length; a++)
				{
					for (int b = 0; b < this.gameBoard.grid[a].length; b++)
					{
						if (this.gameBoard.grid[a][b].caseType == "-")
						{
							emptySpaceList.add(new Coords(a,b));
						}
					}
					
				}
				
				//Create an array of robots.
				//Order of color: Red, Green, Yellow, Blue
				this.robots = new Robot[4];
				String[] robotColors = {"Red","Green","Yellow","Blue"};
				
				//Initalise the robot, and choose a random blank space on the board as their starting position.
				for (int a = 0; a < this.robots.length;a++)
				{
					int seed = rand.nextInt(emptySpaceList.size());
					Coords selectedCoords = emptySpaceList.get(seed);
					this.robots[a] = new Robot(selectedCoords.x,selectedCoords.y,robotColors[a]);
					emptySpaceList.remove(seed);
					
					this.gameBoard.grid[selectedCoords.x][selectedCoords.y].caseType = "$";
				}
				
	}
	
	public boolean isOver(String goalColorText)
	{
		for (int a = 0; a < this.robots.length;a++)
		{
			//Check if a robot is on the goal...
			if ((this.robots[a].coordX == this.selectedGoal.get(goalColorText).x) && (this.robots[a].coordX == this.selectedGoal.get(goalColorText).y))
			{
				//...if it is, check if it's the corresponding color...
				if(this.robots[a].color == goalColorText)
				{
					//Then end the game.
					return true;
				}
			}
		}
		return false;
	}
	
	public void switchSelectedRobot(int robotNum)
	{
		switch(robotNum)
		{
		case 0: {this.selectedRobot = this.robots[0]; break;}
		case 1: {this.selectedRobot = this.robots[1]; break;}
		case 2: {this.selectedRobot = this.robots[2]; break;}
		case 3: {this.selectedRobot = this.robots[3]; break;}
		}
	}
	
	public void moveRobot(int direction)
	{
		int startX = this.selectedRobot.coordX;
		int startY = this.selectedRobot.coordY;
		
		this.selectedRobot.MoveRobot(this.gameBoard.grid, direction);
		
		//
		this.gameBoard.grid[startX][startY].caseType = "-";
		
		if(this.gameBoard.grid[this.selectedRobot.coordX][this.selectedRobot.coordY].caseType == "-")
		{
			this.gameBoard.grid[this.selectedRobot.coordX][this.selectedRobot.coordY].caseType = "-";
		}
		
		this.showGrid(gameBoard);
	}
	
	public void mainLoop()
	{
		Scanner scanner = new Scanner(System.in);
		String goalColorText = (this.selectedGoal.keySet().toString());
		goalColorText = goalColorText.substring(1, goalColorText.length()-1);
		
		System.out.println("Votre objectif: ");
		System.out.println("Déplacer le robot " + goalColorText + " à la case (" + this.selectedGoal.get(goalColorText).x + "," + this.selectedGoal.get(goalColorText).y + ")");
		this.selectedRobot = this.robots[0];
		
		Frame fenetre = new Frame();
		
		for (int a = 0; a < this.robots.length; a++)
		{
			System.out.println("("+this.robots[a].coordX+","+this.robots[a].coordY+")");
		}
		
		fenetre.affichage(this);
		fenetre.window.addKeyListener(new KeyListener()
				{
					public void keyPressed(KeyEvent k)
					{
						switch(k.getKeyCode())
						{
							//Key codes:
							//Up arrow: 38
							//Down arrow: 40
							//Left arrow: 37
							//Right arrow: 39
							//R: 82
							//G: 72
							//Y: 89
							//B: 66
						
							case 38:{System.out.println("Moving up"); moveRobot(0); break;}
							case 40:{System.out.println("Moving down"); moveRobot(1);break;}
							case 37:{System.out.println("Moving left"); moveRobot(2);break;}
							case 39:{System.out.println("Moving right"); moveRobot(3);break;}
						
							case 82: {System.out.println("Red robot selected"); switchSelectedRobot(0); break;}
							case 71: {System.out.println("Green robot selected"); switchSelectedRobot(1);break;}
							case 89: {System.out.println("Yellow robot selected"); switchSelectedRobot(2);break;}
							case 66:{System.out.println("Blue robot selected"); switchSelectedRobot(3);break;}
							
							default:{System.out.println(k.getKeyCode()); break;}
						}
					}
					public void keyReleased(KeyEvent k)
					{
						;
					}
					public void keyTyped(KeyEvent k)
					{
						;
					}
				}
		);
		this.showGrid(this.gameBoard);
		

		
		
		while (this.isOver(goalColorText) != true)
		{
			fenetre.update(this);

			/*this.showGrid(this.gameBoard);
			for(int a = 0; a < this.robots.length; a++)
			{
				System.out.println(this.robots[a].color + " robot: (" + this.robots[a].coordX + "," + this.robots[a].coordY + ")");
			}*/
			
			//System.out.println(this.isOver(goalColorText));
			
					
			
			
			/*System.out.println("Sélectionner un robot: ");
			
			int robotChoice = scanner.nextInt();
			
			System.out.println("Sélectionner une direction");
			System.out.println("0: Haut");
			System.out.println("1: Bas");
			System.out.println("2: Gauche");
			System.out.println("3: Droite");
			
			
			int dirChoice = scanner.nextInt();
			
			   
		    // 0 : haut 
		    // 1 : bas
		    // 2 : gauche
		    // 3 : droite
			
			this.robots[robotChoice].MoveRobot(this.gameBoard.grid, dirChoice);*/
			
		}
		
		System.out.println("Ended");
		
		this.endTime = System.currentTimeMillis();
		this.timeElapsed = (this.endTime - this.startTime);
		this.timeElapsed = this.timeElapsed / 100;
		scanner.close();
		System.out.println(this.timeElapsed);
	}
	
	public void prepareGame(Board gameBoard)
	{
		//Before starting, we need to define the 16 robot goals, the 4 robot starting positions, and the robot color & goal.
		
		//Goal locations are defined in spaces e,f,g,h,i,j on a level. Make an ArrayList of goals, loop through the array and the map,
		//then pick a goal at random to insert, and remove it from the list.
		
		//16 goals: 4 per color, 4 colors.
		
		this.gameBoard = gameBoard;
		
		
		//Initalise the goals.
		HashMap<String,Coords> goalCoords = this.prepareGoals(this.gameBoard);
		
		
		String goalString = this.goals[rand.nextInt(this.goals.length)];
		Coords selectedGoalCoords = goalCoords.get(goalString);
		
		
		if (goalString.contains("Red"))
		{
			goalString = "Red";
		}
		else if (goalString.contains("Green"))
		{
			goalString = "Green";
		}
		else if (goalString.contains("Yellow"))
		{
			goalString = "Yellow";
		}
		else if (goalString.contains("Blue"))
		{
			goalString = "Blue";
		}
		
		
		//Associate the goal color with the robot color.
		this.selectedGoal = new HashMap<String, Coords>();
		this.selectedGoal.put(goalString, selectedGoalCoords);
		
	
		//Initialise the robots.
		this.initialiseRobots();
		System.out.println("Le but " + goalString + " se trouve à: (" + this.selectedGoal.get(goalString).x + "," + this.selectedGoal.get(goalString).y + ")");
		
		
		this.mainLoop();
		

	}
	
	public GameLoop()
	{
		this.startTime = System.currentTimeMillis();
	}
}
