package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class RecursiveBubble extends AdicionalesSorts implements ISort {
	public RecursiveBubble(MainAplicacion m, int[] n) {
		this.m = m;
		sort(n);
	}

	// @Override
	public void sort(int[] arr) {
		setInicio(System.currentTimeMillis());
		bubbleSort(arr, arr.length);
		DibujarGraficos.finSort = true;
	}

	public void bubbleSort(int arr[], int n) {
		if (n == 1)
			return;

		for (int i = 0; i < n - 1; i++)
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
				cambiosArray++;
			}
		accesoArray++;
		m.updateAnimaciones();
		bubbleSort(arr, n - 1);
		m.textos();
	}
}
