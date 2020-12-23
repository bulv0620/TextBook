import java.awt.event.*;
import javax.swing.event.*;

public class Listener implements ActionListener, DocumentListener, WindowListener {

    @Override
    public void insertUpdate(DocumentEvent e) {
        Method.unSavedStatus();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        Method.unSavedStatus();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        Method.unSavedStatus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == TextBook.newText) {
            Method.windowClose();
            TextBook.jfm.setVisible(false);
            new TextBook(null);
        }
        if (source == TextBook.openText) {
            Method.chooseFile();
        }
        if (source == TextBook.saveText) {
            if (TextBook.isLocated)
                Method.saveText();
            else
                Method.saveOtherText();
        }
        if (source == TextBook.saveOtherText) {
            Method.saveOtherText();
        }
        if (source == TextBook.exit) {
            Method.windowClose();
            System.exit(0);
        }
        if (source == TextBook.findWord) {
            Method.findWord();
        }
        if (source == TextBook.style) {
            Method.showStyleDialog();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        Method.windowClose();

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {


    }

    @Override
    public void windowActivated(WindowEvent e) {


    }

    @Override
    public void windowDeactivated(WindowEvent e) {


    }

}
