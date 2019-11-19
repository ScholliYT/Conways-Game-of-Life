package main;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Game {

	private Cell[][] field;
	private boolean autoRun;
	private ScheduledExecutorService autoRunExecutor = Executors.newScheduledThreadPool(1);
	private ScheduledFuture autoRunFuture;

	public boolean isAutoRun() {
		return autoRun;
	}

	private Runnable stepRunnable = () -> step();

	public Game(int _sizeX, int _sizeY) {
		field = new Cell[_sizeY][_sizeX];
		generateField();
	}

	public Game(Cell[][] _field) {
		field = _field;
	}

	private void generateField() {
		// Rows
		for (int r = 0; r < field.length; r++) {
			// Columns
			for (int c = 0; c < field[0].length; c++) {
				field[r][c] = new Cell();
			}
		}
	}

	// Calculates state for next generation and applies it
	public void step() {
		// set state for next generation
		// Rows
		for (int r = 0; r < field.length; r++) {
			// Columns
			for (int c = 0; c < field[0].length; c++) {

				int aliveNeighbors = getAliveNeighbors(r, c);
				setCellsNextGen(field[r][c], aliveNeighbors);
			}
		}

		// update Cell to next generation
		// Rows
		for (int r = 0; r < field.length; r++) {
			// Columns
			for (int c = 0; c < field[0].length; c++) {
				field[r][c].nextGen();
			}
		}
	}

	public void setCellsNextGenTest(Cell cell, int _aliveNeighbors) {
		setCellsNextGen(cell, _aliveNeighbors);
	}

	private void setCellsNextGen(Cell cell, int _aliveNeighbors) {
		if (_aliveNeighbors < 2) {
			// Die
			cell.setAliveForNextGen(false);
		} else if (_aliveNeighbors == 3) {
			// Go alive
			cell.setAliveForNextGen(true);
		}
		// testing for == 2 || == 3 is not necessary because Cell will update to
		// last state (alive)
		else if (_aliveNeighbors > 3) {
			// Die
			cell.setAliveForNextGen(false);
		}
	}

	public int getAliveNeighborsTest(int _r, int _c) {
		return getAliveNeighbors(_r, _c);
	}

	private int getAliveNeighbors(int _r, int _c) {
		int aliveNeighbors = 0;
		// Rows
		for (int r = _r - 1; r <= _r + 1; r++) {
			int realR = r;
			if (realR == -1) { // upper border
				realR = field.length - 1;
			} else if (realR == field.length) { // lower border
				realR = 0;
			}
			// Columns
			for (int c = _c - 1; c <= _c + 1; c++) {
				int realC = c;
				if (realC == -1) { // left border
					realC = field[0].length - 1;
				} else if (realC == field[0].length) { // right border
					realC = 0;
				}
				// System.out.println(realR + " " + realC);
				if (realR == _r && realC == _c) { // Don't check cell thats
													// being updated
					// System.out.println("Dont check: " + realR + " " + realC);
				} else {
					if (field[realR][realC].isAlive()) {
						// System.out.println("Cell: " + realR + " " + realC + "
						// is alive");
						aliveNeighbors++;
					}
				}
			}
		}
		return aliveNeighbors;
	}

	public void addGuiContent(GUI frame) {
		// Rows
		for (int r = 0; r < field.length; r++) {
			// Columns
			for (int c = 0; c < field[0].length; c++) {
				field[r][c].setBtn(frame.addToPanel(field[r][c]));
			}
		}
		step();
	}

	public void toggleAutoRun() {
		if(autoRun) {
			autoRunFuture.cancel(false);
		} else {
			autoRunFuture = autoRunExecutor.scheduleAtFixedRate(stepRunnable, 0, 2, TimeUnit.SECONDS);
		}

		autoRun = !autoRun;
	}
}
