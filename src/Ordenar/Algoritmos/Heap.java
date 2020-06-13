package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class Heap extends AdicionalesSorts implements ISort {
	public Heap(MainAplicacion mainApp, int[] array) {
		this.mainApp = mainApp;
		sort(array);
	}

	@Override
	public void sort(int[] array) {
		int len = array.length;
		setInicio(System.currentTimeMillis());

		for (int i = len / 2 - 1; i >= 0; i--) {
			heapify(array, len, i);
			mainApp.updateAnimaciones();
		}

		for (int i = len - 1; i >= 0; i--) {
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;

			mainApp.updateAnimaciones();
			heapify(array, i, 0);
		}
		DibujarGraficos.finSort = true;
	}

	void heapify(int array[], int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (l < n && array[l] > array[largest])
			largest = l;

		if (r < n && array[r] > array[largest])
			largest = r;

		if (largest != i) {
			int swap = array[i];
			array[i] = array[largest];
			array[largest] = swap;

			heapify(array, n, largest);
		}
		accesoArray += 4;
		cambiosArray += 3;
	}
}
