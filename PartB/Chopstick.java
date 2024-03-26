public class Chopstick {
	private final int ID;
	// hint: use a local variable to indicate whether the chopstick is free
	// (lying on the table), e.g.  private boolean free;
	private boolean free;
	private int eaters;
	// Limit the number of eating philosophers to 4
	private static final int LIMIT = 4;

	Chopstick(int ID) {
		  this.ID = ID;
		  this.free = true;
		  this.eaters = 0;
	}
	
	synchronized void take() {
		while (!this.free || eaters == LIMIT) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Error! Thread was interrupted.");
			}
		}

		this.free = false;
		eaters++;
	}
	
	synchronized void release() {
		this.free = true;
		eaters--;
		notify();
	}
	    
	public int getID() {
	    return(ID);
	}
}
