import java.io.File;

public class FileFilter extends javax.swing.filechooser.FileFilter {

    @Override
    public boolean accept(File f) {
        if (f.isDirectory())
            return true;
        return f.getName().endsWith(".txt"); // 设置为选择以.class为后缀的文件
    }

    @Override
    public String getDescription() {
        return ".txt";
    }

}
