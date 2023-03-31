import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Transfer extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JSpinner spinner1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton BACKButton;
    private JButton OKButton;
    private JTextField textField3;
    private JLabel label1;
    private JLabel label2;
    private JButton OKButton1;
    private JRadioButton CURRENTACCOUNTTOCURRENTRadioButton;
    private JRadioButton SAVINGACCOUNTTOSAVINGRadioButton;
    private JRadioButton CURRENTACCOUNTTOSAVINGRadioButton;
    private JRadioButton SAVINGACCOUNTTOCURRENTRadioButton;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    int a;
    String date = String.valueOf(java.time.LocalDate.now());

    public Transfer() {
        setSize(220,400);
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        panel1.setVisible(false);
        panel2.setVisible(true);
        panel3.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        OKButton.setVisible(false);
        pack();
        label1.setText(date);

    /*    buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });*/

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
        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExistingAccount EA1 = new ExistingAccount();
                setVisible(false);
                EA1.setVisible(true);
            }
        });
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String CNIC1 = textField1.getText();
                String CNIC2 = textField2.getText();
                String Balance1;
                double Balance3 ;
                Integer AMOUNT = (Integer)spinner1.getValue();
                switch (a) {
                    case 1: {
                        File f3 = new File(CNIC1 + "b.txt");
                        File f4 = new File(CNIC2 + "b.txt");
                        if (f3.exists()) {
                            if (f4.exists()) {
                                try {
                                    FileReader f1 = new FileReader(CNIC2 + "b.txt");
                                    Scanner sc = new Scanner(f1);
                                    Balance1 = sc.nextLine();
                                    Balance3 = Double.parseDouble(Balance1);
                                    Balance3 = Balance3 - AMOUNT;
                                    f1.close();

                                    if (Balance3 < 0) {
                                        JOptionPane.showMessageDialog(null, "YOUR TRANSFER EXCEEDS THE CURRENT BALANCE\nYOUR CURRENT BALANCE IS: " + Balance1);
                                    } else {
                                        Balance1 = String.valueOf(Balance3);
                                        FileWriter f2 = new FileWriter(CNIC2 + "b.txt");
                                        f2.write(Balance1);
                                        f2.close();
                                        FileReader f5 = new FileReader(CNIC1 + "b.txt");
                                        Scanner sc1 = new Scanner(f5);
                                        Balance1 = sc1.nextLine();
                                        Balance3 = Double.parseDouble(Balance1);
                                        Balance3 = Balance3 + AMOUNT;
                                        Balance1 = String.valueOf(Balance3);
                                        f5.close();
                                        FileWriter f6 = new FileWriter(CNIC1 + "b.txt");
                                        f6.write(Balance1);
                                        f6.close();
                                        JOptionPane.showMessageDialog(null, "AMOUNT TRANSFERRED SUCCESSFULLY");
                                    }
                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "SENDER ACCOUNT DOES NOT EXIST\nCHECK YOUR CNIC");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "ACCEPTER ACCOUNT DOES NOT EXIST\nCHECK YOUR CNIC");
                        }
                        break;
                    }
                    case 2:
                    {
                        File f3 = new File(CNIC1 + "d.txt");
                        File f4 = new File(CNIC2 + "b.txt");
                        if (f3.exists()) {
                            if (f4.exists()) {
                                try {
                                    FileReader f1 = new FileReader(CNIC2 + "b.txt");
                                    Scanner sc = new Scanner(f1);
                                    Balance1 = sc.nextLine();
                                    Balance3 = Double.parseDouble(Balance1);
                                    Balance3 = Balance3 - AMOUNT;
                                    f1.close();

                                    if (Balance3 < 0) {
                                        JOptionPane.showMessageDialog(null, "YOUR TRANSFER EXCEEDS THE CURRENT BALANCE\nYOUR CURRENT BALANCE IS: " + Balance1);
                                    } else {
                                        Balance1 = String.valueOf(Balance3);
                                        FileWriter f2 = new FileWriter(CNIC2 + "b.txt");
                                        f2.write(Balance1);
                                        f2.close();
                                        FileReader f5 = new FileReader(CNIC1 + "d.txt");
                                        Scanner sc1 = new Scanner(f5);
                                        Balance1 = sc1.nextLine();
                                        Balance3 = Double.parseDouble(Balance1);
                                        Balance3 = Balance3 + AMOUNT;
                                        Balance1 = String.valueOf(Balance3);
                                        f5.close();
                                        FileWriter f6 = new FileWriter(CNIC1 + "d.txt");
                                        f6.write(Balance1);
                                        f6.close();
                                        JOptionPane.showMessageDialog(null, "AMOUNT TRANSFERRED SUCCESSFULLY");
                                    }
                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "SENDER ACCOUNT DOES NOT EXIST\nCHECK YOUR CNIC");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "ACCEPTER ACCOUNT DOES NOT EXIST\nCHECK YOUR CNIC");
                        }
                        break;
                    }
                    case 3:
                    {
                        File f3 = new File(CNIC1 + "b.txt");
                        File f4 = new File(CNIC2 + "d.txt");
                        if (f3.exists()) {
                            if (f4.exists()) {
                                try {
                                    FileReader f1 = new FileReader(CNIC2 + "d.txt");
                                    Scanner sc = new Scanner(f1);
                                    Balance1 = sc.nextLine();
                                    Balance3 = Double.parseDouble(Balance1);
                                    Balance3 = Balance3 - AMOUNT;
                                    f1.close();

                                    if (Balance3 < 0) {
                                        JOptionPane.showMessageDialog(null, "YOUR TRANSFER EXCEEDS THE CURRENT BALANCE\nYOUR CURRENT BALANCE IS: " + Balance1);
                                    } else {
                                        Balance1 = String.valueOf(Balance3);
                                        FileWriter f2 = new FileWriter(CNIC2 + "d.txt");
                                        f2.write(Balance1);
                                        f2.close();
                                        FileReader f5 = new FileReader(CNIC1 + "b.txt");
                                        Scanner sc1 = new Scanner(f5);
                                        Balance1 = sc1.nextLine();
                                        Balance3 = Double.parseDouble(Balance1);
                                        Balance3 = Balance3 + AMOUNT;
                                        Balance1 = String.valueOf(Balance3);
                                        f5.close();
                                        FileWriter f6 = new FileWriter(CNIC1 + "b.txt");
                                        f6.write(Balance1);
                                        f6.close();
                                        JOptionPane.showMessageDialog(null, "AMOUNT TRANSFERRED SUCCESSFULLY");
                                    }
                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "SENDER ACCOUNT DOES NOT EXIST\nCHECK YOUR CNIC");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "ACCEPTER ACCOUNT DOES NOT EXIST\nCHECK YOUR CNIC");
                        }
                        break;
                    }
                    case 4:
                    {
                        File f3 = new File(CNIC1 + "d.txt");
                        File f4 = new File(CNIC2 + "d.txt");
                        if (f3.exists()) {
                            if (f4.exists()) {
                                try {
                                    FileReader f1 = new FileReader(CNIC2 + "d.txt");
                                    Scanner sc = new Scanner(f1);
                                    Balance1 = sc.nextLine();
                                    Balance3 = Double.parseDouble(Balance1);
                                    Balance3 = Balance3 - AMOUNT;
                                    f1.close();

                                    if (Balance3 < 0) {
                                        JOptionPane.showMessageDialog(null, "YOUR TRANSFER EXCEEDS THE CURRENT BALANCE\nYOUR CURRENT BALANCE IS: " + Balance1);
                                    } else {
                                        Balance1 = String.valueOf(Balance3);
                                        FileWriter f2 = new FileWriter(CNIC2 + "d.txt");
                                        f2.write(Balance1);
                                        f2.close();
                                        FileReader f5 = new FileReader(CNIC1 + "d.txt");
                                        Scanner sc1 = new Scanner(f5);
                                        Balance1 = sc1.nextLine();
                                        Balance3 = Double.parseDouble(Balance1);
                                        Balance3 = Balance3 + AMOUNT;
                                        Balance1 = String.valueOf(Balance3);
                                        f5.close();
                                        FileWriter f6 = new FileWriter(CNIC1 + "d.txt");
                                        f6.write(Balance1);
                                        f6.close();
                                        JOptionPane.showMessageDialog(null, "AMOUNT TRANSFERRED SUCCESSFULLY");
                                    }
                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "SENDER ACCOUNT DOES NOT EXIST\nCHECK YOUR CNIC");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "ACCEPTER ACCOUNT DOES NOT EXIST\nCHECK YOUR CNIC");
                        }
                        break;
                    }
                }
            }
        });
        CURRENTACCOUNTTOCURRENTRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CURRENTACCOUNTTOCURRENTRadioButton.isSelected())
                {
                    CURRENTACCOUNTTOSAVINGRadioButton.setSelected(false);
                    SAVINGACCOUNTTOCURRENTRadioButton.setSelected(false);
                    SAVINGACCOUNTTOSAVINGRadioButton.setSelected(false);
                }
            }
        });
        SAVINGACCOUNTTOSAVINGRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (SAVINGACCOUNTTOSAVINGRadioButton.isSelected())
                {
                    CURRENTACCOUNTTOSAVINGRadioButton.setSelected(false);
                    SAVINGACCOUNTTOCURRENTRadioButton.setSelected(false);
                    CURRENTACCOUNTTOCURRENTRadioButton.setSelected(false);
                }
            }
        });
        CURRENTACCOUNTTOSAVINGRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CURRENTACCOUNTTOSAVINGRadioButton.isSelected())
                {
                    SAVINGACCOUNTTOSAVINGRadioButton.setSelected(false);
                    SAVINGACCOUNTTOCURRENTRadioButton.setSelected(false);
                    CURRENTACCOUNTTOCURRENTRadioButton.setSelected(false);
                }
            }
        });
        SAVINGACCOUNTTOCURRENTRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (SAVINGACCOUNTTOCURRENTRadioButton.isSelected())
                {
                    SAVINGACCOUNTTOSAVINGRadioButton.setSelected(false);
                    CURRENTACCOUNTTOSAVINGRadioButton.setSelected(false);
                    CURRENTACCOUNTTOCURRENTRadioButton.setSelected(false);
                }
            }
        });
        OKButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CURRENTACCOUNTTOCURRENTRadioButton.isSelected())
                {
                    a = 1;
                    panel1.setVisible(false);
                    panel2.setVisible(false);
                    panel3.setVisible(true);
                    panel4.setVisible(false);
                    panel5.setVisible(false);
                    OKButton.setVisible(true);
                    pack();
                }
                else if (CURRENTACCOUNTTOSAVINGRadioButton.isSelected())
                {
                    a = 2;
                    panel1.setVisible(false);
                    panel2.setVisible(false);
                    panel3.setVisible(true);
                    panel4.setVisible(false);
                    panel5.setVisible(false);
                    OKButton.setVisible(true);
                    OKButton1.setVisible(false);
                    pack();
                }
                else if (SAVINGACCOUNTTOCURRENTRadioButton.isSelected())
                {
                    a = 3;
                    panel1.setVisible(false);
                    panel2.setVisible(false);
                    panel3.setVisible(true);
                    panel4.setVisible(false);
                    panel5.setVisible(false);
                    OKButton.setVisible(true);
                    OKButton1.setVisible(false);
                    pack();
                }
                else if (SAVINGACCOUNTTOSAVINGRadioButton.isSelected())
                {
                    a = 4;
                    panel1.setVisible(false);
                    panel2.setVisible(false);
                    panel3.setVisible(true);
                    panel4.setVisible(false);
                    panel5.setVisible(false);
                    OKButton.setVisible(true);
                    OKButton1.setVisible(false);
                    pack();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Choose the option");
                }
            }
        });
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String CNIC1 = textField3.getText();
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
                        panel3.setVisible(false);
                        panel4.setVisible(true);
                        panel5.setVisible(true);
                        OKButton.setVisible(false);
                        OKButton1.setVisible(false);
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
        //dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Transfer dialog = new Transfer();
        dialog.pack();
        dialog.setVisible(true);
        //System.exit(0);
    }
}
