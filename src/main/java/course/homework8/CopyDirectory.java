package course.homework8;

import java.io.*;

public class CopyDirectory {
    public static void run() {
        try {
            copyFileOrDir(System.getProperty("user.dir") + "/src/main/java/course/homework8/sourceDir", System.getProperty("user.dir") + "/src/main/java/course/homework8/target");
        } catch (Exception e) {
            System.out.print(e);
        }
    }


    public static void copyFileOrDir(String sourcePath, String targetPath) throws IOException {
        File inFile = new File(sourcePath);
        File outFile = new File(targetPath);
        System.out.println(inFile.getName() + " copy to " + outFile.getName());

        if (inFile.isFile()) {
            FileInputStream in = new FileInputStream(sourcePath);
            FileOutputStream out = new FileOutputStream(targetPath);

            byte[] tmpBuf = new byte[1024];
            int length;
            while ((length = in.read(tmpBuf)) > 0) {
                out.write(tmpBuf);
            }
        } else if (inFile.isDirectory()) {
           outFile.mkdir();

           for (String childPath : inFile.list()) {
               copyFileOrDir(sourcePath + "/" + childPath, targetPath + "/" + childPath);
           }
        }
    }
}
