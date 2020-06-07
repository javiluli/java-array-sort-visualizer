package Sorts.Algoritmos;

import Interfaz.Sort;
import Principal.Barras;
import Principal.Main;
import Sorts.AdicionalesSorts;

public class Heap extends AdicionalesSorts implements Sort {
	public Heap(Main m,int[] n) {
		this.m = m;
		sort(n);
	}

	@Override
	public void sort(int[] n) {
		int len = n.length;
		setInicio(System.currentTimeMillis());

		for (int i = len / 2 - 1; i >= 0; i--) {
			heapify(n, len, i);
			m.updateAnimaciones();
			;
		}

		for (int i = len - 1; i >= 0; i--) {
			int temp = n[0];
			n[0] = n[i];
			n[i] = temp;

			m.updateAnimaciones();
			heapify(n, i, 0);
		}
		Barras.finSort = true;
	}

	void heapify(int arr[], int n, int i) {
		// Find largest among root, left child and right child
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (l < n && arr[l] > arr[largest])
			largest = l;

		if (r < n && arr[r] > arr[largest])
			largest = r;

		// Swap and continue heapifying if root is not largest
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			heapify(arr, n, largest);
		}
		accesoArray += 4;
		cambiosArray += 3;
	}

	@Override
	public String getNombre() {
		return "Heap Sort";
	}

}
