public class RingBuffer{
//-----------------------------------------------------------------------------------------
	public int Max_cap = 0, first = 0, last = 0;//CHANGE BACK TO PRIVATE
	public boolean empty = true;
	public double[] Buffer;

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

		//System.out.println(first+"		" + last + "		");
		if(first+1>last) return (Max_cap-first+last);
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
				//System.out.println("Size= " +size()+" first= "+ first +" last= "+last);
				if(last==Max_cap) last = 0;
				Buffer[last] = x;
		//		System.out.println(isFull());
				empty=false;
				last++;
		}
			else throw new Exception("The Queue is full, the value, " + x  + " could not be stored at " + last);
		}
		catch(Exception exc){
			System.out.println(exc.getMessage());
		}
	}

	double dequeue(){                 // delete and return item from the front
		try{	
				double temp = Buffer[first];	
//				System.out.println("	First "+ Buffer[first]);
		//	if(!this.isEmpty()){
			first++;
				if(first == Max_cap) first = 0;
				if(first==last)
				return temp;
		//	}
		//	else throw new Exception("The Queue is empty, a value could not be dequeued");
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
