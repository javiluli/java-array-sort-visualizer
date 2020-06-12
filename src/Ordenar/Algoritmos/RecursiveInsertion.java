package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class RecursiveInsertion extends AdicionalesSorts implements ISort {

	public RecursiveInsertion(MainAplicacion m, int[] n) {
		this.m = m;
		sort(n);
	}

	// @Override
	public void sort(int[] arr) {
		setInicio(System.currentTimeMillis());
		recursiveInsertionSort(arr, arr.length);
		DibujarGraficos.finSort = true;
	}

	public void recursiveInsertionSort(int arr[], int n) {
		if (n <= 1)
			return;

		recursiveInsertionSort(arr, n - 1);

		int last = arr[n - 1];
		int j = n - 2;

		while (j >= 0 && arr[j] > last) {
			arr[j + 1] = arr[j];
			j--;
		}
		arr[j + 1] = last;
		accesoArray++;
		m.updateAnimaciones();
		m.textos();
	}
}
