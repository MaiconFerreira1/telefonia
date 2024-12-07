import java.util.ArrayList;
import java.util.Date;

class PrePago extends Assinante {
    private float creditos;
    private ArrayList<Recarga> recargas;
    private int numRecargas;

    public PrePago(long cpf, String nome, int numero) {
        super(cpf, nome, numero);
        this.creditos = 0;
        this.recargas = new ArrayList<>();
        this.numRecargas = 0;
    }

    public void fazerChamada(Date data, int duracao) {
        float custo = duracao * 1.45f;
        if (numChamadas < 100 && creditos >= custo) {
            chamadas.add(new Chamada(data, duracao));
            numChamadas++;
            creditos -= custo;
        } else {
            System.out.println("Créditos insuficientes ou limite de chamadas excedido.");
        }
    }

    public void recarregar(Date data, float valor) {
        if (numRecargas < 100) {
            recargas.add(new Recarga(data, valor));
            numRecargas++;
            creditos += valor;
        } else {
            System.out.println("Limite de recargas excedido.");
        }
    }

    public void imprimirFatura(int mes) {
        System.out.println("Fatura Pré-Pago - " + nome);
        System.out.println("CPF: " + cpf + ", Número: " + numero);
        System.out.println("Chamadas:");
        float totalChamadas = 0;
        for (Chamada chamada : chamadas) {
            if (chamada.getData().getMonth() + 1 == mes) {
                System.out.println(chamada);
                totalChamadas += chamada.getDuracao() * 1.45f;
            }
        }
        System.out.println("Recargas:");
        float totalRecargas = 0;
        for (Recarga recarga : recargas) {
            if (recarga.getData().getMonth() + 1 == mes) {
                System.out.println(recarga);
                totalRecargas += recarga.getValor();
            }
        }
        System.out.println("Total Chamadas: R$ " + totalChamadas);
        System.out.println("Total Recargas: R$ " + totalRecargas);
        System.out.println("Créditos Restantes: R$ " + creditos);
    }
}