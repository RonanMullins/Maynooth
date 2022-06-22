import java.util.*;
import java.io.*;

public class travellingSalesman
{
	public static ArrayList<University> unsortedUnis = new ArrayList<>(); //unsorted ArrayList
	public static ArrayList<University> sortedUnis = new ArrayList<>(); //sorted ArrayList

   public static void main(String [] args)
   {
		readIn();
		sort();

		refineSort();
		printArray();
		System.out.println("\nTotal distance: "+ dis()+" Km");


   }
   public static void readIn()
   {
   		try
   		{
   			BufferedReader br = new BufferedReader(new FileReader("TSP.txt"));
   			String line ="";
   			int count=0;

   			while((line = br.readLine())!= null)
   			{
   				String ar[] = line.split("	");
   				int rank= Integer.parseInt(ar[0]);
   				String name=ar[1];
   				String country = ar[2];
   				double lat = Double.parseDouble(ar[3]);
				double lon = Double.parseDouble(ar[4]);

   				unsortedUnis.add(new University(rank,name,country,lat,lon));

   			}

   		}
   		catch(FileNotFoundException e)
   		{
   			System.out.println("File Not Found");
   		}
   		catch(IOException f)
   		{
   			System.out.println("Something is Wrong");
   		}
   }
   public static void printArray() //prints out sorted array (sortedUnis)
   {
   		for(University u:sortedUnis)
   		{
			System.out.print(u.getRank()+"."+" "); //prints the rank
   			System.out.println(u.getLat()+ "	" + u.getLon()); //prints the lat and long

   		}
   }
   public static double Haversine(University u, University v) //calculates distance between two points
   {
	  double oneLat= u.getLat();
	  double oneLon= u.getLon();
	  double twoLat= v.getLat();
	  double twoLon= v.getLon();

      final int r= 6371;

      double latDis= Math.toRadians(twoLat-oneLat);
      double lonDis= Math.toRadians(twoLon-oneLon);
      double a= (Math.sin(latDis/2)*Math.sin(latDis/2))+Math.cos(Math.toRadians(oneLat))* Math.cos(Math.toRadians(twoLat))*Math.sin(lonDis/2)*Math.sin(lonDis/2);
      double c = 2*Math.asin(Math.sqrt(a));
      double dis = r*c;

      return dis;

   }
   public static void sort() //creates path from Maynooth to rank 1 then to rank 1000 then finishing in Maynooth
   {
		for(int i=607; i>0;i-=2) //Maynooth to rank 1 in odd ranking
		{
		 sortedUnis.add(unsortedUnis.get(i));
		}
		for(int i=0;i<1000;i+=2) //Top to rank 1000 in even ranking
		{
		 sortedUnis.add(unsortedUnis.get(i));
		}
		for(int i=999;i>607;i-=2)//Bottom to Maynooth in odd ranking
		{
		 sortedUnis.add(unsortedUnis.get(i));
		}

		sortedUnis.add(sortedUnis.get(0)); //adds Maynooth to the end of sorted array

   }
   public static double dis() //calculates distance of entire path
   {
		double total=0.0;

		for(int i=0;i<1000;i++)
		{
			total += Haversine(sortedUnis.get(i),sortedUnis.get(i+1));
		}

		return total;
   }
   public static void refineSort() //two opt search
   {
   	for(int i =1;i<1000;i++)
   	{
   		for(int j=1;j<1000;j++)
   		{

				University uniAtI = sortedUnis.get(i);
				University uniAtJ = sortedUnis.get(j);

				University uniAtI1 = sortedUnis.get(i-1);
				University uniAtJ1 = sortedUnis.get(j-1);
				University uniAtI2 = sortedUnis.get(i+1);
				University uniAtJ2 = sortedUnis.get(j+1);

				if(swapIsValid(uniAtI,uniAtJ,uniAtI1,uniAtJ1,uniAtI2,uniAtJ2))
				{
					double dis1= Haversine(uniAtI,uniAtI1)+Haversine(uniAtI,uniAtI2)+Haversine(uniAtJ,uniAtJ1)+Haversine(uniAtJ,uniAtJ2); //calculates dis of: I to I-1, I to I+1, J to J-1, J to J+1
					double dis2= Haversine(uniAtJ,uniAtI1)+Haversine(uniAtJ,uniAtI2)+Haversine(uniAtI,uniAtJ1)+Haversine(uniAtI,uniAtJ2); //"	                                    " vice versa

					if(dis2<dis1)
					{
						University temp= sortedUnis.get(j); //swap
						sortedUnis.set(j,sortedUnis.get(i));
						sortedUnis.set(i,temp);

					}

				}


   		}
   	}

   }
   public static boolean swapIsValid(University uniAtI,University uniAtJ,University uniAtI1,University uniAtJ1,University uniAtI2,University uniAtJ2) //checks if the swap fits the contraint
   {
		if((Math.abs(uniAtI.getRank()-uniAtJ1.getRank())<=100)&&(Math.abs(uniAtI.getRank()-uniAtJ2.getRank())<=100)&&(Math.abs(uniAtJ.getRank()-uniAtI1.getRank())<=100)&&(Math.abs(uniAtJ.getRank()-uniAtI2.getRank())<=100))
		{
			return true;
		}
		else
		{
			return false;
		}
   }





}