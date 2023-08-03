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

    // Cette méthode appelle la méthode "partionner" et la stock dans une variable
    // L'utilité de "tri_rapide" va permettre de trier les 2 parties du tableau partitionné
    public void tri_rapide(ObservableArray array, int first, int last) {
        if (first < last) {
            int pi = partitionner(array, first, last);
            tri_rapide(array, first, pi-1);
            tri_rapide(array, pi+1, last);
        }
    }

    // Cette méthode va partitionner le tableau en deux parties, l'une de chaque côté du tableau
    // A gauche les éléments + petits que le pivot, à droite ceux plus grands que le pivot
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
