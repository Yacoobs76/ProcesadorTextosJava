
package procesadortexto;


/**
 * Aprende Java con Yacoobs
 * @author Yacoobs C. M. 
 * https://www.youtube.com/channel/UChFlaF3Ji9vWhizWyhBQdBg?view_as=subscriber
 * Para contactar conmigo: reyrelampago2005@gamil.com
 * Dia Creación 23-feb-2020
 * Tiempo Creación 9:45:39
 * 
 */

 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.StyledEditorKit;
 
 
public class procesadortexto
{
    public static void main(String[] args)
    {
 
        MarcoStyled marco=new MarcoStyled();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}
 
 
final class MarcoStyled extends JFrame
{
    public MarcoStyled()
    {
        setBounds(400,150,500,300);
        setTitle("Word y Menu");
        LaminaStyled lamina=new LaminaStyled();
        add(lamina);
        setDefaultCloseOperation(0);
    }
}
 
final class LaminaStyled extends JPanel
{
 
    private final JMenu fuente;
    private final JMenu estilo;
    private final JMenu tamagno;
    private final JMenu color;
    private final JTextPane miarea;
 
 
    public LaminaStyled()
    {
 
        setLayout(new BorderLayout());
 
        miarea = new JTextPane();
 
        add(miarea,BorderLayout.CENTER);
 
        JPanel laminamenu=new JPanel();
 
        JMenuBar barra=new JMenuBar();
 
        fuente=new JMenu("Fuente");
 
        estilo=new JMenu("Estilo");
 
        tamagno=new JMenu("Tamaño");
 
        color=new JMenu("Color");
 
        barra.add(fuente);
 
        barra.add(estilo);
 
        barra.add(tamagno);
 
        barra.add(color);
 
 
        laminamenu.add(barra);
 
        add(laminamenu,BorderLayout.NORTH);
 
 
        //--------------------------------------------
 
 
        //Llamada al metodo para obtener todas las fuentes de tu sistema.
        String fuentes[] = getFuentesWin();
 
        //Bucle Foreach recorre el array de fuentes almacenando sus datos en el.
        for (String dato: fuentes)
        {
            JMenuItem elem_menu = new JMenuItem(dato);
            fuente.add(elem_menu);
            elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("", dato));
        }
 
        //--------------------------------------------
 
        Ingre_Style("Negrita");
        Ingre_Style("Cursiva");
 
        //--------------------------------------------
 
        for (int sice =12;sice<62;sice+=2)
        {
            JMenuItem elem_menu = new JMenuItem(String.valueOf(sice));
            tamagno.add(elem_menu);
            elem_menu.addActionListener(new StyledEditorKit.FontSizeAction("", sice));
        }
 
        //--------------------------------------------
 
        String colores[] = {"Negro", "Rojo", "Azul", "Verde"};
 
        for (String col: colores)
        {
            Ingre_Color(col);
        }
 
 }
    public void Ingre_Style(String elemento)
    {
        JMenuItem elem_menu = new JMenuItem(elemento);
        estilo.add(elem_menu);
        if (elemento.equals("Negrita"))
            elem_menu.addActionListener(new StyledEditorKit.BoldAction());
        if (elemento.equals("Cursiva"))
            elem_menu.addActionListener(new StyledEditorKit.ItalicAction());
 
    }
 
    public void Ingre_Color(String elemento)
    {
        JMenuItem elem_menu = new JMenuItem(elemento);
        color.add(elem_menu);
        if (elemento.equals("Negro"))
            elem_menu.addActionListener(new StyledEditorKit.ForegroundAction("", Color.BLACK));
        if (elemento.equals("Rojo"))
            elem_menu.addActionListener(new StyledEditorKit.ForegroundAction("", Color.RED));
        if (elemento.equals("Azul"))
            elem_menu.addActionListener(new StyledEditorKit.ForegroundAction("", Color.BLUE));
        if (elemento.equals("Verde"))
            elem_menu.addActionListener(new StyledEditorKit.ForegroundAction("", Color.GREEN));
 
    }
 
    //Este metodo devuelve un array con todas las fuentes disponibles por tu sistema.
    public String[] getFuentesWin()
    {
        return GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    }
 
}
