public class DialogMethod {

	/**
	 * 查找上一个方法
	 */
	public static void prev() {
		String word = Dialog.findText.getText();// 查找的词
		int focousPos = TextBook.text.getCaretPosition();// 当前光标焦点
		String fullText = TextBook.text.getText();// 文档内所有内容
		int startPos = 0;
		int endPos = 0;
		Boolean isfound = false;
		if (word.equals("")) {
			Dialog.statusLabel.setText("失败(请输入内容)");
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
			Dialog.statusLabel.setText("查找已执行");
		} else {
			Dialog.statusLabel.setText("失败(找不到内容)");
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
			Dialog.statusLabel.setText("失败(请输入内容)");
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
			Dialog.statusLabel.setText("查找已执行");
		} else {
			Dialog.statusLabel.setText("失败(找不到内容)");
		}
		return isfound;
	}

	/**
	 * 全部替换方法
	 */
	public static void replaceAll() {
		Boolean isReplaced = false;
		String from = Dialog.findText.getText();
		String to = Dialog.replaceText.getText();
		TextBook.text.setCaretPosition(0);
		while (next(from)) {
			TextBook.text.replaceSelection(to);
			isReplaced = true;
		}
		if (isReplaced)
			Dialog.statusLabel.setText("替换成功");
		else
			Dialog.statusLabel.setText("失败(找不到内容)");

	}

	/**
	 * 替换当前方法
	 */
	public static void replace() {
		String to = Dialog.replaceText.getText();
		String text = TextBook.text.getSelectedText();
		if (text != null) {
			TextBook.text.replaceSelection(to);
		}
		else
			Dialog.statusLabel.setText("失败(没有选择内容)");
	}

}
