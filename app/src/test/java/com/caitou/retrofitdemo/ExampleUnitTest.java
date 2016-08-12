package com.caitou.retrofitdemo;

import com.caitou.retrofitdemo.utils.DateUtil;
import com.caitou.retrofitdemo.utils.LogUtil;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test() throws Exception {
        LogUtil.v("xxxxxxxxxxx");
    }

    @Test
    public void timeTest() throws Exception {
        String time = DateUtil.getTime("1470917205");
        String date = DateUtil.getCurrentDate();
        String date1 = DateUtil.getDate(1470917205);
        System.out.println("time = " + time);
        System.out.println("date = " + date);
        System.out.println("date1 = " + date1);

    }
}