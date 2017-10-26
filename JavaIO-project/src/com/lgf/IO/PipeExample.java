/**
 * 
 */
package com.lgf.IO;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author first
 *
 */
public class PipeExample {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        final PipedOutputStream output = new PipedOutputStream();
        final PipedInputStream input = new PipedInputStream(output);
        
        Thread thread1 = new Thread(new Runnable() {
            
            @Override
            public void run() {
                try{
                    output.write("Hello,Allen".getBytes());
                    output.close();
                }catch(IOException e){
                    System.out.println(e.getMessage());
                }
            }
        });
        
        Thread thread2 = new Thread(new Runnable(){
            @Override
            public void run() {
                int data;
                try {
                    data = input.read();
                    while(data != -1){
                       System.out.print((char)data);
                       data=input.read();
                    }
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
            }
            
        });
        
        thread1.start();
        thread2.start();
        
    }

}
