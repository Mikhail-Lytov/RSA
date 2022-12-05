import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class Frame extends JFrame {
    private JLabel key_generation;
    private JButton button_generation;
    private JLabel file_generation;
    private JLabel emptiness;
    private String path_text_file;
    private String path_close_file_file;
    private String path_open_key;
    private String path_text_signature;
    public Frame() {
        super("RSA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,4,2,2));

        key_generation = new JLabel("генерация ключей");
        button_generation = new JButton("генерировать");
        file_generation = new JLabel("");
        emptiness = new JLabel("");

        panel.add(key_generation);
        button_generation.addActionListener(new file_generation());
        panel.add(file_generation);
        panel.add(emptiness);
        panel.add(button_generation);



        JLabel signature = new JLabel("Подпись");
        JButton text_file = new JButton("Подписываемый файл");
        JButton close_key_file = new JButton("Закрытый ключ");
        JButton button_signature = new JButton("Подписать");

        text_file.addActionListener(new text_file());
        close_key_file.addActionListener(new close_key_file());
        button_signature.addActionListener(new sigianure_file());
        panel.add(signature);
        panel.add(text_file);
        panel.add(close_key_file);
        panel.add(button_signature);

        JLabel signature_verification_label = new JLabel("Проверка подписи");
        JButton text_signature_file = new JButton("Подписанный файл");
        JButton open_key_file = new JButton("Открытый ключ");
        JButton signature_verification_button  =new JButton("проверить");

        panel.add(signature_verification_label);
        panel.add(text_signature_file);
        panel.add(open_key_file);
        panel.add(signature_verification_button);

        signature_verification_button.addActionListener(new signature_verification());
        text_signature_file.addActionListener(new text_signature_verification ());
        open_key_file.addActionListener(new open_key());

        getContentPane().add(panel);
        setPreferredSize(new Dimension(800, 300));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    class signature_verification implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(path_open_key == null || path_text_signature == null){
                if(path_open_key == null){
                    JOptionPane.showConfirmDialog(null, "Не выбран файл c открытым ключём", "ERROR", JOptionPane.PLAIN_MESSAGE);
                } else if (path_text_signature == null) {
                    JOptionPane.showConfirmDialog(null, "Не выбран файл, который нужно проверить", "ERROR", JOptionPane.PLAIN_MESSAGE);
                }
            }else {
                try {
                    FileReader file_open_key = new FileReader(path_open_key);
                    BufferedReader buf = new BufferedReader(file_open_key);
                    String open_exhibitor = buf.readLine();
                    open_exhibitor = open_exhibitor.substring(0,15);
                    if(open_exhibitor.equals("open exhibitor:")) {
                        Long start = System.currentTimeMillis();
                        Signature_verification check = new Signature_verification(path_text_signature, path_open_key);
                        Long finish = System.currentTimeMillis();

                        System.out.println("Время проверки подписи " + (finish - start) + " миллисекунд");

                        String text_check_file = check.check();
                        JOptionPane.showConfirmDialog(null, text_check_file, "Результат", JOptionPane.PLAIN_MESSAGE);
                    }else{
                        JOptionPane.showConfirmDialog(null, "Не выбран файл, c открытым ключём", "ERROR", JOptionPane.PLAIN_MESSAGE);
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }


        }
    }
    class text_signature_verification implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileopen = new JFileChooser();
            int ret = fileopen.showDialog(null, "Открыть файл");
            if(ret == JFileChooser.APPROVE_OPTION){
                File file = fileopen.getSelectedFile();
                try {
                    path_text_signature = file.getCanonicalPath();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        }
    }

    class open_key implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileopen = new JFileChooser();
            int ret = fileopen.showDialog(null, "Открыть файл");
            if(ret == JFileChooser.APPROVE_OPTION){
                File file = fileopen.getSelectedFile();
                try {
                    path_open_key = file.getCanonicalPath();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    class close_key_file implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileopen = new JFileChooser();
            int ret = fileopen.showDialog(null, "Открыть файл");
            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = fileopen.getSelectedFile();
                //System.out.println("тут");
                try {
                    //System.out.println("теперь тут");
                    path_close_file_file = file.getCanonicalPath();
                    //System.out.println(a);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            //System.out.println(path_text_file);

        }
    }
    class sigianure_file implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(path_text_file == null || path_close_file_file == null) {
                if (path_text_file == null) {
                    JOptionPane.showConfirmDialog(null, "Не выбран файл, который нужно подписать", "ERROR", JOptionPane.PLAIN_MESSAGE);
                } else if (path_close_file_file == null) {
                    JOptionPane.showConfirmDialog(null, "Не выбран файл, c закрытым ключём", "ERROR", JOptionPane.PLAIN_MESSAGE);

                }
            }else{
                try {
                    FileReader file_txt = new FileReader(path_close_file_file);
                    BufferedReader buf = new BufferedReader(file_txt);
                    String line_1 = buf.readLine();
                    try {

                        if (line_1.substring(0, 16).equals("close exhibitor:")) {
                            buf.close();
                            file_txt.close();
                            Long start = System.currentTimeMillis();
                            Signature signature_class = new Signature(path_text_file, path_close_file_file);
                            Long finish = System.currentTimeMillis();
                            System.out.println("Время подписи: " + (finish - start) + " миллисекунд");
                            JOptionPane.showConfirmDialog(null, "Файл подписан", "Резульат операции", JOptionPane.PLAIN_MESSAGE);
                        } else {
                            JOptionPane.showConfirmDialog(null, "Некоректный файл с закрытым ключём", "Error", JOptionPane.PLAIN_MESSAGE);
                        }
                    }catch (StringIndexOutOfBoundsException ex){
                        JOptionPane.showConfirmDialog(null, "Некоректный файл с закрытым ключём", "Error", JOptionPane.PLAIN_MESSAGE);
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
    class text_file implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileopen = new JFileChooser();
            int ret = fileopen.showDialog(null, "Открыть файл");
            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = fileopen.getSelectedFile();
                //System.out.println("тут");
                try {
                    //System.out.println("теперь тут");
                    path_text_file = file.getCanonicalPath();
                    //System.out.println(a);

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            //System.out.println(path_close_file_file);

        }
    }
    class file_generation implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            long start;
            long finish;
            start = System.currentTimeMillis();
            key_generation key = new key_generation();
            finish = System.currentTimeMillis();

            System.out.println("Время генерации: " + (finish - start));

            BigInteger open_exhibitor = key.getOpen_exhibitor();
            BigInteger close_exhibitor = key.getClose_exhibitor();
            BigInteger derivative = key.getDerivative();
            BigInteger first_number = key.getFirst_number();
            BigInteger second_number = key.getSecond_number();
            try {
                key_output output = new key_output(open_exhibitor, close_exhibitor, derivative, first_number, second_number);
                String message = "адресс открытого ключа: " + output.path_open_key() + "\nадрес закрытого ключа: " + output.path_close_key();
                JOptionPane.showConfirmDialog(null,message, "Расположение ключей", JOptionPane.PLAIN_MESSAGE);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }


            //OptionPane.showConfirmDialog(null,"a", "out", JOptionPane.PLAIN_MESSAGE);

        }
    }



}
