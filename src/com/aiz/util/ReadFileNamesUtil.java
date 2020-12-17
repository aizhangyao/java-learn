package com.aiz.util;

import java.io.File;
import java.util.*;

/**
 * @ClassName ReadFileUtils
 * @Description
 * @Author Yao
 * @Date Create in 11:21 下午 2020/12/14
 * @Version 1.0
 */
public class ReadFileNamesUtil {

    public static List<String> queryFileNames(String filePath){
        List results = new ArrayList<String>();
        File f = new File(filePath);
        File[] ts = f.listFiles();
        for (int i = 0; i < ts.length; i++) {
            if(ts[i].isFile()&&ts[i].getName().endsWith(".mp4")){
                results.add(ts[i].getName()+"  ");
            }
        }
        return results;
    }

    public static void main(String[] args) {
        final String filePath1 = "/Users/zhangyao/谷粒商城/分布式高级篇";
        final String filePath2 = "/Users/zhangyao/谷粒商城/高可用集群篇";
        List<String> results = queryFileNames(filePath2);
        Collections.sort(results, Comparator.naturalOrder());

        for (String result : results) {
            System.out.println(result);
        }

    }
}
