package com.company;

import org.opencv.core.Core;

import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        File file = null;
        PrintWriter printWriter = null;
        try {
//            Throwable t = new RuntimeException();
//            throw t;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("я родился");
        }

        try {
            file = new File(
                    "C:\\Users\\devepa\\IdeaProjects\\training in\\untitled\\src\\com\\company\\prinwriter.txt"
            );// создание файла
            FileWriter fr = new FileWriter(file); //созданеи потока
            printWriter = new PrintWriter(fr); //Создали файл
            printWriter.println("println"); //пишем пишем
            printWriter.print("print");
            printWriter.append("append");
            printWriter.println("println2");
            printWriter.append("append2");
            printWriter.print("print2");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            printWriter.close(); // Закрываем поток
        }

        Scanner sc = new Scanner(file);//файл, уже был давно создан, привязываем его к сканеру
        String s = "";
        while (sc.hasNext()){
            s += sc.next() + " "; //читаем читаем
        }
        System.out.println(s);
        showThreadSynchronizedWork();
        //showRunnableInterfaceWork();





//        try {
//            FileInputStream fis = new FileInputStream("C:\\Users\\devepa\\IdeaProjects\\training in\\untitled\\src\\com\\company\\a.txt");
//            FileOutputStream fos = new FileOutputStream("C:\\Users\\devepa\\IdeaProjects\\training in\\untitled\\src\\com\\company\\b.txt");
//
//            int c;
//            while ((c = fis.read()) > -1){
//                fos.write(c);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //******************Анонимные и внутренние классы****************
        A a = new A();
        A.B classB = a.new B();
    }
    public static void  showThreadSynchronizedWork() throws InterruptedException {
        class AnotherThread extends Thread{
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 20; i++) {
                        Thread.sleep(1000);
                        System.out.println("1 seconds");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        AnotherThread anotherThread = new AnotherThread();
        anotherThread.start();

        synchronized (System.out){
            for (int i = 0; i < 5; i++) {
                Thread.sleep(4000);
                System.out.println("4 seconds");
            }
        }





    }
    public static void showRunnableInterfaceWork() throws InterruptedException {
        class noRunPLease implements Runnable{
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("you know blin");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        Thread t = new Thread(new noRunPLease());
        t.start();
        for (int i = 0; i < 20; i++) {
            Thread.sleep(1000);
            System.out.println("ya ne know blin");
        }
    }
    public void getFileInfo(String fileName){
        File file = new File(fileName);
        System.out.println(file.length());
        System.out.println(file.getAbsolutePath());

    }
    public void anonimCLass(){
        class InfoService {
            class Paper {
                public String title;
                public int sheets;
            }
            /*...*/
        }
        InfoService i = new InfoService();
        InfoService.Paper vesti = i.new Paper();
    }
    public void ex10(){
        class NumberPhone {
            String phone;
            public NumberPhone(String phone){
                this.phone = phone;
            }
            public boolean validate(){
                return String.valueOf(phone.charAt(0)).equals("+") && String.valueOf(phone.charAt(1)).equals("7")
                        && phone.length() == 12;
            }
        }
    }



    public static int[] arrayDiff(int[] a, int[] b) {
        ArrayList<Integer> arrayListA = new ArrayList<>();
        ArrayList<Integer> arrayListB = new ArrayList<>();
        for (int aelem: a) {
            arrayListA.add(aelem);
        }
        for (int aelem: b) {
            arrayListB.add(aelem);
        }
        for (int i = 0; i < arrayListA.size(); i++) {
            if (arrayListB.contains(arrayListA.get(i))){
                arrayListA.remove(arrayListA.get(i));
                i = -1;
            }
        }
        int[] aa = new int[arrayListA.size()];
        for (int i = 0; i < aa.length; i++) {
            aa[i] = arrayListA.get(i);
        }

        return aa;
    }

}
