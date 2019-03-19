package io.processbuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @version 1.0
 * @Description: 启动 windows 自带的计算器
 * @author: hxw
 * @date: 2019/3/19 16:58
 */
public class ProcessTest {
    private static final Logger logger = Logger.getGlobal();//日志记录器

    public static void main(String[] args) {
        try {
            List<String> paramList = new ArrayList<>();
            //启动 windows 的计算器程序，第一个参数必须是可执行程序
            //paramList.add("C:\\Windows\\System32\\calc.exe");
            //启动 windows 上安装好的 Media Player 播放器，设置 exe 路径，路径必须存在
            paramList.add("C:\\Program Files\\Windows Media Player\\wmplayer.exe");
            //设置 Media Player 将要播放的文件，也就是给 Media Player 传递的参数，文件必须存在
            paramList.add("E:\\娱乐\\视频\\泡泡浴\\JVID顶级女神之夜火辣泡泡浴 [MP4-659MB]\\JVID顶级女神之夜火辣泡泡浴.mp4");
            /** 创建ProcessBuilder对象，设置指令列表*/
            ProcessBuilder processBuilder = new ProcessBuilder(paramList);
            logger.info("启动子进程...");
            Process process = processBuilder.start();
            logger.info("子进程启动完成...");
            logger.info("子进程启动完成...");
            for (int i = 5; i > 0; i--) {
                logger.info((i) + " 秒后结束子进程...");
                Thread.sleep(1000);
            }
            process.destroyForcibly();//强行终结开启的子进程
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
