package EstilosGraficos;

import java.awt.Graphics2D;

public class PiramideVertical extends EstiloGrafico {
	private static final long serialVersionUID = 1L;

	public PiramideVertical() {
	}

	public PiramideVertical(int i, int[] n, Graphics2D graphics) {
		height = (n[i] * BAR_HEIGHT) + BAR_HEIGHT;
		xBegin = i + (BAR_WIDTH - 1) * i;
		yBegin = (WIN_HEIGHT - height) / 2;
		graphics.fillRect(yBegin, xBegin, height, BAR_WIDTH);
	}
}
