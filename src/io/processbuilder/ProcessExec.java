package io.processbuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/3/19 16:41
 */
public class ProcessExec {

    private Process process;

    public void execute() throws InterruptedException, IOException {
        List<String> command = new ArrayList<String>();
        command.add("cmd.exe");
        command.add("/c");
        command.add("ipconfig -all");

// 执行命令
        ProcessBuilder pb = new ProcessBuilder(command);
        process = pb.start();

// 异步读取子进程输出
        InputStream inputStream = process.getInputStream();
        InputStream errorStream = process.getErrorStream();

        ExecutorService service = Executors.newFixedThreadPool(2);

        ResultStreamHandler inputStreamHandler = new ResultStreamHandler(inputStream);
        ResultStreamHandler errorStreamHandler = new ResultStreamHandler(errorStream);

        service.execute(inputStreamHandler);
        service.execute(errorStreamHandler);

        process.waitFor();
        service.shutdownNow();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessExec processExec = new ProcessExec();
        processExec.execute();
    }
}
