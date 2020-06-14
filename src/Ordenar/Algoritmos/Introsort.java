package Ordenar.Algoritmos;

import Ordenar.AdicionalesSorts;
import Ordenar.ISort;
import Principal.DibujarGraficos;
import Principal.MainAplicacion;

public class Introsort extends AdicionalesSorts implements ISort {

	public Introsort(MainAplicacion mainApp, int[] array) {
		this.mainApp = mainApp;
		sort(array);
	}

	@Override
	public void sort(int[] array) {
		setInicio(System.currentTimeMillis());
		sortData(array.length, array);
		DibujarGraficos.finSort = true;
	}

	private void swap(int i, int j, int[] array) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		mainApp.updateAnimaciones();
	}

	private void maxHeap(int i, int heapN, int begin, int[] array) {
		int temp = array[begin + i - 1];
		int child;

		while (i <= heapN / 2) {
			child = 2 * i;
			if (child < heapN && array[begin + child - 1] < array[begin + child])
				child++;
			if (temp >= array[begin + child - 1])
				break;
			array[begin + i - 1] = array[begin + child - 1];
			i = child;
		}
		array[begin + i - 1] = temp;
	}

	private void heapify(int begin, int end, int heapN, int[] array) {
		for (int i = (heapN) / 2; i >= 1; i--)
			maxHeap(i, heapN, begin, array);

	}

	private void heapSort(int begin, int end, int[] array) {
		int heapN = end - begin;
		this.heapify(begin, end, heapN, array);

		for (int i = heapN; i >= 1; i--) {
			swap(begin, begin + i, array);
			maxHeap(1, i, begin, array);
		}
	}

	private void insertionSort(int left, int right, int[] array) {

		for (int i = left; i <= right; i++) {
			int key = array[i];
			int j = i;

			while (j > left && array[j - 1] > key) {
				array[j] = array[j - 1];
				j--;
			}
			mainApp.updateAnimaciones();
			array[j] = key;
		}
	}

	private int findPivot(int a1, int b1, int c1, int[] array) {
		int max = Math.max(Math.max(array[a1], array[b1]), array[c1]);
		int min = Math.min(Math.min(array[a1], array[b1]), array[c1]);
		int median = max ^ min ^ array[a1] ^ array[b1] ^ array[c1];
		if (median == array[a1])
			return a1;
		if (median == array[b1])
			return b1;
		return c1;
	}

	private int partition(int low, int high, int[] array) {
		int pivot = array[high];
		int i = (low - 1);
		for (int j = low; j <= high - 1; j++) {
			if (array[j] <= pivot) {
				i++;
				swap(i, j, array);
			}
		}
		swap(i + 1, high, array);
		mainApp.updateAnimaciones();
		return (i + 1);
	}

	private void sortDataUtil(int begin, int end, int depthLimit, int[] array) {
		if (end - begin > 16) {
			if (depthLimit == 0) {
				this.heapSort(begin, end, array);
				return;
			}

			depthLimit = depthLimit - 1;
			int pivot = findPivot(begin, begin + ((end - begin) / 2) + 1, end, array);
			swap(pivot, end, array);

			int p = partition(begin, end, array);

			sortDataUtil(begin, p - 1, depthLimit, array);
			sortDataUtil(p + 1, end, depthLimit, array);
		}

		else {
			insertionSort(begin, end, array);
		}
	}

	private void sortData(int len, int[] array) {
		int depthLimit = (int) (2 * Math.floor(Math.log(len) / Math.log(2)));
		this.sortDataUtil(0, len - 1, depthLimit, array);
	}
}
