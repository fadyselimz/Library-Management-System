import javax.swing.*;

public class SignupGUI extends JFrame {

    JTextField username;
    JPasswordField password;
    JButton signup;
    JLabel result;

    public SignupGUI() {

        setTitle("Sign Up");
        setSize(300, 200);
        setLayout(null);

        JLabel u = new JLabel("Username:");
        u.setBounds(20, 20, 80, 25);
        add(u);

        username = new JTextField();
        username.setBounds(110, 20, 150, 25);
        add(username);

        JLabel p = new JLabel("Password:");
        p.setBounds(20, 55, 80, 25);
        add(p);

        password = new JPasswordField();
        password.setBounds(110, 55, 150, 25);
        add(password);

        signup = new JButton("Create");
        signup.setBounds(90, 95, 100, 25);
        add(signup);

        result = new JLabel();
        result.setBounds(20, 130, 240, 25);
        add(result);

        signup.addActionListener(e -> doSignup());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void doSignup() {
        Patron patron = new Patron();
        patron.CreateAccount(
                username.getText(),
                new String(password.getPassword())
        );
        result.setText("Account created");
    }
}
