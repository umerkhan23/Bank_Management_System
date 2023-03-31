import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class AccountDetail extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton BACKButton;
    private JTextField textField1;
    private JList list1;
    private JLabel cnic;
    private JPanel panel1;
    private JScrollPane Scrollpane1;
    private JScrollPane Scrollpane2;
    private JPanel panel2;

    public AccountDetail() {
        setSize(300,500);
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        pack();
        Scrollpane2.setVisible(false);

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
        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountDetail AD1 = new AccountDetail();
                setVisible(false);
                AD1.setVisible(true);
            }
        });
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String CNIC = textField1.getText();
                File F1 = new File(CNIC + "a.txt");
                File F2 = new File(CNIC + "b.txt");
                File F3 = new File(CNIC + "c.txt");
                File F4 = new File(CNIC + "d.txt");
                DefaultListModel<String> listModel = new DefaultListModel<>();
                if (F1.exists() && F2.exists() || F3.exists() && F4.exists()) {
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
                        Scrollpane1.setVisible(false);
                        Scrollpane2.setVisible(true);
                        buttonOK.setVisible(false);
                        pack();
                    }
                    else if (F3.exists() && F4.exists()){
                        try {
                            Scanner SC1 = new Scanner(F3);
                            while (SC1.hasNextLine()) {
                                String ss = SC1.nextLine();
                                listModel.addElement(ss);
                            }
                            list1.setModel(listModel);
                            Scanner SC2 = new Scanner(F4);
                            String ss = SC2.nextLine();
                            listModel.addElement("ACCOUNT BALANCE: " + ss);
                            list1.setModel(listModel);
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        }
                        Scrollpane1.setVisible(false);
                        Scrollpane2.setVisible(true);
                        buttonOK.setVisible(false);
                        pack();
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"ACCOUNT DO NOT EXIST");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"ACCOUNT DO NOT EXIST");
                }
            }
        });
        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExistingAccount EA1 = new ExistingAccount();
                setVisible(false);
                EA1.setVisible(true);
            }
        });
    }

    private void onOK() {
        // add your code here
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        AccountDetail dialog = new AccountDetail();
        //dialog.pack();
        dialog.setVisible(true);
        //System.exit(0);
    }
}
