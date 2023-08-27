public class Aresta implements Comparable<Aresta> {
    //Atributos
    private final String origem;
    private final String destino;
    private final int peso;


    //Construtor
    public Aresta(String origem, String destino, int peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;

    }


    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }


    public int getPeso() {
        return peso;
    }

    //CompareTo
    @Override
    public int compareTo(Aresta outraAresta) {
        return Integer.compare(this.peso, outraAresta.peso);
    }
}
