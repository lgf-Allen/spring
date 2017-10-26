/**
 * 
 */
package com.lgf.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
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
//        unZipOutputStreamTest2();
        System.out.println("默认编码："+System.getProperty("file.encoding"));
    }
    
    /**
     * 压缩多个文件
     * @throws IOException
     */
    public static void zipOutputStreamTest1() throws IOException{
        //读取文件夹
        File file = new File("../spring-repository/IO/readFiles");
        //创造一个压缩文件
        File zipFile = new File("../spring-repository/IO/zipFiles/test.zip");
        InputStream input = null;
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(
                 zipFile),Charset.forName("utf-8"));
//        zipOut.putNextEntry(new ZipEntry(file.getName()));
        // 设置注释
        zipOut.setComment("hello");
        //遍历文件夹下的文件
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
    
    /**
     * 解压文件
     * @throws ZipException
     * @throws IOException
     */
    @SuppressWarnings("static-access")
    public static void unZipOutputStreamTest2() throws ZipException, IOException{
        //读取一个已存在的压缩文件
        File file = new File("../spring-repository/IO/zipFiles/test.zip");
        ZipFile zipFile = new ZipFile(file);
        File outFile = null;
        ZipInputStream zipInput = new ZipInputStream(new FileInputStream(file));
        ZipEntry entry = null;
        InputStream input = null;
        OutputStream output = null;
        //遍历压缩包中的文件
        while((entry = zipInput.getNextEntry()) != null){
            System.out.println("解压缩" + entry.getName() + "文件");
            //指定解压后的文件的文件名
            outFile = new File("../spring-repository/IO/unZipFiles"+file.separator+entry.getName());
            //判断压缩文件所在的目录是否存在，不存在则创建
            if(!outFile.getParentFile().exists()){
                outFile.getParentFile().mkdir();
            }
            //判断压缩文件是否存在，不存在则创建
            if(!outFile.exists()){
                outFile.createNewFile();
            }
            //将压缩包中文件的内容写入字节输入流
            input = zipFile.getInputStream(entry);
            output = new FileOutputStream(outFile);
            int temp = 0;
            //将压缩包内容的字节输入流输出到字节输出流，即写入到内存中
            while((temp = input.read())!=-1){
                output.write(temp);
            }
            zipFile.close();
            zipInput.close();
            input.close();
            output.close();
        }
    }

}
