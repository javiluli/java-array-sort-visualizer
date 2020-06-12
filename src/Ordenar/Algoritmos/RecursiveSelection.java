package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class RecursiveSelection extends AdicionalesSorts implements ISort {

	public RecursiveSelection(MainAplicacion m, int[] n) {
		this.m = m;
		sort(n);
	}

	// @Override
	public void sort(int[] arr) {
		setInicio(System.currentTimeMillis());
		recursiveSelectionSort(arr, 0, arr.length - 1);
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

			// Swap the smallest number in list
			list[indexOfMin] = list[low];
			list[low] = min;

			m.updateAnimaciones();
			m.textos();
			// Sort the remaining list
			recursiveSelectionSort(list, low + 1, high);

		}
	}
}
