package main;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GameTest_GetAliveNeighbors {

	private Game g;
	
	@Parameter(0)
	public int x; 
	@Parameter(1)
	public int y;
	@Parameter(2)
	public int result;

	@Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { 2, 1, 8 }, { 0, 0, 3 }, { 4, 4, 2 }, { 2, 2, 4 } };
        return Arrays.asList(data);
    }

	@Before
	public void initGame() {
		Cell[][] field = { 
				{ new Cell(false), new Cell(false), new Cell(false), new Cell(false), new Cell(true ) },
				{ new Cell(true ), new Cell(true ), new Cell(true ), new Cell(false), new Cell(false) },
				{ new Cell(true ), new Cell(false), new Cell(true ), new Cell(false), new Cell(true ) },
				{ new Cell(true ), new Cell(true ), new Cell(true ), new Cell(false), new Cell(false) },
				{ new Cell(false), new Cell(false), new Cell(false), new Cell(false), new Cell(false) } };
		g = new Game(field);
	}

	@Test
	public void getAliveNeighbors() {
		assertEquals(result, g.getAliveNeighborsTest(x, y));
	}
	
}
