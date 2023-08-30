class Vertice {
    private String nome;
    private double custoG; // Custo do início até este vértice
    private double custoH; // Heurística estimada do vértice até o objetivo
    private double custoF; // Custo total estimado: custoG + custoH
    private Vertice pai; // Vértice pai no caminho

    public Vertice(String nome) {
        this.nome = nome;
        this.custoG = Double.MAX_VALUE;
        this.custoH = 0.0; // Será calculado posteriormente
        this.custoF = Double.MAX_VALUE;
        this.pai = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Vertice getPai() {
        return pai;
    }

    public void setPai(Vertice pai) {
        this.pai = pai;
    }
}