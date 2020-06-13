package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class Pigeonhole extends AdicionalesSorts implements ISort {
	public Pigeonhole(MainAplicacion mainApp, int[] array) {
		this.mainApp = mainApp;
		sort(array);
	}

	@Override
	public void sort(int[] array) {
		setInicio(System.currentTimeMillis());
		int min = array[0], max = array[0];
		for (int i : array) {
			min = Math.min(i, min);
			max = Math.max(i, max);
		}
		final int size = max - min + 1;

		int[] holes = new int[size];

		for (int i : array)
			holes[i - min]++;

		int i = 0;
		for (int count = 0; count < size; count++) {
			while (holes[count]-- > 0) {
				array[i++] = count + min;
				accesoArray++;
				mainApp.updateAnimaciones();
			}
		}
		DibujarGraficos.finSort = true;
	}
}
