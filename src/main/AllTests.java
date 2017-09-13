package main;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ GameTest_GetAliveNeighbors.class, GameTest_SetCellsNextGen.class })
public class AllTests {

}
