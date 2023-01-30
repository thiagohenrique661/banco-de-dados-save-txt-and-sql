import java.awt.Container;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ArquivoTxT {
	public String Cod, Nome, Classe, Estado, Lancamento, Reentrada, Velocidade;

	public ArquivoTxT ler(String path) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(path + "/" + Cod + "txt"));
			Cod = br.readLine();
			Nome = br.readLine();
			Classe = br.readLine();
			Estado = br.readLine();
			Lancamento = br.readLine();
			Reentrada = br.readLine();
			Velocidade = br.readLine();
			br.close();
			return this;
		} catch (IOException erro) {
			return null;
		}
	}

	public void Cadastrar(Detritos detrito) throws IOException {
		if (checarExistente(detrito)) {
			JOptionPane.showMessageDialog(null, "COD já existente");
		} else {
			try {
				BufferedWriter br = new BufferedWriter(new FileWriter("c:\\APS\\ARQUIVOS TXT\\APSTXT.txt", true));
				br.write(detrito.getCod() + ",");
				br.write(detrito.getNome() + ",");
				br.write(detrito.getClasse() + ",");
				br.write(detrito.getEstado() + ",");
				br.write(detrito.getLancamento() + ",");
				br.write(detrito.getReentrada() + ",");
				br.write(detrito.getVelocidade());
				br.newLine();
				br.close();
				JOptionPane.showMessageDialog(null, "Gravado com sucesso");
			} catch (IOException erro) {
				JOptionPane.showMessageDialog(null, "Erro para gravar");
			}
		}
	}

	public static void main(String[] args) {
		File dir = new File("c:/APS");
		if (!dir.exists()) {
			dir.mkdir();
		}
		dir = new File("c:/APS/ARQUIVOS TXT");
		if (!dir.exists())
			;
		{
			dir.mkdir();

		}
		System.out.println("Final do processo de criação");

		ArquivoTxT teste = new ArquivoTxT();

	}

	public ArrayList<Detritos> txt() throws IOException {

		ArrayList<Detritos> dados = new ArrayList<Detritos>();

		try {
			FileInputStream arquivo = new FileInputStream("c:/APS/ARQUIVOS TXT/APSTXT.txt");
			InputStreamReader input = new InputStreamReader(arquivo);
			BufferedReader br = new BufferedReader(input);

			String dado[];
			while (br.ready()) {
				try {
					dado = br.readLine().split(",");
					int cod = Integer.parseInt(dado[0]);
					String nome = dado[1];
					String classe = dado[2];
					String estado = dado[3];
					int lancamento = Integer.parseInt(dado[4]);
					int reentrada = Integer.parseInt(dado[5]);
					String velocidade = dado[6];
					dados.add(new Detritos(cod, lancamento, reentrada, nome, velocidade, classe, estado));

				} catch (Exception e) {
					continue;
				}
			}
			br.close();

		} catch (IOException ex) {
			System.out.println("Erro para ler arquivo");
			ex.printStackTrace();
		} finally {

		}
		return dados;
	}

	private boolean checarExistente(Detritos detrito) throws IOException {
		ArrayList<Detritos> lista = txt();
		boolean tem = false;
		for (int x = 0; x < lista.size(); x++) {
			if (lista.get(x).getCod() == detrito.getCod()) {
				tem = true;
			}
		}
		return tem;
	}

	public void criarPasta() {
		File dir = new File("c:\\APS\\ARQUIVOS TXT\\APSTXT.txt");
		if (!dir.exists()) {
			dir.mkdir();
		}
		dir = new File("c:\\APS\\ARQUIVOS TXT\\APSTXT.txt");
		if (!dir.exists()) {
			dir.mkdir();
		}

	}

	public void ExcluirLinha(int cod) {
		ArrayList<Detritos> lista;
		try {
			lista = txt();
			for (int x = 0; x < lista.size(); x++) {
				if (lista.get(x).getCod() == cod) {
					lista.remove(x);
					break;
				}
			}
			reescrever(lista);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// lista.remove(0); primeiro
	// lista.remove(lista.size()-1); ultimo

	public void deletarFinal() {
		try {
			ArrayList<Detritos> lista = txt();
			lista.remove(lista.size() - 1);
			reescrever(lista);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update(int cod, Detritos detrito) {
		try {
			ArrayList<Detritos> lista = txt();
			for (int i = 0; i < lista.size(); i++) {
				//alterar último é lista.get(lista.size()-1) no lugar do i
				//alterar o início é lista.get
				if (lista.get(i).getCod() == cod) {
					lista.get(i).setNome(detrito.getNome());
					lista.get(i).setClasse(detrito.getClasse());
					lista.get(i).setEstado(detrito.getEstado());
					lista.get(i).setLancamento(detrito.getLancamento());
					lista.get(i).setReentrada(detrito.getReentrada());
					lista.get(i).setVelocidade(detrito.getVelocidade());
					break;
				}
			}
			reescrever(lista);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//int ultimo = lista.size() -1;
	//lista.get(ultimo).
	
	
	
	
	public void deletarInicio() {
		try {
			ArrayList<Detritos> lista = txt();
			lista.remove(0);
			reescrever(lista);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void reescrever(ArrayList<Detritos> lista) {
		try {
			BufferedWriter br = new BufferedWriter(new FileWriter("c:\\APS\\ARQUIVOS TXT\\APSTXT.txt", false));
			for (int i = 0; i < lista.size(); i++) {
				br.write(lista.get(i).getCod() + ",");
				br.write(lista.get(i).getNome() + ",");
				br.write(lista.get(i).getClasse() + ",");
				br.write(lista.get(i).getEstado() + ",");
				br.write(lista.get(i).getLancamento() + ",");
				br.write(lista.get(i).getReentrada() + ",");
				br.write(lista.get(i).getVelocidade());
				br.newLine();
			}
			JOptionPane.showMessageDialog(null, "Gravado com sucesso");
			br.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro para gravar");
			e.printStackTrace();
		}

	}

}