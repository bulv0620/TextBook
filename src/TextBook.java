import java.awt.*;

import javax.swing.*;

public class TextBook {
    // 域定义
    // 定义窗口
    protected static JFrame jfm;
    // 定义菜单栏
    protected static JMenuBar bar;
    protected static JMenu menu1;
    protected static JMenuItem newText;
    protected static JMenuItem openText;
    protected static JMenuItem saveText;
    protected static JMenuItem saveOtherText;
    protected static JMenuItem exit;
    protected static JMenu menu2;
    protected static JMenuItem findWord;
    protected static JMenuItem style;
    // 定义文本域
    protected JScrollPane scrollText;
    protected static JTextArea text;
    protected static int FONTSIZE = 20;
    // 判断
    protected static boolean isLocated;
    protected static boolean isSaved;
    // 文件名
    protected static String FILENAME;

    // 主程序构造
    public TextBook(String file) {
        // 初始化域
        isSaved = true;
        isLocated = false;
        FILENAME = "未命名.txt";
        jfm = new JFrame(FILENAME);
        bar = new JMenuBar();// 菜单栏
        menu1 = new JMenu("文件");// 子菜单1
        newText = new JMenuItem("新建");// 菜单项目
        openText = new JMenuItem("打开");
        saveText = new JMenuItem("保存");
        saveOtherText = new JMenuItem("另存为");
        exit = new JMenuItem("退出");
        menu2 = new JMenu("功能");// 子菜单2
        findWord = new JMenuItem("查找&替换");
        style = new JMenuItem("文本样式");

        text = new JTextArea();// 文本域对象
        scrollText = new JScrollPane(text);// 将文本域放入滚动窗口

        // 快捷键设置
        KeyStroke newKS = KeyStroke.getKeyStroke("ctrl N");// 创建保存快捷键
        newText.setAccelerator(newKS);// 设置快捷键
        KeyStroke openKS = KeyStroke.getKeyStroke("ctrl O");
        openText.setAccelerator(openKS);
        KeyStroke saveKS = KeyStroke.getKeyStroke("ctrl S");
        saveText.setAccelerator(saveKS);
        KeyStroke saveOtherKS = KeyStroke.getKeyStroke("ctrl shift S");
        saveOtherText.setAccelerator(saveOtherKS);
        KeyStroke exitKS = KeyStroke.getKeyStroke("ctrl E");
        exit.setAccelerator(exitKS);
        KeyStroke findKS = KeyStroke.getKeyStroke("ctrl F");
        findWord.setAccelerator(findKS);
        KeyStroke styleKS = KeyStroke.getKeyStroke("alt F");
        style.setAccelerator(styleKS);

        // 对象部署
        bar.setBackground(Color.white);
        text.setLineWrap(true);
        text.setFont(new Font("微软雅黑", Font.PLAIN, FONTSIZE));
        if (file != null) {
            FILENAME = file;
            Method.readFile(file);
            isLocated = true;
        }
        text.setCaretPosition(0);

        // 菜单栏组装
        bar.add(menu1);
        bar.add(menu2);
        // 子菜单组装
        menu1.add(newText);
        menu1.add(openText);
        menu1.addSeparator();
        menu1.add(saveText);
        menu1.add(saveOtherText);
        menu1.addSeparator();
        menu1.add(exit);
        menu2.add(findWord);
        menu2.addSeparator();
        menu2.add(style);

        // 布局
        jfm.getContentPane().add("North", bar);// 顶部菜单栏
        jfm.getContentPane().add("Center", scrollText);// 主题文本区域

        // 添加事件
        Listener listener = new Listener();
        newText.addActionListener(listener);
        openText.addActionListener(listener);
        saveText.addActionListener(listener);
        saveOtherText.addActionListener(listener);
        exit.addActionListener(listener);
        findWord.addActionListener(listener);
        style.addActionListener(listener);
        text.getDocument().addDocumentListener(listener);
        jfm.addWindowListener(listener);

        // 窗口部署
        jfm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfm.setSize(500, 550);
        jfm.setLocationRelativeTo(null);
        jfm.setVisible(true);
        new Dialog();
    }

}
