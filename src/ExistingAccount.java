import javax.swing.*;
import java.awt.event.*;

public class ExistingAccount extends JDialog {
    private JPanel contentPane;
    private JButton buttonCancel;
    private JButton ACCOUNTDETAILButton;
    private JButton DEPOSITButton;
    private JButton WITHDRAWALButton;
    private JButton TRANSFERButton;
    private JButton BACKButton;

    public ExistingAccount() {
        setSize(220,400);
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        pack();
        setModal(true);


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
        ACCOUNTDETAILButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountDetail AD1 = new AccountDetail();
                setVisible(false);
                AD1.setVisible(true);
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
        DEPOSITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deposit D1 = new Deposit();
                setVisible(false);
                D1.setVisible(true);
            }
        });
        WITHDRAWALButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Withdrawal W1 = new Withdrawal();
                setVisible(false);
                W1.setVisible(true);
            }
        });
        TRANSFERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Transfer T1 = new Transfer();
                setVisible(false);
                T1.setVisible(true);
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
        ExistingAccount dialog = new ExistingAccount();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
