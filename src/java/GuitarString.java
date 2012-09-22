public class GuitarString{
	private RingBuffer GuiString;
	private int tics = 0;
	
	GuitarString(double frequency){  // create a guitar string of the given frequency, using a sampling rate of 44,100
		GuiString = new RingBuffer((int)((44100/frequency) + 0.5));
		while(!GuiString.isFull())
			GuiString.enqueue(0);
	}

	GuitarString(double[] init){     // create a guitar string whose size and initial values are given by the array
		GuiString = new RingBuffer(init.length);
		for(int i = 0; !GuiString.isFull(); i++)
			GuiString.enqueue(init[i]);
	}

  	void pluck(){                         // set the buffer to white noise
		System.out.println(GuiString.size());
		for(int i=0; i<GuiString.size(); i++){
			double x = Math.random() - 0.5; 
			GuiString.dequeue();
			GuiString.enqueue(x);
		}
	}

  	void tic(){                           // advance the simulation one time step
		double First = GuiString.dequeue();
		double Second = GuiString.peek();
		GuiString.enqueue(0.996* (0.5*(Second+First)));
		tics++;
	}

	double sample(){                       // return the current sample
		return GuiString.peek();
	}

   	int time(){                          // return number of tics
		return tics;
	}
}
