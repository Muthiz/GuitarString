public class GuitarHero {
	public static void main(String[] args) {
		
		/*
		 * Sample stores the current sample. 
		 * keyboard associates the Strings to keys, the ith string is represented by the ith character in the String
		 */
		double sample;
		String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

		/*
		 *  GuitarString setup. Initializes an array of GuitarStrings.
		 */
		GuitarString[] GUItar = new GuitarString[37];

		/*
		 * Creates the new GuitarStrings with specific frequencies
		 */
		for(int i=0; i<37; i++)
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
			 * compute the superposition of ses
			 */
			for(int i=0; i<37; i++)
				sample += GUItar[i].sample();

			/*
			 *  play the sample on standard audio
			 */
			StdAudio.play(sample);

			/*
			 *  advance the simulation of each guitar string by one step   
			 */
			for(int i=0; i < 37; i++)
				GUItar[i].tic();
		}
	}
}
