
public class Detritos {
	private int cod, lancamento, reentrada;
	private String nome, velocidade, classe, estado;

	public Detritos() {

	}

	public Detritos(int cod, int lancamento, int reentrada, String nome, String velocidade, String classe,
			String estado) {
		this.cod = cod;
		this.lancamento = lancamento;
		this.reentrada = reentrada;
		this.nome = nome;
		this.velocidade = velocidade;
		this.classe = classe;
		this.estado = estado;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public int getLancamento() {
		return lancamento;
	}

	public void setLancamento(int lancamento) {
		this.lancamento = lancamento;
	}

	public int getReentrada() {
		return reentrada;
	}

	public void setReentrada(int reentrada) {
		this.reentrada = reentrada;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(String velocidade) {
		this.velocidade = velocidade;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
