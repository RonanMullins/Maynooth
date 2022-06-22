public class University
{
	private int rank;
	private String name;
	private String country;
	private double lat;
	private double lon;
	private boolean visited;
	private int[] adj;

	public University(int rank,String name,String country,double lat,double lon)
	{
		this.rank = rank;
		this.name = name;
		this.country = country;
		this.lat = lat;
		this.lon = lon;
		visited = false;
	}
	public int getRank()
	{
		return rank;
	}
	public String getName()
	{
		return name;
	}
	public String getCountry()
	{
		return country;
	}
	public double getLat()
	{
		return lat;
	}
	public double getLon()
	{
		return lon;
	}
	public boolean getVisited()
	{
		return visited;
	}
	public void setVisited(boolean x)
	{
		visited = x;
	}
	public void setAdj(int [] adjacency)
	{
		adj = adjacency;
	}
}