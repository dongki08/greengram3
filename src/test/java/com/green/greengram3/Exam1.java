package com.green.greengram3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class Exam1 {
//단위 테스트
    @Test
    @DisplayName("테스트1")
    public void test1() {
        System.out.println("test1");
        int sum = 2 + 2;
        Assertions.assertEquals(5, sum);
    }

    @Test
    public void test2() {
        System.out.println("test2");
        int multi = 2 * 3;
        Assertions.assertEquals(6, multi);
    }

    @Test
    public void test3() {
        Assertions.assertEquals(4, MyUtils.sum(2, 2));
        Assertions.assertEquals(5, MyUtils.sum(2, 3));
        Assertions.assertEquals(15, MyUtils.sum(12, 3));
        Assertions.assertEquals(18, MyUtils.sum(5, 13));
    }

    @Test
    public void test4() {
        MyUtils my = new MyUtils();
        Assertions.assertEquals(4, my.multi(2, 2));
        Assertions.assertEquals(6, my.multi(3, 2));
        Assertions.assertEquals(15, my.multi(5, 3));
        Assertions.assertEquals(30, my.multi(5, 6));
    }
}
