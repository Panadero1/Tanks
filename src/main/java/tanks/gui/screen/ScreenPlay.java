package tanks.gui.screen;

import tanks.Crusade;
import tanks.Drawing;
import tanks.Game;
import tanks.gui.Button;

public class ScreenPlay extends Screen
{
	public ScreenPlay()
	{

	}
	
	Button newLevel = new Button(Drawing.drawing.interfaceSizeX / 2, Drawing.drawing.interfaceSizeY / 2 - 120, 350, 40, "Random level", new Runnable()
	{
		@Override
		public void run() 
		{
			Game.reset();
			Game.screen = new ScreenGame();
		}
	}
			, "Generate a random level to play");
	
	Button crusade = new Button(Drawing.drawing.interfaceSizeX / 2, Drawing.drawing.interfaceSizeY / 2 - 60, 350, 40, "Crusades", new Runnable()
	{
		@Override
		public void run() 
		{
			if (Crusade.currentCrusade == null)
				Game.screen = new ScreenCrusades();
			else
				Game.screen = new ScreenResumeCrusade();

		}
	}
			, "Fight battles in an order,---and see how long you can survive!");
	
	Button online = new Button(Drawing.drawing.interfaceSizeX / 2, Drawing.drawing.interfaceSizeY / 2 + 0, 350, 40, "Online", "Online mode is coming soon!");
	
	Button party = new Button(Drawing.drawing.interfaceSizeX / 2, Drawing.drawing.interfaceSizeY / 2 + 60, 350, 40, "Party", new Runnable() 
	{
		@Override
		public void run() 
		{
			if (!Game.username.equals(""))
				Game.screen = new ScreenParty();
			else
				Game.screen = new ScreenUsernamePrompt();
		}
	},
	"Play with other people who are---connected to your local network");
		
	Button tutorial = new Button(Drawing.drawing.interfaceSizeX / 2, Drawing.drawing.interfaceSizeY / 2 + 120, 350, 40, "Tutorial", new Runnable()
	{
		@Override
		public void run() 
		{
			Tutorial.loadTutorial(false);
		}
	}, "Learn how to play Tanks!"
	);

	Button back = new Button(Drawing.drawing.interfaceSizeX / 2, Drawing.drawing.interfaceSizeY / 2 + 270, 350, 40, "Back", new Runnable()
	{
		@Override
		public void run() 
		{
			Game.screen = new ScreenTitle();
		}
	}
	);
	
	@Override
	public void update() 
	{
		newLevel.update();
		crusade.update();
		online.update();
		party.update();
		tutorial.update();
		back.update();
	}

	@Override
	public void draw() 
	{
		this.drawDefaultBackground();
		Drawing.drawing.setFontSize(24);
		Drawing.drawing.setColor(0, 0, 0);
		Drawing.drawing.drawInterfaceText(Drawing.drawing.interfaceSizeX / 2, Drawing.drawing.interfaceSizeY / 2 - 210, "Select a game mode");
		back.draw();
		tutorial.draw();
		party.draw();
		online.draw();
		crusade.draw();
		newLevel.draw();
	}

}