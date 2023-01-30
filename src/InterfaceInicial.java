

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

public class InterfaceInicial extends JFrame {

private JPanel contentPane;
private JLabel[] lblCods, lblNomes, lblClasses, lblEstados, lblLancamentos, lblReentradas, lblVelocidades;
private int paginas = 1;
private int paginaAtual = 1;
private ArrayList<Detritos> lista;
private JTextField textopesquisa;
private ButtonGroup grupo1, grupo2;

public InterfaceInicial() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 750, 600);
contentPane = new JPanel();
contentPane.setBackground(Color.BLACK);
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);

JButton botaoPesquisar = new JButton("PESQUISAR");
botaoPesquisar.setBounds(266, 136, 120, 29);
contentPane.add(botaoPesquisar);

JPanel panel = new JPanel();
panel.setBackground(Color.WHITE);
panel.setBounds(10, 176, 700, 320);
contentPane.add(panel);
GridBagLayout gbl_panel = new GridBagLayout();
gbl_panel.columnWidths = new int[] { 100, 100, 100, 100, 100, 100, 100, 100 };
gbl_panel.rowHeights = new int[] { 40, 40, 40, 40, 40, 40, 40, 40, 40 };
gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
panel.setLayout(gbl_panel);

JLabel labelCod = new JLabel("COD");
GridBagConstraints gbc_labelCod = new GridBagConstraints();
gbc_labelCod.insets = new Insets(0, 0, 5, 5);
gbc_labelCod.gridx = 0;
gbc_labelCod.gridy = 0;
panel.add(labelCod, gbc_labelCod);

JLabel labelNome = new JLabel("NOME");
GridBagConstraints gbc_labelNome = new GridBagConstraints();
gbc_labelNome.insets = new Insets(0, 0, 5, 5);
gbc_labelNome.gridx = 1;
gbc_labelNome.gridy = 0;
panel.add(labelNome, gbc_labelNome);

JLabel labelClasse = new JLabel("CLASSE");
GridBagConstraints gbc_labelClasse = new GridBagConstraints();
gbc_labelClasse.insets = new Insets(0, 0, 5, 5);
gbc_labelClasse.gridx = 2;
gbc_labelClasse.gridy = 0;
panel.add(labelClasse, gbc_labelClasse);

JLabel labelEstado = new JLabel("ESTADO");
GridBagConstraints gbc_labelEstado = new GridBagConstraints();
gbc_labelEstado.insets = new Insets(0, 0, 5, 5);
gbc_labelEstado.gridx = 3;
gbc_labelEstado.gridy = 0;
panel.add(labelEstado, gbc_labelEstado);

JLabel lblLancamento = new JLabel("LANÇAMENTO");
GridBagConstraints gbc_lblLancamento = new GridBagConstraints();
gbc_lblLancamento.insets = new Insets(0, 0, 5, 5);
gbc_lblLancamento.gridx = 4;
gbc_lblLancamento.gridy = 0;
panel.add(lblLancamento, gbc_lblLancamento);

JLabel labelReentrada = new JLabel("REENTRADA");
GridBagConstraints gbc_labelReentrada = new GridBagConstraints();
gbc_labelReentrada.insets = new Insets(0, 0, 5, 5);
gbc_labelReentrada.gridx = 5;
gbc_labelReentrada.gridy = 0;
panel.add(labelReentrada, gbc_labelReentrada);

JLabel labelVelocidade = new JLabel("VELOCIDADE");
GridBagConstraints gbc_labelVelocidade = new GridBagConstraints();
gbc_labelVelocidade.insets = new Insets(0, 0, 5, 0);
gbc_labelVelocidade.gridx = 6;
gbc_labelVelocidade.gridy = 0;
panel.add(labelVelocidade, gbc_labelVelocidade);

JButton botaoAnterior = new JButton("ANTERIOR");
botaoAnterior.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
PaginaAnterior();

}
});
botaoAnterior.setBounds(10, 527, 101, 23);
contentPane.add(botaoAnterior);

JButton botaoProximo = new JButton("PRÓXIMO");
botaoProximo.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
PaginaSeguinte();

}

});

botaoProximo.setBounds(628, 527, 96, 23);
contentPane.add(botaoProximo);

JRadioButton radioCod = new JRadioButton("COD");
radioCod.setFont(new Font("Tahoma", Font.PLAIN, 14));
radioCod.setForeground(Color.WHITE);
radioCod.setBackground(Color.BLACK);
radioCod.setSelected(true);
radioCod.setBounds(232, 64, 63, 23);
contentPane.add(radioCod);

JRadioButton radioNome = new JRadioButton("NOME");
radioNome.setForeground(Color.WHITE);
radioNome.setBackground(Color.BLACK);
radioNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
radioNome.setBounds(341, 64, 87, 23);
contentPane.add(radioNome);

textopesquisa = new JTextField();
textopesquisa.setBounds(167, 96, 300, 29);
contentPane.add(textopesquisa);
textopesquisa.setColumns(10);

JButton botaoAdicionarTXT = new JButton("ADICIONAR");
botaoAdicionarTXT.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
JFrame frame = new FormularioTxT();
frame.setVisible(true);

}
});
botaoAdicionarTXT.setBounds(496, 29, 109, 23);
contentPane.add(botaoAdicionarTXT);

final JRadioButton radioBD = new JRadioButton("BANCO DE DADOS");
radioBD.setFont(new Font("Tahoma", Font.PLAIN, 15));
radioBD.setForeground(Color.YELLOW);
radioBD.setBackground(Color.BLACK);
radioBD.setBounds(20, 27, 167, 23);
contentPane.add(radioBD);
radioBD.setSelected(true);

final JRadioButton radioTXT = new JRadioButton("ARQUIVO TXT");
radioTXT.setFont(new Font("Tahoma", Font.PLAIN, 15));
radioTXT.setForeground(Color.YELLOW);
radioTXT.setBackground(Color.BLACK);
radioTXT.setBounds(20, 64, 131, 23);
contentPane.add(radioTXT);
radioTXT.setSelected(true);
botaoPesquisar.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
paginas = 1;
paginaAtual = 1;
if(radioBD.isSelected()) {
try {
buscarBD("");
} catch (IOException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
}else if(radioTXT.isSelected()) {
try {
buscarTXT("");
}finally {

}
}

else {
JOptionPane.showMessageDialog(null, "Selecione o tipo de busca");
}
validate();
repaint();

}
});
JButton botaoAlterarTXT = new JButton("ALTERAR");
botaoAlterarTXT.setBounds(496, 66, 109, 23);
contentPane.add(botaoAlterarTXT);
botaoAlterarTXT.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
JFrame frame = new FormularioTxT();
frame.setVisible(true);


}
});

JButton botaoDeletarTXT = new JButton("DELETAR");
botaoDeletarTXT.setBounds(496, 95, 109, 23);
contentPane.add(botaoDeletarTXT);
botaoDeletarTXT.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
JFrame frame = new FormularioTxT();
frame.setVisible(true);

}
});

JLabel labelPagina1 = new JLabel("P\u00C1GINA");
labelPagina1.setForeground(Color.WHITE);
labelPagina1.setFont(new Font("Tahoma", Font.PLAIN, 15));
labelPagina1.setBounds(36, 507, 75, 14);
contentPane.add(labelPagina1);

JLabel labelPagina2 = new JLabel("P\u00C1GINA");
labelPagina2.setFont(new Font("Tahoma", Font.PLAIN, 15));
labelPagina2.setForeground(Color.WHITE);
labelPagina2.setBounds(647, 507, 63, 14);
contentPane.add(labelPagina2);

GridBagConstraints gbc_lblCods[] = new GridBagConstraints[7];
GridBagConstraints gbc_lblNomes[] = new GridBagConstraints[7];
GridBagConstraints gbc_lblClasses[] = new GridBagConstraints[7];
GridBagConstraints gbc_lblEstados[] = new GridBagConstraints[7];
GridBagConstraints gbc_lblReentradas[] = new GridBagConstraints[7];
GridBagConstraints gbc_lblVelocidades[] = new GridBagConstraints[7];
GridBagConstraints gbc_lblLancamentos[] = new GridBagConstraints[7];

lblCods = new JLabel[7];
lblNomes = new JLabel[7];
lblClasses = new JLabel[7];
lblLancamentos = new JLabel[7];
lblReentradas = new JLabel[7];
lblVelocidades = new JLabel[7];
lblEstados = new JLabel[7];

grupo1 = new ButtonGroup();
grupo1.add(radioTXT);
grupo1.add(radioBD);

grupo2 = new ButtonGroup();
grupo2.add(radioCod);
grupo2.add(radioNome);

JLabel lblEscolhaOMtodo = new JLabel("ESCOLHA O M\u00C9TODO DE PESQUISA");
lblEscolhaOMtodo.setForeground(Color.CYAN);
lblEscolhaOMtodo.setBackground(Color.CYAN);
lblEscolhaOMtodo.setFont(new Font("Tahoma", Font.PLAIN, 15));
lblEscolhaOMtodo.setBounds(10, 6, 246, 14);
contentPane.add(lblEscolhaOMtodo);

JLabel lblTxt = new JLabel("TXT");
lblTxt.setForeground(Color.CYAN);
lblTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
lblTxt.setBounds(544, 6, 46, 14);
contentPane.add(lblTxt);

JLabel lblBancoDeDados = new JLabel("BANCO");
lblBancoDeDados.setFont(new Font("Tahoma", Font.PLAIN, 15));
lblBancoDeDados.setForeground(Color.CYAN);
lblBancoDeDados.setBounds(647, 6, 63, 14);
contentPane.add(lblBancoDeDados);

JButton btnAdicionarBD = new JButton("ADICIONAR");
btnAdicionarBD.setBounds(615, 29, 109, 23);
contentPane.add(btnAdicionarBD);
btnAdicionarBD.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
JFrame frame = new FormularioBD();
frame.setVisible(true);
}
});

JButton btnAlterarBD = new JButton("ALTERAR");
btnAlterarBD.setBounds(615, 66, 109, 23);
contentPane.add(btnAlterarBD);
btnAlterarBD.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
JFrame frame = new FormularioBD();
frame.setVisible(true);
}
});

JButton btnDeletarBD = new JButton("DELETAR");
btnDeletarBD.setBounds(615, 95, 109, 23);
contentPane.add(btnDeletarBD);
btnDeletarBD.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
JFrame frame = new FormularioBD();
frame.setVisible(true);
}
});

for (int x = 0; x < 7; x++) {

lblCods[x] = new JLabel("");
lblNomes[x] = new JLabel("");
lblClasses[x] = new JLabel("");
lblEstados[x] = new JLabel("");
lblLancamentos[x] = new JLabel("");
lblReentradas[x] = new JLabel("");
lblVelocidades[x] = new JLabel("");

gbc_lblCods[x] = new GridBagConstraints();
gbc_lblCods[x].insets = new Insets(0, 0, 5, 0);
gbc_lblCods[x].gridx = 0;
gbc_lblCods[x].gridy = x + 1;
panel.add(lblCods[x], gbc_lblCods[x]);

gbc_lblNomes[x] = new GridBagConstraints();
gbc_lblNomes[x].insets = new Insets(0, 0, 5, 0);
gbc_lblNomes[x].gridx = 1;
gbc_lblNomes[x].gridy = x + 1;
panel.add(lblNomes[x], gbc_lblNomes[x]);

gbc_lblClasses[x] = new GridBagConstraints();
gbc_lblClasses[x].insets = new Insets(0, 0, 5, 0);
gbc_lblClasses[x].gridx = 2;
gbc_lblClasses[x].gridy = x + 1;
panel.add(lblClasses[x], gbc_lblClasses[x]);

gbc_lblEstados[x] = new GridBagConstraints();
gbc_lblEstados[x].insets = new Insets(0, 0, 5, 0);
gbc_lblEstados[x].gridx = 3;
gbc_lblEstados[x].gridy = x + 1;
panel.add(lblEstados[x], gbc_lblEstados[x]);

gbc_lblLancamentos[x] = new GridBagConstraints();
gbc_lblLancamentos[x].insets = new Insets(0, 0, 5, 0);
gbc_lblLancamentos[x].gridx = 4;
gbc_lblLancamentos[x].gridy = x + 1;
panel.add(lblLancamentos[x], gbc_lblLancamentos[x]);

gbc_lblReentradas[x] = new GridBagConstraints();
gbc_lblReentradas[x].insets = new Insets(0, 0, 5, 0);
gbc_lblReentradas[x].gridx = 5;
gbc_lblReentradas[x].gridy = x + 1;
panel.add(lblReentradas[x], gbc_lblReentradas[x]);

gbc_lblVelocidades[x] = new GridBagConstraints();
gbc_lblVelocidades[x].insets = new Insets(0, 0, 5, 0);
gbc_lblVelocidades[x].gridx = 6;
gbc_lblVelocidades[x].gridy = x + 1;
panel.add(lblVelocidades[x], gbc_lblVelocidades[x]);
}
}

private void buscarBD(String busca) throws IOException {
 ArrayList<Detritos> lista = new ArquivoTxT().txt();
lista = new CRUD().read();
int contador = lista.size();

if (lista.size() > 7) {
paginas = (int) Math.ceil(((double) lista.size() / 7));
contador = 7;
}

for (int x = 0; x < contador; x++) {

lblCods[x].setText("" + lista.get(x).getCod());
lblNomes[x].setText(lista.get(x).getNome());
lblClasses[x].setText(lista.get(x).getClasse());
lblEstados[x].setText(lista.get(x).getEstado());
lblLancamentos[x].setText("" + lista.get(x).getLancamento());
lblReentradas[x].setText("" + lista.get(x).getReentrada());
lblVelocidades[x].setText(lista.get(x).getVelocidade());
}

revalidate();
repaint();
}

private void buscarTXT(String busca)  {
//ArrayList<Detritos> lista = null;
try {
lista = new ArquivoTxT().txt();
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
int contador = lista.size();
if (lista.size() > 7) {
paginas = (int) Math.ceil(((double) lista.size() / 7));
contador = 7;
}
for (int x = 0; x < contador; x++) {
lblCods[x].setText("" + lista.get(x).getCod());
lblNomes[x].setText(lista.get(x).getNome());
lblClasses[x].setText(lista.get(x).getClasse());
lblEstados[x].setText(lista.get(x).getEstado());
lblLancamentos[x].setText("" + lista.get(x).getLancamento());
lblReentradas[x].setText("" + lista.get(x).getReentrada());
lblVelocidades[x].setText(lista.get(x).getVelocidade());
}
revalidate();
repaint();
}

private void PaginaAnterior() {
if (paginaAtual > 1) {
paginaAtual--;
for (int x = 0; x < 7; x++) {
int y = x + 7 * (paginaAtual - 1);
lblCods[x].setText(Integer.toString((((Detritos) lista.get(y)).getCod())));
lblNomes[x].setText(((Detritos) lista.get(y)).getNome());
lblClasses[x].setText(((Detritos) lista.get(y)).getClasse());
lblEstados[x].setText(((Detritos) lista.get(y)).getEstado());
lblLancamentos[x].setText(Integer.toString(((Detritos) lista.get(y)).getLancamento()));
lblReentradas[x].setText(Integer.toString(((Detritos) lista.get(y)).getReentrada()));
lblVelocidades[x].setText(((Detritos) lista.get(y)).getVelocidade());
revalidate();
repaint();
}
}
}

private void PaginaSeguinte() {
if (paginaAtual < paginas) {
paginaAtual++;

for (int x = 0; x < 7; x++) {
int y = x + 7 * (paginaAtual - 1);
if (y >= lista.size()) {
lblCods[x].setText("");
lblNomes[x].setText("");
lblClasses[x].setText("");
lblEstados[x].setText("");
lblLancamentos[x].setText("");
lblReentradas[x].setText("");
lblVelocidades[x].setText("");

} else {
lblCods[x].setText(Integer.toString((((Detritos) lista.get(y)).getCod())));
lblNomes[x].setText(((Detritos) lista.get(y)).getNome());
lblClasses[x].setText(((Detritos) lista.get(y)).getClasse());
lblEstados[x].setText(((Detritos) lista.get(y)).getEstado());
lblLancamentos[x].setText(Integer.toString(((Detritos) lista.get(y)).getLancamento()));
lblReentradas[x].setText(Integer.toString(((Detritos) lista.get(y)).getReentrada()));
lblVelocidades[x].setText(((Detritos) lista.get(y)).getVelocidade());

revalidate();
repaint();
}
}
}

}

}
