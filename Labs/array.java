public class array
{

    public static void main(String [] args)
    {
    	String[] names = {"Peter", "Susan", "Keith"};
        for(int i = 0; i < names.length; i++)
        {
			for(int j = 0; j < names[i].length(); j++)
			{
				System.out.print(names[i].charAt(j) + " ");
		    }

		System.out.println();
		}




     }

}
