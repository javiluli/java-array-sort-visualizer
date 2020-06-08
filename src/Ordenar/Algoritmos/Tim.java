package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class Tim extends AdicionalesSorts implements ISort {
	static final int RUN = 32;

	public Tim(MainAplicacion m, int[] n) {
		this.m = m;
		sort(n);
	}

	// @Override
	public void sort(int[] arr) {
		setInicio(System.currentTimeMillis());
		timSort(arr, arr.length);
		DibujarGraficos.finSort = true;
	}

	public void insertionSort(int[] arr, int left, int right) {
		for (int i = left + 1; i <= right; i++) {
			int temp = arr[i];
			int j = i - 1;
			while (j >= left && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
				m.updateAnimaciones();
			}
			arr[j + 1] = temp;
		}
	}

	public void merge(int[] array, int left, int mid, int right) {
		int len1 = mid - left + 1, len2 = right - mid;
		int[] array_aux_left = new int[len1];
		int[] array_aux_right = new int[len2];
		for (int x = 0; x < len1; x++) {
			array_aux_left[x] = array[left + x];
		}
		for (int x = 0; x < len2; x++) {
			array_aux_right[x] = array[mid + 1 + x];
		}

		int i = 0, j = 0, k = left;
		while (i < len1 && j < len2) {
			if (array_aux_left[i] <= array_aux_right[j]) {
				array[k] = array_aux_left[i];
				i++;
			} else {
				array[k] = array_aux_right[j];
				j++;
			}
			k++;
			m.updateAnimaciones();
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

	public void timSort(int[] arr, int n) {
		for (int i = 0; i < n; i += RUN)
			insertionSort(arr, i, Math.min((i + 31), (n - 1)));

		for (int size = RUN; size < n; size = 2 * size) {
			for (int left = 0; left < n; left += 2 * size) {
				int mid = left + size - 1;
				int right = Math.min((left + 2 * size - 1), (n - 1));
				merge(arr, left, mid, right);
			}
		}
	}
}
