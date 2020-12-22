
public class DialogMethod {

	/**
	 * 查找对话框关闭
	 */
	public static void findDialogExit() {
		FindDialog.dialog.setVisible(false);
	}

	/**
	 * 替换对话框关闭
	 */
	public static void changeDialogExit() {
		ReplaceDialog.dialog.setVisible(false);
	}

	/**
	 * 查找上一个方法
	 */
	public static void prev() {
		String word = FindDialog.textField.getText();// 查找的词
		int focousPos = TextBook.text.getCaretPosition();// 当前光标焦点
		String fullText = TextBook.text.getText();// 文档内所有内容
		int startPos = 0;
		int endPos = 0;
		Boolean isfound = false;
		if (word.equals("")) {
			FindDialog.statusLabel.setText("失败(请输入内容)");
			return;
		}
		char lastLetter = word.charAt(word.length() - 1);
		for (int i = focousPos - 2; i > -1; i--) {
			if (fullText.charAt(i) == lastLetter) {
				isfound = true;
				for (int j = i - 1; j > i - word.length(); j--) {
					if (fullText.charAt(j) != word.charAt(word.length() - i + j - 1)) {
						isfound = false;
						break;
					}
				}
			}
			if (isfound) {
				startPos = i - word.length() + 1;
				endPos = i + 1;
				break;
			}
		}
		if (isfound) {
			TextBook.text.setSelectionStart(startPos);
			TextBook.text.setSelectionEnd(endPos);
			FindDialog.statusLabel.setText("查找已执行");
		} else {
			FindDialog.statusLabel.setText("失败(找不到内容)");
		}
	}

	/**
	 * 查找下一个方法
	 */
	public static Boolean next(String str) {
		String word = str;// 查找的词
		int focousPos = TextBook.text.getCaretPosition();// 当前光标焦点
		String fullText = TextBook.text.getText();// 文档内所有内容
		int startPos = 0;
		int endPos = 0;
		Boolean isfound = false;
		if (word.equals("")) {
			FindDialog.statusLabel.setText("失败(请输入内容)");
			return false;
		}
		char firstLetter = word.charAt(0);
		for (int i = focousPos; i < fullText.length(); i++) {
			if (fullText.charAt(i) == firstLetter) {
				isfound = true;
				for (int j = i + 1; j < word.length() + i; j++) {
					if (fullText.charAt(j) != word.charAt(j - i)) {
						isfound = false;
						break;
					}
				}
			}
			if (isfound) {
				startPos = i;
				endPos = i + word.length();
				break;
			}
		}
		if (isfound) {
			TextBook.text.setSelectionStart(startPos);
			TextBook.text.setSelectionEnd(endPos);
			FindDialog.statusLabel.setText("查找已执行");
		} else {
			FindDialog.statusLabel.setText("失败(找不到内容)");
		}
		return isfound;
	}

	/**
	 * 替换方法
	 */
	public static void change() {
		Boolean isReplaced = false;
		String from = ReplaceDialog.textField.getText();
		String to = ReplaceDialog.toTextField.getText();
		TextBook.text.setCaretPosition(0);
		while (next(from)) {
			TextBook.text.replaceSelection(to);
			isReplaced = true;
		}
		if (isReplaced)
			ReplaceDialog.statusLabel.setText("替换成功");
		else
			ReplaceDialog.statusLabel.setText("失败(找不到内容)");

	}

}
