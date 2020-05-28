package Test;

import java.awt.Color;

public class BarrasMulticolor {
	final int max = 255, min = 0, pigmento = 10;
	int r = max, g = 0, b = 0;

	public void colores() {

		for (int i = 0; i < 100; i++) {

			if (r == max && g < max && b == min) {
				g = g + pigmento;
				if (g >= max)
					g = max;
			}
			if (r >= min && g == max && b == min) {
				r = r - pigmento;
				if (r <= min)
					r = min;
			}

			if (r == min && g == max && b < max) {
				b = b + pigmento;
				if (b >= max)
					b = max;
			}
			if (r == min && g >= min && b == max) {
				g = g - pigmento;
				if (g <= min)
					g = min;
			}

			if (r <= max && g == min && b == max) {
				r = r + pigmento;
				if (r >= max)
					r = max;
			}
			if (r == max && g == min && b >= min) {
				b = b - pigmento;
				if (b <= min)
					b = min;
			}
			try {
//				graphics.setColor(new Color(r, g, b));
			} catch (Exception e) {
				System.out.println("Error de efecto arcoiris");
//				graphics.setColor(Color.WHITE);
			}

		}

	}

}
