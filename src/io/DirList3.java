package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @Description: 继续改进DirList2
 * @author: hxw
 * @date: 2019/2/13 10:48
 */
public class DirList3 {

    public static void main(final String[] args) {
        File path = new File(".");
        String[] list;
        if(args.length == 0){
            list = path.list();
        }else{
            list = path.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(args[0]);
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list)
            System.out.println(dirItem);
    }
    /*
        这样使用匿名内部类能一次性，解决问题，将解决特定问题的代码隔离、聚拢与一点；但是这样做是不方便阅读，因此需要小心使用
    */
}
