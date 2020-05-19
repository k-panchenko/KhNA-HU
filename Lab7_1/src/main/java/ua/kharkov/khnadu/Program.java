package ua.kharkov.khnadu;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(JStyleFontFrame::createGUI);
    }
}

class JStyleFontFrame extends JFrame {
    private final JTextPane textPane;
    private final JMenu fontMenu;
    private final JMenu styleMenu;

    private JStyleFontFrame() {
        super("Main frame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setJMenuBar(new JMenuBar());
        add((textPane = new JTextPane()));

        getJMenuBar().add((fontMenu = new JMenu("Шрифт")));
        configureFontMenu();
        configureButtonGroup(fontMenu);

        getJMenuBar().add((styleMenu = new JMenu("Стиль")));
        configureStyleMenu();
        configureButtonGroup(styleMenu);

        setPreferredSize(new Dimension(1024, 768));

        pack();
        setVisible(true);
    }

    private void configureButtonGroup(JMenu fontMenu) {
        ButtonGroup buttonGroup = new ButtonGroup();
        Arrays.stream(fontMenu.getMenuComponents()).forEach(component -> {
            if (component instanceof AbstractButton) buttonGroup.add((AbstractButton) component);
        });
    }

    private void configureStyleMenu() {
        addStyleButton("Простой", Font.PLAIN, true);
        addStyleButton("Жирный", Font.BOLD);
        addStyleButton("Курсив", Font.ITALIC);
        addStyleButton("Жирный курсив", Font.BOLD + Font.ITALIC);
    }

    private void configureFontMenu() {
        addFontButton("Times New Roman", true);
        addFontButton("Arial");
        addFontButton("Veranda");
    }


    private void addFontButton(String fontName, boolean selected) {
        JRadioButtonMenuItem item = new JRadioButtonMenuItem(fontName);
        item.addActionListener(event -> {
            Font oldFont = textPane.getFont();
            Font newFont = new Font(fontName, oldFont.getStyle(), oldFont.getSize());
            textPane.setFont(newFont);
        });
        if (selected) item.doClick();
        fontMenu.add(item);
    }

    private void addFontButton(String fontName) {
        addFontButton(fontName, false);
    }

    private void addStyleButton(String buttonName, int style, boolean selected) {
        JRadioButtonMenuItem item = new JRadioButtonMenuItem(buttonName);
        item.addActionListener(event -> {
            Font oldFont = textPane.getFont();
            Font newFont = new Font(oldFont.getName(), style, oldFont.getSize());
            textPane.setFont(newFont);
        });
        if (selected) item.doClick();
        styleMenu.add(item);
    }
    private void addStyleButton(String buttonName, int style) {
        addStyleButton(buttonName, style, false);
    }

    public static void createGUI() {
        new JStyleFontFrame();
    }
}

