package Algoritmos;

import javax.swing.JPanel;

import principal.*;

public class Seleccion {

	public Seleccion(JPanel panel, int[] n) {
		sort(panel, n);
	}

	public void sort(JPanel panel, int[] n) {
		for (int i = 0; i < n.length; i++) {
			int min = i;
			for (int j = i + 1; j < n.length; j++) {
				if (n[j] < n[min])
					min = j;
			}
			int aux = n[i];
			n[i] = n[min];
			n[min] = aux;
//			LineasArray.cambiosArray++;

			Barras.mismo = n[min];
			Delay.delay(10);
			panel.repaint();
//			texto();
//			LineasArray.accesoArray++;
		}
	}

//	public void texto() {
//		Main.getLblEstadisticas().setText(getName() + " | Accesos al array " + LineasArray.accesoArray
//				+ " | Cambios en el array " + LineasArray.cambiosArray);
//	}

	String getName() {
		return "Seleccion Sort";
	}
}
