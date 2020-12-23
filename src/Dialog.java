import javax.swing.*;

import java.awt.*;

public class Dialog {
    // 定义域
    // 非模态 对话框
    protected static JDialog dialog;
    protected static JPanel textPanel;
    protected static JPanel btnPanel;
    // 组件
    protected static JLabel statusLabel;
    protected static JLabel findLabel;
    protected static JLabel replaceLabel;
    protected static JTextField findText;
    protected static JTextField replaceText;
    protected static JButton prevBtn;
    protected static JButton nextBtn;
    protected static JButton replaceBtn;
    protected static JButton replaceAllBtn;

    public Dialog() {
        // 初始化域
        dialog = new JDialog(TextBook.jfm, "查找&替换");

        statusLabel = new JLabel("未进行操作");
        findLabel = new JLabel("查找：");
        replaceLabel = new JLabel("替换：");
        findText = new JTextField();
        replaceText = new JTextField();
        prevBtn = new JButton("上一个");
        nextBtn = new JButton("下一个");
        replaceBtn = new JButton("替换");
        replaceAllBtn = new JButton("替换全部");


        textPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        btnPanel = new JPanel(new GridLayout(2, 2, 5, 5));

        // 对象部署
        prevBtn.setBackground(Color.white);
        nextBtn.setBackground(Color.white);
        replaceBtn.setBackground(Color.white);
        replaceAllBtn.setBackground(Color.white);

        // 布局
        textPanel.add(findLabel);
        textPanel.add(findText);
        textPanel.add(replaceLabel);
        textPanel.add(replaceText);

        btnPanel.add(prevBtn);
        btnPanel.add(nextBtn);
        btnPanel.add(replaceBtn);
        btnPanel.add(replaceAllBtn);

        dialog.setLayout(new BorderLayout(5, 5));
        dialog.getContentPane().add("North", statusLabel);
        dialog.getContentPane().add("Center", textPanel);
        dialog.getContentPane().add("East", btnPanel);

        // 事件
        DialogListener listener = new DialogListener();
        prevBtn.addActionListener(listener);
        nextBtn.addActionListener(listener);
        replaceBtn.addActionListener(listener);
        replaceAllBtn.addActionListener(listener);

        // 对话框窗体部署
        dialog.setSize(300,140);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(TextBook.jfm);
    }

}