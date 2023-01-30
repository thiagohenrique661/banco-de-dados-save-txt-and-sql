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
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FormularioBD extends JFrame {

	private JPanel contentPane;
	private JTextField TextoCod;
	private JTextField TextoNome;
	private JTextField TextoClasse;
	private JTextField TextoEstado;
	private JTextField TextoLancamento;
	private JTextField TextoReentrada;
	private JTextField TextoVelocidade;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioBD frame = new FormularioBD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormularioBD() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 378, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 371, 334);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblFormulrio = new JLabel("FORMULÁRIO B.D.");
		lblFormulrio.setForeground(Color.YELLOW);
		lblFormulrio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFormulrio.setBounds(120, 5, 142, 25);
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

		JButton botaoadicionarbanco = new JButton("CADASTRAR");
		botaoadicionarbanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Detritos detritos = new Detritos();
					CRUD create = new CRUD();

					detritos.setCod(Integer.parseInt(TextoCod.getText()));
					detritos.setNome(TextoNome.getText());
					detritos.setClasse(TextoClasse.getText());
					detritos.setEstado(TextoEstado.getText());
					detritos.setLancamento(Integer.parseInt(TextoLancamento.getText()));
					detritos.setReentrada(Integer.parseInt(TextoReentrada.getText()));
					detritos.setVelocidade(TextoVelocidade.getText());
					create.create(detritos);

				} catch (Exception ex) {
					ex.printStackTrace();

				}
			}
		});
		botaoadicionarbanco.setBounds(10, 299, 115, 25);
		panel.add(botaoadicionarbanco);

		JButton botaoalterarbanco = new JButton("ALTERAR");
		botaoalterarbanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Detritos detritos = new Detritos();
					CRUD update = new CRUD();

					detritos.setNome(TextoNome.getText());
					detritos.setClasse(TextoClasse.getText());
					detritos.setEstado(TextoEstado.getText());
					detritos.setLancamento(Integer.parseInt(TextoLancamento.getText()));
					detritos.setReentrada(Integer.parseInt(TextoReentrada.getText()));
					detritos.setVelocidade(TextoVelocidade.getText());
					detritos.setCod(Integer.parseInt(TextoCod.getText()));
					update.update(detritos);

				} catch (Exception ex) {
					ex.printStackTrace();

				}
			}
		});
		botaoalterarbanco.setBounds(135, 300, 104, 23);
		panel.add(botaoalterarbanco);

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
		BotaoLimpar.setBounds(150, 264, 89, 25);
		panel.add(BotaoLimpar);

		JButton botaodeletarbanco = new JButton("DELETAR");
		botaodeletarbanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Detritos detritos = new Detritos();
					CRUD update = new CRUD();
					detritos.setCod(Integer.parseInt(TextoCod.getText()));
					update.delete(detritos);

				} catch (Exception ex) {
					ex.printStackTrace();

				}
			}
		});
		botaodeletarbanco.setBounds(255, 300, 89, 23);
		panel.add(botaodeletarbanco);

	}
}
