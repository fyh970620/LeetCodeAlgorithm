package cn.fyihan.temp;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.FilterReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class DriverCarSnd {

    public static void main(String[] args) {
       /* List<Fuji> list = new ArrayList<>();
        Fuji fuji = new Fuji();
        fuji.setName("aa");
        list.add(fuji);
        List<? extends Apple> test = list;
        Fruit a = list.get(0);
        Fuji b = list.get(0);
        Apple c = list.get(0);*/

        /*final Stream<String> stream = Stream.of("“Red”","”Blue”","”Green”");
        List<String> colors = stream. collection(Collector.toList());*/
        // FilterReader
       // FileInputStream
        //DataInputStream
        /*char ch = 10;
        ch +=ch;
        System.out.println(ch);*/
       /* String s = "\u0456789";
        System.out.println(s.length());
        System.out.println(s);

        char h = '\n';*/

        /*char alpha = 'A';
        int foo = 65;
        boolean trueExp = true;
        System.out.println(trueExp ? alpha : 0);-
        System.out.println(alpha);
        System.out.println(trueExp ? alpha : foo);*/

        /*List arrayList = new ArrayList();
        arrayList.add("aaaa");
        arrayList.add(100);
        System.out.println((String)arrayList.get(1));
        Object obj;
*/
      /*  byte b = 10;
        char c = '1';

        Integer a = 321;

        Integer h = 320;

        System.out.println(a);*/
        for(int i=0; i<5; ++i){
            System.out.println(i);
        }
    }
}
