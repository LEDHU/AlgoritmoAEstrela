import java.util.ArrayList;
import java.util.List;

class Vertice {
    private final String nome;
    private final List<Aresta> arestasAdjacentes;
    private final double lat;
    private final double lon;
    private Vertice pai;
    private double custoG;
    private double custoH;
    private double custoF;

    public Vertice(String nome, double lat, double lon) {
        this.nome = nome;
        this.arestasAdjacentes = new ArrayList<>();
        this.lat = lat;
        this.lon = lon;
        this.pai = null;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getNome() {
        return nome;
    }

    public List<Aresta> getArestasAdjacentes() {
        return arestasAdjacentes;
    }

    public void adicionarAresta(Aresta aresta) {
        arestasAdjacentes.add(aresta);
    }

    public Vertice getPai() {
        return pai;
    }

    public void setPai(Vertice pai) {
        this.pai = pai;
    }

    public double getCustoG() {
        return custoG;
    }

    public void setCustoG(double custoG) {
        this.custoG = custoG;
    }

    public double getCustoH() {
        return custoH;
    }

    public void setCustoH(double custoH) {
        this.custoH = custoH;
    }

    public double getCustoF() {
        return custoF;
    }

    public void setCustoF(double custoF) {
        this.custoF = custoF;
    }
}
