package com.clima.util;

//https://www.youtube.com/watch?v=aKWXWtLacAY

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
* Classe para gerenciar chamada das jInternalFrame na tela principal.
*/

public class GerenciadorDeJanelas {

    //private static JDesktopPane jDesktopPane;
    public static JDesktopPane jDesktopPane;

    public GerenciadorDeJanelas(JDesktopPane jDesktopPane) {
        GerenciadorDeJanelas.jDesktopPane = jDesktopPane;
    }

    public void abrirJanelas(JInternalFrame jInternalFrame) {
        if (jInternalFrame.isVisible()) {
            jInternalFrame.toFront();
            jInternalFrame.requestFocus();
        } else {
            jDesktopPane.add(jInternalFrame);
            jInternalFrame.setVisible(true);
        }

    }

}
