import javax.swing.*;
import java.awt.event.*;
import java.text.BreakIterator;
import javax.swing.JOptionPane;

public class Dashboard extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton CREATEACCOUNTButton;
    private JButton EXISTINGACCOUNTButton;
    private JButton UPDATEACCOUNTButton;
    private JButton DELETEACCOUNTButton;

    public Dashboard() {
        setSize(220,400);
        setLocationRelativeTo(null);
        setTitle("Dashboard Form");
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
                LoginForm LF1 = new LoginForm();
                setVisible(false);
                LF1.setVisible(true);
            }
        });
        CREATEACCOUNTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewAccount NA1 = new NewAccount();
                setVisible(false);
                NA1.setVisible(true);
            }
        });
        EXISTINGACCOUNTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExistingAccount EA1 = new ExistingAccount();
                setVisible(false);
                EA1.setVisible(true);
            }
        });
        UPDATEACCOUNTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateAccount UA1 = new UpdateAccount();
                setVisible(false);
                UA1.setVisible(true);
            }
        });
        DELETEACCOUNTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteAccount DA1 = new DeleteAccount();
                setVisible(false);
                DA1.setVisible(true);
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
        Dashboard dialog = new Dashboard();
        dialog.pack();
        dialog.setVisible(true);
        //System.exit(0);
    }
}
