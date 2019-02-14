package io;

import java.io.File;

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
        if(args[0].equals("-r")) { //如果args[0]=-r 并且参数列表长度不等于3
            if(args.length != 3) {
                usage(); //
            }
            File old = new File(args[1]), rname = new File(args[2]); //将
            old.renameTo(rname);
            fileData(old);
            fileData(rname);
            return; // Exit main
        }
        int count = 0; //
        boolean del = false; //
        if(args[0].equals("-d")) { //如果args[0] = -d 则
            count++;
            del = true;
        }
        count--;
        while(++count < args.length) {
            File f = new File(args[count]); //用传入的参数创建File
            if(f.exists()) { //文件是否存在
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

}
