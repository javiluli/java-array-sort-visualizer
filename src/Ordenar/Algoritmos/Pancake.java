package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class Pancake extends AdicionalesSorts implements ISort {
	public Pancake(MainAplicacion m, int[] n) {
		this.m = m;
		sort(n);
	}

	@Override
	public void sort(int[] n) {
		setInicio(System.currentTimeMillis());

		for (int curr_size = n.length; curr_size > 1; --curr_size) {
			int mi = findMax(n, curr_size);
			if (mi != curr_size - 1) {
				flip(n, mi);
				flip(n, curr_size - 1);
			}
			m.updateAnimaciones();
		}
		DibujarGraficos.finSort = true;
	}

	static void flip(int arr[], int i) {
		int temp, start = 0;
		while (start < i) {
			temp = arr[start];
			arr[start] = arr[i];
			arr[i] = temp;
			start++;
			i--;
		}
	}

	static int findMax(int arr[], int n) {
		int mi, i;
		for (mi = 0, i = 0; i < n; ++i)
			if (arr[i] > arr[mi])
				mi = i;
		return mi;
	}
}
