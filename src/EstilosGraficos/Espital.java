package EstilosGraficos;

import java.awt.Graphics2D;

public class Espital extends Transfomaciones {
	private static final long serialVersionUID = 1L;

	public Espital() {
	}

	public Espital(int i, int[] n, Graphics2D graphics) {
		height = (n[i] * BAR_HEIGHT) + BAR_HEIGHT;
		graphics.rotate(Math.PI / (NUM_BARS / 2));
		graphics.drawLine(10, 10, 20, height / 3);
	}

}
