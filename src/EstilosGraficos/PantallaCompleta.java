package EstilosGraficos;

import java.awt.Graphics2D;

public class PantallaCompleta extends EstiloGrafico {
	private static final long serialVersionUID = 1L;

	public PantallaCompleta() {
	}

	public PantallaCompleta(int i, int n[], Graphics2D graphics) {
		height = (n[i] * BAR_HEIGHT) + BAR_HEIGHT;
		xBegin = i + (BAR_WIDTH - 1) * i;
		graphics.fillRect(xBegin, 0, BAR_HEIGHT, WIN_HEIGHT);
	}
}
