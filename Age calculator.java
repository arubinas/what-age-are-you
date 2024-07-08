git@github.com:arubinas/what-age-are-you.git
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator extends JFrame {
    private JTextField dayField;
    private JTextField monthField;
    private JTextField yearField;
    private JLabel ageLabel;

    public AgeCalculator() {
        // Set up the frame
        setTitle("Age Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        // Add components to the panel
        panel.add(new JLabel("Day:"));
        dayField = new JTextField();
        panel.add(dayField);

        panel.add(new JLabel("Month:"));
        monthField = new JTextField();
        panel.add(monthField);

        panel.add(new JLabel("Year:"));
        yearField = new JTextField();
        panel.add(yearField);

        JButton calculateButton = new JButton("Calculate Age");
        panel.add(calculateButton);

        ageLabel = new JLabel("Age: ");
        panel.add(ageLabel);

        // Add panel to frame
        add(panel, BorderLayout.CENTER);

        // Add action listener to the button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAge();
            }
        });
    }

    private void calculateAge() {
        int day = Integer.parseInt(dayField.getText());
        int month = Integer.parseInt(monthField.getText());
        int year = Integer.parseInt(yearField.getText());

        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();

        Period age = Period.between(birthDate, today);

        ageLabel.setText("Age: " + age.getYears() + " years");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AgeCalculator().setVisible(true);
            }
        });
    }
}
