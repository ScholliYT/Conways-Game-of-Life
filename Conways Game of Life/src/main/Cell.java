package main;

public class Cell {
	private boolean alive; //Sate of cell in current generation
	public boolean isAlive() {
		return alive;
	}
	
	private boolean aliveNextGen; //State of cell in next generation
	public void setAliveForNextGen(boolean _alive) {
		aliveNextGen = _alive;
	}
	

	public Cell() {
		alive = false;
	}
	
	public Cell(boolean _alive) {
		//By first storing _alive in aliveNextGen and then nextGen() we can skip checking for 2.) condition
		//"2.) Jede lebende Zelle, die 2 oder 3 lebendige Nachbarzellen hat, lebt weiter"
		aliveNextGen = _alive;
		nextGen();
	}
	
	public void nextGen() {
		alive = aliveNextGen;
	}
}
