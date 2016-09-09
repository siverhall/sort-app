package sorting;

import org.junit.Assert;
import org.junit.Test;

public class SortResultTest {

    @Test
    public void sorting_outputs_correct_result() throws Exception {
        SortResult sortResult = new SortResult(new int[]{32, 3, 36, 17, 15, 19, 93, 4});
        Assert.assertEquals("[3, 4, 15, 17, 19, 32, 36, 93]", sortResult.getResultArray());
    }

    @Test
    public void sorting_of_sorted_array_doesnt_require_swaps() throws Exception {
        SortResult sortResult = new SortResult(new int[]{1, 5, 7, 432, 444});
        Assert.assertEquals(0, sortResult.getSwapCount());
    }

    @Test
    public void counts_correct_with_one_swap() throws Exception {
        SortResult sortResult = new SortResult(new int[]{1, 5, 7, 432, 19});
        Assert.assertEquals(1, sortResult.getSwapCount());
    }
}