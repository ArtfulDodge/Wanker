package wank;

import java.util.Scanner;

public class Main
{
	public static void main(String args[]) throws InterruptedException
	{
		Wank myWank;
		Scanner input = new Scanner(System.in);
		while(true)
		{	
			myWank = new Wank();
			System.out.println("Please enter a Command");
			String line = input.nextLine();
			switch (line)
			{
				case "wank fast":
					myWank.doFap(Wank.FapSpeed.Fast, 50);
					break;
				case "wank slow":
					myWank.doFap(Wank.FapSpeed.Slow, 50);
					break;
				case "exit":
					return;
				case "help":
				default:
					System.out.println();
					System.out.println("help:: ");
					System.out.println("wank fast   - wanks fast");
					System.out.println("wank slow   - wanks slowly");
					System.out.println("help        - displays help");
					System.out.println("exit        - does exactly what you'd think");
			}

			System.out.println();
		}
	}
}
