package com.company;

import java.util.ArrayList;

public class MyPositive10mulStack implements IMyPositive10mulStack{

    private ArrayList<Integer> m_items = new ArrayList<>();

    @Override
    public void push(int item)
    {
        //הכנסת אייטם למחסנית
        m_items.add(0, item);
    }

    @Override
    public int pop() {
        throw new RuntimeException();
    }

    @Override
    public int peek() {
        throw new RuntimeException();
    }

    @Override
    public int clear() {
        throw new RuntimeException();
    }

    @Override
    public int count() {
        throw new RuntimeException();
    }
}
