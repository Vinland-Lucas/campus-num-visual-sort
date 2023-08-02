package edu.campusnum.visualsort.sort;

import edu.campusnum.visualsort.model.ObservableArray;

/**
 * Created by Web 74 all right reserved
 * User: vincent
 * Date: 27/07/2023
 * Time: 16:31
 */
public class HeapSort implements SortAlgorithm{
    @Override
    public void sort(ObservableArray array) {
        int longueur = array.getLength();

        organiser(array);

        for (int i = longueur-1; i > 0; i--) {
            array.swap(0, i);
            redescendre(array, i, 0);
        }

        //throw new UnsupportedOperationException("Not implemented");
    }

    public void organiser(ObservableArray array) {
        int longueur = array.getLength();

        for (int i = 0; i < longueur-1; i++) {
            remonter(array, i);
        }
    }

    public void remonter(ObservableArray array, int index) {
        if (array.get(index) > array.get(index / 2)) {
            array.swap(index, index/2);
            remonter(array, index/2);
        }
    }

    public void redescendre(ObservableArray array, int element, int index) {
        int formule = 2 * index + 1;
        int max;

        if (formule < element) {
            if (array.get(formule) > array.get(2 * index)) {
                max = formule;
            } else {
                max = 2 * index;
            }

            if (array.get(max) > array.get(index)) {
                array.swap(max, index);
                redescendre(array, element, max);
            }
        }
    }
}
