//UNIVERSIDADE DO VALE DO ITAJAÍ - UNIVALI
//Escola do Mar, Ciência e Tecnologia
//Curso de Ciência da Computação – Campus Kobrasol
//Disciplina: Compiladores
//Professor:  Alessandro Mueller
//Alunos:     Guilherme Veiga, Bruno Frassetto e Fabio Volkmann Coelho
package semantico;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainScreen extends javax.swing.JFrame {

    public Console c = new Console();
    public TableObject tblo = new TableObject();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAbout;
    private javax.swing.JButton btCompile;
    private javax.swing.JButton btCopy;
    private javax.swing.JButton btCut;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btOpen;
    private javax.swing.JButton btPaste;
    private javax.swing.JButton btRun;
    private javax.swing.JButton btSave;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JSplitPane jSplitPanel;
    private javax.swing.JMenu jmCompile;
    private javax.swing.JMenu jmEdit;
    private javax.swing.JMenu jmFile;
    private javax.swing.JMenu jmHelp;
    private javax.swing.JMenuBar jmbMenuBar;
    private javax.swing.JMenuItem jmiAbout;
    private javax.swing.JMenuItem jmiCompile;
    private javax.swing.JMenuItem jmiCopy;
    private javax.swing.JMenuItem jmiCut;
    private javax.swing.JMenuItem jmiExit;
    private javax.swing.JMenuItem jmiHelp;
    private javax.swing.JMenuItem jmiNew;
    private javax.swing.JMenuItem jmiOpen;
    private javax.swing.JMenuItem jmiPaste;
    private javax.swing.JMenuItem jmiRun;
    private javax.swing.JMenuItem jmiSave;
    private javax.swing.JMenuItem jmiSaveAs;
    private javax.swing.JPanel jpEdit;
    private javax.swing.JPanel jpMain;
    private javax.swing.JPanel jpMessage;
    private javax.swing.JToolBar.Separator jsToolBarSeparator1;
    private javax.swing.JToolBar.Separator jsToolBarSeparator2;
    private javax.swing.JScrollPane jspEdit;
    private javax.swing.JScrollPane jspMessage;
    private javax.swing.JEditorPane jtaEdit;
    private javax.swing.JTextArea jtaMessage;
    private javax.swing.JToolBar jtbToolBar;
    private javax.swing.JLabel lbErr;
    private javax.swing.JLabel lbFeedback;
    private javax.swing.JLabel lbPosition;
    // End of variables declaration//GEN-END:variables
    private ScreenController control = new ScreenController();
    private String fileName = "sem nome.txt";
    private String filePath = "";
    private List<Instruction> instructions = new ArrayList<>();

    /**
     * Creates new form Screen
     */
    public MainScreen() {
        initComponents();
        TextLineNumber LinesCounter = new TextLineNumber(jtaEdit);
        jspEdit.setRowHeaderView(LinesCounter);
        LinePainter LinesPainter = new LinePainter(jtaEdit);
        LinesPainter.setColor(Color.lightGray);
        setMinimumSize(new Dimension(800, 600));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        try {
            //</editor-fold>
            //</editor-fold>
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtbToolBar = new javax.swing.JToolBar();
        btNew = new javax.swing.JButton();
        btOpen = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        jsToolBarSeparator1 = new javax.swing.JToolBar.Separator();
        btCopy = new javax.swing.JButton();
        btPaste = new javax.swing.JButton();
        btCut = new javax.swing.JButton();
        jsToolBarSeparator2 = new javax.swing.JToolBar.Separator();
        btCompile = new javax.swing.JButton();
        btRun = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btAbout = new javax.swing.JButton();
        lbPosition = new javax.swing.JLabel();
        lbFeedback = new javax.swing.JLabel();
        jpMain = new javax.swing.JPanel();
        jSplitPanel = new javax.swing.JSplitPane();
        jpEdit = new javax.swing.JPanel();
        jspEdit = new javax.swing.JScrollPane();
        jtaEdit = new javax.swing.JEditorPane();
        jpMessage = new javax.swing.JPanel();
        jspMessage = new javax.swing.JScrollPane();
        jtaMessage = new javax.swing.JTextArea();
        lbErr = new javax.swing.JLabel();
        jmbMenuBar = new javax.swing.JMenuBar();
        jmFile = new javax.swing.JMenu();
        jmiNew = new javax.swing.JMenuItem();
        jmiOpen = new javax.swing.JMenuItem();
        jmiSave = new javax.swing.JMenuItem();
        jmiSaveAs = new javax.swing.JMenuItem();
        jmiExit = new javax.swing.JMenuItem();
        jmEdit = new javax.swing.JMenu();
        jmiCopy = new javax.swing.JMenuItem();
        jmiPaste = new javax.swing.JMenuItem();
        jmiCut = new javax.swing.JMenuItem();
        jmCompile = new javax.swing.JMenu();
        jmiCompile = new javax.swing.JMenuItem();
        jmiRun = new javax.swing.JMenuItem();
        jmHelp = new javax.swing.JMenu();
        jmiHelp = new javax.swing.JMenuItem();
        jmiAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compilador");
        setLocation(new java.awt.Point(0, 0));

        jtbToolBar.setFloatable(false);

        btNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/new-page.png"))); // NOI18N
        btNew.setToolTipText("Novo");
        btNew.setFocusable(false);
        btNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewActionPerformed(evt);
            }
        });
        jtbToolBar.add(btNew);

        btOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/folder.png"))); // NOI18N
        btOpen.setToolTipText("Abrir");
        btOpen.setFocusable(false);
        btOpen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btOpen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOpenActionPerformed(evt);
            }
        });
        jtbToolBar.add(btOpen);

        btSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        btSave.setToolTipText("Salvar");
        btSave.setFocusable(false);
        btSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });
        jtbToolBar.add(btSave);
        jtbToolBar.add(jsToolBarSeparator1);

        btCopy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/document.png"))); // NOI18N
        btCopy.setToolTipText("Copiar");
        btCopy.setFocusable(false);
        btCopy.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCopy.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCopyActionPerformed(evt);
            }
        });
        jtbToolBar.add(btCopy);

        btPaste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/paste-as-text.png"))); // NOI18N
        btPaste.setToolTipText("Colar");
        btPaste.setFocusable(false);
        btPaste.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btPaste.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btPaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPasteActionPerformed(evt);
            }
        });
        jtbToolBar.add(btPaste);

        btCut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/scissors.png"))); // NOI18N
        btCut.setToolTipText("Recortar");
        btCut.setFocusable(false);
        btCut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCutActionPerformed(evt);
            }
        });
        jtbToolBar.add(btCut);
        jtbToolBar.add(jsToolBarSeparator2);

        btCompile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tools.png"))); // NOI18N
        btCompile.setToolTipText("Compilar");
        btCompile.setFocusable(false);
        btCompile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCompile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCompile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCompileActionPerformed(evt);
            }
        });
        jtbToolBar.add(btCompile);

        btRun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/play.png"))); // NOI18N
        btRun.setToolTipText("Executar");
        btRun.setFocusable(false);
        btRun.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btRun.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRunActionPerformed(evt);
            }
        });
        jtbToolBar.add(btRun);
        jtbToolBar.add(jSeparator1);

        btAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/santa-claus.png"))); // NOI18N
        btAbout.setToolTipText("Sobre");
        btAbout.setFocusable(false);
        btAbout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAbout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAboutActionPerformed(evt);
            }
        });
        jtbToolBar.add(btAbout);

        jSplitPanel.setDividerLocation(500);
        jSplitPanel.setDividerSize(20);
        jSplitPanel.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPanel.setOneTouchExpandable(true);

        jtaEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtaEdit.setPreferredSize(new java.awt.Dimension(600, 600));
        jtaEdit.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jtaEditCaretUpdate(evt);
            }
        });
        jspEdit.setViewportView(jtaEdit);

        javax.swing.GroupLayout jpEditLayout = new javax.swing.GroupLayout(jpEdit);
        jpEdit.setLayout(jpEditLayout);
        jpEditLayout.setHorizontalGroup(
            jpEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1014, Short.MAX_VALUE)
            .addGroup(jpEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpEditLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jspEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jpEditLayout.setVerticalGroup(
            jpEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
            .addGroup(jpEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpEditLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jspEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jSplitPanel.setLeftComponent(jpEdit);

        jpMessage.setPreferredSize(new java.awt.Dimension(1014, 384));

        jtaMessage.setEditable(false);
        jtaMessage.setColumns(20);
        jtaMessage.setLineWrap(true);
        jtaMessage.setRows(50);
        jtaMessage.setPreferredSize(new java.awt.Dimension(220, 400));
        jspMessage.setViewportView(jtaMessage);

        javax.swing.GroupLayout jpMessageLayout = new javax.swing.GroupLayout(jpMessage);
        jpMessage.setLayout(jpMessageLayout);
        jpMessageLayout.setHorizontalGroup(
            jpMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1014, Short.MAX_VALUE)
            .addGroup(jpMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpMessageLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jspMessage)
                    .addContainerGap()))
        );
        jpMessageLayout.setVerticalGroup(
            jpMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 643, Short.MAX_VALUE)
            .addGroup(jpMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMessageLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jspMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jSplitPanel.setRightComponent(jpMessage);

        javax.swing.GroupLayout jpMainLayout = new javax.swing.GroupLayout(jpMain);
        jpMain.setLayout(jpMainLayout);
        jpMainLayout.setHorizontalGroup(
            jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpMainLayout.setVerticalGroup(
            jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
                .addContainerGap())
        );

        jmFile.setText("Arquivo");

        jmiNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK));
        jmiNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/new-page.png"))); // NOI18N
        jmiNew.setText("Novo");
        jmiNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNewActionPerformed(evt);
            }
        });
        jmFile.add(jmiNew);

        jmiOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        jmiOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/folder.png"))); // NOI18N
        jmiOpen.setText("Abrir");
        jmiOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiOpenActionPerformed(evt);
            }
        });
        jmFile.add(jmiOpen);

        jmiSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jmiSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save-file.png"))); // NOI18N
        jmiSave.setText("Salvar");
        jmiSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSaveActionPerformed(evt);
            }
        });
        jmFile.add(jmiSave);

        jmiSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        jmiSaveAs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        jmiSaveAs.setText("Salvar como...");
        jmiSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSaveAsActionPerformed(evt);
            }
        });
        jmFile.add(jmiSaveAs);

        jmiExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jmiExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exit.png"))); // NOI18N
        jmiExit.setText("Sair");
        jmiExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExitActionPerformed(evt);
            }
        });
        jmFile.add(jmiExit);

        jmbMenuBar.add(jmFile);

        jmEdit.setText("Edição");

        jmiCopy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/document.png"))); // NOI18N
        jmiCopy.setText("Copiar");
        jmiCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCopyActionPerformed(evt);
            }
        });
        jmEdit.add(jmiCopy);

        jmiPaste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/paste-as-text.png"))); // NOI18N
        jmiPaste.setText("Colar");
        jmiPaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPasteActionPerformed(evt);
            }
        });
        jmEdit.add(jmiPaste);

        jmiCut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/scissors.png"))); // NOI18N
        jmiCut.setText("Recortar");
        jmiCut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCutActionPerformed(evt);
            }
        });
        jmEdit.add(jmiCut);

        jmbMenuBar.add(jmEdit);

        jmCompile.setText("Compilação");

        jmiCompile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jmiCompile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tools.png"))); // NOI18N
        jmiCompile.setText("Compilar");
        jmiCompile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCompileActionPerformed(evt);
            }
        });
        jmCompile.add(jmiCompile);

        jmiRun.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jmiRun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/play.png"))); // NOI18N
        jmiRun.setText("Executar");
        jmiRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRunActionPerformed(evt);
            }
        });
        jmCompile.add(jmiRun);

        jmbMenuBar.add(jmCompile);

        jmHelp.setText("Ajuda");

        jmiHelp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        jmiHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/santa-claus.png"))); // NOI18N
        jmiHelp.setText("Informação");
        jmiHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiHelpActionPerformed(evt);
            }
        });
        jmHelp.add(jmiHelp);

        jmiAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        jmiAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/snowman.png"))); // NOI18N
        jmiAbout.setText("Sobre");
        jmiAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAboutActionPerformed(evt);
            }
        });
        jmHelp.add(jmiAbout);

        jmbMenuBar.add(jmHelp);

        setJMenuBar(jmbMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 977, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbPosition)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbErr, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(lbFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jtbToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 737, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbPosition)
                    .addComponent(lbFeedback, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                    .addComponent(lbErr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jpMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(21, 21, 21)))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbErr, lbFeedback});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        jmiNewActionPerformed(evt);
    }//GEN-LAST:event_btNewActionPerformed

    private void jmiSaveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jmiSaveActionPerformed
    {//GEN-HEADEREND:event_jmiSaveActionPerformed
        String res = control.save(fileName, filePath, jtaEdit, this);
        String array[] = new String[2];
        array = res.split(",");
        fileName = array[0];
        filePath = array[1];
    }//GEN-LAST:event_jmiSaveActionPerformed

    private void jmiSaveAsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jmiSaveAsActionPerformed
    {//GEN-HEADEREND:event_jmiSaveAsActionPerformed
        String res = control.saveAs(jtaEdit, fileName, filePath, this);
        String array[] = new String[2];
        array = res.split(",");
        fileName = array[0];
        filePath = array[1];
    }//GEN-LAST:event_jmiSaveAsActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btSaveActionPerformed
    {//GEN-HEADEREND:event_btSaveActionPerformed
        jmiSaveAsActionPerformed(evt);
    }//GEN-LAST:event_btSaveActionPerformed

    private void btAboutActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btAboutActionPerformed
    {//GEN-HEADEREND:event_btAboutActionPerformed
        control.about();
    }//GEN-LAST:event_btAboutActionPerformed

    private void btOpenActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btOpenActionPerformed
    {//GEN-HEADEREND:event_btOpenActionPerformed
        jmiOpenActionPerformed(evt);
    }//GEN-LAST:event_btOpenActionPerformed

    private void jmiOpenActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jmiOpenActionPerformed
    {//GEN-HEADEREND:event_jmiOpenActionPerformed
        String res = control.openFile(jtaEdit, jtaMessage, fileName, filePath, this);
        String array[] = new String[2];
        array = res.split(",");
        fileName = array[0];
        filePath = array[1];
    }//GEN-LAST:event_jmiOpenActionPerformed

    private void jmiCopyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jmiCopyActionPerformed
    {//GEN-HEADEREND:event_jmiCopyActionPerformed
        control.copy(jtaEdit);
    }//GEN-LAST:event_jmiCopyActionPerformed

    private void jmiPasteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jmiPasteActionPerformed
    {//GEN-HEADEREND:event_jmiPasteActionPerformed
        control.paste(jtaEdit);
    }//GEN-LAST:event_jmiPasteActionPerformed

    private void jmiCutActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jmiCutActionPerformed
    {//GEN-HEADEREND:event_jmiCutActionPerformed
        control.cut(jtaEdit);
    }//GEN-LAST:event_jmiCutActionPerformed

    private void btCutActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btCutActionPerformed
    {//GEN-HEADEREND:event_btCutActionPerformed
        jmiCutActionPerformed(evt);
    }//GEN-LAST:event_btCutActionPerformed

    private void btCopyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btCopyActionPerformed
    {//GEN-HEADEREND:event_btCopyActionPerformed
        jmiCopyActionPerformed(evt);
    }//GEN-LAST:event_btCopyActionPerformed

    private void btPasteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btPasteActionPerformed
    {//GEN-HEADEREND:event_btPasteActionPerformed
        jmiPasteActionPerformed(evt);
    }//GEN-LAST:event_btPasteActionPerformed

    private void btRunActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btRunActionPerformed
    {//GEN-HEADEREND:event_btRunActionPerformed
        jmiRunActionPerformed(evt);
    }//GEN-LAST:event_btRunActionPerformed

    private void btCompileActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btCompileActionPerformed
    {//GEN-HEADEREND:event_btCompileActionPerformed
        jmiCompileActionPerformed(evt);
    }//GEN-LAST:event_btCompileActionPerformed

    private void jmiCompileActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jmiCompileActionPerformed
    {//GEN-HEADEREND:event_jmiCompileActionPerformed
        control.setFile(filePath, fileName);
        instructions = control.compile(jtaEdit, this, jtaEdit, jtaMessage, lbErr, lbFeedback, instructions);
    }//GEN-LAST:event_jmiCompileActionPerformed

    private void jmiRunActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jmiRunActionPerformed
    {//GEN-HEADEREND:event_jmiRunActionPerformed
        jmiCompileActionPerformed(evt);
        control.run(jtaMessage, instructions, tblo, c);
    }//GEN-LAST:event_jmiRunActionPerformed

    private void jmiExitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jmiExitActionPerformed
    {//GEN-HEADEREND:event_jmiExitActionPerformed
        control.exit(jtaEdit, fileName, filePath, this);
    }//GEN-LAST:event_jmiExitActionPerformed

    private void jtaEditCaretUpdate(javax.swing.event.CaretEvent evt)//GEN-FIRST:event_jtaEditCaretUpdate
    {//GEN-HEADEREND:event_jtaEditCaretUpdate
        control.getPosition(evt, lbPosition);
    }//GEN-LAST:event_jtaEditCaretUpdate

    private void jmiNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNewActionPerformed
        fileName = control.newFile(jtaEdit, jtaMessage, this, fileName, filePath);
        filePath = "";
    }//GEN-LAST:event_jmiNewActionPerformed

    private void jmiHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiHelpActionPerformed
        control.about();
    }//GEN-LAST:event_jmiHelpActionPerformed

    private void jmiAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAboutActionPerformed
        control.help();
    }//GEN-LAST:event_jmiAboutActionPerformed
}
