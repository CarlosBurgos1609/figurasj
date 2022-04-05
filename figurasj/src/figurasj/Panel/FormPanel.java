/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figurasj.Panel;

import figurasj.Dibujo;
import figurasj.Figura;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Santiago
 */
public class FormPanel extends JPanel {

    JLabel lblX1, lblY1, lblX2, lblY2;
    JTextField tfX1, tfY1, tfX2, tfY2;
    JComboBox<Figura> cbFigura;
    JCheckBox chkRelleno;
    JButton btnColor, btnFondo, btnDibujar, btnLimpiar;
    LienzoPanel lienzoPanel;

    public FormPanel(LienzoPanel lienzoPanel) {
        super();
        this.lienzoPanel = lienzoPanel;
        this.initComponents();
    }

    private void initComponents() {
        this.setLayout(new GridLayout(9, 2, 5, 5));
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        this.lblX1 = new JLabel("x1:");
        this.lblY1 = new JLabel("y1:");
        this.lblX2 = new JLabel("x2:");
        this.lblY2 = new JLabel("y2:");
        this.tfX1 = new JTextField();
        this.tfY1 = new JTextField();
        this.tfX2 = new JTextField();
        this.tfY2 = new JTextField();
        this.cbFigura = new JComboBox<Figura>(Figura.values());
        this.cbFigura.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cbFiguraActionPerformed(evt);
            }
        });

        this.chkRelleno = new JCheckBox();
        this.btnFondo = new JButton();
        this.btnFondo.setBackground(lienzoPanel.getColor());
        this.btnFondo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnFondoActionPerformed(evt);
            }
        });
        this.btnColor = new JButton();
        this.btnColor.setBackground(Color.BLACK);
        this.btnColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnColorActionPerformed(evt);
            }
        });
        this.btnDibujar = new JButton("Dibujar");
        this.btnDibujar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnDibujarActionPerformed(evt);
            }
        });
        this.btnLimpiar = new JButton("Limpiar");
        this.btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        this.add(new JLabel("Fondo:"));
        this.add(this.btnFondo);
        this.add(this.lblX1);
        this.add(this.tfX1);
        this.add(this.lblY1);
        this.add(this.tfY1);
        this.add(this.lblX2);
        this.add(this.tfX2);
        this.add(this.lblY2);
        this.add(this.tfY2);
        this.add(new JLabel("Figura:"));
        this.add(this.cbFigura);
        this.add(new JLabel("Relleno:"));
        this.add(this.chkRelleno);
        this.add(new JLabel("Color:"));
        this.add(this.btnColor);
        this.add(this.btnDibujar);
        this.add(this.btnLimpiar);
        this.setPreferredSize(new Dimension(300, 250));
        this.setMaximumSize(this.getPreferredSize());
        this.setMinimumSize(this.getPreferredSize());
    }

    private void cbFiguraActionPerformed(ActionEvent evt) {
        Figura figura = (Figura) this.cbFigura.getSelectedItem();
        switch (figura) {
            case LINEA:
                this.lblX1.setText("x1:");
                this.lblY1.setText("y1:");
                this.lblX2.setText("x2:");
                this.lblY2.setText("y2:");
                break;
            default:
                this.lblX1.setText("x:");
                this.lblY1.setText("y:");
                this.lblX2.setText("w:");
                this.lblY2.setText("h:");
                break;
        }
    }

    private void btnFondoActionPerformed(ActionEvent evt) {
        Color color = JColorChooser.showDialog(this, "Seleccione un color", this.btnFondo.getBackground());
        if (color != null) {
            this.btnFondo.setBackground(color);
            this.lienzoPanel.setColor(color);
        }
    }

    private void btnColorActionPerformed(ActionEvent evt) {
        Color color = JColorChooser.showDialog(this, "Seleccione un color", this.btnColor.getBackground());
        if (color != null) {
            this.btnColor.setBackground(color);
        }
    }

    private void btnDibujarActionPerformed(ActionEvent evt) {
        Dibujo dibujo = this.getDibujo();
        if (dibujo == null)
            return;
        this.lienzoPanel.addDibujo(dibujo);
    }

    private void btnLimpiarActionPerformed(ActionEvent evt) {
        this.lienzoPanel.limpiar();
    }

    public Dibujo getDibujo() {
        try {
            int x1 = Integer.parseInt(this.tfX1.getText());
            int y1 = Integer.parseInt(this.tfY1.getText());
            int x2 = Integer.parseInt(this.tfX2.getText());
            int y2 = Integer.parseInt(this.tfY2.getText());
            Figura figura = (Figura) this.cbFigura.getSelectedItem();
            boolean relleno = this.chkRelleno.isSelected();
            Color color = this.btnColor.getBackground();

            return new Dibujo(x1, y1, x2, y2, figura, relleno, color);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en los datos");
            return null;
        }
    }
}
