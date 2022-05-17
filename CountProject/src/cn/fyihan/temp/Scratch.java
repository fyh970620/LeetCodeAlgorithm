package cn.fyihan.temp;

import java.util.Iterator;
import java.util.TreeSet;

class Scratch extends Thread {
    private boolean stop = false;
    public static void main(String[] args) throws InterruptedException {
        /*Scratch t = new Scratch();
        t.start();
        Thread.sleep(3000);
        t.interrupt();
        Thread.sleep(3000);
        System.out.println("exit");*/
        /*int end = Integer.MAX_VALUE;
        int start = end - 50;
        System.out.println(start +"--" + end);
        for(int i =start; i<=end; i++){
            System.out.println("==>" +i);
        }

        Object[] array = new String[3];*/
        TreeSet dset = new TreeSet();
        dset.add(new Dog(2));
        dset.add(new Dog(1));
        dset.add(new Dog(3));
        Iterator iterator = dset.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next()+"");
        }

    }

    static class Dog{
        int size;
        public Dog(int s){
            size = s;
        }

        @Override
        public String toString() {
            return "Dog{" + "size=" + size + '}';
        }
    }

    @Override
    public void run(){
        while(!stop){
            System.out.println("running");
            try{
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("stop");
    }
}
