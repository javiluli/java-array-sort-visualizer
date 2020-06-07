package EstilosGraficos;

import java.awt.Graphics2D;

public class Pixel extends EstiloGrafico {

	private static final long serialVersionUID = 1L;
	
	public Pixel() {

	}

	public Pixel(int i, int[] n, Graphics2D graphics) {
		height = (n[i] * BAR_HEIGHT) + BAR_HEIGHT;
		xBegin = i + (BAR_WIDTH - 1) * i;
		yBegin = WIN_HEIGHT - height;
		graphics.fillRect(xBegin, yBegin, BAR_HEIGHT, BAR_HEIGHT);
	}

}
