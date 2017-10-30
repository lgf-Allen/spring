/**
 * 
 */
package com.lgf.IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.SequenceInputStream;
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
        SequenceInputStreamTest();
    }
    
    protected static void SequenceInputStreamTest() throws IOException{
        File file1 = new File("../spring-repository/IO/readFiles/file1.txt");
        File file2 = new File("../spring-repository/IO/readFiles/file2.txt");
        File file3 = new File("../spring-repository/IO/readFiles/file3.txt");
        FileInputStream out1 = new FileInputStream(file1);
        FileInputStream out2 = new FileInputStream(file2);
        SequenceInputStream sis = new SequenceInputStream(out1, out2);
        OutputStream out = new FileOutputStream(file3);
        int temp = 0;
        while((temp = sis.read())!=-1){
            out.write(temp);
        }
        out1.close();
        out2.close();
        sis.close();
        out.close();
        
    }

}
