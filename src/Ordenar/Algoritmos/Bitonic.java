package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class Bitonic extends AdicionalesSorts implements ISort {

	public Bitonic(MainAplicacion mainApp, int[] array) {
		this.mainApp = mainApp;
		sort(array);
	}

	// @Override
	public void sort(int[] array) {
		setInicio(System.currentTimeMillis());
		ordenar(array, array.length, 1);
		mainApp.updateAnimaciones();
		DibujarGraficos.finSort = true;
	}

	void compAndSwap(int array[], int i, int j, int dir) {
		if ((array[i] > array[j] && dir == 1) || (array[i] < array[j] && dir == 0)) {
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			cambiosArray++;
			mainApp.updateAnimaciones();
		}
	}

	void bitonicMerge(int array[], int low, int cnt, int dir) {
		if (cnt > 1) {
			int k = cnt / 2;
			for (int i = low; i < low + k; i++)
				compAndSwap(array, i, i + k, dir);
			bitonicMerge(array, low, k, dir);
			bitonicMerge(array, low + k, k, dir);
			mainApp.updateAnimaciones();
		}
	}

	void bitonicSort(int array[], int low, int cnt, int dir) {
		if (cnt > 1) {
			int k = cnt / 2;
			bitonicSort(array, low, k, 1);
			bitonicSort(array, low + k, k, 0);
			bitonicMerge(array, low, cnt, dir);
		}
	}

	void ordenar(int array[], int n, int up) {
		bitonicSort(array, 0, n, up);
	}
}
