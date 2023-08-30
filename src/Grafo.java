import java.util.*;

class Grafo {
    private Map<String, Vertice> vertices = new HashMap<>();
    private Map<Vertice, Map<Vertice, Double>> arestas = new HashMap<>();

    public void adicionarVertice(String nome) {
        vertices.put(nome, new Vertice(nome));
    }

    public void adicionarAresta(String inicio, String fim, double peso) {
        Vertice verticeInicio = vertices.get(inicio);
        Vertice verticeFim = vertices.get(fim);

        if (!arestas.containsKey(verticeInicio)) {
            arestas.put(verticeInicio, new HashMap<>());
        }

        arestas.get(verticeInicio).put(verticeFim, peso);
    }

    public Vertice getVertice(String nome) {
        return vertices.get(nome);
    }

    public Map<Vertice, Double> getVizinhos(Vertice vertice) {
        return arestas.getOrDefault(vertice, Collections.emptyMap());
    }
}