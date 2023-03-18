import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class ImageOperation {

    public static void operate(int key)
    {

        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file=fileChooser.getSelectedFile();
        //file FileInputStream
        try
        {

            FileInputStream fis=new FileInputStream(file);

            byte []data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data)
            {
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }

            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Request Processed!");

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        

        JFrame f=new JFrame();
        f.setTitle("Image Operation");
        f.setSize(500,500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font=new Font("Times New Roman",Font.BOLD,25);
        //creating button
        JButton button1=new JButton();         //Button1
        button1.setText("Encrypt Image");
        button1.setFont(font);
        
        JButton button2=new JButton();         //Button2
        button2.setText("Decrypt Image");
        button2.setFont(font);

        //creating text field
        JTextField textField=new JTextField(10);
        textField.setFont(font);

        
        button1.addActionListener(e->{
            System.out.println("button clicked");
            String text=textField.getText();
            int temp=Integer.parseInt(text);
            operate(temp);
        });
        
        button2.addActionListener(e->{
        	System.out.println("button clicked");
            String text=textField.getText();
            int temp=Integer.parseInt(text);
            operate(temp);
        });
       
        f.setLayout(new FlowLayout());

        f.add(button1);
        f.add(button2);
        f.add(textField);
        f.setVisible(true);

    }
}