package EstilosGraficos;

import java.awt.Graphics2D;

import Sorts.Sorts;

public class Espital extends Transfomaciones {
	private static final long serialVersionUID = 1L;

	public Espital() {
	}

	public Espital(int i, Graphics2D graphics) {
		height = (Sorts.n[i] * BAR_HEIGHT) + BAR_HEIGHT;
		graphics.rotate(Math.PI / (NUM_BARS / 2));
		graphics.drawLine(10, 10, 20, height / 3);
	}

}
