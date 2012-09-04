public class RingBuffer{
//-----------------------------------------------------------------------------------------
	private int Max_cap = 0, first = 0, last = 0, index = 0;
	private double[] Buffer;

	RingBuffer(int capacity){  // create an empty ring buffer, with given max capacity
		Max_cap = capacity;
		Buffer = new double[capacity];
	}

    	int size(){                    // return number of items currently in the buffer
		return last;
	}

	boolean isEmpty(){                 // is the buffer empty (size equals zero)?
		return last==0;
	}

	boolean isFull(){                  // is the buffer full  (size equals capacity)?
		return index==Max_cap;
	}

	void enqueue(double x){         // add item x to the end
		try{
			if(index<Max_cap){
				Buffer[index] = x;
				index++;
			}
			else throw new Exception("The Queue is full, the value could not be stored");
		}
		catch(Exception exc){
			System.out.println(exc.getMessage());
		}
	}

	double dequeue(){                 // delete and return item from the front
		try{	
			if(!this.isEmpty()){
				Buffer[index
			}
			throw new Exception("The Queue is empty, a value could not be dequeued");
		}
		catch(Exception exc){
			System.out.println(exc.getMessage());
		}
	}

	double peek(){                    // return (but do not delete) item from the front
		return Buffer[0];
	}
}
