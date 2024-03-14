import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

    private static final long serialVersionUID = 1L;

    public Frame() {
        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JTextField textField = new JTextField("Enter the name", 20);
        JButton button = new JButton("Go");

        // Set layout manager for the content pane
        getContentPane().setLayout(new BorderLayout());

        // Add components to the frame's content pane
        getContentPane().add(textField, BorderLayout.NORTH);
        getContentPane().add(button, BorderLayout.CENTER);

        button.addActionListener(e -> {
            String content = textField.getText();
            GamePanel panel = new GamePanel();
            panel.setPreferredSize(new Dimension(500, 500));
            getContentPane().remove(textField);
            getContentPane().remove(button);

            // Create a panel to hold both the welcome button and the GamePanel
            JPanel welcomePanel = new JPanel(new BorderLayout());
            welcomePanel.add(new JLabel("Welcome " + content.toUpperCase()), BorderLayout.NORTH);
            welcomePanel.add(panel, BorderLayout.CENTER);

            getContentPane().add(welcomePanel, BorderLayout.CENTER); // Add the panel to the center
            setMinimumSize(new Dimension(500, 500));
        });

        pack(); // Pack the components
        setVisible(true);
    }
}