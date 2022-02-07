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
    private JButton encryptFileButton;
    private JButton encryptFileWithFileButton;
    private String filename;

    public CryptView() {
        filename="";
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
    public JButton getEncryptFileButton() {
        return encryptFileButton;
    }
    public JButton getEncryptFileWithFileButton() {
        return encryptFileWithFileButton;
    }


    public JTextArea getTextArea1() {
        return textArea1;
    }


    public String getFilename(){
        return filename;
    }

    public String chooseFilename() {
        String temp="";
        JFileChooser fc = new JFileChooser();
        while (temp=="") {
            int resultat = fc.showOpenDialog(null);
            if (resultat != JFileChooser.APPROVE_OPTION) {
                System.out.println("ingen fil valdes");
            } else {
                temp = fc.getSelectedFile().getAbsolutePath();
            }
        }
        return temp;
    }

    public String chooseNewFilename() {
        filename="";
        JFileChooser fc = new JFileChooser();
        while (filename=="") {
            int resultat = fc.showOpenDialog(null);
            if (resultat != JFileChooser.APPROVE_OPTION) {
                System.out.println("ingen fil valdes");
            } else {
                filename = fc.getSelectedFile().getAbsolutePath();
            }
        }
        return filename;
    }

    public String getKey() {
        return textField1.getText();
    }

    public void setResult(String result) {
        this.textArea1.setText("");
        this.textArea1.setText(result);
    }
}
