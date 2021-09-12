package com.company;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class MyPositive10mulStackTest {

    private ArrayList<Integer> get_m_items(MyPositive10mulStack stack) {
        try {
            // reflection in order to get the m_items.....
            ArrayList<Integer> m_items = null; // m_items
            Field privateStringField = null;
            privateStringField = MyPositive10mulStack.class.
                    getDeclaredField("m_items");
            privateStringField.setAccessible(true);
            m_items = (ArrayList<Integer>) privateStringField.get(stack);
            // i got the m_items
            return m_items;
        }
        catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    // positive flows

    //    void push(int item);
    //    int pop();
    //    int peek();
    //    void clear();
    //    int count();

    // push
    @Test
    public void test_MyPositive10mulStack_push_pos1()
    {
        MyPositive10mulStack stack = new MyPositive10mulStack();

        stack.push(10);

        // non atomic
        //assertEquals(1, stack.count());
        //assertEquals(10, stack.peek());


        //atomic
        ArrayList<Integer> m_items = get_m_items(stack);
        assertEquals(1, m_items.size());
        assertEquals(10, (int)m_items.get(0));

        // atomic
        // how to check the push without using the interface!
        // stack.m_items -> size == 1
        // stack.m_items -> get(0) == 10
        // reflection

    }

    //pop
    @Test
    public void test_MyPositive10mulStack_pop_pos1()
    {
        MyPositive10mulStack stack = new MyPositive10mulStack();
        stack.push(10);
        int item = stack.pop();

        assertEquals(0, stack.count());
        assertEquals(10, item);
    }


    //peek
    @Test
    public void test_MyPositive10mulStack_peek_pos1()
    {
        MyPositive10mulStack stack = new MyPositive10mulStack();
         int item = stack.peek();

         assertEquals(1, stack.count());
         assertEquals(10, item);
    }

    @Test
    public void test_MyPositive10mulStack_clear_pos2()
    {
        MyPositive10mulStack stack = new MyPositive10mulStack();
        stack.push(10);
        stack.push(20);
        stack.clear();

        assertEquals(0, stack.count());
    }

    //clear
    @Test
    public void test_MyPositive10mulStack_clear_pos1()
    {
        MyPositive10mulStack stack = new MyPositive10mulStack();
        stack.clear();

        assertEquals(0, stack.count());
    }

    //counter
    @Test
    public void test_MyPositive10mulStack_count_pos1()
    {
        MyPositive10mulStack stack = new MyPositive10mulStack();
        stack.push(10);
        stack.push(20);
        int counter = stack.count();

        assertEquals(2, counter);
    }


    @Test
    public void test_MyPositive10mulStack_count_pos2()
    {
        MyPositive10mulStack stack = new MyPositive10mulStack();
        int counter = stack.count();

        assertEquals(2, counter);
    }



}
