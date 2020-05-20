package christaul.cursed;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

	private IllegalStateException illegalStateExceptionThrown;

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
		illegalStateExceptionThrown = null;
	}

	@Test
	public void startAndStopGame() throws Exception
	{
		givenNothing();
		thenStartGame();
		thenWait(DURATION);
		thenStopGame();
		expectGameRan(DURATION);
	}

	@Test
	public void startingStartedGameThrowsException()
	{
		givenGameIsStarted();
		thenStartGame();
		expectIllegalStateExceptionIsThrown();
	}

	@Test
	public void stoppingStoppedGameThrowsException()
	{
		givenGameIsStopped();
		thenStopGame();
		expectIllegalStateExceptionIsThrown();
	}

	private void expectIllegalStateExceptionIsThrown()
	{
		assertNotNull(illegalStateExceptionThrown);
	}

	private void givenNothing()
	{
	}

	private void givenGameIsStarted()
	{
		startGame();
	}

	private void givenGameIsStopped()
	{
	}

	private void thenStartGame()
	{
		try
		{
			startGame();
		}
		catch (IllegalStateException e)
		{
			illegalStateExceptionThrown = e;
		}
	}

	private void thenStopGame()
	{
		try
		{
			stopGame();
		}
		catch (IllegalStateException e)
		{
			illegalStateExceptionThrown = e;
		}
	}

	private void thenWait(Duration duration) throws InterruptedException
	{
		Thread.sleep(duration.toMillis());
	}

	private void expectGameRan(Duration expectedDuration)
	{
		assertEquals(getTotalGameRunTime().toMillis(), expectedDuration.toMillis(), 10);
	}

	private void startGame()
	{
		game.start();
		startTime = LocalTime.now();
	}

	private void stopGame()
	{
		game.stop();
		stopTime = LocalTime.now();
	}

	private Duration getTotalGameRunTime()
	{
		return Duration.between(startTime, stopTime);
	}
}
