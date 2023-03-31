import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class DeleteAccount extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JList list1;
    private JButton DELETEButton;
    private JList list2;
    private JButton DELETEButton1;
    private JRadioButton CURRENTACCOUNTRadioButton;
    private JRadioButton SAVINGACCOUNTRadioButton;
    private JButton BACKButton;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JButton OKButton;
    private JPanel panel4;
    private JPanel panel5;
    int a;
    String CNIC;
    String CNIC1;

    public DeleteAccount() {
        setSize(220,400);
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        panel1.setVisible(true);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        buttonOK.setVisible(false);
        OKButton.setVisible(true);
        pack();

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
        CURRENTACCOUNTRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CURRENTACCOUNTRadioButton.isSelected())
                {
                    SAVINGACCOUNTRadioButton.setSelected(false);
                }
            }
        });
        SAVINGACCOUNTRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (SAVINGACCOUNTRadioButton.isSelected())
                {
                    CURRENTACCOUNTRadioButton.setSelected(false);
                }
            }
        });
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CURRENTACCOUNTRadioButton.isSelected())
                {
                    a=1;
                    panel1.setVisible(false);
                    panel2.setVisible(true);
                    panel3.setVisible(false);
                    panel4.setVisible(false);
                    panel5.setVisible(false);
                    buttonOK.setVisible(true);
                    OKButton.setVisible(false);
                    pack();
                }
                else if (SAVINGACCOUNTRadioButton.isSelected())
                {
                    a=2;
                    panel1.setVisible(false);
                    panel2.setVisible(false);
                    panel3.setVisible(false);
                    panel4.setVisible(true);
                    panel5.setVisible(false);
                    buttonOK.setVisible(true);
                    OKButton.setVisible(false);
                    pack();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"CHOOSE THE OPTION");
                }
            }
        });
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (a){
                    case 1:
                    {
                        CNIC = textField1.getText();
                        File F1 = new File(CNIC + "a.txt");
                        File F2 = new File(CNIC + "b.txt");
                        File F3 = new File(CNIC + "c.txt");
                        File F4 = new File(CNIC + "d.txt");
                        DefaultListModel<String> listModel = new DefaultListModel<>();
                        if (F3.exists() && F4.exists())
                        {
                            JOptionPane.showMessageDialog(null,"THIS ACCOUNT IS A SAVING ACCOUNT");
                        }
                        else {
                            if (F1.exists() && F2.exists()) {
                                try {
                                    Scanner SC1 = new Scanner(F1);
                                    while (SC1.hasNextLine()) {
                                        String ss = SC1.nextLine();
                                        listModel.addElement(ss);
                                    }
                                    list1.setModel(listModel);
                                    Scanner SC2 = new Scanner(F2);
                                    String ss = SC2.nextLine();
                                    listModel.addElement("ACCOUNT BALANCE: " + ss);
                                    list1.setModel(listModel);
                                } catch (FileNotFoundException fileNotFoundException) {
                                    fileNotFoundException.printStackTrace();
                                }
                                panel1.setVisible(false);
                                panel2.setVisible(false);
                                panel3.setVisible(true);
                                panel4.setVisible(false);
                                panel5.setVisible(false);
                                buttonOK.setVisible(false);
                                OKButton.setVisible(false);
                                pack();
                            } else {
                                JOptionPane.showMessageDialog(null, "ACCOUNT DO NOT EXIST");
                            }
                        }
                        break;
                    }
                    case 2:
                    {
                        CNIC1 = textField2.getText();
                        File F1 = new File(CNIC1 + "a.txt");
                        File F2 = new File(CNIC1 + "b.txt");
                        File F3 = new File(CNIC1 + "c.txt");
                        File F4 = new File(CNIC1 + "d.txt");
                        DefaultListModel<String> listModel1 = new DefaultListModel<>();
                        if (F1.exists() && F2.exists())
                        {
                            JOptionPane.showMessageDialog(null,"THIS ACCOUNT IS A CURRENT ACCOUNT");
                        }
                        else {
                            if (F3.exists() && F4.exists()) {
                                try {
                                    Scanner SC1 = new Scanner(F3);
                                    while (SC1.hasNextLine()) {
                                        String ss = SC1.nextLine();
                                        listModel1.addElement(ss);
                                    }
                                    list2.setModel(listModel1);
                                    Scanner SC2 = new Scanner(F4);
                                    String ss = SC2.nextLine();
                                    listModel1.addElement("ACCOUNT BALANCE: " + ss);
                                    list2.setModel(listModel1);
                                } catch (FileNotFoundException fileNotFoundException) {
                                    fileNotFoundException.printStackTrace();
                                }
                                panel1.setVisible(false);
                                panel2.setVisible(false);
                                panel3.setVisible(false);
                                panel4.setVisible(false);
                                panel5.setVisible(true);
                                buttonOK.setVisible(false);
                                OKButton.setVisible(false);
                                pack();
                            } else {
                                JOptionPane.showMessageDialog(null, "ACCOUNT DO NOT EXIST");
                            }
                        }
                        break;
                    }
                }
            }
        });
        DELETEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Balance1;
                double Balance3;
                File f2 = new File(CNIC + "a.txt");
                File f3 = new File(CNIC + "b.txt");
                try{
                        Scanner sc = new Scanner(f3);
                        Balance1 = sc.nextLine();
                        Balance3 = Double.parseDouble(Balance1);
                        sc.close();
                        if (f3.delete() || f2.delete()) {
                            JOptionPane.showMessageDialog(null, "THE ACCOUNT DELETED SUCCESSFULLY\nTHE CURRENT BALANCE IS: " + Balance1 + "\nPRESS OK TO WITHDRAW");
                            if (Balance3 == 0) {
                                JOptionPane.showMessageDialog(null, "YOUR BALANCE IS 0");
                            } else {
                                JOptionPane.showMessageDialog(null, "BALANCE WITHDRAWAL SUCCESSFULLY");
                            }
                            ExistingAccount EA1 = new ExistingAccount();
                            setVisible(false);
                            EA1.setVisible(true);
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"ACCOUNT HAVE NOT DELETED"); }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        DELETEButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Balance1;
                double Balance3;
                File f2 = new File(CNIC1 + "c.txt");
                File f3 = new File(CNIC1 + "d.txt");
                try{
                    Scanner sc = new Scanner(f3);
                    Balance1 = sc.nextLine();
                    Balance3 = Double.parseDouble(Balance1);
                    sc.close();
                    if (f3.delete() || f2.delete()) {
                        JOptionPane.showMessageDialog(null, "THE ACCOUNT DELETED SUCCESSFULLY\nTHE CURRENT BALANCE IS: " + Balance1 + "\nPRESS OK TO WITHDRAW");
                        if (Balance3 == 0) {
                            JOptionPane.showMessageDialog(null, "YOUR BALANCE IS 0");
                        } else {
                            JOptionPane.showMessageDialog(null, "BALANCE WITHDRAWAL SUCCESSFULLY");
                        }
                        ExistingAccount EA1 = new ExistingAccount();
                        setVisible(false);
                        EA1.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"ACCOUNT HAVE NOT DELETED"); }
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
        DeleteAccount dialog = new DeleteAccount();
        dialog.pack();
        dialog.setVisible(true);
        //System.exit(0);
    }
}
