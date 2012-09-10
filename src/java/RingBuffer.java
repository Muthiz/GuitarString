public class RingBuffer{
//-----------------------------------------------------------------------------------------

	/**
		Make it an actual ringbuffer.
		First does not loop
		Last does not loop
	*/


	private int Max_cap = 0, first = 0, last = 0;
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
		if(first>last)
			return (Max_cap-first+last);
		return (last - first);
	}

	boolean isEmpty(){                 // is the buffer empty (size equals zero)?
		return this.size() == 0;
	}

	boolean isFull(){                  // is the buffer full  (size equals capacity)?
		return this.size() == Max_cap;
	}

	void enqueue(double x){         // add item x to the end
		try{
			if(!this.isFull()){
				System.out.println("Size=" +size()+" Enqueued "+ x +" last= "+last);
				Buffer[last] = x;
				last++;
			}
			else throw new Exception("The Queue is full, the value could not be stored");
		}
		catch(Exception exc){
			System.out.println(exc.getMessage());
		}
	}

	double dequeue(){                 // delete and return item from the front
		System.out.println("DeQueue!!!");
		try{	
			if(!this.isEmpty()){
				
				return Buffer[first];
				
			}
			throw new Exception("The Queue is empty, a value could not be dequeued");
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
