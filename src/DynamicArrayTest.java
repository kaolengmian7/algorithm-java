package src;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class DynamicArrayTest {

    @Test
    public void testAdd1Del2() {
        // 添加1个，删除2个
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();

        dynamicArray.add(0, 1);
        dynamicArray.removeLast();
        try {
            dynamicArray.removeLast();
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Remove failed. Require index >= 0 and index <= size.", e.getMessage());
        }
    }

    @Test
    public void testAddResize() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>(1);

        // 添加1个，填满，不扩容
        dynamicArray.add(0, 1);
        Assert.assertEquals(1, dynamicArray.getCapacity());
        // 再添加1个，满了添不进去，扩容
        dynamicArray.add(0, 1);
        Assert.assertEquals(2, dynamicArray.getCapacity());
    }

    @Test
    public void testAddLast() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>(2);

        dynamicArray.addLast(1);
        Assert.assertEquals(1, dynamicArray.getSize());
        assertEquals(1, (int) dynamicArray.get(0));
        dynamicArray.addLast(2);
        Assert.assertEquals(2, dynamicArray.getSize());
        assertEquals(2, (int) dynamicArray.get(1));
    }

    @Test
    public void testAddFirst() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>(2);

        dynamicArray.addFirst(1);
        Assert.assertEquals(1, dynamicArray.getSize());
        assertEquals(1, (int) dynamicArray.get(0));
        dynamicArray.addFirst(2);
        Assert.assertEquals(2, dynamicArray.getSize());
        assertEquals(2, (int) dynamicArray.get(0));
        assertEquals(1, (int) dynamicArray.get(1));
    }
}


