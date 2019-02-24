package net.mindview.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/24 17:00
 */
public class OSExecute {

  public static void command(String command) {
    boolean err = false;
    try {
      Process process = new ProcessBuilder(command.split(" ")).start(); //用指定的操作系统程序和参数构造一个进程生成器
      BufferedReader results = new BufferedReader(
              new InputStreamReader(process.getInputStream())); //process.getInputStream()获取子进程的输入流
      String s;
      while((s = results.readLine())!= null){
        System.out.println(s);
      }
      BufferedReader errors = new BufferedReader(
              new InputStreamReader(process.getErrorStream())); //获取子进程的错误流
      // Report errors and return nonzero value to calling process if there are problems: 报告错误，如果有问题，将非零值返回到调用进程
      while((s = errors.readLine())!= null) {
        System.err.println(s);
        err = true;
      }
    } catch(Exception e) {
      // Compensate for Windows 2000, which throws an exception for the default command line:
      if(!command.startsWith("CMD /C"))
        command("CMD /C " + command);
      else
        throw new RuntimeException(e);
    }
    if(err)
      throw new OSExecuteException("Errors executing " + command);
  }

}
