package com.mime.javafps;

import java.awt.Canvas;
import javax.swing.JFrame;

public class Display extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "JavaFPS Pre-Alpha 0.01";

	private Thread thread;
	private boolean running = false;

	private void start() {
		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
	}

	private void stop() {
		if (!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void run() {
		while (running) {
			tick();
			render();
		}
	}
	
	private void tick() {
		
	}
	
	private void render() {
		
	}

//	main is needed to run the program
//	main will produce a fixed-frame
	public static void main(String[] args) {
		Display game = new Display();
		JFrame frame = new JFrame();
		frame.add(game);

		// the window will terminate itself after closing the window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setTitle(TITLE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		System.out.println("We're still running...");

		game.start();
	}
}