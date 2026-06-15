package modelo;

public class Venda {

	public int id;
	public Cliente cliente;
    public Ingresso ingresso;
    public String dataVenda;
    public double valorFinal;

    public Venda(int id, Cliente cliente, Ingresso ingresso, String dataVenda) {
        this.id = id;
        this.cliente = cliente;
        this.ingresso = ingresso;
        this.dataVenda = dataVenda;
        this.valorFinal = ingresso.calcularValor();
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Ingresso getIngresso() {
		return ingresso;
	}

	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
	}

	public String getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}

	public double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
	}
    
    
    
    
}
