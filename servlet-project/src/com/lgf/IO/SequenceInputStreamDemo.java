/**
 * 
 */
package com.lgf.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * @author first
 *
 */
public class SequenceInputStreamDemo {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
       ByteToCharacter2();
//       System.out.println(File.separator);//\
//       System.out.println(File.pathSeparator);//;
//       System.out.println("默认编码："+System.getProperty("file.encoding"));
    }
    /**
     * 将字节输出流转化为字符输出流
     * @throws IOException 
     */
    protected static void ByteToCharacter1() throws IOException{
        String fileName = "../spring-repository/IO/hello.txt";
        File file=new File(fileName);
        Writer out=new OutputStreamWriter(new FileOutputStream(file));
        out.write("HELLO");
        out.close();
        
    }
    
    /**
     * 将字节输入流转为字符输入流
     * @throws IOException 
     */
    protected static void ByteToCharacter2() throws IOException{
        String fileName = "../spring-repository/IO/hello.txt";
        File file = new File(fileName);
        Reader reader = new InputStreamReader(new FileInputStream(file));
        char[] b = new char[100];
        int len = reader.read(b);
        System.out.println(new String(b,0,len));
        reader.close();
    }
    
    

}
