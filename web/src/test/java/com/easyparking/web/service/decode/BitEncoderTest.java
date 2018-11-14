package com.easyparking.web.service.decode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BitEncoderTest {

    @Parameterized.Parameters
    public static Collection<Byte[]> data() {
        return Arrays.asList(new Byte[][] {
                { 32, 6, 0 },           //00100000
                { 32, 7, 0},            //00100000
                { (byte) 128, 6, 0 },   //10000000
                { (byte) 128, 7, 1},    //10000000
                { 64, 6, 1 },           //01000000
                { 64, 7, 0},            //01000000
                { (byte) 192, 6, 1 },   //11000000
                { (byte) 192, 7, 1},    //11000000
                { (byte) 224, 6, 1 },   //11100000
                { (byte) 224, 7, 1},    //11100000
        });
    }

    private byte value;
    private byte position;
    private int expected;

    public BitEncoderTest(byte value, byte position, int expected) {
        this.value = value;
        this.position = position;
        this.expected = expected;
    }

    @Test
    public void encodesParticularBitsFromByte() {
        assertEquals(expected, BitEncoder.getBit(value, position));
    }
}
