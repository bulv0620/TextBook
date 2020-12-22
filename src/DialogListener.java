import java.awt.event.*;

public class DialogListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == FindDialog.prevButton) {
            DialogMethod.prev();
        }
        if (source == FindDialog.nextButton) {
            DialogMethod.next(FindDialog.textField.getText());
        }
        if (source == FindDialog.exitButton) {
            DialogMethod.findDialogExit();
        }
        if (source == ReplaceDialog.changeButton) {
            DialogMethod.change();
        }
        if (source == ReplaceDialog.exitButton) {
            DialogMethod.changeDialogExit();
        }
    }

}
