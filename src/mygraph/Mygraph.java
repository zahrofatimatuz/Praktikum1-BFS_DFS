/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygraph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author FAZA
 */
public class Mygraph {
    
    private final int v;

	// Adjacency Lists
    private final LinkedList<Integer> adj[];
    
    @SuppressWarnings("unchecked")
    public Mygraph(int v) { //ini konstruktor
	this.v = v; //untuk inisialisasi vertex (node)
	adj = new LinkedList[v];
	for (int i = 0; i < v; ++i) {
		adj[i] = new LinkedList<>();//semua node, dimasukan ke array. Bukan array biasa, tapi linkedlist, karena tidak diketahui jumlahnya
        }
    }
    
    public void addEdge(int v, int w) { // untuk menghubungkan node dengan node
	adj[v].add(w);
	adj[w].add(v);
    }
    
    	public void bfs(int source) {

		// Mark all the vertices as not visited (by default set as false)
		boolean visited[] = new boolean[v];
                int parent[] = new int[15];

		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<>();

		// Mark the current node as visited and enqueue it
		visited[source] = true;
		queue.add(source);

		while (!queue.isEmpty()) {

			// Dequeue a vertex from queue and print it
			source = queue.poll();
			System.out.println(source + " "+parent[source]);
                        //System.out.print(parent[source]);

			// Get all adjacent vertices of the dequeued vertex source
			Iterator<Integer> iterator = adj[source].listIterator();

			// If an adjacent vertex has not been visited, then mark it visited and enqueue it
			while (iterator.hasNext()) {
				int n = iterator.next();
                                //System.out.print(parent[n]);
                                //parent[n]=source;

				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
                                        parent[n]=source;
                                        //System.out.print(" - "+n);
				}
			}
                        
		}
	}
        
    private void dfsUtil(int v, boolean visited[]) {

		// Mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v + " ");

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> iterator = adj[v].listIterator();
		while (iterator.hasNext()) {
			int n = iterator.next();

			if (!visited[n]) {
				dfsUtil(n, visited);
			}
		}
    }
    
    	// The function to do DFS traversal. It uses recursive DFSUtil()
    public void dfs() {

		// Mark all the vertices as not visited (by default set as false)
		boolean visited[] = new boolean[v];

		// Call the recursive helper function to print DFS traversal
		for (int i = 0; i < v; ++i) {
			if (!visited[i]) {
				dfsUtil(i, visited);
			}
		}
    }
    
    void DFS(int v)
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[v];
 
        // Call the recursive helper function to print DFS traversal
        dfsUtil(v, visited);
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Mygraph g;
        g = new Mygraph(15);

	g.addEdge(0, 1);//membuat node 1 yang terhubung dengan node 0
	g.addEdge(0, 2);//membuat node 5 yang terhubung dengan node 0
	g.addEdge(1, 3);//membuat node 7 yang terhubung dengan node 0
	g.addEdge(1, 4);//membuat cabang dari node 1, yaitu node 2
	g.addEdge(2, 5);//membuat cabang dari node 5 yaitu node 6
	g.addEdge(2, 6);
	g.addEdge(3, 7);
	g.addEdge(3, 8);
	g.addEdge(4, 9);
	g.addEdge(4, 10);
	g.addEdge(5, 11);
	g.addEdge(5, 12);
	g.addEdge(6, 13);
	g.addEdge(6, 14);


	System.out.println("Following is Breadth First Traversal (starting from vertex 0): ");
	g.bfs(0);
        System.out.println("-----------");
        g.dfs();
    }
    
}
