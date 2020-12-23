import java.awt.event.*;

public class DialogListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == Dialog.prevBtn) {
            DialogMethod.prev();
        }
        if (source == Dialog.nextBtn) {
            DialogMethod.next(Dialog.findText.getText());
        }

        if (source == Dialog.replaceBtn) {
            DialogMethod.replace();
        }
        if (source == Dialog.replaceAllBtn) {
            DialogMethod.replaceAll();
        }

    }

}
