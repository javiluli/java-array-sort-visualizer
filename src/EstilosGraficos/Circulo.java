package EstilosGraficos;

import java.awt.Graphics2D;

public class Circulo extends TransformCentrarGraficos {
	private static final long serialVersionUID = 1L;

	public Circulo() {
	}

	public Circulo(Graphics2D graphics) {
		graphics.rotate(Math.PI / (NUM_BARS / 2));
		graphics.fillRect(0, 0, 5, 400);
	}
}
