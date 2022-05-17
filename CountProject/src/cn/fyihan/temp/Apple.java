package cn.fyihan.temp;

public class Apple extends Fruit{

    public void a(int a, String b){}

    public void a(String b, int a){}

    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.a(1,"2");
        try {
            // Error可以抛出也可以catch
            throw new OutOfMemoryError();
        }catch (OutOfMemoryError error){
           //
        }
    }
}
