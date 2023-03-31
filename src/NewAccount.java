import javax.swing.*;
import java.awt.event.*;

public class NewAccount extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JRadioButton currentRadioButton;
    private JRadioButton savingRadioButton;
    private JButton BACKButton;

    public NewAccount() {
        setSize(220,400);
        setLocationRelativeTo(null);
        setTitle("NEW REGISTRATION FORM");
        setContentPane(contentPane);
        pack();
        setModal(true);
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

            }
        });
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
                    CurrentAccount CA1 = new CurrentAccount();
                    CA1.setVisible(true);
                }
                else if (savingRadioButton.isSelected())
                {
                    SavingAccount SA1 = new SavingAccount();
                    SA1.setVisible(true);
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
                Dashboard d1 = new Dashboard();
                setVisible(false);
                d1.setVisible(true);
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
        NewAccount dialog = new NewAccount();
        dialog.pack();
        dialog.setVisible(true);
        //System.exit(0);
    }
}
