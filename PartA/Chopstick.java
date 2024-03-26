public class Chopstick {
	private final int ID;
	// hint: use a local variable to indicate whether the chopstick is free
	// (lying on the table), e.g.  private boolean free;
	private boolean free;

	Chopstick(int ID) {
		  this.ID = ID;
		  this.free = true;
	}
	
	synchronized void take() {
		while (!this.free) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Error! Thread was interrupted.");
			}
		}

		this.free = false;
	}
	
	synchronized void release() {
		this.free = true;
		notify();
	}
	    
	public int getID() {
	    return(ID);
	}
}
