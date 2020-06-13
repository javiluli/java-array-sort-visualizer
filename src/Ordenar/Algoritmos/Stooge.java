package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class Stooge extends AdicionalesSorts implements ISort {

	public Stooge(MainAplicacion mainApp, int[] array) {
		this.mainApp = mainApp;
		sort(array);
	}

	// @Override
	public void sort(int[] array) {
		setInicio(System.currentTimeMillis());
		stoogesort(array, 0, array.length - 1);
		DibujarGraficos.finSort = true;
	}

	public void stoogesort(int[] array, int low, int higt) {
		if (low >= higt)
			return;

		if (array[low] > array[higt]) {
			int t = array[low];
			array[low] = array[higt];
			array[higt] = t;
			cambiosArray++;
			mainApp.updateAnimaciones();
		}

		if (higt - low + 1 > 2) {
			int t = (higt - low + 1) / 3;
			stoogesort(array, low, higt - t);
			stoogesort(array, low + t, higt);
			stoogesort(array, low, higt - t);
		}
	}
}
