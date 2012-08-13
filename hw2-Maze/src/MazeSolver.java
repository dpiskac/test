
public class MazeSolver {
	Maze maze;
	int moves = 0;
	public MazeSolver(Maze m)
	{
		maze = m;
		
	}
	
	
	public void solveMaze()
	{
		/*
		//System.out.println("Solving the maze!");
		boolean success = solve(maze.getStart());
		if ( success )
		{
			System.out.println("Solved!");
			System.out.println(maze);
			System.out.println("Path took "+ moves+ " steps!");
		}
		else
		{
			System.out.println("Maze is not solvable!");
		}
		*/
		paintMaze();
		//System.out.println(maze);
		
	}
	
	public void paintMaze()
	{
		paint(maze.getStart(), 0);
		
		Position p = maze.getEnd();
		int moves = (int)maze.getValueAt(p)+1;
		for ( int i = moves; i>0; i--)
		{
			
			//maze.setPath(p);
			
			Position u = new Position(p.x, p.y-1);
			Position d = new Position(p.x, p.y+1);
			Position l = new Position(p.x-1, p.y);
			Position r = new Position(p.x+1, p.y);
			
			if ( maze.isValidPos2(u) && (int)maze.getValueAt(u) == (int)(maze.getValueAt(p) -1) )
			{
				maze.setPath(p);
				p = u;
				//System.out.println("fuck");
			}
			else if ( maze.isValidPos2(d) && (int)maze.getValueAt(d) == (int)(maze.getValueAt(p) -1) )
			{	
				maze.setPath(p);
				p = d;
				//System.out.println("fuck");
			}
			else if ( maze.isValidPos2(l) && (int)maze.getValueAt(l) == (int)(maze.getValueAt(p) -1) )
			{	
				maze.setPath(p);
				p = l;
				//System.out.println("fuck");
			}
			else if ( maze.isValidPos2(r) && (int)maze.getValueAt(r) == (int)(maze.getValueAt(p) -1) )
			{
				maze.setPath(p);
				p = r;
				//System.out.println("fuck");
			}
		}
		
		maze.setPath(maze.getStart());
		
		maze.cleanMaze();
		
		
		
	
		System.out.println(maze);
		if ( p != maze.getEnd())
			System.out.println("Took "+moves+" moves");
		else
			System.out.println("Not solvable");
	}
	
	public void paint(Position p, int moves)
	{
		
		boolean valid = false;
		//System.out.println("painting "+p);
		if ( maze.getValueAt(p) == '.')
		{
			valid = true;
			maze.setValue(p, moves);
		}
		else if ((int)maze.getValueAt(p) > moves)
		{	
			valid = true;
			maze.setValue(p, moves);
		}
		if ( valid )
		{
		Position u, d, l, r;
		
		u = new Position(p.x, p.y-1);
		d = new Position(p.x, p.y+1);
		l = new Position(p.x-1, p.y);
		r = new Position(p.x+1, p.y);
		
		if ( maze.isValidPos2(u) )
			paint (u, moves+1);
		if ( maze.isValidPos2(d) )
			paint (d, moves+1);
		if ( maze.isValidPos2(l) )
			paint (l, moves+1);
		if ( maze.isValidPos2(r) )
			paint (r, moves+1);
		}
	}
	
	public boolean solve(Position p)
	{
		//System.out.println(p);
		maze.setVisited(p);
		
		if (maze.isEnd(p))
		{
			
			maze.setPath(p);
			moves++;
			return true;
		}
		
		else
		{
			Position u, d, l, r;
			
			u = new Position(p.x, p.y-1);
			d = new Position(p.x, p.y+1);
			l = new Position(p.x-1, p.y);
			r = new Position(p.x+1, p.y);
			
			if ( maze.isValidPos(u)  )
			{
				//System.out.println(maze);
				if (solve(u))
				{
					moves++;
					maze.setPath(p);
					return true;
				}
				//else
					//maze.setBack(u);
			}
			
			if ( maze.isValidPos(d) )
			{
				//System.out.println(maze);
				if (solve(d))
				{
					moves++;
					maze.setPath(p);
					return true;
				}
				//else
					//maze.setBack(d);
			
			}
			if (maze.isValidPos(r) )
			{
				//System.out.println(maze);
				if (solve(r))
				{
					moves++;
					maze.setPath(p);
					return true;
				}
				//else
					//maze.setBack(r);

			}
			if (maze.isValidPos(l) )
			{
				//System.out.println(maze);
				if (solve(l))
				{
					moves++;
					maze.setPath(p);
					return true;
				}
				//else
					//maze.setBack(l);
			
			}
			
			

			

		}
		
		maze.setBack(p);
		return false;
	}
	
	
}
