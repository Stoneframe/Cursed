package christaul.cursed;

public class TestableGame
	extends Game
{
	@Override
	protected void init()
	{
		display = new DisplayMock();
	}
}
