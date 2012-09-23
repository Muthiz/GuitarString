public class GuitarHeroVisualizer {
      public static void main(String[] args) {
    	  double sample, temp=0;
    	  int x=0;
    	  String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    	  GuitarString[] GUItar = new GuitarString[37];
    	  for(int i = 0; i < 37; i++)
    		  GUItar[i] = new GuitarString(440 * Math.pow(2, (i - 24)/12)) ;
    	  StdDraw.setYscale(-0.5*37, 0.5*37);
    	  StdDraw.setXscale(0, 100);
    	  while (true) {
              if(x==100){
            	  x=0;
            	  StdDraw.clear();
              }
    		  sample = 0;

    		  // check if the user has typed a key; if so, process it   
              if (StdDraw.hasNextKeyTyped()) {
                  char key = StdDraw.nextKeyTyped();
                  if(keyboard.contains(key+"")) GUItar[keyboard.indexOf(key)].pluck();
                  else System.out.println("Invalid key =O");
              }

              // compute the superposition of ses
              for(int i=0; i<37; i++)
            	  sample += GUItar[i].sample();
              
              // play the sample on standard audio
              StdAudio.play(sample);

              StdDraw.line(x, temp, x+1, sample);
              temp = sample;
              x += 1;
              
              // advance the simulation of each guitar string by one step   
              for(int i=0; i < 37; i++)
            	  GUItar[i].tic();
          }
       }
  }
