package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class Merge extends AdicionalesSorts implements ISort {

	public Merge(MainAplicacion mainApp, int[] array) {
		this.mainApp = mainApp;
		sort(array);
	}

	@Override
	public void sort(int[] array) {
		setInicio(System.currentTimeMillis());
		sortingMerge(0, array.length - 1, array);
		DibujarGraficos.finSort = true;
	}

	public void sortingMerge(int izq, int der, int[] array) {
		if (izq < der) {
			cambiosArray++;
			int mitad = (izq + der) / 2;
			sortingMerge(izq, mitad, array);
			sortingMerge(mitad + 1, der, array);
			merge(izq, mitad, der, array);
		}
	}

	void merge(int izq, int mit, int der, int[] array) {
		int len_left = mit - izq + 1;
		int len_right = der - mit;

		int arr_left[] = new int[len_left];
		int arr_right[] = new int[len_right];

		for (int i = 0; i < len_left; i++) {
			arr_left[i] = array[izq + i];
			accesoArray++;
		}
		for (int j = 0; j < len_right; j++) {
			arr_right[j] = array[mit + 1 + j];
			accesoArray++;
		}
		int i = 0, j = 0;
		int k = izq;
		while (i < len_left && j < len_right) {
			if (arr_left[i] <= arr_right[j]) {
				array[k] = arr_left[i];
				i++;
				accesoArray++;
			} else {
				array[k] = arr_right[j];
				j++;
				accesoArray++;
			}
			k++;
			cambiosArray++;
			mainApp.updateAnimacionesSinTiempo();
		}

		while (i < len_left) {
			array[k] = arr_left[i];
			i++;
			k++;
			accesoArray++;
			mainApp.updateAnimacionesSinTiempo();
		}

		while (j < len_right) {
			array[k] = arr_right[j];
			j++;
			k++;
			accesoArray++;
			mainApp.updateAnimacionesSinTiempo();
		}
		mainApp.textos();
		setFin(System.currentTimeMillis());
	}
}
