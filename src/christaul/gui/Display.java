package christaul.gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

public class Display
{
	private static final KeyStroke ESCAPE_KEY_STROKE =
			KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);

	private JFrame frame;

	public Display()
	{
		createDisplay();
	}

	private void createDisplay()
	{
		frame = new JFrame();
		frame
			.getRootPane()
			.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
			.put(ESCAPE_KEY_STROKE, "ESCAPE");
		frame
			.getRootPane()
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
	}
}
