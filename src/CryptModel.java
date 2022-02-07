import javax.swing.*;
import java.io.*;

public class CryptModel {

    public static void main(String[] args) {

    }
    public void Save(JTextArea textArea1, String filename){
        if (! filename.equals("")) {
            FileWriter fw = null;
            try {
                fw = new FileWriter(filename);
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
    public void SaveAs(JTextArea textArea1, String filename){
        FileWriter fw = null;
        try {
            fw = new FileWriter(filename);
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
    public String Load(String filename) {

        FileReader fr = null;
        try {
            fr = new FileReader(filename);
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
        if (key.length()==0){
            JOptionPane.showMessageDialog(null, "No key value\nDidn't encrypt");
            return textArea1.getText();
        } else {
            System.out.println(key);
            int n = 0;
            String result = "";
            char ch;
            for (int i = 0; i < textArea1.getText().length(); i++) {
                if (n >= key.length()) {
                    n = 0;
                }
                ch = (char) Integer.parseInt(Integer.toBinaryString(textArea1.getText().charAt(i) ^ key.charAt(n)), 2);

                result += ch;

                n++;
            }
            return result;
        }
    }

    public String getFile(String tempfilename) {
        String text="";
        FileReader fr = null;
        try {
            fr = new FileReader(tempfilename);
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

    public void EncryptFile(String filename, String key) throws IOException {
        if (key.length()==0){
            JOptionPane.showMessageDialog(null, "No key value\nDidn't encrypt");
        } else {
            FileReader fr = null;
            try {
                fr = new FileReader(filename);
            } catch (FileNotFoundException E) {
                E.printStackTrace();
            }
            assert fr != null;
            BufferedReader inFile = new BufferedReader(fr);

            String line;
            String result = "";
            try {
                while ((line = inFile.readLine()) != null) {
                    result += line + "\n";
                }
                inFile.close();
            } catch (IOException E) {
                E.printStackTrace();
            }
            System.out.println(result);
            int n = 0;
            String newtext = "";
            char ch;
            for (int i = 0; i < result.length() - 1; i++) {
                if (n >= key.length()) {
                    n = 0;
                }
                ch = (char) Integer.parseInt(Integer.toBinaryString(result.charAt(i) ^ key.charAt(n)), 2);

                newtext += ch;

                n++;
            }
            System.out.println(newtext);
            PrintWriter txtOut = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
            txtOut.write(newtext);
            txtOut.flush();
            txtOut.close();
        }
    }
}
