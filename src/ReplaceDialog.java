import javax.swing.*;

import java.awt.*;

public class ReplaceDialog {
    // 定义域
    // 非模态 对话框
    protected static JDialog dialog;
    protected static JPanel textPanel;
    protected static JPanel btnPanel;
    // 组件
    protected static JTextField textField;
    protected static JLabel statusLabel;
    protected static JTextField toTextField;
    protected static JButton changeButton;
    protected static JButton exitButton;

    public ReplaceDialog() {
        // 初始化域
        dialog = new JDialog(TextBook.jfm, "替换");
        statusLabel = new JLabel("未进行替换");
        textField = new JTextField();
        toTextField = new JTextField();
        changeButton = new JButton("替换");
        exitButton = new JButton("退出");
        btnPanel = new JPanel(new GridLayout(1, 2));
        textPanel = new JPanel(new GridLayout(1, 3));

        // 对象部署
        statusLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
        changeButton.setBackground(Color.WHITE);
        exitButton.setBackground(Color.WHITE);

        // 布局
        textPanel.add(textField);
        textPanel.add(new JLabel("替换为", JLabel.CENTER));
        textPanel.add(toTextField);
        btnPanel.add(changeButton);
        btnPanel.add(exitButton);
        dialog.getContentPane().add("North", statusLabel);
        dialog.getContentPane().add("Center", textPanel);
        dialog.getContentPane().add("South", btnPanel);

        // 事件
        DialogListener listener = new DialogListener();
        changeButton.addActionListener(listener);
        exitButton.addActionListener(listener);

        // 对话框窗体部署
        dialog.setSize(250, 110);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(TextBook.jfm);
    }
}
