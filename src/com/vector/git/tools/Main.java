package com.vector.git.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * author: vector.huang
 * date：2016/3/21 9:48
 */
public class Main {

    public static String config = "[core]\n" +
            "\trepositoryformatversion = 0\n" +
            "\tfilemode = false\n" +
            "\tbare = false\n" +
            "\tlogallrefupdates = true\n" +
            "\tsymlinks = false\n" +
            "\tignorecase = true\n" +
            "\thideDotFiles = dotGitOnly\n" +
            "[remote \"origin\"]\n" +
            "\turl = https://github.com/VectorWen/?.git\n" +
            "\turl = https://git.coding.net/Vector/?.git\n"+
            "[branch \"master\"]\n" +
            "\tremote = origin\n" +
            "\tmerge = refs/heads/master";

    static String repositoryName;
    static String pathname = "e:/";


    public static void main(String[] args) throws IOException {

        if (args == null || args.length == 0) {
            System.out.println("有病是不是，仓库名都输入了");
        }

        repositoryName = args[0];
        config = config.replace("?",repositoryName);

        if (args.length > 1) {
            pathname = args[1];
        }

        pathname += "config";

        File configFile = new File(pathname);
        if (configFile.exists()) {
            configFile.delete();
            System.out.println("已删除文件："+pathname);
        }
        configFile.createNewFile();
        System.out.println("已创建文件："+pathname);

        FileOutputStream out = new FileOutputStream(configFile);
        PrintStream print = new PrintStream(out);
        print.print(config);
        print.flush();
        print.close();

        System.out.println("完成");
    }

}
