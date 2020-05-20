package christaul.cursed;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest
{
	@BeforeEach
	public void setUp() throws Exception
	{
	}

	@AfterEach
	public void tearDown() throws Exception
	{
	}

	@Test
	public void runGame() throws Exception
	{
		TestableGame game = new TestableGame();

		game.start();

		Thread.sleep(100);

		game.stop();
	}
}
