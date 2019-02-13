package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/13 14:27
 */
public class SortedDirList {

    private File path;

    public SortedDirList(){
        this.path = new File(".");
    }

    public SortedDirList(File path){
        this.path = path;
    }

    public String[] list(){
        String[] list = path.list();
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        return list;
    }

    //返回当前文件路径下与正则匹配的文件
    public String[] list(String regex){
        String[] list = path.list(
                new FilenameFilter() {
                    private Pattern pattern = Pattern.compile(regex);

                    @Override
                    public boolean accept(File dir, String name) {
                        boolean matches = pattern.matcher(name).matches();
                        return matches;
                    }
                });
        return list;
    }


}
