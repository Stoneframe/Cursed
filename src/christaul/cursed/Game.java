package christaul.cursed;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import christaul.cursed.display.Display;

public class Game
	implements
		Runnable
{
	private Display display;

	private Thread thread;

	private BufferStrategy bs;
	private Graphics g;

	private boolean running = false;

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

	private void init()
	{
		display = new Display();
	}

	private void update()
	{

	}

	private void draw()
	{
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.fillRect(0, 0, display.getWidth(), display.getHeight());

		bs.show();
		g.dispose();
	}
}
