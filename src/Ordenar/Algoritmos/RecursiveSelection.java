package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class RecursiveSelection extends AdicionalesSorts implements ISort {

	public RecursiveSelection(MainAplicacion mainApp, int[] array) {
		this.mainApp = mainApp;
		sort(array);
	}

	// @Override
	public void sort(int[] array) {
		setInicio(System.currentTimeMillis());
		recursiveSelectionSort(array, 0, array.length - 1);
		DibujarGraficos.finSort = true;
	}

	public void recursiveSelectionSort(int[] list, int low, int high) {
		if (low < high) {
			int indexOfMin = low;
			int min = list[low];
			for (int i = low + 1; i <= high; i++) {
				if (list[i] < min) {
					min = list[i];
					indexOfMin = i;
				}
			}

			list[indexOfMin] = list[low];
			list[low] = min;
			cambiosArray++;
			mainApp.updateAnimaciones();
			mainApp.textos();

			recursiveSelectionSort(list, low + 1, high);

		}
	}
}
