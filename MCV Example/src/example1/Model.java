package example1;

public class Model extends java.util.Observable{
	
	private int counter; // primitive automatically initialized to 0
	
	public Model()
	{
		System.out.println("Model()");
				
	}
	
	public void setValue(int value){
		this.counter = value;
		System.out.println("Model init: counter = " + counter);
		setChanged();
		notifyObservers(counter);
	}
	
	public void incrementValue(){
		++counter;
		System.out.println("Model : counter = " + counter);
		setChanged();
		notifyObservers(counter);
	}
	
}
