import java.util.Random;

public class Maze {
	private int width;
	private int height;
	
	private Position start;
	private Position end;
	
	private char maze[][];
	
	private int maxSize = 100;
	
	char border = (char) 999;
	char path = 'x';

	

	public Maze(char m[][], int w, int h)
	{
		width = w;
		height = h;
		
		maze = new char[height][width];
		
		for ( int i = 0; i < height; i ++ )
		{
			for ( int j = 0; j < width; j++)
			{
				if ( m[i][j] == '#')
					maze[i][j] = (char)999;
				else
					maze[i][j] = m[i][j];
			}
		}
		for ( int i = 0; i < height; i++)
		{
			if ( maze[i][0] == '.')
				start = new Position(0, i);
			if ( maze[i][width-1] == '.')
				end = new Position(width-1, i);
		}
		//start = s;
		//end = e;			
	}
	
	public Maze()
	{
		Random rand = new Random();
		System.out.println("Generating random maze...");
		
		//create random dimensions
		height = rand.nextInt(maxSize)+6;
		width = rand.nextInt(maxSize)+6;
		
		//init the array
		maze = new char[height][width];
		for ( int i = 0; i < height; i ++ )
			for ( int j = 0; j < width; j++)			
				maze[i][j] = border;
		
		
		//create start
		int s = rand.nextInt(height-2)+1;
		maze[s][0] = '.';
		start = new Position(0,s);
		
		//create end
		int e = rand.nextInt(height-2)+1;
		maze[e][width-1]= '.';
		end = new Position(width-1, e);
		
		for ( int i = 1; i < height - 1; i ++ )
			for ( int j = 1; j < width - 1; j++)
			{
				int foo = rand.nextInt(3);
				if ( foo != 0)
					maze[i][j] = '.';
			}	
	}
	
	public Maze(int h, int w)
	{
		height = h;
		width = w;
		
		Random rand = new Random();
		System.out.println("Generating random maze of size "+h+" x "+w);
		//init the array
		maze = new char[height][width];
		for ( int i = 0; i < height; i ++ )
			for ( int j = 0; j < width; j++)			
				maze[i][j] = border;
				
				 
		//create start
		int s = rand.nextInt(height-2)+1;
		maze[s][0] = '.';
		start = new Position(0,s);
				
		//create end
		int e = rand.nextInt(height-2)+1;
		maze[e][width-1]= '.';
		end = new Position(width-1, e);
			
		for ( int i = 1; i < height - 1; i ++ )
			for ( int j = 1; j < width - 1; j++)
			{
				int foo = rand.nextInt(3);
				if ( foo != 0)
					maze[i][j] = '.';
			}	
		
	}
	
	
	
	public String toString()
	{
		String rval = "Your Maze\n\n";
		for ( int i = 0; i < height; i ++ )
		{
			for ( int j = 0; j < width; j++)
			{
				
				if ( maze[i][j] != border)
					rval += String.format("%2s",maze[i][j]);
				else
					rval += String.format("%2s","#");
			}
			rval += "\n";
		}
		rval += "\n";
		//rval += "Start : "+start+"\n"+"End : "+end+"\n" + "width: "+width+"\nheight: "+height+"\n";
		
		return rval;		
	}
	
	public void cleanMaze()
	{
		for ( int i = 0; i < height; i++)
			for ( int j = 0; j < width; j++)
				if ( maze[i][j] != border && maze[i][j] != path)
					maze[i][j] = '.';
	}
	
	public Position getStart()
	{
		return start;
	}
	
	public Position getEnd()
	{
		return end;
	}
	
	public char getValueAt(Position p)
	{
		return maze[p.y][p.x];		
	}

	public boolean isEnd(Position p) 
	{
		return (p.x == end.x && p.y == end.y);
	}

	public void setPath(Position p) 
	{
		maze[p.y][p.x] = path;
		
	}
	public void setVisited(Position p)
	{
		maze[p.y][p.x] = 'v';
	}
	
	public boolean isValidPos(Position p)
	{
		return ((p.x >= 0 && p.x < width) && (p.y >= 0 && p.y < height ) && getValueAt(p) =='.');
	}

	public void setBack(Position p) 
	{

		maze[p.y][p.x] = '.';
		
	}

	public void setValue(Position p, int moves) {
		// TODO Auto-generated method stub
		maze[p.y][p.x] = (char)moves;
		
	}

	public boolean isValidPos2(Position p) {
		// TODO Auto-generated method stub
		return ((p.x >= 0 && p.x < width) && (p.y >= 0 && p.y < height ) && getValueAt(p) != border);
	}
}



