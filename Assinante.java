import java.util.ArrayList;

class Assinante {
    protected long cpf;
    protected String nome;
    protected int numero;
    protected ArrayList<Chamada> chamadas;
    protected int numChamadas;

    public Assinante(long cpf, String nome, int numero) {
        this.cpf = cpf;
        this.nome = nome;
        this.numero = numero;
        this.chamadas = new ArrayList<>();
        this.numChamadas = 0;
    }

    public long getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "CPF: " + cpf + ", Nome: " + nome + ", Número: " + numero;
    }
}