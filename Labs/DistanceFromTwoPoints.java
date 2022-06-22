

import java.util.*;

public class DistanceFromTwoPoints
{

    public static void main(String [] args)
    {
      Scanner scan = new Scanner (System.in);

      System.out.println("GPS1 Latitude:");
      double oneLat = scan.nextDouble();
      System.out.println("GPS1 Longitude:");
      double oneLon = scan.nextDouble();
      System.out.println("GPS2 Latitude:");
      double twoLat = scan.nextDouble();
      System.out.println("GPS2 Longitude:");
      double twoLon = scan.nextDouble();

      Haversine(oneLat,oneLon,twoLat,twoLon);

    }
    public static void Haversine(double oneLat,double oneLon, double twoLat, double twoLon)
    {
      final int r= 6371;

      double latDis= Math.toRadians(twoLat-oneLat);
      double lonDis= Math.toRadians(twoLon-oneLon);
      double a= (Math.sin(latDis/2)*Math.sin(latDis/2))+Math.cos(Math.toRadians(oneLat))* Math.cos(Math.toRadians(twoLat))*Math.sin(lonDis/2)*Math.sin(lonDis/2);
      double c = 2*Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
      double dis = r*c;

      System.out.println(dis);

    }


}
