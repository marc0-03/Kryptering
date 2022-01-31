import javax.swing.*;

public class CryptView {
    private JPanel Panel;
    private JTextArea textArea1;
    private JButton encryptWithFileButton;
    private JButton loadFileButton;
    private JButton saveButton;
    private JButton saveAsButton;
    private JButton encryptButton;
    private JTextField textField1;

    public CryptView() {

    }

    public JPanel getPanel() {
        return Panel;
    }

    public JButton getSaveButton() {
        return saveButton;
    }
    public JButton getSaveAsButton() {
        return saveAsButton;
    }
    public JButton getLoadFileButton() {
        return loadFileButton;
    }
    public JButton getEncryptButton() {
        return encryptButton;
    }
    public JButton getEncryptWithFileButton() {
        return encryptWithFileButton;
    }

    public JTextArea getTextArea1() {
        return textArea1;
    }

    public String getKey() {
        return textField1.getText();
    }

    public void setResult(String result) {
        this.textArea1.setText("");
        this.textArea1.setText("" + result);
    }
}
