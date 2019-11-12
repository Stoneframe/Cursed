package christaul.gui;

import javax.swing.JFrame;

public class GameFrame
	extends JFrame
{
	private static final long serialVersionUID = 779680918452594443L;

	public GameFrame()
	{
		super("Cursed");

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
