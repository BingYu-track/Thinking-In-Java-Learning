package io;

import net.mindview.util.OSExecuteException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/24 17:50
 */
public class OSExecute2 {

    public static List<String> command(String command) {
        boolean err = false;
        List<String> output = new LinkedList<String>();
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(
                                        new InputStreamReader(process.getInputStream()));
            String s;
            while((s = results.readLine()) != null){
                output.add(s);
            }
            BufferedReader errors = new BufferedReader(
                                        new InputStreamReader(process.getErrorStream()));
// Report errors and return nonzero value to calling process if there are problems:
            while((s = errors.readLine()) != null) {
                System.err.println(s);
                err = true;
            }
        } catch(IOException e) {
            if(!command.startsWith("CMD /C"))
                return command("CMD /C " + command);
            throw new RuntimeException(e);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        if(err)
            throw new OSExecuteException("Errors executing " + command);
        return output;
    }
}
