package maze;

public class Maze {
	//instance var
	public char[][] maze;
	
	//constructor
	public Maze(char[][] maze) {
		this.maze = maze;
	}
	
	//get start location and try to solve
	public void solve(int x, int y) {
		if (step(x,y)) 
		{
			maze[x][y] = 'X';
		}
	}
			
	//backtracking
	public boolean step (int x, int y) {
		//If it finds the exit
		if (maze[x][y] == 'E') {
			return true;
		}
				
		//if its out of bounds, or if it hits the path
		if (x < 1|| y < 1 || x > maze.length -1 || y >maze[0].length -1) {
			return false;
		}
		if(maze[x][y] == '#' || maze[x][y] == 'X' ) {
			return false;
		}
				
				
		//mark the path
		maze[x][y] = 'X';
		
		//try right
		if (step(x, y+1)) { return true;}
				
		//try up
		if (step(x-1, y)) { return true;}
				
		//try left
		if (step(x, y-1)) { return true;}		
				
		//try down
		if ((step(x+1, y))) { return true;}		
				
				

		//If current path leads to a dead end, un-mark location		
		maze[x][y] = '.';
				
		return false;
	}
			
	

	
	public void printMaze(char[][] initialMaze) {
		String output = "";
		for (int i=0; i<maze.length; i++) {
			for (int j=0; j<maze[i].length; j++) {
				output += maze[i][j] + " ";
			}
			output += "\n";
		}
		System.out.println(output);
	}

}
