import javax.swing.*;

public class AdminDashboardGUI extends JFrame {

    Admin admin;

    public AdminDashboardGUI(Admin admin) {

        this.admin = admin;

        setTitle("Admin Dashboard");
        setSize(400, 420);
        setLayout(null);

        JButton addUser = new JButton("Add User");
        addUser.setBounds(100, 30, 200, 30);
        add(addUser);

        JButton deleteUser = new JButton("Delete User");
        deleteUser.setBounds(100, 70, 200, 30);
        add(deleteUser);

        JButton searchUser = new JButton("Search User");
        searchUser.setBounds(100, 110, 200, 30);
        add(searchUser);

        JButton addBook = new JButton("Add Book");
        addBook.setBounds(100, 150, 200, 30);
        add(addBook);

        JButton removeBook = new JButton("Remove Book");
        removeBook.setBounds(100, 190, 200, 30);
        add(removeBook);

        JButton updateBook = new JButton("Update Book");
        updateBook.setBounds(100, 230, 200, 30);
        add(updateBook);

        JButton categories = new JButton("Book Categories");
        categories.setBounds(100, 270, 200, 30);
        add(categories);

        JButton logout = new JButton("Logout");
        logout.setBounds(100, 320, 200, 30);
        add(logout);

        addBook.addActionListener(e -> new AddBookGUI(admin));

        logout.addActionListener(e -> {
            dispose();
            new AdminLoginGUI();
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
