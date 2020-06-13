package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class IterativeQuick extends AdicionalesSorts implements ISort {
	public IterativeQuick(MainAplicacion mainApp, int[] array) {
		this.mainApp = mainApp;
		sort(array);
	}

	// @Override
	public void sort(int[] array) {
		setInicio(System.currentTimeMillis());
		qSort(array, 0, array.length - 1);
		DibujarGraficos.finSort = true;
	}

	private int partition(int array[], int low, int high) {
		int pivot = array[high];
		int i = (low - 1);
		for (int j = low; j <= high - 1; j++) {
			if (array[j] <= pivot) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				cambiosArray++;
			}
			mainApp.updateAnimaciones();
		}

		int temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;
		cambiosArray++;
		return i + 1;
	}

	private void qSort(int array[], int low, int high) {
		if (low < high) {
			int pi = partition(array, low, high);
			qSort(array, low, pi - 1);
			qSort(array, pi + 1, high);
		}
	}
}
