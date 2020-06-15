package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class BidirectionalBubble extends AdicionalesSorts implements ISort {

	public BidirectionalBubble(MainAplicacion mainApp, int[] array) {
		this.mainApp = mainApp;
		sort(array);
	}

	// @Override
	public void sort(int[] array) {
		setInicio(System.currentTimeMillis());
		int j;
		int st = -1;
		int n = array.length;

		while (st < n) {
			st++;
			n--;
			for (j = st; j < n; j++) {
				if (array[j] > array[j + 1]) {
					int T = array[j];
					array[j] = array[j + 1];
					array[j + 1] = T;
				}
				mainApp.updateAnimaciones();
			}

			for (j = n; --j >= st;) {
				if (array[j] > array[j + 1]) {
					int T = array[j];
					array[j] = array[j + 1];
					array[j + 1] = T;
				}
				mainApp.updateAnimaciones();
			}
		}

		DibujarGraficos.finSort = true;
	}
}
