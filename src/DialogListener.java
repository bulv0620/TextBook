import java.awt.event.*;

public class DialogListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == FindDialog.findButton) {
            DialogMethod.find();
        }
        if (source == FindDialog.nextButton) {
            DialogMethod.next();
        }
        if (source == FindDialog.exitButton) {
            DialogMethod.findDialogExit();
        }
        if (source == ChangeDialog.changeButton) {
            DialogMethod.change();
        }
        if (source == ChangeDialog.exitButton) {
            DialogMethod.changeDialogExit();
        }
    }

}
