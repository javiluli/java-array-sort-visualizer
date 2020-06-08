package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class Bitonic extends AdicionalesSorts implements ISort {

	public Bitonic(MainAplicacion m, int[] n) {
		this.m = m;
		sort(n);
	}

	// @Override
	public void sort(int[] arr) {
		setInicio(System.currentTimeMillis());
		ordenar(arr, arr.length, 1);
		m.updateAnimaciones();
		DibujarGraficos.finSort = true;
	}

	void compAndSwap(int a[], int i, int j, int dir) {
		if ((a[i] > a[j] && dir == 1) || (a[i] < a[j] && dir == 0)) {
			// Swapping elements
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			m.updateAnimaciones();
		}
	}

	void bitonicMerge(int a[], int low, int cnt, int dir) {
		if (cnt > 1) {
			int k = cnt / 2;
			for (int i = low; i < low + k; i++)
				compAndSwap(a, i, i + k, dir);
			bitonicMerge(a, low, k, dir);
			bitonicMerge(a, low + k, k, dir);
			m.updateAnimaciones();
		}
	}

	void bitonicSort(int a[], int low, int cnt, int dir) {
		if (cnt > 1) {
			int k = cnt / 2;
			bitonicSort(a, low, k, 1);
			bitonicSort(a, low + k, k, 0);
			bitonicMerge(a, low, cnt, dir);
		}
	}

	void ordenar(int a[], int N, int up) {
		bitonicSort(a, 0, N, up);
	}
}
