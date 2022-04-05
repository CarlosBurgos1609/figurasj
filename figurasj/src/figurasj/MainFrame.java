/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figurasj;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import figurasj.Panel.FormPanel;
import figurasj.Panel.LienzoPanel;

/**
 *
 * @author Santiago
 */
public class MainFrame extends JFrame {

    public MainFrame() {
        super();
        this.initComponents();
    }

    private void initComponents() {
        this.setTitle("Figuras");
        this.setSize(800, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));

        LienzoPanel lienzoPanel = new LienzoPanel(Color.WHITE);

        this.add(new FormPanel(lienzoPanel));
        this.add(lienzoPanel);

        this.setVisible(true);
    }
}
