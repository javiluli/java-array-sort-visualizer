package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class IterativeQuick extends AdicionalesSorts implements ISort {
	public IterativeQuick(MainAplicacion m, int[] n) {
		this.m = m;
		sort(n);
	}

	// @Override
	public void sort(int[] arr) {
		setInicio(System.currentTimeMillis());
		qSort(arr, 0, arr.length - 1);
		DibujarGraficos.finSort = true;
	}

	private int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low - 1);
		for (int j = low; j <= high - 1; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			m.updateAnimaciones();
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}

	private void qSort(int arr[], int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			qSort(arr, low, pi - 1);
			qSort(arr, pi + 1, high);
		}
	}
}
