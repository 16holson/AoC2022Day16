import java.io.*;
import java.util.*;

public class Part1
{
    static class Vertex
    {
        private String value;
        private int flow;

        public Vertex(String value, int flow)
        {
            this.value = value;
            this.flow = flow;
        }

        public Vertex(String value)
        {
            this.value = value;
            this.flow = 0;
        }

        public Vertex()
        {
        }

        public String getValue()
        {
            return value;
        }

        public void setValue(String value)
        {
            this.value = value;
        }

        public int getFlow()
        {
            return flow;
        }

        public void setFlow(int flow)
        {
            this.flow = flow;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (obj == this)
            {
                return true;
            }
            Vertex other = (Vertex) obj;
            return Objects.equals(this.value, other.getValue());
        }

        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result
                    + ((value == null) ? 0 : value.hashCode());
            return result;
        }

        @Override
        public String toString()
        {
            return "Vertex{" +
                    "value=" + value +
                    ", flow=" + flow +
                    '}';
        }
    }

    static class Edge
    {
        private Vertex source;
        private Vertex dest;
        private int weight;

        public Edge(Vertex source, Vertex dest, int weight)
        {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public String toString()
        {
            return "Edge{" +
                    "source=" + source +
                    ", dest=" + dest +
                    ", weight=" + weight +
                    '}';
        }
    }

    static class Graph
    {
        Map<Vertex, List<Edge>> adj;

        Graph()
        {
            adj = new HashMap<>();
        }

        public Map<Vertex, List<Edge>> getAdj()
        {
            return adj;
        }

        public void addVertex(String value, int flow)
        {
            Vertex v = new Vertex(value, flow);
            List<Edge> edges = new ArrayList<>();
            this.adj.put(v, edges);
        }

        public List<Edge> getEdges(Vertex source)
        {
            return adj.get(source);
        }

        public void addEdge(Vertex source, Vertex dest, int weight)
        {
            List<Edge> sourceEdges = this.getEdges(source);
            sourceEdges.add(new Edge(source, dest, weight));
        }

        public void printGraph()
        {
            for (Map.Entry<Vertex, List<Edge>> entry : adj.entrySet())
            {
                System.out.println(entry.getKey() + ":" + entry.getValue().toString());
            }
        }

        public void traverse()
        {

        }
    }

    public static void main(String[] args) throws IOException
    {
        Graph graph = new Graph();
        String line;
        String file = new File("").getAbsolutePath();
        file = file.concat("\\src\\InputData.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        while ((line = bufferedReader.readLine()) != null)
        {
            String[] split = line.strip().split("; ");
            String value = split[0].replace("Valve ", "").replace(" has flow rate=", "").replaceAll("\\d", "");
            int flow = Integer.parseInt(split[0].replaceAll("[^\\d]", ""));

            graph.addVertex(value, flow);

        }
        bufferedReader = new BufferedReader(new FileReader(file));
        while ((line = bufferedReader.readLine()) != null)
        {

            String[] split = line.strip().split("; ");
            String value = split[0].replace("Valve ", "").replace(" has flow rate=", "").replaceAll("\\d", "");
            int flow = Integer.parseInt(split[0].replaceAll("[^\\d]", ""));
            Vertex vertex = new Vertex(value, flow);
            String replace = split[1].strip().replace("tunnels lead to valves ", "");
            String[] edges;
            if (!replace.contains(","))
            {
                edges = new String[]{replace.replace("tunnel leads to valve ", "")};
            }
            else
            {
                edges = replace.strip().split(", ");
            }
            for (Vertex temp : graph.getAdj().keySet())
            {
                for (String edge : edges)
                {
                    if (temp.getValue().equals(edge))
                    {
                        graph.addEdge(vertex, temp, 2);
                    }

                }
            }
        }
        graph.printGraph();
    }
}
