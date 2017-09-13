package main;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GameTest_SetCellsNextGen {

	private Game g;

	@Parameter(0)
	public int neighborsAlive;
	@Parameter(1)
	public boolean initState;
	@Parameter(2)
	public boolean expectedState;
	
	@Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { 
        	{ 0, true, false },
        	{ 0, false, false },
        	{ 1, true, false },
        	{ 1, false, false },
        	{ 2, false, false },
        	{ 2, true, true },
        	{ 3, false, true },
        	{ 3, true, true },
        	{ 4, false, false },
        	{ 4, true, false },
        	{ 5, false, false },
        	{ 5, true, false },
        	{ 6, false, false },
        	{ 6, true, false },
        	{ 7, false, false },
        	{ 7, true, false },
        	{ 8, false, false },
        	{ 8, true, false }
        	};
        return Arrays.asList(data);
    }
    
    @Before
	public void initGame() {
		g = new Game(5,5); //just give some data. This can be anything
	}
	
	@Test
	public void setCellsNextGen() {
		Cell cell = new Cell(initState);
		g.setCellsNextGenTest(cell, neighborsAlive);
		cell.nextGen();
		assertEquals(expectedState, cell.isAlive());
	}

}
