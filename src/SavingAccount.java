import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SavingAccount extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JRadioButton MALERadioButton;
    private JRadioButton OTHERRadioButton;
    private JRadioButton FEMALERadioButton;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;
    private JTextField textField14;
    private JButton BACKButton;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private SpinnerModel Model1;
    private SpinnerModel Model2;
    private SpinnerModel Model3;

    public SavingAccount() {
        setSize(220,400);
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        setModal(true);
        pack();
        getRootPane().setDefaultButton(buttonOK);

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
                String NAME = textField1.getText();
                String FATHERNAME = textField5.getText();
                String MOTHERNAME = textField6.getText();
                String CNIC = textField2.getText();
                String TELEPHONENUMBER = textField9.getText();
                String MOBILENUMBER1 = textField8.getText();
                String NTNNUMBER = textField11.getText();
                String OCCUPATION = textField10.getText();
                String EMAILADDRESS = textField4.getText();
                String HOMEADDRESS = textField3.getText();
                String MOBILENUMBER2 = textField13.getText();
                String OFFICEADDRESS = textField12.getText();
                String RANK = textField14.getText();
                String GENDER;
                Integer date = (Integer) spinner1.getValue();
                String month = (String) spinner2.getValue();
                Integer year = (Integer) spinner3.getValue();
                String BALANCE = "0";
                if (MALERadioButton.isSelected())
                {
                    GENDER = "MALE";
                }
                else if (FEMALERadioButton.isSelected())
                {
                    GENDER = "FEMALE";
                }
                else
                {
                    GENDER = "OTHERS";
                }
                File F5 =  new File(CNIC + "a.txt");
                File F6 = new  File(CNIC + "b.txt");
                File F2 = new File(CNIC + "d.txt");
                if (F5.exists() || F6.exists()){
                    JOptionPane.showMessageDialog(null,"THIS ID ALREADY HAVE CURRENT ACCOUNT");
                }
                else {
                    if (F2.exists()) {
                        JOptionPane.showMessageDialog(null, "ACCOUNT Already EXIST");
                    } else {
                        try {
                            F2.createNewFile();
                            FileWriter f3 = new FileWriter(CNIC + "d.txt");
                            f3.write(BALANCE);
                            f3.close();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        File F1 = new File(CNIC + "c.txt");
                        if (F1.exists()) {
                            JOptionPane.showMessageDialog(null, "ACCOUNT ALREADY EXIST");
                        } else {
                            try {
                                F1.createNewFile();
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                            try {
                                FileWriter FA1 = new FileWriter(CNIC + "c.txt");
                                FA1.write("NAME: " + NAME);
                                FA1.write("\nFATHER NAME: " + FATHERNAME);
                                FA1.write("\nMOTHER NAME: " + MOTHERNAME);
                                FA1.write("\nCNIC: " + CNIC);
                                FA1.write("\nDOB: " + date + "th" + month + "," + year);
                                FA1.write("\nGENDER: " + GENDER);
                                FA1.write("\nMOBILE NUMBER: " + MOBILENUMBER1);
                                FA1.write("\nTELEPHONE NUMBER: " + TELEPHONENUMBER);
                                FA1.write("\nEMAIL ADDRESS: " + EMAILADDRESS);
                                FA1.write("\nHOME ADDRESS: " + HOMEADDRESS);
                                FA1.write("\nOCCUPATION: " + OCCUPATION);
                                FA1.write("\nNTN NUMBER: " + NTNNUMBER);
                                FA1.write("\nMOBILE NUMBER: " + MOBILENUMBER2);
                                FA1.write("\nRANK: " + RANK);
                                FA1.write("\nOFFICE ADDRESS: " + OFFICEADDRESS);
                                FA1.close();
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                            if ((NAME == null)
                                    || (NAME.equals(""))
                                    || (!NAME.matches("^[a-zA-Z ]*$"))) {
                                JOptionPane.showMessageDialog(null, "FILL THE NAME CORRECTLY");
                                F1.delete();
                                F2.delete();
                            } else if ((FATHERNAME == null)
                                    || (FATHERNAME.equals(""))
                                    || (!FATHERNAME.matches("^[a-zA-Z ]*$"))) {
                                JOptionPane.showMessageDialog(null, "FILL THE FATHER NAME CORRECTLY");
                                F1.delete();
                                F2.delete();
                            } else if ((MOTHERNAME == null)
                                    || (MOTHERNAME.equals(""))
                                    || (!MOTHERNAME.matches("^[a-zA-Z ]*$"))) {
                                JOptionPane.showMessageDialog(null, "FILL THE MOTHER NAME CORRECTLY");
                                F1.delete();
                                F2.delete();
                            } else if ((CNIC == null)
                                    || (CNIC.equals(""))
                                    || (CNIC.matches("^[a-zA-Z ]*$"))) {
                                JOptionPane.showMessageDialog(null, "FILL THE CNIC CORRECTLY");
                                F1.delete();
                                F2.delete();
                            } else if ((TELEPHONENUMBER == null)
                                    || (TELEPHONENUMBER.equals(""))
                                    || (!TELEPHONENUMBER.matches("^[0-9]*$"))) {
                                JOptionPane.showMessageDialog(null, "FILL THE TELEPHONE NUMBER CORRECTLY");
                                F1.delete();
                                F2.delete();
                            } else if ((MOBILENUMBER1 == null)
                                    || (MOBILENUMBER1.equals(""))
                                    || (!MOBILENUMBER1.matches("^[0-9]*$"))) {
                                JOptionPane.showMessageDialog(null, "FILL THE MOBILE NUMBER CORRECTLY");
                                F1.delete();
                                F2.delete();
                            } else if ((NTNNUMBER == null)
                                    || (NTNNUMBER.equals(""))
                                    || (!NTNNUMBER.matches("^[0-9]*$"))) {
                                JOptionPane.showMessageDialog(null, "FILL THE NTN NUMBER CORRECTLY");
                                F1.delete();
                                F2.delete();
                            } else if ((MOBILENUMBER2 == null)
                                    || (MOBILENUMBER2.equals(""))
                                    || (!MOBILENUMBER2.matches("^[0-9]*$"))) {
                                JOptionPane.showMessageDialog(null, "FILL THE MOBILE NUMBER CORRECTLY");
                                F1.delete();
                                F2.delete();
                            } else if ((EMAILADDRESS == null)
                                    || (EMAILADDRESS.equals(""))) {
                                JOptionPane.showMessageDialog(null, "FILL EMAIL ADDRESS CORRECTLY");
                                F1.delete();
                                F2.delete();
                            } else if ((HOMEADDRESS == null)
                                    || (HOMEADDRESS.equals(""))) {
                                JOptionPane.showMessageDialog(null, "FILL THE HOME ADDRESS CORRECTLY");
                                F1.delete();
                                F2.delete();
                            } else if ((OFFICEADDRESS == null)
                                    || (OFFICEADDRESS.equals(""))) {
                                JOptionPane.showMessageDialog(null, "FILL THE OFFICE ADDRESS CORRECTLY");
                                F1.delete();
                                F2.delete();
                            } else if ((OCCUPATION == null)
                                    || (OCCUPATION.equals(""))
                                    || (!OCCUPATION.matches("^[a-zA-Z ]*$"))) {
                                JOptionPane.showMessageDialog(null, "FILL THE OCCUPATION CORRECTLY");
                                F1.delete();
                                F2.delete();
                            } else if ((RANK == null)
                                    || (RANK.equals(""))) {
                                JOptionPane.showMessageDialog(null, "FILL THE RANK CORRECTLY");
                                F1.delete();
                                F2.delete();
                            } else {
                                JOptionPane.showMessageDialog(null, "THE ACCOUNT IS SAVED");
                                dispose();
                                Dashboard D1 = new Dashboard();
                                D1.setVisible(true);
                            }
                        }
                    }
                }

            }
        });
        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewAccount  NA1= new NewAccount();
                setVisible(false);
               NA1.setVisible(true);
            }
        });
        MALERadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(MALERadioButton.isSelected())
                {
                    FEMALERadioButton.setSelected(false);
                    OTHERRadioButton.setSelected(false);
                }
            }
        });
        FEMALERadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(FEMALERadioButton.isSelected())
                {
                    MALERadioButton.setSelected(false);
                    OTHERRadioButton.setSelected(false);
                }
            }
        });
        OTHERRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(OTHERRadioButton.isSelected())
                {
                    FEMALERadioButton.setSelected(false);
                    MALERadioButton.setSelected(false);
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
        SavingAccount dialog = new SavingAccount();
        dialog.pack();
        dialog.setVisible(true);
        //System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        String[] month = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        String YEAR = String.valueOf(java.time.Year.now());
        int y = Integer.parseInt(YEAR);
        Model1 = new SpinnerNumberModel(1,1,31,1);
        Model2 = new SpinnerListModel(month);
        Model3 = new SpinnerNumberModel(y,y-100,y,1);
        spinner1 = new JSpinner(Model1);
        spinner2 = new JSpinner(Model2);
        spinner3 = new JSpinner(Model3);
    }
}
