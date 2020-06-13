package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class RecursiveBubble extends AdicionalesSorts implements ISort {

	public RecursiveBubble(MainAplicacion m, int[] n) {
		this.mainApp = m;
		sort(n);
	}

	// @Override
	public void sort(int[] array) {
		setInicio(System.currentTimeMillis());
		recursiveBubbleSort(array, array.length);
		DibujarGraficos.finSort = true;
	}

	public void recursiveBubbleSort(int array[], int len) {
		if (len == 1)
			return;

		for (int i = 0; i < len - 1; i++) {
			if (array[i] > array[i + 1]) {
				int temp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;
				cambiosArray++;
			}
			accesoArray++;
		}
		mainApp.updateAnimaciones();
		recursiveBubbleSort(array, len - 1);
		mainApp.textos();
	}
}
