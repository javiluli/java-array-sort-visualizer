package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class Stooge extends AdicionalesSorts implements ISort {

	public Stooge(MainAplicacion m, int[] n) {
		this.m = m;
		sort(n);
	}

	// @Override
	public void sort(int[] arr) {
		setInicio(System.currentTimeMillis());
		stoogesort(arr, 0, arr.length - 1);
		DibujarGraficos.finSort = true;
	}

	public void stoogesort(int[] arr, int l, int h) {
		if (l >= h)
			return;

		if (arr[l] > arr[h]) {
			int t = arr[l];
			arr[l] = arr[h];
			arr[h] = t;
			m.updateAnimaciones();
		}

		if (h - l + 1 > 2) {
			int t = (h - l + 1) / 3;
			stoogesort(arr, l, h - t);
			stoogesort(arr, l + t, h);
			stoogesort(arr, l, h - t);
		}
	}
}
