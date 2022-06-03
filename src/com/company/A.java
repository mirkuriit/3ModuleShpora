package com.company;

public class A {
    int a;
    B classB;

    public A(){
        classB = new B();
    }


    class B{
        enum Problems{
            EXAM,
            BIG_EXAM,
            VERY_BIG_EXAM
        }
        public static int c = 2;

        int b;
        public B(){
            b = 34;
        }

        public static void someFunc(){}
    }
}
