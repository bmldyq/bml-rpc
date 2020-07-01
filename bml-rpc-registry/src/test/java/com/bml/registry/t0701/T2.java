package com.bml.registry.t0701;

public class T2 {


    public static void main(String[] args) {
    T2 t2 = new T2();
    t2.test();

    }

    private void test(){
        T1 t = new T1();
                Object msg = t.getMsg();
        System.out.println("调用前msg="+msg);
        t.df();
        System.out.println("调用后msg="+t.getMsg());
    }
}
