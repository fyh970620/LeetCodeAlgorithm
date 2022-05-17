package cn.fyihan.temp;

import com.sun.glass.ui.Clipboard;

import java.util.ArrayList;
import java.util.List;

public class TestFirst {

   private String name1;

    public static void main(String[] args) {
        TestFirst testFirst = new TestFirst();
        System.out.println(testFirst.hashCode()+"==" + testFirst.getName1());
        testFirst.setName1("test");
        System.out.println(testFirst.hashCode()+"==" + testFirst.getName1());
    }



    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName1() {
        return name1;
    }
}
