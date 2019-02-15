package io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @version 1.0
 * @Description: 创建目录
 * @author: hxw
 * @date: 2019/2/14 14:32
 */
public class MakeDirectories {

    private static void usage() {
        System.err.println(
                        "Usage:MakeDirectories path1 ...\n" +
                        "Creates each path\n" +
                        "Usage:MakeDirectories -d path1 ...\n" +
                        "Deletes each path\n" +
                        "Usage:MakeDirectories -r path1 path2\n" +
                        "Renames from path1 to path2");
        System.exit(1);
    }

    private static void fileData(File f) {
        System.out.println(
                        "Absolute path: " + f.getAbsolutePath() +
                        "\n Can read: " + f.canRead() +
                        "\n Can write: " + f.canWrite() +
                        "\n getName: " + f.getName() +
                        "\n getParent: " + f.getParent() +
                        "\n getPath: " + f.getPath() +
                        "\n length: " + f.length() +
                        "\n lastModified: " + f.lastModified());
        if(f.isFile()){ //判断是否是文件
            System.out.println("It’s a file");
        } else if(f.isDirectory()){
            System.out.println("It’s a directory");
        }
    }

    //这里args[0]用来表示操作类型。-r"更名",-d删除,
    public static void main(String[] args) {
        if(args.length < 1){
            usage();
        }
        if(args[0].equals("-r")) { //如果args[0]=-r 并且参数列表长度不等于3,则调用usage退出程序
            if(args.length != 3) {
                usage(); //
            }
            File old = new File(args[1]), rname = new File(args[2]); //将第二，和第三个参数作为
            boolean b = old.renameTo(rname); //将旧的File(文件或目录)重新命名
            fileData(old);
            fileData(rname);
            return; // Exit main
        }
        int count = 0; //
        boolean del = false; //删除标志
        if(args[0].equals("-d")) { //如果args[0] = -d 则
            count++;
            del = true;
        }
        count--;
        while(++count < args.length) { //count先自增，在比较
            File f = new File(args[count]); //用传入的参数创建File
            if(f.exists()) { //文件或目录是否存在
                System.out.println(f + " exists");
                if(del) { //del = true，删除该File
                    System.out.println("deleting..." + f);
                    f.delete();
                }
            } else { // Doesn’t exist 执行到这说明文件不存在
                if(!del) { //如果del = false 创建目录
                    f.mkdirs(); //
                    System.out.println("created " + f);
                }
            }
            fileData(f);
        }
    }

    @Test
    public void test1(){
        File file = new File("D:\\Eclipse_Code\\ThinkInJava\\src\\io");
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath); // D:\Eclipse_Code\ThinkInJava\src\io
        File parent = file.getParentFile();
        System.out.println(parent.getName()); //src
    }

    @Test
    public void test2(){
        File file = new File(".");
        String absolutePath = file.getAbsolutePath(); //绝对路径名
        System.out.println(absolutePath); // D:\Eclipse_Code\ThinkInJava\src\io\.  与上面对比多一个.
        File parent = file.getParentFile(); // null
        System.out.println(parent.getName()); //报空指针异常
    }

    @Test
    public void test3() throws IOException {
        File file = new File(".");
        File canonicalFile = file.getCanonicalFile();  //File file=new File(".")获取的是当前目录的相对路径，要先将其转为绝对路径，然后才能再获取其父目录
        File parentFile = canonicalFile.getParentFile();
        System.out.println(parentFile.getName()); //报空指针异常
    }
}
