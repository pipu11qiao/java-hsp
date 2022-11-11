package sort;

import static org.junit.jupiter.api.Assertions.*;
import static sort.Util.checkSortMethod;
import static sort.Util.generateRandomArray;


import org.junit.jupiter.api.*;

import java.util.Arrays;


public class SortTest {
    @Test
    public void generateTEst() {
        int[] arr = generateRandomArray(50, 50);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testBubble() {
        BubbleSort bubbleSort = new BubbleSort();
        boolean result = checkSortMethod(bubbleSort);
        assertTrue(result);
    }
    @Test
    public void testSelect(){
        SelectSort selectSort = new SelectSort();
        boolean result = checkSortMethod(selectSort);
        assertTrue(result);
    }
}
