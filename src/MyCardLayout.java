
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;



public class MyCardLayout extends JFrame {

    private static final long serialVersionUID = 1L;

    public MyCardLayout(String title) {

        super(title);

    }

    public void doShow() {

        setSize(400, 300);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addControl();

        setVisible(true);

    }

    public void addControl() {

        JPanel pnBorder = new JPanel();

        pnBorder.setLayout(new BorderLayout());

        JPanel pnNorth = new JPanel();

        JButton btnShowCard1 = new JButton("Form Student");

        JButton btnShowCard2 = new JButton("List Student");

        pnNorth.add(btnShowCard1);

        pnNorth.add(btnShowCard2);

        pnBorder.add(pnNorth, BorderLayout.NORTH);

        final JPanel pnCenter = new JPanel();

        pnCenter.setLayout(new CardLayout());

        pnCenter.setBackground(Color.LIGHT_GRAY);

        final JPanel pnCard1 = new JPanel();

        pnCard1.setBackground(Color.LIGHT_GRAY);

        pnCard1.add(new JLabel("Form Student"));

        final JPanel pnCard2 = new JPanel();

        pnCard2.setBackground(Color.PINK);

        pnCard2.add(new JLabel("List Student"));

        pnCenter.add(pnCard1, "mycard1");

        pnCenter.add(pnCard2, "mycard2");

        pnBorder.add(pnCenter, BorderLayout.CENTER);

        Container con = getContentPane();

        con.add(pnBorder);

        btnShowCard1.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent arg0) {

                CardLayout cl = (CardLayout) pnCenter.getLayout();

                cl.show(pnCenter, "mycard1");

            }

        });

        btnShowCard2.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent arg0) {

                CardLayout cl = (CardLayout) pnCenter.getLayout();

                cl.show(pnCenter, "mycard2");

            }

        });

    }

    public static void main(String[] args) {

        MyCardLayout card = new MyCardLayout("demo layout");

        card.doShow();

    }

}
