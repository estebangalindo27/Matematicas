import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class juego {
    Random random = new Random();
    private int opera;
    private int punta=0, numJuga=0;
    boolean intento=false;
    ArrayList<jugador> jugadores =new ArrayList<jugador>();
    jugador jugaS;
    ranking rank = new ranking();

    private JTabbedPane opciones;
    private JPanel panel1;
    private JTextField respuesta;
    private JButton btnAceptarRes;
    private JLabel n1Txt;
    private JLabel signoTxt;
    private JLabel n2Txt;
    private JTextField txtNombre;
    private JButton btnAceptar;
    private JLabel txt1;
    private JPanel jueguito;
    private JPanel ranked;
    private JLabel txt2;
    private JTextArea txtARanking;

    private void generar(){
        int operacion = random.nextInt(3) + 1;
        int n1 = random.nextInt(10) + 1;
        int n2 = random.nextInt(10) + 1;

        if(intento){
            JOptionPane.showMessageDialog(null,"Has Terminado");
            jueguito.setVisible(false);
            opciones.setSelectedComponent(ranked);
            jugaS.setScore(punta);
            rank.agregar(jugaS);
            rank.ordenar();
            txtARanking.setText("Nombre         Score\n"+rank.imprimir());
            numJuga++;
            intento=false;
            punta=0;
            jueguito.setVisible(false);
            txt2.setVisible(false);
            btnAceptarRes.setVisible(false);
            respuesta.setVisible(false);
            txtNombre.setVisible(true);
            txt1.setVisible(true);
            btnAceptar.setVisible(true);
            respuesta.setText("");
            generar();
        }else{
            n1Txt.setText(String.valueOf(n1));
            n2Txt.setText(String.valueOf(n2));
            switch (operacion){
                case 1: {
                    signoTxt.setText("*");
                    break;
                }
                case 2: {
                    signoTxt.setText("+");
                    break;
                }
                case 3: {
                    signoTxt.setText("-");
                    break;
                }

            }
            opera=operacion;
        }
    }
public juego() {
    JOptionPane.showMessageDialog(null,"Estas Listo para empezar");
    generar();
    jueguito.setVisible(false);
    txt2.setVisible(false);
    btnAceptarRes.setVisible(false);
    respuesta.setVisible(false);

    btnAceptarRes.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int n1=Integer.parseInt(n1Txt.getText());
            int n2=Integer.parseInt(n2Txt.getText());
            switch (opera){
                case 1: {//*
                    if(respuesta.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"No respondiste");
                    }else if((n1*n2)==Double.parseDouble(respuesta.getText())){
                            JOptionPane.showMessageDialog(null, "Correcto");
                            punta += 1;
                            respuesta.setText("");
                            generar();
                        }else{
                            JOptionPane.showMessageDialog(null,"Te equivocaste");
                             intento = true;
                            generar();
                        }
                    break;
                }
                case 2: {//+
                    if(respuesta.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"No respondiste");
                    }else if((n1+n2)==Double.parseDouble(respuesta.getText())){
                        JOptionPane.showMessageDialog(null, "Correcto");
                        punta += 1;
                        respuesta.setText("");
                        generar();
                    }else{
                        JOptionPane.showMessageDialog(null,"Te equivocaste");
                        intento = true;
                        generar();
                    }
                    break;
                }
                case 3: {//-
                    if(respuesta.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"No respondiste");
                    }else if((n1-n2)==Double.parseDouble(respuesta.getText())){
                        JOptionPane.showMessageDialog(null, "Correcto");
                        punta += 1;
                        respuesta.setText("");
                        generar();
                    }else{
                        JOptionPane.showMessageDialog(null,"Te equivocaste");
                        intento = true;
                        generar();
                    }
                }
            }
        }
    });
    btnAceptar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(txtNombre.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Debe Ingresar un nombre");
            }else{
                jugadores.add(new jugador(txtNombre.getText()));
                jugaS = jugadores.get(numJuga);
                txtNombre.setVisible(false);
                txt1.setVisible(false);
                btnAceptar.setVisible(false);
                jueguito.setVisible(true);
                txt2.setVisible(true);
                btnAceptarRes.setVisible(true);
                respuesta.setVisible(true);
                txtNombre.setText("");
            }
        }
    });
}

    public static void main(String[] args) {
        JFrame frame = new JFrame("juego");
        frame.setContentPane(new juego().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
