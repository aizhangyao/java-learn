package com.aiz.jvm;

public class ClassLoaderTest {
    /**
     * 类加载器
     */
    public static void main_2(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());

        //sun.misc.Launcher$AppClassLoader@18b4aac2
        //sun.misc.Launcher$ExtClassLoader@45ee12a7
        //null
    }

}
