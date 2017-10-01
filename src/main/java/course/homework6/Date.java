package course.homework6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Date extends JFrame {
    private JPanel Main;
    private JPanel SelectedDate;
    private JPanel MonthPick;
    private JPanel Weekday;
    private JPanel Date;
    private JButton button1;
    private JButton button2;
    private JPanel CalendarWrapper;
    private JPanel DateLine;
    private JButton btnExit;
    private JLabel lbYear;
    private JLabel lbDate;

    public Date() {
        setSize(310, 440);
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        add(Main);

        pack();
        setLocationRelativeTo(null);

        initComponent();

        Date that = this;
        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
               that.dispose();
            }
        });
    }

    private void initComponent() {
        lbYear.setForeground(new Color(255,255,255,178));

    }
}
