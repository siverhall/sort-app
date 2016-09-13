package sorting.dataobjects;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;

@Entity
public class SortResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty
    private String originArray;

    @JsonProperty
    private String resultArray;

    @JsonProperty
    private int swapCount = 0;

    @JsonProperty
    private long execTime = 0; //nano seconds

    public SortResult() {
    }

    public SortResult(int[] origin) {
        this.originArray = Arrays.toString(origin);
        this.resultArray = Arrays.toString(sort(origin));
    }

    private int[] sort(int[] arr) {
        long start = System.nanoTime();
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index]) {
                    index = j;
                    swapCount++;
                }

            int smaller = arr[index];
            arr[index] = arr[i];
            arr[i] = smaller;
        }
        long end = System.nanoTime();
        execTime = end - start;
        return arr;
    }

    String getResultArray() {
        return resultArray;
    }

    int getSwapCount() {
        return swapCount;
    }
}
