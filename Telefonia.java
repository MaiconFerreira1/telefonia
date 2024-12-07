import java.util.ArrayList;
import java.util.Date;

class Telefonia {
    private ArrayList<PrePago> prePagos;
    private ArrayList<PosPago> posPagos;

    public Telefonia() {
        this.prePagos = new ArrayList<>();
        this.posPagos = new ArrayList<>();
    }

    public void cadastrarAssinante(boolean isPrePago, long cpf, String nome, int numero, float assinaturaOuCredito) {
        if (isPrePago) {
            prePagos.add(new PrePago(cpf, nome, numero));
        } else {
            posPagos.add(new PosPago(cpf, nome, numero, assinaturaOuCredito));
        }
    }

    public void listarAssinantes() {
        System.out.println("Assinantes Pré-Pagos:");
        for (PrePago prePago : prePagos) {
            System.out.println(prePago);
        }
        System.out.println("Assinantes Pós-Pagos:");
        for (PosPago posPago : posPagos) {
            System.out.println(posPago);
        }
    }

    public void fazerChamada(boolean isPrePago, long cpf, Date data, int duracao) {
        if (isPrePago) {
            for (PrePago prePago : prePagos) {
                if (prePago.getCpf() == cpf) {
                    prePago.fazerChamada(data, duracao);
                    return;
                }
            }
        } else {
            for (PosPago posPago : posPagos) {
                if (posPago.getCpf() == cpf) {
                    posPago.fazerChamada(data, duracao);
                    return;
                }
            }
        }
        System.out.println("Assinante não encontrado.");
    }

    public void fazerRecarga(long cpf, Date data, float valor) {
        for (PrePago prePago : prePagos) {
            if (prePago.getCpf() == cpf) {
                prePago.recarregar(data, valor);
                return;
            }
        }
        System.out.println("Assinante não encontrado.");
    }

    public void imprimirFaturas(int mes) {
        System.out.println("Faturas Pré-Pagos:");
        for (PrePago prePago : prePagos) {
            prePago.imprimirFatura(mes);
        }
        System.out.println("Faturas Pós-Pagos:");
        for (PosPago posPago : posPagos) {
            posPago.imprimirFatura(mes);
        }
    }
}