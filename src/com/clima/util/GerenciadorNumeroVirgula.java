

package com.clima.util;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class GerenciadorNumeroVirgula {
    
        public void teclaPressionada(KeyEvent tecla, JTextField txt) {
        //ASCII Numero zero até nove é representado pelo 48 até 57
        //ASCII Space é representado pelo valor 8
        //ASCII Ponto é representado pelo valor 46
        if (((tecla.getKeyCode() < 48 || tecla.getKeyCode() > 57)
          && (tecla.getKeyCode() < 96 || tecla.getKeyCode() > 105) //Linha de código feito para meu teclado numérico.
           && (tecla.getKeyCode() != 8 && tecla.getKeyCode() != 46))) {
            if (txt.getText().length() > 0) {
                txt.setText(txt.getText().
                        substring(0, txt.getText().length() - 1));
            }
        }

//ASCII trocando virgula por ponto
        if (tecla.getKeyCode() == 44 || tecla.getKeyCode() == 110) {//A virgula é representado pelo valor 44 e o 110 teclado numérico.
            txt.setText(txt.getText() + ".");
        }
    }

}

