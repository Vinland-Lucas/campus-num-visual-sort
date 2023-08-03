package edu.campusnum.visualsort.sort;

import edu.campusnum.visualsort.model.ObservableArray;
import edu.campusnum.visualsort.model.Order;

/**
 * Created by Web 74 all right reserved
 * User: vincent
 * Date: 27/07/2023
 * Time: 16:31
 */
public class QuickSort implements SortAlgorithm{
    @Override
    public void sort(ObservableArray array) {
        int first = 0;
        int length = array.getLength();
        int last = length-1;

        tri_rapide(array, first, last);

        //throw new UnsupportedOperationException("Not implemented");
    }

    public void tri_rapide(ObservableArray array, int first, int last) {
        if (first < last) {
            int pi = partitionner(array, first, last);
            tri_rapide(array, first, pi-1);
            tri_rapide(array, pi+1, last);
        }
    }

    public int partitionner(ObservableArray array, int first, int last) {
        int pivot = last;
        int j = (first - 1);

        for (int i = first; i <= pivot-1; i++) {
            if (array.compare(pivot, i).equals(Order.Higher)) {
                j = j + 1;
                array.swap(i, j);
            }
        }

        array.swap(j + 1, pivot);

        return (j + 1);
    }
}
