package EstilosGraficos;

import java.awt.Graphics2D;

public class CircunferenciaPunteada extends TransformCentrarGraficos {
	private static final long serialVersionUID = 1L;

	public CircunferenciaPunteada() {
	}

	public CircunferenciaPunteada(int i, Graphics2D graphics) {
		graphics.rotate(Math.PI / (NUM_BARS / 2));
		graphics.fillOval(300, 300, BAR_WIDTH * 3, BAR_WIDTH * 3);
	}
}
