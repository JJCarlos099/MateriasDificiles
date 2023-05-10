import javax.swing.*;
import java.awt.*;


public class EncuestaMaterias {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(EncuestaMaterias::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Las Materias mas dificiles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());

        JLabel questionLabel = new JLabel("¿Cuál de las tres materias se te ha dificultado más y por qué?");
        frame.add(questionLabel);

        String[] subjects = {"Matemáticas", "Física", "Química"};
        JComboBox<String> subjectComboBox = new JComboBox<>(subjects);
        frame.add(subjectComboBox);

        JLabel reasonLabel = new JLabel("Motivo:");
        frame.add(reasonLabel);

        JTextArea reasonTextArea = new JTextArea(5, 30);
        JScrollPane scrollPane = new JScrollPane(reasonTextArea);
        frame.add(scrollPane);

        JButton submitButton = new JButton("Enviar");
        frame.add(submitButton);

        submitButton.addActionListener(e -> {
            String selectedSubject = (String) subjectComboBox.getSelectedItem();
            String reason = reasonTextArea.getText();
            if (reason.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Por favor, ingresa el motivo.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String message = "Materia más difícil: " + selectedSubject + "\nMotivo: " + reason;
                JOptionPane.showMessageDialog(frame, message, "Resultado de la Encuesta", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        frame.setVisible(true);
    }
}
