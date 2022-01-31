import javax.swing.*;
import java.io.*;

public class CryptModel {
    public String filnamn;

    public static void main(String[] args) {

    }
    public void Save(JTextArea textArea1){
        if (! filnamn.equals("")) {
            FileWriter fw = null;
            try {
                fw = new FileWriter(filnamn);
            } catch (IOException g) {
                g.printStackTrace();
            }
            assert fw != null;
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter outFile = new PrintWriter(bw);

            outFile.println(textArea1.getText());
            outFile.flush();
            outFile.close();
        } else {
            JOptionPane.showMessageDialog(null, "Ingen fil är vald\nKan inte spara");
        }
    }
    public void SaveAs(JTextArea textArea1){
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            filnamn = fc.getSelectedFile().getAbsolutePath();
        } else {
            filnamn = "exempel";
        }

        filnamn = filnamn+".txt";
        FileWriter fw = null;
        try {
            fw = new FileWriter(filnamn);
        } catch (IOException g) {
            g.printStackTrace();
        }
        assert fw != null;
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter outFile = new PrintWriter(bw);
        outFile.println(textArea1.getText());
        outFile.flush();
        outFile.close();
    }
    public String Load() {
        JFileChooser fc = new JFileChooser();
        int resultat = fc.showOpenDialog(null);
        if (resultat != JFileChooser.APPROVE_OPTION) {
            System.out.println("ingen fil valdes");
            System.exit(0);
        }
        filnamn = fc.getSelectedFile().getAbsolutePath();
        FileReader fr = null;
        try {
            fr = new FileReader(filnamn);
        } catch (FileNotFoundException E) {
            E.printStackTrace();
        }
        assert fr != null;
        BufferedReader inFile = new BufferedReader(fr);

        String line;
        String result = "";
        try {
            while ((line = inFile.readLine()) != null) {
                result+=line+"\n";
            }
            inFile.close();
        } catch (IOException E) {
            E.printStackTrace();
        }
        return result;
    }

    public String Encrypt(JTextArea textArea1, String key) {
        int n = 0;
        String result="";
        char ch;
        for (int i = 0; i<textArea1.getText().length(); i++) {
            if (n>=key.length()) {
                n = 0;
            }
            ch = (char) Integer.parseInt(Integer.toBinaryString(textArea1.getText().charAt(i) ^ key.charAt(n)),2);



           //textArea1.setText(textArea1.getText().substring(0, i) + ch + textArea1.getText().substring(i+1));
            result+=ch;

            n++;
        }
        return result;
    }

    public String getFile() {
        String text="";
        JFileChooser fc = new JFileChooser();
        int resultat = fc.showOpenDialog(null);
        if (resultat != JFileChooser.APPROVE_OPTION) {
            System.out.println("ingen fil valdes");
            System.exit(0);
        }
        String tempfilnamn = fc.getSelectedFile().getAbsolutePath();
        FileReader fr = null;
        try {
            fr = new FileReader(tempfilnamn);
        } catch (FileNotFoundException E) {
            E.printStackTrace();
        }
        assert fr != null;
        BufferedReader inFile = new BufferedReader(fr);

        String line;
        try {
            while ((line = inFile.readLine()) != null) {
                text+=line;
            }
            inFile.close();
        } catch (IOException E) {
            E.printStackTrace();
        }
        return text;
    }
}
