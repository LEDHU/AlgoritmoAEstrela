import java.util.*;

public class Grafo {
    //Atributos
    public List<String> vertices;
    public List<Aresta> arestas;

    //Construtor
    public Grafo() {
        this.vertices = new ArrayList<>();
        this.arestas = new ArrayList<>();
    }

    public void adicionarVertice(String vertice) {
        vertices.add(vertice);
    }

    public void adicionarAresta(String origem, String destino, int real) {
        Aresta aresta = new Aresta(origem, destino, real);
        arestas.add(aresta);
    }
    // Método de busca A*
    public List<String> aStar(String inicio, String fim) {
        Map<String, String> pais = new HashMap<>();
        Map<String, Integer> custoG = new HashMap<>();
        Map<String, Integer> custoF = new HashMap<>();

        PriorityQueue<String> fronteira = new PriorityQueue<>(Comparator.comparingInt(custoF::get));

        pais.put(inicio, null);
        custoG.put(inicio, 0);
        custoF.put(inicio, heuristic(inicio, fim));
        fronteira.add(inicio);

        while (!fronteira.isEmpty()) {
            String atual = fronteira.poll();

            if (atual.equals(fim)) {
                return reconstruirCaminho(pais, fim);
            }

            for (Aresta aresta : arestas) {
                if (aresta.getOrigem().equals(atual)) {
                    String proximo = aresta.getDestino();
                    int novoCustoG = custoG.get(atual) + aresta.getPeso();

                    if (!custoG.containsKey(proximo) || novoCustoG < custoG.get(proximo)) {
                        pais.put(proximo, atual);
                        custoG.put(proximo, novoCustoG);
                        custoF.put(proximo, novoCustoG + heuristic(proximo, fim));

                        if (!fronteira.contains(proximo)) {
                            //System.out.println(atual + " -- " + proximo + " " + aresta.getPeso());
                            fronteira.add(proximo);
                        }

                    }
                }
            }
        }

        return null;
    }

    private List<String> reconstruirCaminho(Map<String, String> pais, String fim) {
        List<String> caminho = new ArrayList<>();
        String atual = fim;

        while (atual != null) {
            caminho.add(atual);
            atual = pais.get(atual);
        }

        Collections.reverse(caminho);
        return caminho;
    }

    private int heuristic(String no, String fim) {
        // Implemente a função de heurística apropriada aqui
        // Retorne um valor estimado da distância de no até o fim
        return 0;
    }
}
