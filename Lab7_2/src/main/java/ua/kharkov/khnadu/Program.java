package ua.kharkov.khnadu;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Program {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(JFrameExtended::createGUI);
    }
}

@Getter
@RequiredArgsConstructor
enum LocalizedColor {
    BLACK("Чёрный", Color.BLACK),
    RED("Красный", Color.RED),
    GREEN("Зелёный", Color.GREEN),
    BLUE("Синий", Color.BLUE);

    private final String localized;
    private final Color color;

    public static LocalizedColor fromLocalized(String localized) {
        return Arrays.stream(LocalizedColor.values())
                .filter(localizedColor -> localizedColor.getLocalized().equals(localized))
                .findAny()
                .orElseThrow();
    }
}

class JFrameExtended extends JFrame {
    private JFrameExtended() {
        super("Main frame");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        configureTopPanel();

        configureLowPanel();

        setPreferredSize(new Dimension(1024, 768));

        pack();
        setVisible(true);
    }

    private void configureTopPanel() {
        JPanel topPanel = new JPanel();

        topPanel.add(new JLabel("Текст: "));

        JTextField textField = new JTextField(15);
        topPanel.add(textField);

        topPanel.add(new JLabel("Гарнитура: "));
        SpinnerModel fontModel = new SpinnerListModel(
                asList("Times New Roman", "Arial", "Veranda")
        );
        topPanel.add(new JSpinner(fontModel));

        topPanel.add(new JLabel("Цвет: "));
        SpinnerModel colorModel = new SpinnerListModel(
                Arrays.stream(LocalizedColor.values())
                        .map(LocalizedColor::getLocalized)
                        .collect(toList())
        );

        topPanel.add(new JSpinner(colorModel));

        JButton button = new JButton("Вывести строку");
        button.addActionListener(event -> {
            Component component = getContentPane().getComponent(1);
            Font font = component.getGraphics().getFont();
            String fontName = String.valueOf(fontModel.getValue());
            String colorName = String.valueOf(colorModel.getValue());
            LocalizedColor localizedColor = LocalizedColor.fromLocalized(colorName);
            Font newFont = new Font(fontName, font.getStyle(), font.getSize());

            component.getGraphics().setFont(newFont);
            component.getGraphics().setColor(localizedColor.getColor());
            component.getGraphics()
                    .drawString(
                            textField.getText(),
                            getWidth() / 2,
                            getHeight() / 2
                    );
        });

        topPanel.add(button);

        getContentPane().add(topPanel, BorderLayout.NORTH);
    }

    private void configureLowPanel() {
        JPanel lowPanel = new JPanel();


        getContentPane().add(lowPanel);
    }

    public static void createGUI() {
        new JFrameExtended();
    }
}
