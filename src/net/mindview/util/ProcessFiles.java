//: net/mindview/util/ProcessFiles.java
package net.mindview.util;
import java.io.*;

/**
* @Description:
* @Author:hxw
* @Date:2019/2/13 22:09
*/
public class ProcessFiles {

  public interface Strategy {
    void process(File file);
  }

  private Strategy strategy;//策略
  private String ext;
  public ProcessFiles(Strategy strategy, String ext) {
    this.strategy = strategy;
    this.ext = ext;
  }

  public void start(String[] args) {
    try {
      if(args.length == 0){
        processDirectoryTree(new File(".")); //处理当前目录下所有的目录和文件
      }else{
        for(String arg : args) { //遍历参数
          File fileArg = new File(arg);
          if(fileArg.isDirectory()){ //如果是目录，继续调用processDirectoryTree()方法处理下面的所有文件
            processDirectoryTree(fileArg);
          }else { //如果不是目录
            // Allow user to leave off extension:
            if(!arg.endsWith("." + ext)) //判断当前参数是否与 .ext结尾，不是就添加该扩展名
              arg += "." + ext;
            strategy.process(new File(arg).getCanonicalFile());
          }
        }

      }
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void processDirectoryTree(File root) throws IOException {
    Directory.TreeInfo files = Directory.walk(root.getAbsolutePath(), ".*\\." + ext);//获取根目录下所有以.ext变量值结尾的文件
    for(File file : files){
      strategy.process(file.getCanonicalFile()); //file.getCanonicalFile() 返回此抽象路径名的规范形式
    }
  }

  // Demonstration of how to use it:
  public static void main(String[] args) {
    //匿名内部类实现Strategy接口(处理指定的扩展名文件)，由于ProcessFiles只有带参构造，因此参数1：它强制你实现Strategy接口来定义"如何处理文件"；
    //参数2：是定义你想要处理的文件的后缀名
    ProcessFiles pf = new ProcessFiles(new Strategy() {
              public void process(File file) {
                System.out.println(file);
              }
            }, "java");
    pf.start(args);
  }

} /* (Execute to see output) *///:~
