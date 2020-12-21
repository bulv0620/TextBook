import java.awt.event.*;

public class DialogListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == FindDialog.findButton) {

        }
        if (source == FindDialog.nextButton) {

        }
        if (source == FindDialog.exitButton) {
            DialogMethod.findDialogExit();
        }
        if (source == ChangeDialog.changeButton) {

        }
        if (source == ChangeDialog.exitButton) {
            DialogMethod.changeDialogExit();
        }
    }

}
