package sorting;


import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Arrays;

@Entity
public class SortResult {

    @Id
    @GeneratedValue
    private Long id;

    @Basic(optional = false)
    private String originArray;

    @Basic(optional = false)
    private String resultArray;

    @Basic(optional = false)
    private int swapCount = 0;

    @Basic(optional = false)
    private long execTime = 0; //nano seconds

    public SortResult() { //hibernate wants a no-args constructor
    }

    public SortResult(int[] originArray) {
        this.originArray = Arrays.toString(originArray);
        this.resultArray = Arrays.toString(sort(originArray));
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

    public int getSwapCount() {
        return swapCount;
    }

    public String getResultArray() {
        return resultArray;
    }

    public String getOriginArray() {
        return originArray;
    }

    public long getExecTime() {
        return execTime;
    }
}
