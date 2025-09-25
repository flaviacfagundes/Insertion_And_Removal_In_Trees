
import com.formdev.flatlaf.FlatDarkLaf;
import view.TelaPrincipal;
import javax.swing.UIManager;

class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Falha ao inicializar o tema escuro.");
        }
        java.awt.EventQueue.invokeLater(() -> {
            new TelaPrincipal(
                    "Visualizador de Árvore Binária",
                    1200,
                    800
            );
        });
    }
}
