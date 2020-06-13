package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class Tim extends AdicionalesSorts implements ISort {
	static final int RUN = 32;

	public Tim(MainAplicacion mainApp, int[] array) {
		this.mainApp = mainApp;
		sort(array);
	}

	// @Override
	public void sort(int[] array) {
		setInicio(System.currentTimeMillis());
		timSort(array, array.length);
		DibujarGraficos.finSort = true;
	}

	public void insertionSort(int[] array, int izq, int der) {
		for (int i = izq + 1; i <= der; i++) {
			int temp = array[i];
			int j = i - 1;
			while (j >= izq && array[j] > temp) {
				array[j + 1] = array[j];
				j--;
				mainApp.updateAnimaciones();
			}
			array[j + 1] = temp;
		}
	}

	public void merge(int[] array, int izq, int mid, int der) {
		int len1 = mid - izq + 1, len2 = der - mid;
		int[] array_aux_left = new int[len1];
		int[] array_aux_right = new int[len2];
		for (int x = 0; x < len1; x++) {
			array_aux_left[x] = array[izq + x];
		}
		for (int x = 0; x < len2; x++) {
			array_aux_right[x] = array[mid + 1 + x];
		}

		int i = 0, j = 0, k = izq;
		while (i < len1 && j < len2) {
			if (array_aux_left[i] <= array_aux_right[j]) {
				array[k] = array_aux_left[i];
				i++;
			} else {
				array[k] = array_aux_right[j];
				j++;
			}
			k++;
			mainApp.updateAnimaciones();
		}
		while (i < len1) {
			array[k] = array_aux_left[i];
			k++;
			i++;
		}

		while (j < len2) {
			array[k] = array_aux_right[j];
			k++;
			j++;
		}
	}

	public void timSort(int[] array, int len) {
		for (int i = 0; i < len; i += RUN)
			insertionSort(array, i, Math.min((i + 31), (len - 1)));

		for (int size = RUN; size < len; size = 2 * size) {
			for (int left = 0; left < len; left += 2 * size) {
				int mid = left + size - 1;
				int right = Math.min((left + 2 * size - 1), (len - 1));
				merge(array, left, mid, right);
			}
		}
	}
}
