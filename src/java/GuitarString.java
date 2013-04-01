public class GuitarString{
  private RingBuffer GuiString;
  private int tics = 0;

  /*
   *  create a guitar string of the given frequency, using a sampling rate of 44,100
   *  @param frequency Creates a RingBuffer of a size equal to 44100/frequency filled with zeroes
   */
  GuitarString(double frequency){
    GuiString = new RingBuffer((int)((44100/frequency) + 1));
    System.out.println((int)((44100/frequency) + 1));
    int i =0;
    while(!GuiString.isFull()){
      GuiString.enqueue(0);
    }
  }

  /*
   * @param init creates a RingBuffer of size init.length, and enqueues the values in the array
   */
  GuitarString(double[] init){
    GuiString = new RingBuffer(init.length);
    for(int i = 0; !GuiString.isFull(); i++)
      GuiString.enqueue(init[i]);
  }

  /*
   *  set the buffer to white noise
   */
  void pluck(){
    int lim = GuiString.size();
    for(int i=0; i<lim; i++){
      double x = Math.random() - 0.5;
      GuiString.dequeue();
      GuiString.enqueue(x);
    }
  }

  /*
   * advance the simulation one time step
   */
  void tic(){
    double First = GuiString.dequeue();
    double Second = GuiString.peek();
    GuiString.enqueue(0.996*(0.5*(Second+First)));
    tics++;
  }
  /*
   * @return the current sample
   */
  double sample(){
    return GuiString.peek();
  }

  /*
   * @return returns number of tics
   */
  int time(){
    return tics;
  }
}
