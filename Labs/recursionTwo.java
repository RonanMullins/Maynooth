public class recursionTwo
{
 public static void main(String[] args)
 {
 	System.out.println(method(3));
 }
 public static int method(int number)
 {
 	if (number > 30)
 	{
	 return 7;
 	}
	 System.out.println("hello");
	 return method(number + 7) - 8;
 }
}