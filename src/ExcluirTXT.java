import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ExcluirTXT {

	public static void main(String[] args) {
		File dir = new File("c:\\APS\\ARQUIVOS TXT\\teste.txt");
		{
			try {
				FileInputStream arquivo = new FileInputStream("c:/APS/ARQUIVOS TXT/APSTXT.txt");
				InputStreamReader input = new InputStreamReader(arquivo);
				BufferedReader br = new BufferedReader(input);
				FileReader fr = new FileReader(dir);
				String linha = br.readLine();
				ArrayList<String> salvar = new ArrayList();

				while (linha != null) {
					if (linha.equals("teste".split(linha)) == false) {
						salvar.add(linha);

						
					}
					linha = br.readLine();
				}
				FileWriter fw2 = new FileWriter(dir, true);
				fw2.close();

				FileWriter fw = new FileWriter(dir);
				BufferedWriter bw = new BufferedWriter(fw);
				for (int i = 0; i < salvar.size(); i++) {
					bw.write(salvar.get(i));
					bw.newLine();

				}
				bw.close();
				fw.close();

				JOptionPane.showMessageDialog(null, "EXCLUÍDO COM SUCESSO!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

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

	}


