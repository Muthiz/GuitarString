public class GuitarHeroVisualizer {
	/**
	 * @param args
	 */
	private static int x=0;
	private static double temp=0;
	private static double sample=0;
	/*public static void run(){
		StdDraw.setYscale(-10, 10);
		StdDraw.setXscale(0, 100);

		if(x==100){
			x=0;
			StdDraw.clear();
		}
		StdDraw.line(x, temp, x+1, sample);
		temp = sample;
		x += 1;
	}*/
	public static void main(String[] args) {

		/*
		 * Sample stores the current sample. 
		 * Temp stores the previous sample
		 * x keeps track of the x position on the StdDraw canvas  
		 * keyboard associates the Strings to keys, the ith string is represented by the ith character in the String
		 */
		double sample, temp=0;
		int x=0;
		String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

		/*
		 *  GuitarString setup. Initializes an array of GuitarStrings.
		 */
		GuitarString[] GUItar = new GuitarString[37];

		/*
		 * Creates the new GuitarStrings with specific frequencies
		 */
		for(int i = 0; i < 37; i++)
			GUItar[i] = new GuitarString(440 * Math.pow(2, (i - 24)/12)) ;

		while (true) {
			sample = 0;			
			/*
			 *  check if the user has typed a key; if so, process it   
			 */
			if (StdDraw.hasNextKeyTyped()) {
				char key = StdDraw.nextKeyTyped();
				if(keyboard.contains(key+"")) GUItar[keyboard.indexOf(key)].pluck();
				else System.out.println("Invalid key =O");
			}

			/*
			 *  compute the superposition of ses by adding the sound waves samples.
			 */
			for(int i=0; i<37; i++)
				sample += GUItar[i].sample();

			/*
			 * play the sample on standard audio
			 */
			StdAudio.play(sample);
			run();

			/*
			 *  Draws the sound wave in real time
			 */


			/*
			 *  advance the simulation of each guitar string by one step   
			 */
			for(int i=0; i < 37; i++)
				GUItar[i].tic();
		}
	}
}
