public class Position
{
	public int x;
	public int y;
	
	public Position( int X, int Y)
	{
		x = X;
		y = Y;
		
	}
	
	
	
	
	public String toString()
	{
		String rval = "";
		rval += "("+ x + "," + y + ")";
		return rval;
	}
	
}