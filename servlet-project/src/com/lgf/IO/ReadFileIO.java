/**
 * 
 */
package com.lgf.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author first
 * 字节流读取文件
 */
public class ReadFileIO {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        readFile4();
        
    }
    
    /**
     * 该示例中由于b字节数组长度为1024，如果文件较小，则会有大量填充空格。
     * 我们可以利用in.read(b);的返回值来设计程序
     * @throws IOException
     */
    protected static void readFile1() throws IOException{
        String fileName = "../spring-repository/IO/readFile/file1.txt";
        File file = new File(fileName);
        InputStream in = new FileInputStream(file);
        byte[] b = new byte[1024];
        in.read(b);
        in.close();
        System.out.println(new String(b));
    }

    /**
     * 例子可以看出，我们预先申请了一个指定大小的空间，但是有时候这个空间可能太小，
     * 有时候可能太大，我们需要准确的大小，这样节省空间
     * @throws IOException
     */
    protected static void readFile2() throws IOException{
        String fileName = "../spring-repository/IO/readFile/file1.txt";
        File file = new File(fileName);
        InputStream in = new FileInputStream(file);
        byte[] b = new byte[1024];
        int len = in.read(b);
        in.close();
        System.out.println(new String(b,0,len));
    }
    /**
     * 
     * @throws IOException
     */
    protected static void readFile3() throws IOException{
        String fileName = "../spring-repository/IO/readFile/file1.txt";
        File file = new File(fileName);
        InputStream in = new FileInputStream(file);
        byte[] b = new byte[(int)file.length()];
        in.read(b);
        in.close();
        System.out.println(new String(b));
    }
    
    /**
     * 按字节读取
     * @throws IOException
     */
    protected static void readFile4() throws IOException{
        String fileName = "../spring-repository/IO/readFile/file1.txt";
        File file = new File(fileName);
        InputStream in = new FileInputStream(file);
        byte[] b = new byte[(int)file.length()];
        for(int i = 0 ;i<b.length;i++){
            b[i] = (byte) in.read();
        }
        in.close();
        System.out.println(new String(b));
    }
}
