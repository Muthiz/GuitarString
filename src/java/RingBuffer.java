public class RingBuffer{

	public int Max_cap = 0, first = 0, last = 0;
	private boolean empty = true;
	private double[] Buffer;

	/*
	 * @param capacity create an empty ring buffer, with given max capacity
	 */
	RingBuffer(int capacity){  
		try{
			if(capacity>0){
				Max_cap = capacity;
				Buffer = new double[Max_cap];
			}
			else throw new Exception(capacity +" is not a valid RingBuffer size!");
		}
		catch(Exception exc){
			System.out.println(exc.getMessage());
		}
	}
	
	/*
	 *  @return return number of items currently in the buffer
	 */
    int size(){
    	if(empty) return 0;
    	else if(first >= last) return (Max_cap - first + last);
		return (last - first);
	}

    /*
     * @return is the buffer empty (size equals zero)?
     */
	boolean isEmpty(){                 
		return this.size()==0;
		//return empty;
	}

	/*
	 * @return is the buffer full  (size equals capacity)?
	 */
	boolean isFull(){                  
		return this.size() == Max_cap;
	}

	/*
	 * add item x to the end of the buffer
	 */
	void enqueue(double x){         
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

	/*
	 * @return delete and return item from the front
	 */
	double dequeue(){                 
		try{	
			if(!this.isEmpty()){
				double temp = Buffer[first];
				first++;
			    if(first==last) empty=true;	
				if(first == Max_cap) first = 0;
					return temp;
			}
			else throw new Exception("The Queue is empty, a value could not be dequeued");
		}
		catch(Exception exc){
			System.out.println(exc.getMessage());
		}
		return 0;
	}

	/*
	 * @return return (but do not delete) item from the front
	 */
	double peek(){                    
		return Buffer[first];
	}
}
