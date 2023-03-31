import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class Withdrawal extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JSpinner spinner1;
    private JButton BACKButton;
    private JTextField textField2;
    private JLabel label1;
    private JLabel label2;
    private JButton OKButton;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    String date = String.valueOf(java.time.LocalDate.now());

    public Withdrawal() {
        setSize(220,400);
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        panel1.setVisible(false);
        panel2.setVisible(true);
        panel3.setVisible(false);
        panel4.setVisible(false);
        pack();
        label1.setText(date);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String CNIC = textField1.getText();
                String Balance1;
                double Balance3 ;
                Integer AMOUNT = (Integer)spinner1.getValue();
                File f3 = new File(CNIC + "b.txt");
                File f4 = new File(CNIC + "d.txt");
                if (f3.exists()) {
                    try {
                        FileReader f1 = new FileReader(CNIC + "b.txt");
                        Scanner sc = new Scanner(f1);
                        Balance1 = sc.nextLine();
                        Balance3 = Double.parseDouble(Balance1);
                        Balance3 = Balance3 - AMOUNT;
                        f1.close();

                    if (Balance3 < 0) {
                        JOptionPane.showMessageDialog(null, "YOUR WITHDRAW EXCEEDS THE CURRENT BALANCE\nYOUR CURRENT BALANCE IS: " + Balance1);
                    }
                    else {
                            Balance1 = String.valueOf(Balance3);
                            FileWriter f2 = new FileWriter(CNIC + "b.txt");
                            f2.write(Balance1);
                            f2.close();


                        JOptionPane.showMessageDialog(null, "AMOUNT WITHDRAWAL SUCCESSFULLY");
                        setVisible(false);
                        ExistingAccount EA1 = new ExistingAccount();
                        EA1.setVisible(true);
                    }
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                else if(f4.exists())
                {
                    try {
                        FileReader f1 = new FileReader(CNIC + "d.txt");
                        Scanner sc = new Scanner(f1);
                        Balance1 = sc.nextLine();
                        Balance3 = Double.parseDouble(Balance1);
                        Balance3 = Balance3 - AMOUNT;
                        f1.close();

                        if (Balance3 < 0) {
                            JOptionPane.showMessageDialog(null, "YOUR WITHDRAW EXCEEDS THE CURRENT BALANCE\nYOUR CURRENT BALANCE IS: " + Balance1);
                        }
                        else {
                            Balance1 = String.valueOf(Balance3);
                            FileWriter f2 = new FileWriter(CNIC + "d.txt");
                            f2.write(Balance1);
                            f2.close();


                            JOptionPane.showMessageDialog(null, "AMOUNT WITHDRAWAL SUCCESSFULLY");
                            setVisible(false);
                            ExistingAccount EA1 = new ExistingAccount();
                            EA1.setVisible(true);
                        }
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                else
                    {
                        JOptionPane.showMessageDialog(null, "ACCOUNT DOES NOT EXIST\nCHECK YOUR CNIC");
                    }
            }
        });
        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExistingAccount EA2 = new ExistingAccount();
                setVisible(false);
                EA2.setVisible(true);
            }
        });
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String CNIC1 = textField2.getText();
                File f1 = new File(CNIC1 + "d.txt");
                File f2 = new File(CNIC1 + "b.txt");
                try {
                if (f2.exists() || f1.exists())
                {
                    if (f1.exists()) {
                        FileReader f6 = new FileReader(CNIC1 + "c.txt");
                        Scanner sc1 = new Scanner(f6);
                        String Name = sc1.nextLine();
                        label2.setText(Name);
                        f6.close();
                    }
                    else
                    {
                        FileReader f7 = new FileReader(CNIC1 + "a.txt");
                        Scanner sc = new Scanner(f7);
                        String Name = sc.nextLine();
                        label2.setText(Name);
                        f7.close();
                    }
                    panel1.setVisible(true);
                    panel2.setVisible(false);
                    panel3.setVisible(true);
                    panel4.setVisible(true);
                    OKButton.setVisible(false);
                    pack();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"ERROR ENTER THE CORRECT CNIC");
                }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }

    private void onOK() {
        // add your code here
       // dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Withdrawal dialog = new Withdrawal();
        dialog.pack();
        dialog.setVisible(true);
        //System.exit(0);
    }
}
