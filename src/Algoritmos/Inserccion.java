package Algoritmos;

import javax.swing.JPanel;

import principal.*;

public class Inserccion {

	public Inserccion(JPanel panel, int[] n) {
		sort(panel, n);
	}

	public void sort(JPanel panel, int[] n) {
		for (int i = 0; i < n.length; i++) {
			int pos = i;
			int aux = n[i];

			while ((pos > 0) && (n[pos - 1] > aux)) {
				n[pos] = n[pos - 1];
				pos--;
//				LineasArray.cambiosArray++;
			}
			n[pos] = aux;

			Barras.mismo = i + 1;
//			LineasArray.accesoArray++;
			Delay.delay(10);
			panel.repaint();
//			texto();
		}
	}

//	public void texto() {
//		Main.getLblEstadisticas().setText(getName() + " | Accesos al array " + LineasArray.accesoArray
//				+ " | Cambios en el array " + LineasArray.cambiosArray);
//	}

	String getName() {
		return "Inserccion Sort";
	}
}
