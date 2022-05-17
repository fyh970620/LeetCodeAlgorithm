package cn.fyihan.temp;

public class SwitchTest {

    public static void main(String[] args) {
        switchTest(null);
    }

    public static void switchTest(String str){
        switch (str) {
            case "null":
                System.out.println("----1");
                break;
            default:
                System.out.println("----2");
        }
    }
}
