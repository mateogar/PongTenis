package juego;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;


public class Raqueta {

	private int x  = 0;
	private int xa = 0;
	
	private static final int ANCHO = 60;
	private static final int ALTO  = 10;
	private static final int Y     = 530;
	
	private Juego juego;

	public Raqueta(Juego juego) {
		this.juego= juego;
	}

	void moverRaqueta() {
		if ((x+xa > 0) && (x+xa) < (juego.getWidth()-ANCHO)) {
			x = x + xa;
		}			
	}

	public void paint(Graphics2D g) {
		g.fillRect(x, Y, ANCHO, ALTO);
	}

	//Al soltar la tecla
	public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	
	//Al pulsar la tecla
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -juego.velocidad;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = juego.velocidad;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, Y, ANCHO, ALTO);
	}
	
	public int getTopY() {
		return Y - ALTO;
	}
}
