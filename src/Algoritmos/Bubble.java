package Algoritmos;

import javax.swing.JPanel;

import principal.*;

public class Bubble {

	public Bubble(JPanel panel, int[] n) {
		sort(panel, n);
	}

	public static void sort(JPanel panel, int[] n) {
		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < n.length - 1 - i; j++) {
				if (n[j] > n[j + 1]) {
					int temp = n[j];
					n[j] = n[j + 1];
					n[j + 1] = temp;
//					LineasArray.cambiosArray++;
				}
				Barras.mismo = j + 1;
//				LineasArray.accesoArray++;
				Delay.delay(1);
				panel.repaint();
//				texto();
			}
//			LineasArray.accesoArray++;
//			texto();
		}
	}

//	public void texto() {
//		Main.getLblEstadisticas().setText(getName() + " | Accesos al array " + LineasArray.accesoArray
//				+ " | Cambios en el array " + LineasArray.cambiosArray);
//	}

	String getName() {
		return "Bubble Sort";
	}
}
