package edu.campusnum.visualsort.sort;

import edu.campusnum.visualsort.model.ObservableArray;

/**
 * Created by Web 74 all right reserved
 * User: vincent
 * Date: 27/07/2023
 * Time: 14:55
 */
public class InsertionSort  implements SortAlgorithm{
    @Override
    public void sort(ObservableArray array) {
        int n = array.getLength();

        for (int i = 1; i < n; i++) {
            int temp = array.get(i);
            int j = i;

            while (j > 0 && array.get(j - 1) > temp) {
                array.swap(j, j-1); // permet de swap l'index gauche à celui de droite si la condition de boucle est respectée
                j = j - 1;
            }
        }

       // throw new UnsupportedOperationException("Not implemented");
    }
}
