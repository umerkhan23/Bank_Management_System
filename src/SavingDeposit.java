import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SavingDeposit extends JDialog {
    private JPanel contentPane;
    private JButton BACKButton;
    private JButton buttonCancel;
    private JButton DEPOSITButton;
    private JSpinner spinner1;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel label1;
    private JLabel label2;
    private JButton OKButton;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    String date = String.valueOf(java.time.LocalDate.now());

    public SavingDeposit() {
        setSize(220,400);
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(BACKButton);
        panel1.setVisible(false);
        panel2.setVisible(true);
        panel3.setVisible(false);
        panel4.setVisible(false);
        pack();
        label1.setText(date);

        BACKButton.addActionListener(new ActionListener() {
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
        DEPOSITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String CNIC = textField1.getText();
                String Balance1;
                double Balance3, Balance2;
                Integer AMOUNT = (Integer)spinner1.getValue();
                File f3 = new File(CNIC + "d.txt");
                File f4 = new File(CNIC + "b.txt");
                if(f4.exists())
                {
                    JOptionPane.showMessageDialog(null,"THIS ACCOUNT IS CURRENT ACCOUNT\nENTER THE CORRECT CNIC");
                }
                else {
                    if (f3.exists()) {
                        try {
                            FileReader f1 = new FileReader(CNIC + "d.txt");
                            Scanner sc = new Scanner(f1);
                            Balance1 = sc.nextLine();
                            Balance3 = Double.parseDouble(Balance1);
                            Balance3 = Balance3 / 1.07;
                            Balance3 = Balance3 + AMOUNT;
                            Balance2 = Balance3 * 0.07;
                            Balance3 = Balance3 + Balance2;
                            Balance1 = String.valueOf(Balance3);
                            f1.close();
                            FileWriter f2 = new FileWriter(CNIC + "d.txt");
                            f2.write(Balance1);
                            f2.close();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        JOptionPane.showMessageDialog(null, "AMOUNT DEPOSITED SUCCESSFULLY");
                        setVisible(false);
                        ExistingAccount EA1 = new ExistingAccount();
                        EA1.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "ACCOUNT DOES NOT EXIST\nCHECK YOUR CNIC");
                    }
                }
            }

        });

        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deposit D1 = new Deposit();
                setVisible(false);
                D1.setVisible(true);
            }
        });
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String CNIC1 = textField2.getText();
                File F1 = new File(CNIC1 + "b.txt");
                File f2 = new File(CNIC1 + "d.txt");
                try {
                    if(F1.exists())
                    {
                        JOptionPane.showMessageDialog(null,"THIS ACCOUNT IS A CURRENT ACCOUNT");
                    }
                    else {
                        if (f2.exists()) {
                            FileReader f6 = new FileReader(CNIC1 + "c.txt");
                            Scanner sc1 = new Scanner(f6);
                            String Name = sc1.nextLine();
                            label2.setText(Name);
                            f6.close();
                            panel1.setVisible(true);
                            panel2.setVisible(false);
                            panel3.setVisible(true);
                            panel4.setVisible(true);
                            OKButton.setVisible(false);
                            pack();
                        } else {
                            JOptionPane.showMessageDialog(null, "ERROR ENTER THE CORRECT CNIC");
                        }
                    }} catch (IOException ioException) {
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
        SavingDeposit dialog = new SavingDeposit();
        dialog.pack();
        dialog.setVisible(true);
        //System.exit(0);
    }


}
