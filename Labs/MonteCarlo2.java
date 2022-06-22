import java.util.*;



public class MonteCarlo2{



    public static void main(String[] args){

        Scanner myscanner = new Scanner(System.in);

        double tosses = myscanner.nextInt();

        double bias = myscanner.nextInt();



        double count=0;

        double simulations=1000;



        for(int i=0;i<simulations;i++)
        {

            double total=0;

            for(int j=0;j<tosses;j++)
            {

                if(Math.random()<bias/100.0)
                {

                    total++;

                }

            }

            if(total>tosses/2.0){

                count++;

            }

        }

        System.out.println((count*100/simulations));

    }

}
