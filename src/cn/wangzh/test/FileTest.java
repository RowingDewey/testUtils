package cn.wangzh.test;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class FileTest
{
    public static void main(String[] args)
    {
        // 创建文件选择器
        JFileChooser fileChooser = new JFileChooser();
        // 设置当前目录
        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        final String[][] fileENames = {{".java", "JAVA源程序 文件(*.java)"},
            {".xml", ".xml"}};

        // 显示所有文件
        fileChooser.addChoosableFileFilter(new FileFilter()
        {
            public boolean accept(File file)
            {
                return true;
            }

            public String getDescription()
            {
                return "所有文件(*.*)";
            }
        });

        // 循环添加需要显示的文件
        for (final String[] fileEName : fileENames)
        {

            fileChooser.setFileFilter(new FileFilter()
            {

                public boolean accept(File file)
                {

                    if (file.getName().endsWith(fileEName[0])
                        || file.isDirectory())
                    {

                        return true;
                    }

                    return false;
                }

                public String getDescription()
                {

                    return fileEName[1];
                }

            });
        }

        fileChooser.showDialog(null, null);
    }
}