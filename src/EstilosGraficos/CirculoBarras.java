package EstilosGraficos;

import java.awt.Graphics2D;

public class CirculoBarras extends TransformCentrarGraficos {
	private static final long serialVersionUID = 1L;

	public CirculoBarras() {
	}

	public CirculoBarras(Graphics2D graphics) {
		graphics.rotate(Math.PI / (NUM_BARS / 2));
		graphics.fillRect(0, 0, 5, 400);
	}
}
