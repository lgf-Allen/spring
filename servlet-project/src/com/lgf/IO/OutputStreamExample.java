/**
 * 
 */
package com.lgf.IO;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author first
 *
 */
public class OutputStreamExample {

    public static void main(String[] args) throws IOException {
//        fileOutputStreamTest();
        DataOutputStreamTest();
    }
    

    /**逐字节写入文件，文件内容追加
     * @param args
     * @throws IOException 
     */
    public static void  fileOutputStreamTest() throws IOException{
        File file = new File("../spring-repository/IO/readFile/file1.txt");
        OutputStream out = new FileOutputStream(file,true);//true表示在文件后面追加
        String str = "追加内容";
        byte[] b = str.getBytes();
        for(int i=0; i<b.length;i++){
            out.write(b[i]);
        }
        System.out.println(new String(b));
        out.close();
    }

    /**
     * DataOutputStream类示例
     * @throws IOException
     */
    public static void DataOutputStreamTest() throws IOException{
        File file = new File("../spring-repository/IO/readFile/file1.txt");
        DataOutputStream out = new DataOutputStream(new FileOutputStream(file,true));
        String str = "\r\n追加内容222";
        byte[] b = str.getBytes();
        for(int i=0; i<b.length;i++){
            out.write(b[i]);
        }
        System.out.println(new String(b));
        out.close();
    }
}
