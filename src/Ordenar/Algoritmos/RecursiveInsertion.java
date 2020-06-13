package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class RecursiveInsertion extends AdicionalesSorts implements ISort {

	public RecursiveInsertion(MainAplicacion mainApp, int[] array) {
		this.mainApp = mainApp;
		sort(array);
	}

	// @Override
	public void sort(int[] array) {
		setInicio(System.currentTimeMillis());
		recursiveInsertionSort(array, array.length);
		DibujarGraficos.finSort = true;
	}

	public void recursiveInsertionSort(int array[], int len) {
		if (len <= 1)
			return;

		recursiveInsertionSort(array, len - 1);

		int last = array[len - 1];
		int j = len - 2;

		while (j >= 0 && array[j] > last) {
			array[j + 1] = array[j];
			j--;
		}
		array[j + 1] = last;
		accesoArray++;
		mainApp.updateAnimaciones();
		mainApp.textos();
	}
}
