package Sorts.Algoritmos;

import Adicionales.Delay;
import Interfaz.Sort;
import Principal.Main;
import Sorts.Sorts;

public class Pancake extends Sorts implements Sort {
	public Pancake(Main m) {
		this.m = m;
		sort();
	}

	@Override
	public void sort() {
		for (int curr_size = n.length; curr_size > 1; --curr_size) {
			int mi = findMax(n, curr_size);
			if (mi != curr_size - 1) {
				flip(n, mi);
				flip(n, curr_size - 1);
			}
			m.textos();
			setFin(System.currentTimeMillis());
			Main.getPanelBarras().repaint();
			Delay.delay();
		}
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

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

}
