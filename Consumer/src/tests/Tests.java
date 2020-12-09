package tests;

import fizzbuzz.KafkaConsumer;
import org.junit.Assert;
import org.junit.Test;

public class Tests {
    @Test
    public void fizzBuzzTest(){
        KafkaConsumer t = new KafkaConsumer();
        Assert.assertEquals(t.fizzBuzz("1"), "1");
        Assert.assertEquals(t.fizzBuzz("2"), "2");
        Assert.assertEquals(t.fizzBuzz("3"), "Fizz");
        Assert.assertEquals(t.fizzBuzz("4"), "4");
        Assert.assertEquals(t.fizzBuzz("5"), "Buzz");
        Assert.assertEquals(t.fizzBuzz("6"), "Fizz");
        Assert.assertEquals(t.fizzBuzz("7"), "7");
        Assert.assertEquals(t.fizzBuzz("8"), "8");
        Assert.assertEquals(t.fizzBuzz("9"), "Fizz");
        Assert.assertEquals(t.fizzBuzz("10"), "Buzz");
        Assert.assertEquals(t.fizzBuzz("11"), "11");
        Assert.assertEquals(t.fizzBuzz("12"), "Fizz");
        Assert.assertEquals(t.fizzBuzz("13"), "13");
        Assert.assertEquals(t.fizzBuzz("14"), "14");
        Assert.assertEquals(t.fizzBuzz("15"), "FizzBuzz");
    }
}
