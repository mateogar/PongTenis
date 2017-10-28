package juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Juego extends JPanel {
	
	private Pelota pelota;
	Raqueta raqueta;
	
	int puntuacion;
	int velocidad;
	
	public Juego () {
		pelota  = new Pelota(this);
		raqueta = new Raqueta(this);
		
		puntuacion = 0;
		velocidad  = 1;
		listeners();
	}
	

	private void mover() {
		pelota.moverPelota();
		raqueta.moverRaqueta();
	}

	
	private void listeners() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				raqueta.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				raqueta.keyPressed(e);
			}
		});
		setFocusable(true);
	}
	
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "PUNTUACIÓN: " + puntuacion,
				"Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);


		pelota.paint(g2d);
		raqueta.paint(g2d);
		
		g2d.setColor(Color.GRAY);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(puntuacion), 10, 30);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Tenis");
		Juego juego = new Juego();
		frame.add(juego);
		frame.setSize(500, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			juego.mover();
			juego.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				System.err.println("Error en la ejecución");
			}
		}
	}
	
	
	
}
