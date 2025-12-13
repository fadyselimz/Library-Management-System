import javax.swing.*;

public class LoginGUI extends JFrame {

    JTextField username;
    JPasswordField password;
    JButton login, signup, adminLogin;
    JLabel result;

    public LoginGUI() {

        setTitle("Library Login");
        setSize(350, 230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel u = new JLabel("Username:");
        u.setBounds(20, 20, 80, 25);
        add(u);

        username = new JTextField();
        username.setBounds(110, 20, 180, 25);
        add(username);

        JLabel p = new JLabel("Password:");
        p.setBounds(20, 55, 80, 25);
        add(p);

        password = new JPasswordField();
        password.setBounds(110, 55, 180, 25);
        add(password);

        login = new JButton("Login");
        login.setBounds(20, 95, 90, 25);
        add(login);

        signup = new JButton("Sign Up");
        signup.setBounds(125, 95, 90, 25);
        add(signup);

        adminLogin = new JButton("Admin");
        adminLogin.setBounds(230, 95, 80, 25);
        add(adminLogin);

        result = new JLabel();
        result.setBounds(20, 135, 300, 25);
        add(result);

        login.addActionListener(e -> doLogin());
        signup.addActionListener(e -> new SignupGUI());
        adminLogin.addActionListener(e -> new AdminLoginGUI());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void doLogin() {
        Patron patron = new Patron();

        boolean success = patron.login(
                username.getText(),
                new String(password.getPassword())
        );

        if (success) {
            result.setText("Patron login successful");
        } else {
            result.setText("Login failed");
        }
    }
}
