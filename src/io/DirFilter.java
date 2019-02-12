package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @Description: FilenameFilter
 * @author: hxw
 * @date: 2019/2/12 11:29
 */
class DirFilter implements FilenameFilter {

    private Pattern pattern;
    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches(); //整体匹配，没有匹配返回false
    }
}
