package me.jay;

import me.jay.utils.HWID;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

/**
 * @Author Jay
 */
public class Frame {

    public void onInit() {
        try {
            JFrame frame = new JFrame("External HWID");

            Dimension size = new Dimension(500, 500);

            frame.setLayout(new GridBagLayout());
            frame.setMaximumSize(size);
            frame.setMinimumSize(size);
            frame.setPreferredSize(size);
            frame.setResizable(false);
            frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("assets/logo.png")));
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            GridBagConstraints c = new GridBagConstraints();

            JLabel title = new JLabel("External HWID");
            c.gridx = 0;
            c.gridy = 0;
            title.setSize(500, 500);
            title.setFont(new Font("URW Gothic L", Font.PLAIN, 50));
            frame.add(title, c);

            JLabel author = new JLabel("By Jay");
            c.gridx = 0;
            c.gridy = 1;
            author.setSize(50, 50);
            author.setFont(new Font("URW Gothic L", Font.PLAIN, 50));
            frame.add(author, c);

            JLabel empty = new JLabel("-");
            c.gridx = 0;
            c.gridy = 2;
            empty.setSize(50, 50);
            frame.add(empty, c);

            JButton github = new JButton("Visit My Github!");
            c.gridx = 0;
            c.gridy = 3;
            github.setPreferredSize(new Dimension(200, 30));

            github.addActionListener(e -> {
                try {
                    if(Desktop.isDesktopSupported()) {
                        Desktop.getDesktop().browse(new URI("https://www.github.com/SyntheticJay"));
                    }
                }catch(Exception error) {
                    JOptionPane.showMessageDialog(frame, "Failed to take user to github page! Printed Stacktrace to console");
                    error.printStackTrace();
                }
            });

            frame.add(github, c);

            JButton copy = new JButton("Copy HWID");
            c.gridx = 0;
            c.gridy = 4;
            copy.setPreferredSize(new Dimension(150, 30));

            copy.addActionListener(e -> {
                try {
                    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(HWID.getHWID()), null);
                    JOptionPane.showMessageDialog(frame, "Copied HWID (" + HWID.getHWID() + ") To Clipboard.");
                }catch(Exception error) {
                    JOptionPane.showMessageDialog(frame, "Failed to grab HWID! Printed Stacktrace to console");
                    error.printStackTrace();
                }
            });

            frame.add(copy, c);

            JButton exit = new JButton("Exit");
            c.gridx = 0;
            c.gridy = 5;
            exit.setPreferredSize(new Dimension(100, 30));

            exit.addActionListener(e -> {
                try {
                    System.exit(1);
                }catch(Exception error) {
                    error.printStackTrace();
                }
            });

            frame.add(exit, c);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}
