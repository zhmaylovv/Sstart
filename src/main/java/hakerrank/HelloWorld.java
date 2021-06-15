//package hello;
//
//import javax.print.DocFlavor;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReadWriteLock;
//import java.util.concurrent.locks.ReentrantLock;
//import java.util.concurrent.locks.ReentrantReadWriteLock;
//
//public class HelloWorld extends Thread{
//    public static List<String> arr = new ArrayList<String>();
//    public static ReadWriteLock lock = new ReentrantReadWriteLock();
//    public static void main(String[] args) throws InterruptedException {
//        Thread thread1= new HelloWorld();
//        Thread thread2= new HelloWorld();
//        Thread thread3= new HelloWorld();
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        Thread.sleep(400);
//        for (String i : arr){
//            System.out.println(i);
//        }
//
//    }
//
//    @Override
//    public void run() {
//        lock.writeLock().lock();
//        for (int i = 0; i < 100; i++) {
//            arr.add(currentThread().getName() + i);
//        lock.writeLock().unlock();
//        }
//    }
//}
