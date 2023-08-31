import java.util.*;

class AEstrela {
    private final ArrayList<Vertice> grafo;

    public AEstrela() {
        this.grafo = new ArrayList<>();
    }

    public void adicionarVertice(Vertice vertice) {
        grafo.add(vertice);
    }

    private double calcularHeuristica(Vertice atual, Vertice objetivo) {
        double dx = Math.abs(atual.getLat() - objetivo.getLat());
        double dy = Math.abs(atual.getLon() - objetivo.getLon());
        return Math.sqrt(dx * dx + dy * dy);
    }

    public List<Vertice> encontrarCaminho(Vertice inicio, Vertice fim) {
        PriorityQueue<Vertice> filaPrioridade = new PriorityQueue<>(Comparator.comparingDouble(Vertice::getCustoF));
        Set<Vertice> visitados = new HashSet<>();

        for (Vertice vertice : grafo) {
            vertice.setCustoG(Double.POSITIVE_INFINITY);
            vertice.setCustoH(0);
            vertice.setCustoF(Double.POSITIVE_INFINITY);
        }

        inicio.setCustoG(0);
        inicio.setCustoH(calcularHeuristica(inicio, fim));
        inicio.setCustoF(inicio.getCustoG() + inicio.getCustoH());

        filaPrioridade.add(inicio);

        while (!filaPrioridade.isEmpty()) {
            Vertice atual = filaPrioridade.poll();

            if (atual.equals(fim)) {
                return reconstruirCaminho(atual);
            }

            visitados.add(atual);

            for (Aresta aresta : atual.getArestasAdjacentes()) {
                Vertice vizinho = aresta.getDestino();
                double custoAresta = aresta.getPeso();

                if (visitados.contains(vizinho)) {
                    continue;
                }

                double novoCustoG = atual.getCustoG() + custoAresta;

                if (novoCustoG < vizinho.getCustoG()) {
                    vizinho.setPai(atual);
                    vizinho.setCustoG(novoCustoG);
                    vizinho.setCustoH(calcularHeuristica(vizinho, fim));
                    vizinho.setCustoF(vizinho.getCustoG() + vizinho.getCustoH());

                    if (!filaPrioridade.contains(vizinho)) {
                        filaPrioridade.add(vizinho);
                    }
                }
            }
        }

        return null;
    }

    private List<Vertice> reconstruirCaminho(Vertice destino) {
        List<Vertice> caminho = new ArrayList<>();
        Vertice atual = destino;

        while (atual != null) {
            caminho.add(atual);
            atual = atual.getPai();
        }

        Collections.reverse(caminho);
        return caminho;
    }


    public Vertice encontrarVertice(String nome) {
        for (Vertice vertice : grafo) {
            if (Objects.equals(vertice.getNome(), nome)) return vertice;
        }
        return null;
    }

    public void printar(List<Vertice> x){
        for(int i = 0; i < x.size(); i++){
            if (i != x.size() - 1)
                System.out.print(x.get(i).getNome() + " -> ");
            else
                System.out.print(x.get(i).getNome());
        }
    }
}
