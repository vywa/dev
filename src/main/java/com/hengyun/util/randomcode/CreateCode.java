package com.hengyun.util.randomcode;

import java.awt.Color;
import java.util.Random;

public class CreateCode {



public static Color getRandColor(int fc, int bc) {// 给定范围获得随机颜色
    Random random = new Random();
    if (fc > 255)
        fc = 255;
    if (bc > 255)
        bc = 255;
    int r = fc + random.nextInt(bc - fc);
    int g = fc + random.nextInt(bc - fc);
    int b = fc + random.nextInt(bc - fc);
    return new Color(r, g, b);
}

public static  char getSingleNumberChar() {
    Random random = new Random();
    int numberResult = random.nextInt(10);
    int ret = numberResult + 48;
    return (char) ret;
}

public static  char getLowerOrUpperChar(int upper) {
    Random random = new Random();
    int numberResult = random.nextInt(26);
    int ret = 0;
    if (upper == 0) {// 小写
        ret = numberResult + 97;
    } else if (upper == 1) {// 大写
        ret = numberResult + 65;
    }
    return (char) ret;
}
}
