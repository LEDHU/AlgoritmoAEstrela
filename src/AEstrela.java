import java.util.*;


class AEstrela {
    Grafo grafo;

    public AEstrela(Grafo grafo) {
        this.grafo = grafo;
    }

    // Função de heurística simples, você pode modificar conforme necessário
    private double calcularHeuristica(String atual, String objetivo) {
        // Aqui você pode implementar uma heurística mais apropriada, como a distância em linha reta
        return 0.0;
    }

    public List<String> encontrarCaminho(String inicio, String fim) {
        PriorityQueue<Vertice> filaAberta = new PriorityQueue<>(Comparator.comparingDouble(v -> v.getCustoF()));
        Set<Vertice> visitados = new HashSet<>();

        Vertice verticeInicial = grafo.getVertice(inicio);
        verticeInicial.setCustoG(0);
        verticeInicial.setCustoH(calcularHeuristica(inicio, fim));
        verticeInicial.setCustoF(verticeInicial.getCustoG() + verticeInicial.getCustoH());

        filaAberta.add(verticeInicial);

        while (!filaAberta.isEmpty()) {
            Vertice atual = filaAberta.poll();

            if (atual.getNome().equals(fim)) {
                return reconstruirCaminho(atual);
            }

            visitados.add(atual);

            for (Map.Entry<Vertice, Double> vizinhoEntry : grafo.getVizinhos(atual).entrySet()) {
                Vertice vizinho = vizinhoEntry.getKey();
                double custoAresta = vizinhoEntry.getValue();

                if (visitados.contains(vizinho)) {
                    continue;
                }

                double novoCustoG = atual.getCustoG() + custoAresta;

                if (novoCustoG < vizinho.getCustoG()) {
                    vizinho.setPai(atual);
                    vizinho.setCustoG(novoCustoG);
                    vizinho.setCustoH(calcularHeuristica(vizinho.getNome(), fim));
                    vizinho.setCustoF(vizinho.getCustoG() + vizinho.getCustoH());

                    if (!filaAberta.contains(vizinho)) {
                        filaAberta.add(vizinho);
                    }
                }
            }

        }

        return null;
    }

    private List<String> reconstruirCaminho(Vertice destino) {
        List<String> caminho = new ArrayList<>();
        Vertice atual = destino;

        while (atual != null) {
            caminho.add(atual.getNome());
            atual = atual.getPai();
        }

        Collections.reverse(caminho);
        return caminho;
    }
}
