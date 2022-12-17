import java.io.*;
import java.util.LinkedList;
import java.util.Vector;

public class Part1
{
    static class Edge
    {
        int source;
        int dest;
        int weight;
        public Edge(int source, int dest, int weight)
        {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }
    static class Graph
    {
        int vertices; //Number of vertices
        LinkedList<Edge>[] adjList;

        Graph(int vertices)
        {
            this.vertices = vertices;
            this.adjList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++)
            {
                this.adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int dest, int weight)
        {
            Edge edge = new Edge(source, dest, weight);
            adjList[source].addFirst(edge);
        }
        public void printGraph()
        {
            for(int i = 0; i < vertices; i++)
            {
                LinkedList<Edge> list = adjList[i];
                for (Edge edge : list)
                {
                    System.out.println("vertex-" + i + " is connected to " + edge.dest + " with weight " + edge.weight);
                }
            }
        }

        public static void main(String[] args) throws IOException
        {
            int vertices = 10;
            Graph graph = new Graph(vertices);
            String line;
            String file = new File("").getAbsolutePath();
            file = file.concat("\\src\\InputData.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while((line = bufferedReader.readLine()) != null)
            {

            }
        }
    }
}
