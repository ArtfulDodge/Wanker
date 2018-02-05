package wank;

public class Wank
{
	int FapCounter = 0;
	int BlamCounter = 0;
	
	int ShaftLength = 7;
	char ballsack = '8';
	char tip = 'D';
	String Hand = "MM";
	int padding = 1;
	char ShaftChar = '=';

	public static enum FapSpeed {Fast, Slow};

	public int calculateFapPosition(int i)
	{
		int FapDistance = ShaftLength - Hand.length() - padding * 2;
		return Math.abs(i % (FapDistance * 2) - FapDistance) + Hand.length() + padding;
	}

	public String fap()
	{
		int fapPosition = calculateFapPosition(FapCounter++);
		
		String shaft = padLeft(padRight(Hand, ShaftChar, fapPosition), ShaftChar, ShaftLength);

		return ballsack + shaft + tip;			
	}

	private String padLeft(String base, char pad, int totalLength)
	{
		String result = "";
		while (result.length() < totalLength - base.length())
		{
			result += pad;
		}

		return result + base;
	}

	private String padRight(String base, char pad, int totalLength)
	{
		String result = base;
		while (result.length() < totalLength)
		{
			result += pad;
		}

		return result;
	}

	public void doFap(FapSpeed speed, int strokes) throws InterruptedException
	{
		boolean isWanking = true;
		int delayTime = 100;
		switch (speed)
		{
			case Fast:
				delayTime = 100;
				break;

			case Slow:
				delayTime = 200;
				break;
		}

		if (isWanking)
		{
			for (int i = 0; i < strokes; i++)
			{
				Thread.sleep(delayTime);
				System.out.print("\r" + fap());
			}

			doBlamm();
			isWanking = false;
		}
	}

	public void Blamm()
        {
            BlamCounter++;
            switch (BlamCounter % 4)
            {
                case 0:
                    System.out.print("-");
                    break;
                case 1:
                    System.out.print(" --");
                    break;
                case 2:
                    System.out.print("\b\b\b --_");
                    break;
                case 3:
                    System.out.print("\b\b\b\b ___");
                    break;
            }
        }
	
	public void doBlamm() throws InterruptedException
	{
		boolean isBlamming = true;
		if(isBlamming)
		{
			for(int i = 0; i < 3; i++)
			{
				Blamm();
				Thread.sleep(200);
			}
		}
	}
}
