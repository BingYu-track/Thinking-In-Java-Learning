package io;

import net.mindview.util.Directory;
import net.mindview.util.ProcessFiles;

import java.io.File;
import java.io.IOException;

/**
 * @version 1.0
 * @Description: 修改之前的ProcessFiles，使其匹配正则表达式，而不是扩展名
 * @author: hxw
 * @date: 2019/2/14 11:19
 */
public class ProcessFiles2 {

    private ProcessFiles.Strategy strategy;
    private String regex;

    public ProcessFiles2(ProcessFiles.Strategy strategy,String regex){
        this.strategy = strategy;
        this.regex = regex;
    }

    public void start(String[] args) {
        try {
            if(args.length == 0){
                processDirectoryTree(new File(".")); //没有参数，处理当前目录下所有的目录和文件
            }else{ //有参数
                for(String arg : args) { //遍历参数
                    File fileArg = new File(arg);
                    if(fileArg.isDirectory()){ //如果该参数是目录，继续调用processDirectoryTree()方法处理下面的所有文件
                        processDirectoryTree(fileArg);
                    }else if(arg.matches(regex)){ //执行到这，说明参数是文件并与正则进行匹配
                        strategy.process(new File(arg).getCanonicalFile());
                    }
                }

            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void processDirectoryTree(File root) throws IOException {
        Directory.TreeInfo files = Directory.walk(root.getAbsolutePath(), regex);//获取根目录下所有匹配regex的文件
        for(File file : files){
            strategy.process(file.getCanonicalFile()); //file.getCanonicalFile() 返回此抽象路径名的规范形式
        }
    }

    public static void main(String[] args){
        ProcessFiles2 pf = new ProcessFiles2(new ProcessFiles.Strategy() {
            public void process(File file) {
                System.out.println(file);
            }
        }, ".*\\.java"); //这个正则是表示:所有以.java结尾的路径
        pf.start(args);
    }
}
