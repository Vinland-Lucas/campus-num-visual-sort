package edu.campusnum.visualsort.sort;

import edu.campusnum.visualsort.model.ObservableArray;
import edu.campusnum.visualsort.model.Order;

/**
 * Created by Web 74 all right reserved
 * User: vincent
 * Date: 27/07/2023
 * Time: 16:31
 */
public class MergeSort implements SortAlgorithm{
    @Override
    public void sort(ObservableArray array) {
        if (array.getLength() > 1) {
            int arraySize = array.getLength();
            int iL = 0;
            int iR = arraySize / 2;

            ObservableArray leftArray = array.slice(iL, iR);
            ObservableArray rightArray = array.slice(iR, arraySize - iR);

            sort(leftArray);
            sort(rightArray);

            //fusion
            while (iR - iL > 0 && arraySize - iR > 0) {
                if (array.compare(iL, iR).equals(Order.Higher)) {
                    for (int j = iR; j > iL; j--) {
                        array.swap(j, j-1);
                    }
                    iR = iR + 1;
                }
                iL++;
            }
        }

        // throw new UnsupportedOperationException("Not implemented");
    }

    /*
    public void tri_fusion(ObservableArray array) {

        int length = array.getLength();
        if (length <= 1) {
            return;
        }
        int middle = length / 2;
        ObservableArray leftArray = array.slice(0, middle);
        ObservableArray rightArray = array.slice(middle, length - middle);

        int iL = 0; // left array
        int iR = 0; // right array

        for (iL; iL < length; iL++) {
            if (iL < middle) {
                array.swap(iL, leftArray.get(iL));
            } else {
                array.swap(iR, rightArray.get(iR));
            }
        }
    }

    public ObservableArray fusion(ObservableArray leftArray, ObservableArray rightArray, ObservableArray array) {
        if (arrayA == null) {
            return arrayB;
        }

        if (arrayA == null) {
            return arrayA;
        }

        if (arrayA.get(1) <= arrayB.get(1)) {
            return;
        }
    }
     //*/
}
