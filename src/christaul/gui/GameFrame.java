package christaul.gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

public class GameFrame
	extends JFrame
{
	private static final long serialVersionUID = 779680918452594443L;

	public GameFrame()
	{
		super("Cursed");

		KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);

		getRootPane()
			.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
			.put(escapeKeyStroke, "ESCAPE");
		getRootPane()
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

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		new GameFrame();
	}
}
