package main;

import java.awt.Color;

import javax.swing.JButton;

public class Cell {
	private boolean alive; //Sate of cell in current generation
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean _alive) {
		alive = _alive;
		if(alive) {
			btn.setBackground(Color.BLACK);
		}
		else {
			btn.setBackground(Color.WHITE);
		}
	}
	
	private boolean aliveNextGen; //State of cell in next generation
	public void setAliveForNextGen(boolean _alive) {
		aliveNextGen = _alive;
	}
	
	private JButton btn;
	public void setBtn(JButton _btn) {
		btn = _btn;
	}
	public JButton getBtn() {
		return btn;
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
		setAlive(aliveNextGen);
	}
}
