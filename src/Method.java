import java.awt.Font;
import java.io.*;

import javax.swing.*;

public class Method {
    private static FileFilter fileFilter = new FileFilter();// 过滤器对象

    /**
     * 选择文件
     */
    public static void chooseFile() {
        String fileName;
        JFileChooser fc = new JFileChooser("E:\\");
        fc.setFileFilter(fileFilter);
        int val = fc.showOpenDialog(TextBook.jfm); // 文件打开对话框
        if (val == JFileChooser.APPROVE_OPTION) {
            // 正常选择文件
            fileName = fc.getSelectedFile().toString();
        } else {
            // 未正常选择文件，如选择取消按钮
            fileName = null;
        }
        if (fileName != null) {
            windowClose();
            TextBook.jfm.setVisible(false);
            new TextBook(fileName);
        }
    }

    /**
     * 读取文件
     */
    public static void readFile(String fileName) {
        StringBuilder fileText = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                fileText.append(line + "\n");
            }
            reader.close();
            TextBook.text.append(fileText.toString());
            setTitle(fileName);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(TextBook.jfm, "打开失败", "警告", 0);
        }
    }

    /**
     * 设置字体大小
     */
    public static void showStyleDialog() {
        String input;
        input = JOptionPane.showInputDialog(TextBook.jfm, "设置字体大小:", String.valueOf(TextBook.FONTSIZE));
        if (input != null) {
            try {
                int fontSize = Integer.valueOf(input);
                TextBook.text.setFont(new Font("微软雅黑", Font.PLAIN, fontSize));
                TextBook.FONTSIZE = fontSize;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(TextBook.jfm, "请正确输入！", "警告", 0);
                showStyleDialog();
            }
        }

    }

    /**
     * 未保存状态
     */
    public static void unSavedStatus() {
        if (TextBook.isSaved) {
            TextBook.isSaved = false;
            setTitle(getFileName() + " - 未保存");
        }
    }

    /**
     * 保存状态
     */
    public static void savedStatus() {
        TextBook.isSaved = true;
        setTitle(getFileName());
    }

    /**
     * 获得文件名字
     */
    public static String getFileName() {
        return TextBook.FILENAME;
    }

    /**
     * 保存文件
     */
    public static void saveText() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(getFileName()));
            writer.write(TextBook.text.getText());
            writer.flush();
            writer.close();
            savedStatus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(TextBook.jfm, "保存失败", "警告", 0);
        }
    }

    /**
     * 另存为文件
     */
    public static void saveOtherText() {
        String fileName = null;
        JFileChooser fc = new JFileChooser("E:\\");
        fc.setSelectedFile(new File("E:\\未命名.txt"));
        fc.setFileFilter(fileFilter);
        int val = fc.showSaveDialog(TextBook.jfm);
        if (val == JFileChooser.APPROVE_OPTION) {
            if (fc.getSelectedFile().exists()) {
                int result = JOptionPane.showConfirmDialog(TextBook.jfm, "文件已存在，是否替换？", "提示",
                        JOptionPane.YES_NO_OPTION);
                if (result == 1) {
                    saveOtherText();
                }
            }
            // 正常选择文件
            fileName = fc.getSelectedFile().toString();

        } else {
            // 未正常选择文件，如选择取消按钮
            fileName = null;
        }
        if (fileName != null) {
            TextBook.isLocated = true;
            TextBook.FILENAME = fileName;
            savedStatus();
            saveText();
        }
    }

    /**
     * 退出事件
     */
    public static void windowClose() {
        if (!TextBook.isSaved) {
            int result = JOptionPane.showConfirmDialog(TextBook.jfm, "是否保存？", "提示", JOptionPane.YES_NO_OPTION);
            if (result == 0) {
                if (TextBook.isLocated)
                    Method.saveText();
                else
                    Method.saveOtherText();
            }
        }
    }

    /**
     * 设置标题
     */
    public static void setTitle(String title) {
        int posIndex = 0;
        for (int i = title.length() - 1; i >= 0; i--) {
            if (title.charAt(i) == '\\') {
                posIndex = i + 1;
                break;
            }
        }
        if (!TextBook.isSaved)
            TextBook.jfm.setTitle("*" + title.substring(posIndex, title.length()));
        else
            TextBook.jfm.setTitle(title.substring(posIndex, title.length()));
    }

    /**
     * 查找功能
     */
    public static void findWord() {
        FindDialog.dialog.setVisible(true);
    }

    /**
     * 替换功能
     */
    public static void changeWord() {
        ChangeDialog.dialog.setVisible(true);
    }

}
