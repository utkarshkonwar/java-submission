import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class _24ageweb{
    public static void main(String[] args) {
        // Create the main JFrame (window)
        JFrame frame = new JFrame("Age Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        // Create and add components to the panel
        JLabel birthDateLabel = new JLabel("Enter Date of Birth (dd/MM/yyyy):");
        JTextField birthDateField = new JTextField();
        JLabel calcDateLabel = new JLabel("Calculate Age As Of (dd/MM/yyyy):");
        JTextField calcDateField = new JTextField();
        JButton calculateButton = new JButton("Calculate Age");
        JLabel resultLabel = new JLabel("Your Age: ");
        
        // Add components to panel
        panel.add(birthDateLabel);
        panel.add(birthDateField);
        panel.add(calcDateLabel);
        panel.add(calcDateField);
        panel.add(new JLabel()); // Empty space in grid
        panel.add(calculateButton);
        panel.add(resultLabel);

        // Set up action for the Calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String birthDateStr = birthDateField.getText();
                String calcDateStr = calcDateField.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setLenient(false);  // Strict date parsing
                
                try {
                    // Parse the input strings to Date objects
                    Date birthDate = sdf.parse(birthDateStr);
                    Date calcDate = sdf.parse(calcDateStr);
                    
                    // Use Calendar to calculate the age
                    Calendar birthCal = Calendar.getInstance();
                    birthCal.setTime(birthDate);
                    Calendar calcCal = Calendar.getInstance();
                    calcCal.setTime(calcDate);
                    
                    int years = calcCal.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR);
                    int months = calcCal.get(Calendar.MONTH) - birthCal.get(Calendar.MONTH);
                    int days = calcCal.get(Calendar.DAY_OF_MONTH) - birthCal.get(Calendar.DAY_OF_MONTH);
                    
                    if (days < 0) {
                        months--;
                        calcCal.add(Calendar.MONTH, -1);
                        days += calcCal.getActualMaximum(Calendar.DAY_OF_MONTH);
                    }
                    
                    if (months < 0) {
                        years--;
                        months += 12;
                    }

                    // Display the result in the label
                    resultLabel.setText("Your Age: " + years + " Years, " + months + " Months, " + days + " Days.");
                    
                } catch (ParseException ex) {
                    resultLabel.setText("Invalid date format. Please use dd/MM/yyyy.");
                }
            }
        });

        // Add panel to the frame
        frame.add(panel);
        
        // Make the frame visible
        frame.setVisible(true);
    }
}

    

