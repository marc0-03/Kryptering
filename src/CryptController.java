import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CryptController {
    private CryptView view;
    private CryptModel model;

    public CryptController() {
        view = new CryptView();
        model = new CryptModel();

        JFrame frame = new JFrame("Encryption program (SHHHH DONT TELL)");
        frame.setContentPane(view.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        view.getSaveButton().addActionListener(actionEvent -> model.Save(view.getTextArea1(), view.getFilename()) );
        view.getSaveAsButton().addActionListener(actionEvent -> model.SaveAs(view.getTextArea1(), view.chooseNewFilename()));
        view.getLoadFileButton().addActionListener(actionEvent -> view.setResult(model.Load(view.chooseNewFilename())));

        view.getEncryptFileButton().addActionListener(actionEvent -> {
            try {
                model.EncryptFile(view.chooseFilename(),view.getKey());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        view.getEncryptFileWithFileButton().addActionListener(actionEvent -> {
            try {
                model.EncryptFile(view.chooseFilename(),model.getFile(view.chooseFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        view.getEncryptButton().addActionListener(actionEvent -> view.setResult(model.Encrypt(view.getTextArea1(), view.getKey())));
        view.getEncryptWithFileButton().addActionListener(actionEvent -> view.setResult(model.Encrypt(view.getTextArea1(), model.getFile(view.chooseFilename()))));
    }

    public static void main(String[] args) {
        CryptController controller = new CryptController();
    }
}
