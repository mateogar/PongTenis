package juego;

import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Pelota {

	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	
	private static final int DIAMETRO = 30;
	
	private Juego juego;

	public Pelota (Juego juego) {
		this.juego = juego;
	}

	void moverPelota() {
		if (x + xa < 0) {
			xa = juego.velocidad;
		}
			
		if (x+xa > juego.getWidth()-DIAMETRO) {
			xa = -juego.velocidad;
		}
			
		if (y + ya < 0) {
			ya = juego.velocidad;
		}
			
		if (y+ya > juego.getHeight()-DIAMETRO) {
			juego.gameOver();
		}	
		
		if (colision()){
			ya = -juego.velocidad;
			y = juego.raqueta.getTopY() - DIAMETRO;
			juego.velocidad++;
			juego.puntuacion++;
		}			
		
		x = x + xa;
		y = y + ya;
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, 30, 30);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETRO, DIAMETRO);
	}
	
	private boolean colision() {
		return juego.raqueta.getBounds().intersects(getBounds());
	}
	
}
