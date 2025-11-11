import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public MainPanel() {
        Box bv = new Box(BoxLayout.Y_AXIS);
        // минимальная ширина текстовых полей
        bv.add(Box.createHorizontalStrut(60));
        JTextArea jta = new JTextArea();
        // рамка вокруг текстового поля
        jta.setBorder(BorderFactory.createLineBorder(Color.green));
        bv.add(jta);
        // пустое место в 15 пикселей
        bv.add(Box.createVerticalStrut(15));
        // для эксперемента с размерами
        // jta.setPreferredSize(new Dimension(60,100));
        // jta.setMaximumSize(new Dimension(60,100));
        // jta.setAlignmentX(LEFT_ALIGNMENT); // явно задаем выравнивание
        jta = new JTextArea();
        jta.setBorder(BorderFactory.createLineBorder(Color.green));
        bv.add(jta);
        bv.add(Box.createVerticalStrut(15));
        jta = new JTextArea();
        jta.setBorder(BorderFactory.createLineBorder(Color.green));
        bv.add(jta);
        bv.add(Box.createVerticalStrut(15));
        add(bv, BorderLayout.WEST); // добавляем ящик влево
    }
}
