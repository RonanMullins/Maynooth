import java.util.*;

public class luhnsAlgorithm
{

    public static void main(String [] args)
    {
		Scanner myscanner = new Scanner(System.in);

        String number = myscanner.nextLine();

        int total=0;

        for(int i=0;i<number.length()-1;i++)
        {

            int digit = Integer.parseInt(""+number.charAt(number.length()-i-2));

            if(i%2==0)
            {

                digit=digit*2;

            }

            if(digit>9)
            {

                digit=digit-9;

            }

            total+=digit;

        }

        if((total+Integer.parseInt(""+number.charAt(number.length()-1)))%10==0)
        {

            System.out.println("VALID");

        }
        else
        {

            System.out.println("INVALID");
        }


     }
}