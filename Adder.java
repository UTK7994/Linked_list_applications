import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;

//Importing linked list is not important as java.util.LinkedList is called by its full name!!!!!
public class Adder
{
	public static void main(String args[])
	{
		Queue<Integer> l1 = new java.util.LinkedList<Integer>();
		Queue<Integer> l2 = new java.util.LinkedList<Integer>();
		Queue<Integer> l3 = new java.util.LinkedList<Integer>();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 2 big numbers");
		String s1 = sc.next();
		String s2 = sc.next();

		//Added the linked list in the reverse order!!!!
		//so that mathematical method can be easily applied!!!!
		for (int i = s1.length() - 1; i >= 0; i--)
		{
			try
			{
				l1.add(Integer.parseInt(s1.charAt(i) + ""));
			} catch (Exception e)
			{
				System.out.println("Enter the number only!!!");
				System.exit(1);
			}
		}

		for (int i = s2.length() - 1; i >= 0; i--)
		{
			try
			{
				l2.add(Integer.parseInt(s2.charAt(i) + ""));
			} catch (Exception e)
			{
				System.out.println("Enter the number only!!!");
				System.exit(1);
			}
		}

		int carry = 0, sum = 0;
		
		//Iterator is the best solution to avoid n^2 complexity by running through n loops
		//Use iterator to point out to the last traversed pointer;
		
		Iterator<Integer> I1 = l1.iterator();
		Iterator<Integer> I2 = l2.iterator();

		//when both the linked list are there go for addition
		while (I1.hasNext() && I2.hasNext())
		{
			int i = I1.next();
			int j = I2.next();
			sum = (i + j + carry) % 10;
			carry = (i + j + carry) / 10;
			l3.add(sum);
		}

		if (I1.hasNext())
		{
			//System.out.println("L1 is bigger!!!!!");
			while (I1.hasNext())
			{
				l3.add((I1.next() + carry) % 10);
				carry = (I1.next() + carry) / 10;
			}
		} else if (I2.hasNext())
		{
			//System.out.println("L2 is bigger!!!!!");
			while (I2.hasNext())
			{
				int i = I2.next();
				l3.add((i + carry) % 10);
				carry = (i + carry) / 10;
			}
		}
		
		// when both the codes Linked list finishes!!!!!
		if (carry != 0)
		{
			//unnecessary carry is avoidable when the lists are empty and carry is also not there;
			//error prone Condition
			l3.add(carry);
		}

		Object[] Ob=l3.toArray();
		
		System.out.println("The Big number is --->");
		for(int i=Ob.length-1;i>=0;i--){
			System.out.print(Ob[i]+"");
		}
		
	}
}
