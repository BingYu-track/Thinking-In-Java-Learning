package io.processbuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/3/19 16:46
 */
public class ResultStreamHandler implements Runnable{

    private InputStream inputStream;

    ResultStreamHandler( InputStream inputStream ) {
        this.inputStream = inputStream;
    }

    public void run() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader( inputStream ));
            String line = null;
            while ( ( line = bufferedReader.readLine() ) != null ) {
                System.out.println( line );
            }
        } catch (Throwable t) {

        }
        finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
            }
        }
    }


}
