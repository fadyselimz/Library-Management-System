import javax.swing.*;

public class AdminLoginGUI extends JFrame {

    JTextField username;
    JPasswordField password;
    JButton login;
    JLabel result;

    public AdminLoginGUI() {

        setTitle("Admin Login");
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

        login = new JButton("Login");
        login.setBounds(90, 95, 100, 25);
        add(login);

        result = new JLabel();
        result.setBounds(20, 130, 240, 25);
        add(result);

        login.addActionListener(e -> doAdminLogin());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void doAdminLogin() {
        Admin admin = new Admin();

        boolean success = admin.login(
                username.getText(),
                new String(password.getPassword())
        );

        if (success && admin.getAccountType() == AccountType.ADMIN) {
            dispose();
            new AdminDashboardGUI(admin);
        } else {
            result.setText("Not an admin");
        }
        }
    }
