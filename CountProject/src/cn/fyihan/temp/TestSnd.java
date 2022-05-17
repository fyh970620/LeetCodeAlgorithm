package cn.fyihan.temp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TestSnd {

    private String name;

    public TestSnd(){
        super();
        name = "testSnd";
    }

    @Override
    public String toString() {
        return name.toUpperCase();
    }

    public static void main(String[] args) throws IOException {
        //TestSnd testSnd = new TestSnd();

        Integer n1 = 100;
        Integer n2 = 100;
        Integer n3 = 100;
        Integer n4 = 100;
        System.out.println(n1==n2);
        System.out.println(n3==n4);

        int[][] a = new int[10][];

        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\f30027415\\Desktop\\a.txt",true);
        outputStream.write("ABCD".getBytes(StandardCharsets.UTF_8));
        outputStream.close();
    }

    public void A(int a){

    }

    public void A(Integer a){

    }
}
