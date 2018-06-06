package io.fileCls;

import java.io.File;
import java.io.FilenameFilter;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @Description: Produce a sequence of File objects that match a regular expression in either a local directory,
 * or by walking a directory tree.
 * @Author: lc
 * @Date: Created in 2018-05-31
 */
public final class Directory
{
    public static File[] local(File dir, final String regex)
    {
        return dir.listFiles(new FilenameFilter()
        {
            private Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name)
            {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }

    public static File[] local(String path, final String regex)
    {
        return local(new File(path), regex);
    }

    public static class TreeInfo implements Iterable<File>
    {
        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();

        @Override
        public Iterator<File> iterator()
        {
            return files.iterator();
        }

        void addAll(TreeInfo other)
        {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        @Override
        public String toString()
        {
            return "dirs: " + PPrint.pformat(dirs) +
                    "\n\nfiles: " + PPrint.pformat(files);
        }
    }

    public static TreeInfo walk(String start, String regex)
    {
        return recurseDirs(new File(start), regex);
    }

    public static TreeInfo walk(File start, String regex)
    {
        return recurseDirs(start, regex);
    }

    public static TreeInfo walk(String start)
    {
        return recurseDirs(new File(start), ".*");
    }

    public static TreeInfo walk(File start)
    {
        return recurseDirs(start, ".*");
    }

    static TreeInfo recurseDirs(File startDir, String regex)
    {
        TreeInfo result = new TreeInfo();
        for (File item : startDir.listFiles())
        {
            if (item.isDirectory())
            {
                result.dirs.add(item);
                result.addAll(recurseDirs(item, regex));
            } else
            {
                if (item.getName().matches(regex))
                    result.files.add(item);
            }
        }
        return result;
    }

    public static class PPrint
    {
        public static String pformat(Collection<?> c)
        {
            if (c.size() == 0) return "[]";
            StringBuilder sb = new StringBuilder("[");
            for (Object elem : c)
            {
                if (c.size() != 1)
                    sb.append("\n   ");
                sb.append(elem);
            }
            if (c.size() != 1)
                sb.append("\n");
            sb.append("]");
            return sb.toString();
        }

        public static void pprint(Collection<?> c)
        {
            System.out.println(pformat(c));
        }

        public static void pprint(Object[] c)
        {
            System.out.println(pformat(Arrays.asList(c)));
        }
    }

    public static void main(String[] args)
    {
        if (args.length == 0)
            System.out.println(walk("."));
        else
            for (String arg : args)
                System.out.println(walk(arg));
    }

}
