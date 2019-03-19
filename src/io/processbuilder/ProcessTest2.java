package io.processbuilder;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/3/19 17:17
 */
public class ProcessTest2 {
    private static final Logger logger = Logger.getGlobal();//日志记录器

    public static void main(String[] args) throws IOException {
        List<String> paramList = new ArrayList<>();
        //使用 cmd 命令 ping 远程主机
        //第一个参数必须是可执行程序,cmd也是一个可执行程序，位于 C:/Windows/System32目录下
        paramList.add("cmd");
        paramList.add("/c");
        paramList.add("ping www.taobao.com");//也可以是ip，如 paramList.add("ping 114.114.114.114");

        /** 创建ProcessBuilder对象，设置指令列表*/
        ProcessBuilder processBuilder = new ProcessBuilder(paramList);

        //获取桌面路径
        File desktopFile = FileSystemView.getFileSystemView().getHomeDirectory();

        //创建子进程输出信息的存放文件，文件不存在时，会自动创建
        File outputFile = new File(desktopFile, "output.txt");
        //返回此流程构建器的标准输出目标,意思是将来输出信息全部放在这个目标中
        processBuilder = processBuilder.redirectOutput(outputFile);
        processBuilder.start();//启动进程构建器
        logger.info("子进程执行消息存放在：" + processBuilder.redirectOutput().file().getPath());
    }

}
