package christaul.cursed;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest
{
	private static final Duration DURATION = Duration.ofMillis(100);

	private TestableGame game;

	private LocalTime startTime;
	private LocalTime stopTime;

	@BeforeEach
	public void setUp() throws Exception
	{
		game = new TestableGame();
	}

	@AfterEach
	public void tearDown() throws Exception
	{
		game = null;
		startTime = null;
		stopTime = null;
	}

	@Test
	public void runGame() throws Exception
	{
		givenNothing();
		thenStartGame();
		thenWait(DURATION);
		thenStopGame();
		expectGameRan(DURATION);
	}

	private void givenNothing()
	{
	}

	private void thenStartGame()
	{
		game.start();
		startTime = LocalTime.now();
	}

	private void thenWait(Duration duration) throws InterruptedException
	{
		Thread.sleep(duration.toMillis());
	}

	private void thenStopGame()
	{
		game.stop();
		stopTime = LocalTime.now();
	}

	private void expectGameRan(Duration expectedDuration)
	{
		assertEquals(getTotalGameRunTime().toMillis(), expectedDuration.toMillis(), 10);
	}

	private Duration getTotalGameRunTime()
	{
		return Duration.between(startTime, stopTime);
	}
}
