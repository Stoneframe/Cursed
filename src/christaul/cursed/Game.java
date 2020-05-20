package christaul.cursed;

import christaul.cursed.display.Display;
import christaul.cursed.display.DisplayImpl;

public class Game
	implements
		Runnable
{
	protected Display display;

	private Thread thread;

	private volatile boolean running = false;

	public Game()
	{
	}

	@Override
	public void run()
	{
		init();

		while (running)
		{
			update();
			draw();
		}
	}

	public synchronized void start()
	{
		if (running)
		{
			throw new IllegalStateException("Game is already started!");
		}

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop()
	{
		if (!running)
		{
			throw new IllegalStateException("Game has already stopped!");
		}

		running = false;
		try
		{
			thread.join();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	protected void init()
	{
		display = new DisplayImpl();
	}

	private void update()
	{
	}

	private void draw()
	{
		display.startDrawing();
		display.stopDrawing();
	}
}
