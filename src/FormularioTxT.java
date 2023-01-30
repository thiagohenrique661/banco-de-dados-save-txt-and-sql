import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FormularioTxT extends JFrame {

	private JPanel contentPane;
	private JTextField TextoCod;
	private JTextField TextoNome;
	private JTextField TextoClasse;
	private JTextField TextoEstado;
	private JTextField TextoLancamento;
	private JTextField TextoReentrada;
	private JTextField TextoVelocidade;
	private ArquivoTxT arquivotxt;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioTxT frame = new FormularioTxT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormularioTxT() {
		arquivotxt = new ArquivoTxT();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 413, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 397, 334);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblFormulrio = new JLabel("FORMULÁRIO");
		lblFormulrio.setForeground(Color.YELLOW);
		lblFormulrio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFormulrio.setBounds(125, 11, 102, 25);
		panel.add(lblFormulrio);

		JLabel lblCod = new JLabel("COD");
		lblCod.setForeground(Color.WHITE);
		lblCod.setBackground(new Color(240, 240, 240));
		lblCod.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCod.setBounds(10, 42, 46, 14);
		panel.add(lblCod);

		TextoCod = new JTextField();
		TextoCod.setBounds(59, 41, 192, 20);
		panel.add(TextoCod);
		TextoCod.setColumns(10);

		TextoNome = new JTextField();
		TextoNome.setBounds(59, 72, 192, 20);
		panel.add(TextoNome);
		TextoNome.setColumns(10);

		JLabel lblNome = new JLabel("NOME");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(10, 73, 46, 19);
		panel.add(lblNome);

		JLabel lblClasse = new JLabel("CLASSE");
		lblClasse.setForeground(Color.WHITE);
		lblClasse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClasse.setBounds(9, 103, 57, 14);
		panel.add(lblClasse);

		TextoClasse = new JTextField();
		TextoClasse.setBounds(59, 103, 192, 20);
		panel.add(TextoClasse);
		TextoClasse.setColumns(10);

		TextoEstado = new JTextField();
		TextoEstado.setBounds(69, 139, 182, 20);
		panel.add(TextoEstado);
		TextoEstado.setColumns(10);

		JLabel lblEstado = new JLabel("ESTADO");
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEstado.setBounds(9, 140, 57, 14);
		panel.add(lblEstado);

		JLabel lblLancamento = new JLabel("LAN\u00C7AMENTO");
		lblLancamento.setForeground(Color.WHITE);
		lblLancamento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLancamento.setBounds(10, 170, 102, 14);
		panel.add(lblLancamento);

		TextoLancamento = new JTextField();
		TextoLancamento.setBounds(109, 169, 142, 20);
		panel.add(TextoLancamento);
		TextoLancamento.setColumns(10);

		JLabel lblReentrada = new JLabel("REENTRADA");
		lblReentrada.setForeground(Color.WHITE);
		lblReentrada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblReentrada.setBounds(10, 207, 102, 14);
		panel.add(lblReentrada);

		TextoReentrada = new JTextField();
		TextoReentrada.setBounds(96, 206, 155, 20);
		panel.add(TextoReentrada);
		TextoReentrada.setColumns(10);

		JLabel lblVelocidade = new JLabel("VELOCIDADE");
		lblVelocidade.setForeground(Color.WHITE);
		lblVelocidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVelocidade.setBounds(10, 242, 87, 14);
		panel.add(lblVelocidade);

		TextoVelocidade = new JTextField();
		TextoVelocidade.setBounds(106, 237, 145, 20);
		panel.add(TextoVelocidade);
		TextoVelocidade.setColumns(10);

		JButton botaoAdicionarLIFO = new JButton("FIM");
		botaoAdicionarLIFO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (TextoCod.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O nome não pode estar vazio");
					TextoCod.requestFocus();
				} else if (TextoNome.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O endereço não pode estar vazio");
					TextoNome.requestFocus();

				} else if (TextoClasse.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O bairro não pode estar vazio");
					TextoClasse.requestFocus();
				} else if (TextoEstado.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "A bairro não pode estar vazia");
					TextoEstado.requestFocus();
				} else if (TextoLancamento.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "A naturaçodade não pode estar vazia");
					TextoLancamento.requestFocus();
				} else if (TextoReentrada.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O CEP não pode estar vazio");
					TextoReentrada.requestFocus();
				} else if (TextoVelocidade.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O número não pode estar vazio");
					TextoVelocidade.requestFocus();

				}
				try {
					int cod = Integer.parseInt(TextoCod.getText());
					String nome = TextoNome.getText();
					String classe = TextoClasse.getText();
					String estado = TextoEstado.getText();
					int lancamento = Integer.parseInt(TextoLancamento.getText());
					int reentrada = Integer.parseInt(TextoReentrada.getText());
					String velocidade = TextoVelocidade.getText();

					Detritos detrito = new Detritos(cod, lancamento, reentrada, nome, velocidade, classe, estado);
					new ArquivoTxT().Cadastrar(detrito);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});
		botaoAdicionarLIFO.setBounds(288, 42, 84, 25);
		panel.add(botaoAdicionarLIFO);

		JButton botaoAdicionarFIFO = new JButton("INÍCIO");
		botaoAdicionarFIFO.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoAdicionarFIFO.setBounds(288, 71, 84, 23);
		panel.add(botaoAdicionarFIFO);

		JButton botaoAlterarLIFO = new JButton("LIFO");
		botaoAlterarLIFO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int cod = Integer.parseInt(TextoCod.getText());
					String nome = TextoNome.getText();
					String classe = TextoClasse.getText();
					String estado = TextoEstado.getText();
					int lancamento = Integer.parseInt(TextoLancamento.getText());
					int reentrada = Integer.parseInt(TextoReentrada.getText());
					String velocidade = TextoVelocidade.getText();
					new ArquivoTxT().update(cod, new Detritos(cod, lancamento, reentrada, nome, velocidade, classe, estado));
					

				} catch (Exception e2) {
					System.out.println("Id deve ser inteiro");
				}
			}
		});
		botaoAlterarLIFO.setBounds(281, 149, 91, 23);
		panel.add(botaoAlterarLIFO);

		JButton BotaoLimpar = new JButton("LIMPAR");
		BotaoLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextoCod.setText("");
				TextoNome.setText("");
				TextoEstado.setText("");
				TextoReentrada.setText("");
				TextoClasse.setText("");
				TextoVelocidade.setText("");
				TextoLancamento.setText("");
			}
		});
		BotaoLimpar.setBounds(138, 268, 89, 30);
		panel.add(BotaoLimpar);

		JLabel lblAdicionar = new JLabel("ADICIONAR");
		lblAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdicionar.setForeground(Color.YELLOW);
		lblAdicionar.setBounds(288, 23, 87, 14);
		panel.add(lblAdicionar);

		JLabel lblNewLabel_1 = new JLabel("ALTERAR");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setBackground(Color.YELLOW);
		lblNewLabel_1.setBounds(298, 124, 74, 14);
		panel.add(lblNewLabel_1);

		JButton botaoAlterarFIFO = new JButton("FIFO");
		botaoAlterarFIFO.setBounds(281, 180, 89, 23);
		panel.add(botaoAlterarFIFO);

		JLabel lblDeletar = new JLabel("DELETAR");
		lblDeletar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDeletar.setForeground(Color.YELLOW);
		lblDeletar.setBounds(291, 215, 71, 14);
		panel.add(lblDeletar);

		JButton botaoDeletarLIFO = new JButton("LIFO");
		botaoDeletarLIFO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// int cod = Integer.parseInt(TextoCod.getText());
				ArquivoTxT teste = new ArquivoTxT();
				// teste.ExcluirLinha(cod);
				teste.deletarFinal();

			}
		});
		botaoDeletarLIFO.setBounds(281, 240, 89, 23);
		panel.add(botaoDeletarLIFO);

		JButton botaoDeletarFIFO = new JButton("FIFO");
		botaoDeletarFIFO.setBounds(283, 275, 89, 23);
		panel.add(botaoDeletarFIFO);
		botaoDeletarFIFO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArquivoTxT teste = new ArquivoTxT();
				teste.deletarInicio();

			}
		});
	}

}
