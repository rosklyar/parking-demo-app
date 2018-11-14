package com.easyparking.web.service.decode;

public class BitEncoder {

    public static int getBit(byte value, int position) {
        return (value >> position) & 1;
    }
}
