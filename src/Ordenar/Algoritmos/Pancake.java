package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class Pancake extends AdicionalesSorts implements ISort {

	public Pancake(MainAplicacion mainApp, int[] array) {
		this.mainApp = mainApp;
		sort(array);
	}

	@Override
	public void sort(int[] array) {
		setInicio(System.currentTimeMillis());

		for (int curr_size = array.length; curr_size > 1; --curr_size) {
			int mi = findMax(array, curr_size);
			if (mi != curr_size - 1) {
				flip(array, mi);
				flip(array, curr_size - 1);
			}
			mainApp.updateAnimaciones();
		}
		DibujarGraficos.finSort = true;
	}

	static void flip(int array[], int i) {
		int temp, start = 0;
		while (start < i) {
			temp = array[start];
			array[start] = array[i];
			array[i] = temp;
			start++;
			i--;
			cambiosArray++;
		}
	}

	static int findMax(int array[], int n) {
		int mi, i;
		for (mi = 0, i = 0; i < n; ++i)
			if (array[i] > array[mi])
				mi = i;
		return mi;
	}
}
