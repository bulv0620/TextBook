import javax.swing.*;

import java.awt.*;

public class ChangeDialog {
    // 定义域
    // 非模态 对话框
    protected static JDialog dialog;
    protected static JPanel textPanel;
    protected static JPanel btnPanel;
    // 组件
    protected static JTextField textField;
    protected static JTextField toTextField;
    protected static JButton changeButton;
    protected static JButton exitButton;
    protected static JLabel label;

    public ChangeDialog() {
        // 初始化域
        dialog = new JDialog(TextBook.jfm, "替换");
        textField = new JTextField();
        toTextField = new JTextField();
        changeButton = new JButton("替换");
        exitButton = new JButton("退出");
        label = new JLabel("TO",JLabel.CENTER);
        btnPanel = new JPanel(new GridLayout(1, 2));
        textPanel = new JPanel(new GridLayout(1, 3));

        // 布局
        textPanel.add(textField);
        textPanel.add(label);
        textPanel.add(toTextField);
        btnPanel.add(changeButton);
        btnPanel.add(exitButton);
        dialog.getContentPane().add("Center",textPanel);
        dialog.getContentPane().add("South",btnPanel);

        //事件
        DialogListener listener = new DialogListener();
        changeButton.addActionListener(listener);
        exitButton.addActionListener(listener);


        // 对话框窗体部署
        dialog.setSize(250, 100);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(TextBook.jfm);
    }
}
