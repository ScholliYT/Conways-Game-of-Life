package main;

import java.awt.EventQueue;

public class Main {

	private final int sizeX = 64;
	private final int sizeY = 36;
	
	private Game g;
	private GUI frame;
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		g = new Game(sizeX, sizeY);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new GUI(sizeX, sizeY, g);
					frame.setVisible(true);
					g.addGuiContent(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
