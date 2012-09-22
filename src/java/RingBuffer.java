public class RingBuffer{
//-----------------------------------------------------------------------------------------
	private int Max_cap = 0, first = 0, last = 0;//CHANGE BACK TO PRIVATE
	private boolean empty = true;
	private double[] Buffer;

	RingBuffer(int capacity){  // create an empty ring buffer, with given max capacity
		try{
			if(capacity>0){
				Max_cap = capacity;
				Buffer = new double[capacity];
			}
			else throw new Exception(capacity +" is not a valid RingBuffer size!");
		}
		catch(Exception exc){
			System.out.println(exc.getMessage());
		}
	}

    int size(){                    // return number of items currently in the buffer
		if(first >= last) return (Max_cap - first + last);
		return (last - first);
	}

	boolean isEmpty(){                 // is the buffer empty (size equals zero)?
		return empty;
	}

	boolean isFull(){                  // is the buffer full  (size equals capacity)?
		return this.size() == Max_cap;
	}

	void enqueue(double x){         // add item x to the end
		try{
			if(!this.isFull()){
				Buffer[last] = x;
				empty=false;
				last++;
				if(last==Max_cap) last = 0;
		}
			else throw new Exception("The Queue is full, the value, " + x  + " could not be stored at " + last);
		}
		catch(Exception exc){
			System.out.println(exc.getMessage());
		}
	}

	double dequeue(){                 // delete and return item from the front
		try{	
			System.out.println(!this.isEmpty());
			//if(!this.isEmpty()){
				double temp = Buffer[first];	
				first++;
				if(first == Max_cap) first = 0;
				if(first==last) System.out.println("TRUE");;
					return temp;
			//}
			//else throw new Exception("The Queue is empty, a value could not be dequeued");
		}
		catch(Exception exc){
			System.out.println(exc.getMessage());
		}
		return 0;
	}

	double peek(){                    // return (but do not delete) item from the front
		return Buffer[first];
	}
}
