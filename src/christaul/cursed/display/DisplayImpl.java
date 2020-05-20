package christaul.cursed.display;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

public class DisplayImpl
	implements
		Display
{
	private static final KeyStroke ESCAPE_KEY_STROKE =
			KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);

	private JFrame frame;
	private Canvas canvas;

	private BufferStrategy bs;
	private Graphics g;

	public DisplayImpl()
	{
		createDisplay();
	}

	private void createDisplay()
	{
		frame = new JFrame();
		frame.getRootPane()
			.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
			.put(ESCAPE_KEY_STROKE, "ESCAPE");
		frame.getRootPane()
			.getActionMap()
			.put("ESCAPE", new AbstractAction()
			{
				private static final long serialVersionUID = 4403370472658630695L;

				@Override
				public void actionPerformed(ActionEvent e)
				{
					System.exit(0);
				}
			});

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setVisible(true);

		canvas = new Canvas();
		canvas.setPreferredSize(frame.getSize());
		canvas.setMaximumSize(frame.getSize());
		canvas.setMinimumSize(frame.getSize());

		frame.add(canvas);
		frame.pack();

		canvas.createBufferStrategy(3);
	}

	@Override
	public void startDrawing()
	{
		bs = canvas.getBufferStrategy();
		g = bs.getDrawGraphics();

		g.fillRect(0, 0, getWidth(), getHeight());
	}

	@Override
	public void stopDrawing()
	{
		bs.show();
		g.dispose();
	}

	private int getWidth()
	{
		return frame.getSize().width;
	}

	private int getHeight()
	{
		return frame.getSize().height;
	}
}
