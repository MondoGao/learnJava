package course.homework6;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class CalendarUI extends JFrame {
    private JPanel Main;
    private JPanel SelectedDate;
    private JPanel MonthPick;
    private JPanel jpWeekday;
    private JPanel jpDate;
    private JPanel CalendarWrapper;
    private JPanel DateLine;
    private JButton btnExit;
    private JLabel lbYear;
    private JLabel lbDayMonthDay;
    private JLabel lbMonthYear;
    private JButton prevButton;
    private JButton nextButton;

    private LocalDate now = LocalDate.now();

    public CalendarUI() {
        setSize(310, 440);
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        add(Main);

        pack();
        setLocationRelativeTo(null);

        initComponent();

        CalendarUI that = this;
        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                that.dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                ((JButton) e.getSource()).setBackground(new Color(240, 240, 240));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);

                ((JButton) e.getSource()).setBackground(new Color(255, 255, 255));
            }
        });

        resetDate();
        prevButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                nextMonth(-1);
            }
        });
        nextButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                nextMonth(1);
            }
        });

    }

    private void initComponent() {
        lbYear.setForeground(new Color(255, 255, 255, 178));
        Component[] weekdays = jpWeekday.getComponents();

        for (Component wd : weekdays) {
            wd.setForeground(new Color(0, 0, 0, 100));
        }
    }

    private void nextMonth(int direct) {
        now = now.plusMonths(direct);

        resetDate();
    }

    private void resetDate() {
        int year = now.getYear();
        Month month = now.getMonth();
        int day = now.getDayOfMonth();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        lbYear.setText(String.valueOf(year));
        lbDayMonthDay.setText(capitalize(dayOfWeek.name().substring(0, 3)) + ", " + capitalize(month.name().substring(0, 3)) + " " + day);
        lbMonthYear.setText(capitalize(month.name()) + " " + year);

        LocalDate firstOfMonth = LocalDate.of(year, month, 1);
        DayOfWeek firstDayOfWeek = firstOfMonth.getDayOfWeek();

        int pIndex = 0;
        int dd = 1;
        final Color transparent = new Color(255, 255, 255, 0);
        final Color grey = new Color(240, 240, 240);
        for (Component p : jpDate.getComponents()) {
            JPanel pa = (JPanel) p;

            int lbIndex = 0;
            for (Component l : pa.getComponents()) {
                JLabel lb = (JLabel) l;
                lb.setForeground(transparent);

                if (pIndex == 0) {
                    if (lbIndex + 1 >= firstDayOfWeek.getValue()) {
                        lb.setText(String.valueOf(dd++));
                        lb.setForeground(Color.BLACK);
                    }
                } else if (dd <= month.length(false)) {
                    lb.setText(String.valueOf(dd++));
                    lb.setForeground(Color.BLACK);
                }

                if (dd - 1 == day) {
                    lb.setOpaque(true);
                    lb.setBackground(grey);
                } else {
                    lb.setOpaque(false);
                    lb.setBackground(Color.WHITE);
                }

                lbIndex++;
            }

            pIndex++;
        }

        repaint();
    }

    private String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        Main = new JPanel();
        Main.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        Main.setAlignmentX(0.0f);
        Main.setAlignmentY(0.0f);
        Main.setBackground(new Color(-1));
        Main.setForeground(new Color(-1));
        Main.setMaximumSize(new Dimension(310, 440));
        Main.setMinimumSize(new Dimension(310, 440));
        Main.setPreferredSize(new Dimension(310, 440));
        SelectedDate = new JPanel();
        SelectedDate.setLayout(new GridLayoutManager(2, 1, new Insets(20, 20, 20, 20), 0, 0));
        SelectedDate.setAlignmentX(0.0f);
        SelectedDate.setAlignmentY(0.0f);
        SelectedDate.setBackground(new Color(-16728876));
        SelectedDate.setEnabled(true);
        SelectedDate.setForeground(new Color(-1));
        SelectedDate.setPreferredSize(new Dimension(310, 100));
        Main.add(SelectedDate);
        lbYear = new JLabel();
        Font lbYearFont = this.$$$getFont$$$("SansSerif", -1, 16, lbYear.getFont());
        if (lbYearFont != null) lbYear.setFont(lbYearFont);
        lbYear.setForeground(new Color(-1));
        lbYear.setPreferredSize(new Dimension(270, 20));
        lbYear.setText("year");
        SelectedDate.add(lbYear, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lbDayMonthDay = new JLabel();
        Font lbDayMonthDayFont = this.$$$getFont$$$("SansSerif", -1, 36, lbDayMonthDay.getFont());
        if (lbDayMonthDayFont != null) lbDayMonthDay.setFont(lbDayMonthDayFont);
        lbDayMonthDay.setForeground(new Color(-1));
        lbDayMonthDay.setPreferredSize(new Dimension(270, 20));
        lbDayMonthDay.setText("Day, Mon dd");
        SelectedDate.add(lbDayMonthDay, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        CalendarWrapper = new JPanel();
        CalendarWrapper.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        CalendarWrapper.setBackground(new Color(-1));
        CalendarWrapper.setForeground(new Color(-1));
        CalendarWrapper.setPreferredSize(new Dimension(310, 340));
        Main.add(CalendarWrapper);
        MonthPick = new JPanel();
        MonthPick.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        MonthPick.setBackground(new Color(-1));
        MonthPick.setDoubleBuffered(false);
        MonthPick.setForeground(new Color(-1));
        MonthPick.setMaximumSize(new Dimension(-1, -1));
        MonthPick.setMinimumSize(new Dimension(-1, -1));
        MonthPick.setPreferredSize(new Dimension(294, 48));
        CalendarWrapper.add(MonthPick);
        lbMonthYear = new JLabel();
        Font lbMonthYearFont = this.$$$getFont$$$(null, Font.BOLD, -1, lbMonthYear.getFont());
        if (lbMonthYearFont != null) lbMonthYear.setFont(lbMonthYearFont);
        lbMonthYear.setForeground(new Color(-16777216));
        lbMonthYear.setHorizontalAlignment(0);
        lbMonthYear.setHorizontalTextPosition(0);
        lbMonthYear.setText("month year");
        MonthPick.add(lbMonthYear, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        prevButton = new JButton();
        prevButton.setBackground(new Color(-1));
        prevButton.setBorderPainted(false);
        prevButton.setContentAreaFilled(true);
        Font prevButtonFont = this.$$$getFont$$$(null, Font.BOLD, -1, prevButton.getFont());
        if (prevButtonFont != null) prevButton.setFont(prevButtonFont);
        prevButton.setForeground(new Color(-16777216));
        prevButton.setHorizontalAlignment(0);
        prevButton.setHorizontalTextPosition(10);
        prevButton.setMargin(new Insets(3, 0, 0, 0));
        prevButton.setOpaque(true);
        prevButton.setText("Prev");
        MonthPick.add(prevButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(68, 32), null, 0, false));
        nextButton = new JButton();
        nextButton.setBackground(new Color(-1));
        nextButton.setBorderPainted(false);
        nextButton.setContentAreaFilled(true);
        Font nextButtonFont = this.$$$getFont$$$(null, Font.BOLD, -1, nextButton.getFont());
        if (nextButtonFont != null) nextButton.setFont(nextButtonFont);
        nextButton.setForeground(new Color(-16777216));
        nextButton.setHorizontalAlignment(0);
        nextButton.setHorizontalTextPosition(4);
        nextButton.setMargin(new Insets(3, 0, 0, 0));
        nextButton.setOpaque(true);
        nextButton.setText("Next");
        MonthPick.add(nextButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        jpWeekday = new JPanel();
        jpWeekday.setLayout(new GridLayoutManager(1, 7, new Insets(0, 0, 0, 0), -1, -1));
        jpWeekday.setBackground(new Color(-1));
        jpWeekday.setForeground(new Color(-1));
        jpWeekday.setMinimumSize(new Dimension(204, 20));
        jpWeekday.setPreferredSize(new Dimension(294, 24));
        CalendarWrapper.add(jpWeekday);
        final JLabel label1 = new JLabel();
        label1.setOpaque(false);
        label1.setText("M");
        jpWeekday.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setOpaque(false);
        label2.setText("T");
        jpWeekday.add(label2, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setOpaque(false);
        label3.setText("W");
        jpWeekday.add(label3, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setOpaque(false);
        label4.setText("T");
        jpWeekday.add(label4, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setOpaque(false);
        label5.setText("F");
        jpWeekday.add(label5, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setOpaque(false);
        label6.setText("S");
        jpWeekday.add(label6, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setOpaque(false);
        label7.setText("S");
        jpWeekday.add(label7, new GridConstraints(0, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jpDate = new JPanel();
        jpDate.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        jpDate.setBackground(new Color(-1));
        jpDate.setForeground(new Color(-1));
        jpDate.setPreferredSize(new Dimension(294, 214));
        CalendarWrapper.add(jpDate);
        DateLine = new JPanel();
        DateLine.setLayout(new GridLayoutManager(1, 7, new Insets(0, 0, 0, 0), -1, -1, true, true));
        DateLine.setBackground(new Color(-1));
        DateLine.setPreferredSize(new Dimension(294, 36));
        jpDate.add(DateLine);
        final JLabel label8 = new JLabel();
        label8.setBackground(new Color(-1));
        label8.setDoubleBuffered(true);
        label8.setFocusable(false);
        label8.setForeground(new Color(-16777216));
        label8.setHorizontalAlignment(0);
        label8.setHorizontalTextPosition(0);
        label8.setOpaque(false);
        label8.setText("1");
        label8.setVisible(true);
        DateLine.add(label8, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setBackground(new Color(-1));
        label9.setDoubleBuffered(true);
        label9.setForeground(new Color(-16777216));
        label9.setHorizontalAlignment(0);
        label9.setHorizontalTextPosition(0);
        label9.setText("2");
        DateLine.add(label9, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setAlignmentX(0.5f);
        label10.setBackground(new Color(-1));
        label10.setDoubleBuffered(true);
        label10.setForeground(new Color(-16777216));
        label10.setHorizontalAlignment(0);
        label10.setHorizontalTextPosition(0);
        label10.setText("3");
        DateLine.add(label10, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label11 = new JLabel();
        label11.setAlignmentX(0.5f);
        label11.setBackground(new Color(-1));
        label11.setDoubleBuffered(true);
        label11.setForeground(new Color(-16777216));
        label11.setHorizontalAlignment(0);
        label11.setHorizontalTextPosition(0);
        label11.setText("4");
        DateLine.add(label11, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label12 = new JLabel();
        label12.setAlignmentX(0.5f);
        label12.setBackground(new Color(-1));
        label12.setDoubleBuffered(true);
        label12.setForeground(new Color(-16777216));
        label12.setHorizontalAlignment(0);
        label12.setHorizontalTextPosition(0);
        label12.setText("5");
        DateLine.add(label12, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label13 = new JLabel();
        label13.setAlignmentX(0.5f);
        label13.setBackground(new Color(-1));
        label13.setDoubleBuffered(true);
        label13.setForeground(new Color(-16777216));
        label13.setHorizontalAlignment(0);
        label13.setHorizontalTextPosition(0);
        label13.setText("6");
        DateLine.add(label13, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label14 = new JLabel();
        label14.setAlignmentX(0.5f);
        label14.setBackground(new Color(-1));
        label14.setDoubleBuffered(true);
        label14.setForeground(new Color(-16777216));
        label14.setHorizontalAlignment(0);
        label14.setHorizontalTextPosition(0);
        label14.setText("7");
        DateLine.add(label14, new GridConstraints(0, 6, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 7, new Insets(0, 0, 0, 0), -1, -1, true, true));
        panel1.setBackground(new Color(-1));
        panel1.setPreferredSize(new Dimension(294, 36));
        jpDate.add(panel1);
        final JLabel label15 = new JLabel();
        label15.setDoubleBuffered(true);
        label15.setHorizontalAlignment(0);
        label15.setHorizontalTextPosition(0);
        label15.setText("1");
        panel1.add(label15, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label16 = new JLabel();
        label16.setBackground(new Color(-1));
        label16.setDoubleBuffered(true);
        label16.setHorizontalAlignment(0);
        label16.setHorizontalTextPosition(0);
        label16.setText("2");
        panel1.add(label16, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label17 = new JLabel();
        label17.setAlignmentX(0.5f);
        label17.setDoubleBuffered(true);
        label17.setHorizontalAlignment(0);
        label17.setHorizontalTextPosition(0);
        label17.setText("3");
        panel1.add(label17, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label18 = new JLabel();
        label18.setAlignmentX(0.5f);
        label18.setDoubleBuffered(true);
        label18.setHorizontalAlignment(0);
        label18.setHorizontalTextPosition(0);
        label18.setText("4");
        panel1.add(label18, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label19 = new JLabel();
        label19.setAlignmentX(0.5f);
        label19.setDoubleBuffered(true);
        label19.setHorizontalAlignment(0);
        label19.setHorizontalTextPosition(0);
        label19.setText("5");
        panel1.add(label19, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label20 = new JLabel();
        label20.setAlignmentX(0.5f);
        label20.setDoubleBuffered(true);
        label20.setHorizontalAlignment(0);
        label20.setHorizontalTextPosition(0);
        label20.setText("6");
        panel1.add(label20, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label21 = new JLabel();
        label21.setAlignmentX(0.5f);
        label21.setDoubleBuffered(true);
        label21.setHorizontalAlignment(0);
        label21.setHorizontalTextPosition(0);
        label21.setText("7");
        panel1.add(label21, new GridConstraints(0, 6, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 7, new Insets(0, 0, 0, 0), -1, -1, true, true));
        panel2.setBackground(new Color(-1));
        panel2.setPreferredSize(new Dimension(294, 36));
        jpDate.add(panel2);
        final JLabel label22 = new JLabel();
        label22.setDoubleBuffered(true);
        label22.setHorizontalAlignment(0);
        label22.setHorizontalTextPosition(0);
        label22.setText("1");
        panel2.add(label22, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label23 = new JLabel();
        label23.setDoubleBuffered(true);
        label23.setHorizontalAlignment(0);
        label23.setHorizontalTextPosition(0);
        label23.setText("2");
        panel2.add(label23, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label24 = new JLabel();
        label24.setAlignmentX(0.5f);
        label24.setDoubleBuffered(true);
        label24.setHorizontalAlignment(0);
        label24.setHorizontalTextPosition(0);
        label24.setText("3");
        panel2.add(label24, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label25 = new JLabel();
        label25.setAlignmentX(0.5f);
        label25.setDoubleBuffered(true);
        label25.setHorizontalAlignment(0);
        label25.setHorizontalTextPosition(0);
        label25.setText("4");
        panel2.add(label25, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label26 = new JLabel();
        label26.setAlignmentX(0.5f);
        label26.setDoubleBuffered(true);
        label26.setHorizontalAlignment(0);
        label26.setHorizontalTextPosition(0);
        label26.setText("5");
        panel2.add(label26, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label27 = new JLabel();
        label27.setAlignmentX(0.5f);
        label27.setDoubleBuffered(true);
        label27.setHorizontalAlignment(0);
        label27.setHorizontalTextPosition(0);
        label27.setText("6");
        panel2.add(label27, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label28 = new JLabel();
        label28.setAlignmentX(0.5f);
        label28.setDoubleBuffered(true);
        label28.setHorizontalAlignment(0);
        label28.setHorizontalTextPosition(0);
        label28.setText("7");
        panel2.add(label28, new GridConstraints(0, 6, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(1, 7, new Insets(0, 0, 0, 0), -1, -1, true, true));
        panel3.setBackground(new Color(-1));
        panel3.setPreferredSize(new Dimension(294, 36));
        jpDate.add(panel3);
        final JLabel label29 = new JLabel();
        label29.setDoubleBuffered(true);
        label29.setHorizontalAlignment(0);
        label29.setHorizontalTextPosition(0);
        label29.setText("1");
        panel3.add(label29, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label30 = new JLabel();
        label30.setDoubleBuffered(true);
        label30.setHorizontalAlignment(0);
        label30.setHorizontalTextPosition(0);
        label30.setText("2");
        panel3.add(label30, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label31 = new JLabel();
        label31.setAlignmentX(0.5f);
        label31.setDoubleBuffered(true);
        label31.setHorizontalAlignment(0);
        label31.setHorizontalTextPosition(0);
        label31.setText("3");
        panel3.add(label31, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label32 = new JLabel();
        label32.setAlignmentX(0.5f);
        label32.setDoubleBuffered(true);
        label32.setHorizontalAlignment(0);
        label32.setHorizontalTextPosition(0);
        label32.setText("4");
        panel3.add(label32, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label33 = new JLabel();
        label33.setAlignmentX(0.5f);
        label33.setDoubleBuffered(true);
        label33.setHorizontalAlignment(0);
        label33.setHorizontalTextPosition(0);
        label33.setText("5");
        panel3.add(label33, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label34 = new JLabel();
        label34.setAlignmentX(0.5f);
        label34.setDoubleBuffered(true);
        label34.setHorizontalAlignment(0);
        label34.setHorizontalTextPosition(0);
        label34.setText("6");
        panel3.add(label34, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label35 = new JLabel();
        label35.setAlignmentX(0.5f);
        label35.setDoubleBuffered(true);
        label35.setHorizontalAlignment(0);
        label35.setHorizontalTextPosition(0);
        label35.setText("7");
        panel3.add(label35, new GridConstraints(0, 6, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayoutManager(1, 7, new Insets(0, 0, 0, 0), -1, -1, true, true));
        panel4.setBackground(new Color(-1));
        panel4.setPreferredSize(new Dimension(294, 36));
        jpDate.add(panel4);
        final JLabel label36 = new JLabel();
        label36.setDoubleBuffered(true);
        label36.setHorizontalAlignment(0);
        label36.setHorizontalTextPosition(0);
        label36.setText("1");
        panel4.add(label36, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label37 = new JLabel();
        label37.setDoubleBuffered(true);
        label37.setHorizontalAlignment(0);
        label37.setHorizontalTextPosition(0);
        label37.setText("2");
        panel4.add(label37, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label38 = new JLabel();
        label38.setAlignmentX(0.5f);
        label38.setDoubleBuffered(true);
        label38.setHorizontalAlignment(0);
        label38.setHorizontalTextPosition(0);
        label38.setText("3");
        panel4.add(label38, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label39 = new JLabel();
        label39.setAlignmentX(0.5f);
        label39.setDoubleBuffered(true);
        label39.setHorizontalAlignment(0);
        label39.setHorizontalTextPosition(0);
        label39.setText("4");
        panel4.add(label39, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label40 = new JLabel();
        label40.setAlignmentX(0.5f);
        label40.setDoubleBuffered(true);
        label40.setHorizontalAlignment(0);
        label40.setHorizontalTextPosition(0);
        label40.setText("5");
        panel4.add(label40, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label41 = new JLabel();
        label41.setAlignmentX(0.5f);
        label41.setDoubleBuffered(true);
        label41.setHorizontalAlignment(0);
        label41.setHorizontalTextPosition(0);
        label41.setText("6");
        panel4.add(label41, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label42 = new JLabel();
        label42.setAlignmentX(0.5f);
        label42.setDoubleBuffered(true);
        label42.setHorizontalAlignment(0);
        label42.setHorizontalTextPosition(0);
        label42.setText("7");
        panel4.add(label42, new GridConstraints(0, 6, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayoutManager(1, 7, new Insets(0, 0, 0, 0), -1, -1, true, true));
        panel5.setBackground(new Color(-1));
        panel5.setPreferredSize(new Dimension(294, 36));
        jpDate.add(panel5);
        final JLabel label43 = new JLabel();
        label43.setDoubleBuffered(true);
        label43.setHorizontalAlignment(0);
        label43.setHorizontalTextPosition(0);
        label43.setText("1");
        panel5.add(label43, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label44 = new JLabel();
        label44.setDoubleBuffered(true);
        label44.setHorizontalAlignment(0);
        label44.setHorizontalTextPosition(0);
        label44.setText("2");
        panel5.add(label44, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label45 = new JLabel();
        label45.setAlignmentX(0.5f);
        label45.setDoubleBuffered(true);
        label45.setHorizontalAlignment(0);
        label45.setHorizontalTextPosition(0);
        label45.setText("3");
        panel5.add(label45, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label46 = new JLabel();
        label46.setAlignmentX(0.5f);
        label46.setDoubleBuffered(true);
        label46.setHorizontalAlignment(0);
        label46.setHorizontalTextPosition(0);
        label46.setText("4");
        panel5.add(label46, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label47 = new JLabel();
        label47.setAlignmentX(0.5f);
        label47.setDoubleBuffered(true);
        label47.setHorizontalAlignment(0);
        label47.setHorizontalTextPosition(0);
        label47.setText("5");
        panel5.add(label47, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label48 = new JLabel();
        label48.setAlignmentX(0.5f);
        label48.setDoubleBuffered(true);
        label48.setHorizontalAlignment(0);
        label48.setHorizontalTextPosition(0);
        label48.setText("6");
        panel5.add(label48, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JLabel label49 = new JLabel();
        label49.setAlignmentX(0.5f);
        label49.setDoubleBuffered(true);
        label49.setHorizontalAlignment(0);
        label49.setHorizontalTextPosition(0);
        label49.setText("7");
        panel5.add(label49, new GridConstraints(0, 6, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(34, 34), null, 0, false));
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new FlowLayout(FlowLayout.TRAILING, 0, 5));
        panel6.setBackground(new Color(-1));
        panel6.setPreferredSize(new Dimension(294, 46));
        CalendarWrapper.add(panel6);
        btnExit = new JButton();
        btnExit.setAlignmentX(0.5f);
        btnExit.setBackground(new Color(-1));
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(true);
        btnExit.setForeground(new Color(-16728876));
        btnExit.setIconTextGap(0);
        btnExit.setMargin(new Insets(0, 0, 0, 0));
        btnExit.setOpaque(true);
        btnExit.setText("退出");
        panel6.add(btnExit);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return Main;
    }
}
