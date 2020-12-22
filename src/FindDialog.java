import javax.swing.*;

import java.awt.*;

public class FindDialog {
    // 定义域
    // 非模态 对话框
    protected static JDialog dialog;
    protected static JPanel btnPanel;
    // 组件
    protected static JLabel statusLabel;
    protected static JTextField textField;
    protected static JButton findButton;
    protected static JButton nextButton;
    protected static JButton exitButton;

    public FindDialog() {
        // 初始化域
        dialog = new JDialog(TextBook.jfm, "查找");
        statusLabel = new JLabel("未进行查找");
        textField = new JTextField();
        findButton = new JButton("查找");
        nextButton = new JButton("下一个");
        exitButton = new JButton("退出");
        btnPanel = new JPanel(new GridLayout(1, 3));

        //对象部署
        findButton.setBackground(Color.WHITE);
        nextButton.setBackground(Color.WHITE);
        exitButton.setBackground(Color.WHITE);

        // 布局
        btnPanel.add(findButton);
        btnPanel.add(nextButton);
        btnPanel.add(exitButton);
        dialog.getContentPane().add("North",statusLabel);
        dialog.getContentPane().add("Center",textField);
        dialog.getContentPane().add("South",btnPanel);

        //事件
        DialogListener listener = new DialogListener();
        findButton.addActionListener(listener);
        nextButton.addActionListener(listener);
        exitButton.addActionListener(listener);


        // 对话框窗体部署
        dialog.setSize(250, 110);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(TextBook.jfm);
    }
}
