package EstilosGraficos;

import java.awt.Graphics2D;

public class Circunferencia extends Transfomaciones {
	private static final long serialVersionUID = 1L;

	public Circunferencia() {
	}

	public Circunferencia(int i, Graphics2D graphics) {
		graphics.rotate(Math.PI / (NUM_BARS / 2));
		graphics.fillOval(300, 300, BAR_WIDTH * 3, BAR_WIDTH * 3);
	}
}
