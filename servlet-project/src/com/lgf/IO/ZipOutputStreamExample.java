/**
 * 
 */
package com.lgf.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author first
 *
 */
public class ZipOutputStreamExample {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        zipOutputStreamTest1(); 
        System.out.println("默认编码："+System.getProperty("file.encoding"));
    }
    
    /**
     * 压缩多个文件
     * @throws IOException
     */
    public static void zipOutputStreamTest1() throws IOException{
        //读取文件夹
        File file = new File("../spring-repository/IO/readFile");
        File zipFile = new File("../spring-repository/IO/zipFile/test.zip");
        InputStream input = null;
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(
                 zipFile),Charset.forName("utf-8"));
//        zipOut.putNextEntry(new ZipEntry(file.getName()));
        // 设置注释
        zipOut.setComment("hello");
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(int i=0;i<files.length;i++){
                input = new FileInputStream(files[i]);
                zipOut.putNextEntry(new ZipEntry(file.getName()
                        + File.separator +files[i].getName()));
                System.out.println(files[i].getName());
               int temp = 0;
                while((temp = input.read()) !=-1){
                    zipOut.write(temp);
                }
                input.close();
            }
        }
        zipOut.close();
    }
    
    public static void unZipOutputStreamTest2(){
        File file = new File("../spring-repository/IO/zipFile/test.zip")
    }

}
