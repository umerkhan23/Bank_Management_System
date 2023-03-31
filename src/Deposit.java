import javax.swing.*;
import java.awt.event.*;

public class Deposit extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JRadioButton currentRadioButton;
    private JRadioButton savingRadioButton;
    private JButton BACKButton;

    public Deposit() {
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
        currentRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentRadioButton.isSelected())
                {
                    savingRadioButton.setSelected(false);
                }
            }
        });
        savingRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (savingRadioButton.isSelected())
                {
                    currentRadioButton.setSelected(false);
                }
            }
        });
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                if (currentRadioButton.isSelected())
                {
                    CurrentDeposit CD1 = new CurrentDeposit();
                    CD1.setVisible(true);
                }
                else if (savingRadioButton.isSelected())
                {
                    SavingDeposit SD1 = new SavingDeposit();
                    SD1.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Select the option");
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
        //dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Deposit dialog = new Deposit();
        dialog.pack();
        dialog.setVisible(true);
        //System.exit(0);
    }
}
