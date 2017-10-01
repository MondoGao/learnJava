package course.homework6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HoverButton extends JButton {
    public static Color LIGHT_GREY = new Color(240,240,240);

    public static class handleMouseHover<T extends Component> extends MouseAdapter {
        private Color lastColor;

        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);
            T comp = (T)e.getSource();

            lastColor = comp.getBackground();
            comp.setBackground(LIGHT_GREY);
            if (comp instanceof JLabel) {
                ((JLabel) comp).setOpaque(true);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);

            T comp = (T)e.getSource();

            comp.setBackground(lastColor);
            if (comp instanceof JLabel) {
                ((JLabel) comp).setOpaque(false);
            }
        }
    }
    public HoverButton(Color c) {
        super();
        setBackground(c);
        this.addMouseListener(new handleMouseHover<JButton>());
    }
}
