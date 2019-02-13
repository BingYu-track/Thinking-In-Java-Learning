//: net/mindview/util/Directory.java
// Produce a sequence of File objects that match a
// regular expression in either a local directory,
// or by walking a directory tree.
package net.mindview.util;
import org.junit.Test;

import java.util.regex.*;
import java.io.*;
import java.util.*;

/**
* @Description: 目录工具类介绍
* @Author:hxw
* @Date:2019/2/13 17:08
*/
public final class Directory {

  /**
   * 产生由本地目录中的文件审查的File对象数组
   * @param dir 文件目录
   * @param regex 正则
   * @return
   */
  public static File[] local(File dir, final String regex) {
    return dir.listFiles(   //使用 File 的  File[] listFiles(FilenameFilter filter)方法 --返回满足过滤器的抽象路径名数组
            new FilenameFilter() {
      private Pattern pattern = Pattern.compile(regex);
      public boolean accept(File dir, String name) {
        return pattern.matcher(new File(name).getName()).matches();
        //File的 public String getName()方法 返回由此抽象路径名表示的文件或目录的名称,如果路径名名称序列为空，则返回空字符串
        //因此这里是用来对目录
      }
    });
  }

  public static File[] local(String path, final String regex) { // Overloaded
    return local(new File(path), regex); //调用上面的静态方法
  }

  // A two-tuple for returning a pair of objects:
  public static class TreeInfo implements Iterable<File> {
    public List<File> files = new ArrayList<File>();
    public List<File> dirs = new ArrayList<File>();

    // The default iterable element is the file list:
    public Iterator<File> iterator() {
      return files.iterator();
    }

    void addAll(TreeInfo other) {
      files.addAll(other.files);
      dirs.addAll(other.dirs);
    }

    public String toString() {
      return "dirs: " + PPrint.pformat(dirs) + "\n\nfiles: " + PPrint.pformat(files);
    }

  }


  public static TreeInfo walk(String start, String regex) { // Begin recursion
    return recurseDirs(new File(start), regex);
  }

  public static TreeInfo walk(File start, String regex) { // Overloaded
    return recurseDirs(start, regex);
  }

  public static TreeInfo walk(File start) { // Everything
    return recurseDirs(start, ".*");
  }

  public static TreeInfo walk(String start) {
    return recurseDirs(new File(start), ".*");
  }

  static TreeInfo recurseDirs(File startDir, String regex){
    TreeInfo result = new TreeInfo();
    for(File item : startDir.listFiles()) {
      if(item.isDirectory()) {
        result.dirs.add(item);
        result.addAll(recurseDirs(item, regex));
      } else if(item.getName().matches(regex)){
        result.files.add(item);
      }
    }
    return result;
  }

  // Simple validation test:
  public static void main(String[] args) {
    if(args.length == 0){
      System.out.println(walk("."));
    } else{
      for(String arg : args)
        System.out.println(walk(arg));
    }
  }

  @Test
  public void test(){
    File path = new File(".");
    Directory.local(path,"E0[12]_.*\\.java");
  }

} ///:~
