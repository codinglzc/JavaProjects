package io.fileCls;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: lc
 * @Date: Created in 2018-05-30
 */
public class DirList
{
    private static class DirFilter implements FilenameFilter
    {
        private Pattern pattern;

        public DirFilter(String regex)
        {
            this.pattern = Pattern.compile(regex);
        }

        @Override
        public boolean accept(File dir, String name)
        {
            return pattern.matcher(name).matches();
        }
    }

    public static void main(String[] args)
    {
        File path = new File(".");
        String[] list = path.list();    // 获得此File对象包含的全部列表
        for (String s : list)
        {
            System.out.print(s);
        }
        System.out.println();

        list = path.list(new DirFilter("^(Dir)\\w*")); // 添加了筛选回调
        for (String s : list)
        {
            System.out.print(s);
        }
        System.out.println();

        list = path.list(new FilenameFilter()   // 采用匿名内部类形式
        {
            private Pattern pattern = Pattern.compile("^(.idea)\\w*");

            @Override
            public boolean accept(File dir, String name)
            {
                return pattern.matcher(name).matches();
            }
        });
        for (String s : list)
        {
            System.out.print(s);
        }
        System.out.println();
    }
}
