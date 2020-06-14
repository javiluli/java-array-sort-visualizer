package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class IterativeMerge extends AdicionalesSorts implements ISort {

	public IterativeMerge(MainAplicacion mainApp, int[] array) {
		this.mainApp = mainApp;
		sort(array);
	}

	@Override
	public void sort(int[] array) {
		setInicio(System.currentTimeMillis());
		int curr_size;
		int left_start;

		for (curr_size = 1; curr_size <= array.length - 1; curr_size = 2 * curr_size) {
			for (left_start = 0; left_start < array.length - 1; left_start += 2 * curr_size) {
				int mid = left_start + curr_size - 1;
				int right_end = Math.min(left_start + 2 * curr_size - 1, array.length - 1);
				merge(array, left_start, mid, right_end);
			}
		}
		DibujarGraficos.finSort = true;
	}

	void merge(int array[], int izq, int mit, int der) {
		int i, j, k;
		int n1 = mit - izq + 1;
		int n2 = der - mit;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (i = 0; i < n1; i++)
			L[i] = array[izq + i];
		for (j = 0; j < n2; j++)
			R[j] = array[mit + 1 + j];

		i = 0;
		j = 0;
		k = izq;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				array[k] = L[i];
				i++;
			} else {
				array[k] = R[j];
				j++;
			}
			k++;
			mainApp.updateAnimaciones();
		}

		while (i < n1) {
			array[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			array[k] = R[j];
			j++;
			k++;
		}
	}
}
