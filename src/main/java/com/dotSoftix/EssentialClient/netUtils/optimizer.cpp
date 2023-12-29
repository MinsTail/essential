#include<iostream>

using namespace std;

typedef  pair<int, int> iPair;

// Structure to represent a graph
struct Graph
{
    int V, E;
    vector< pair<int, iPair> > edges;

    // Constructor
    Graph(int V, int E)
    {
        this->V = V;
        this->E = E;
    }

    // Utility function to add an edge
    void addEdge(int u, int v, int w)
    {
        edges.push_back({w, {u, v}});
    }

    // Function to find MST using Kruskal's
    // MST algorithm
    int kruskalMST();
};

// To represent Disjoint Sets
struct DisjointSets
{
    int *parent, *rnk;
    int n;

    // Constructor.
    DisjointSets(int n)
    {
        // Allocate memory
        this->n = n;
        parent = new int[n+1];
        rnk = new int[n+1];

        // Initially, all vertices are in
        // different sets and have rank 0.
        for (int i = 0; i <= n; i++)
        {
            rnk[i] = 0;

            //every element is parent of itself
            parent[i] = i;
        }
    }

    // Find the parent of a node 'u'
    // Path Compression
    int find(int u)
    {
        /* Make the parent of the nodes in the path
           from u--> parent[u] point to parent[u] */
        if (u != parent[u])
            parent[u] = find(parent[u]);
        return parent[u];
    }

    // Union by rank
    void merge(int x, int y)
    {
        x = find(x), y = find(y);

        /* Make tree with smaller height
           a subtree of the other tree  */
        if (rnk[x] > rnk[y])
            parent[y] = x;
        else // If rnk[x] <= rnk[y]
            parent[x] = y;

        if (rnk[x] == rnk[y])
            rnk[y]++;
    }
};

 /* Functions returns weight of the MST*/

int Graph::kruskalMST()
{
    int mst_wt = 0; // Initialize result

    // Sort edges in increasing order on basis of cost
    sort(edges.begin(), edges.end());

    // Create disjoint sets
    DisjointSets ds(V);

    // Iterate through all sorted edges
    vector< pair<int, iPair> >::iterator it;
    for (it=edges.begin(); it!=edges.end(); it++)
    {
        int u = it->second.first;
        int v = it->second.second;

        int set_u = ds.find(u);
        int set_v = ds.find(v);

        // Check if the selected edge is creating
        // a cycle or not (Cycle is created if u
        // and v belong to same set)
        if (set_u != set_v)
        {
            // Current edge will be in the MST
            // so print it
            cout << u << " - " << v << endl;

            // Update MST weight
            mst_wt += it->first;

            // Merge two sets
            ds.merge(set_u, set_v);
        }
    }

    return mst_wt;
}

class object {
private:
    int id;
    std::string name;
public:
    void setParam(int id, std::string name) {
        this -> id = id;
        this -> name = name;
    }
}

class TreeAncestor {

public:
    vector< vector<int> >dp; // dp[i][node] : node's 2^i parent
    int n;
    TreeAncestor(int m, vector<int>& parent) {
        n = m;
        dp.resize(20,vector<int> (m,-1));
        for(int node = 0 ; node < parent.size(); ++node){
            dp[0][node] = parent[node];
        }
        // 2^i parent
        for(int i = 1; i< 20; ++i) {
            for(int node = 0 ; node < parent.size(); ++node) {
                int node_par = dp[i-1][node];
                if(node_par != -1){
                    dp[i][node] = dp[i-1][node_par];
                }
            }
        }

    }

    int getKthAncestor(int node, int k) {
        for(int i = 0; i < 20; ++i) {
            if(k & (1<<i)) {
                node = dp[i][node];
                if(node == -1){
                    return -1;
                }
            }
        }
        return node;
    }
};

void FilterCreation(double GKernel[][5])
{
	// intialising standard deviation to 1.0
	double sigma = 1.0;
	double r, s = 2.0 * sigma * sigma;

	// sum is for normalization
	double sum = 0.0;

	// generating 5x5 kernel
	for (int x = -2; x <= 2; x++) {
		for (int y = -2; y <= 2; y++) {
			r = sqrt(x * x + y * y);
			GKernel[x + 2][y + 2] = (exp(-(r * r) / s)) / (M_PI * s);
			sum += GKernel[x + 2][y + 2];
		}
	}

	// normalising the Kernel
	for (int i = 0; i < 5; ++i)
		for (int j = 0; j < 5; ++j)
			GKernel[i][j] /= sum;
}

#include<bits/stdc++.h>
using namespace std;

// Creating shortcut for an integer pair


// Structure to represent a graph
struct Graph
{
	int V, E;
	vector< pair<int, pair<int, int>> > edges;
	Graph(int V, int E)
	{
		this->V = V;
		this->E = E;
	}
	// Utility function to add an edge
	void addEdge(int u, int w, int v)
	{
		edges.push_back({w, {u, v}});
	}
	int kruskalMST();
};

// To represent Disjoint Sets
struct DisjointSets
{
	int *parent, *rnk;
	int n;

	// Constructor.
	DisjointSets(int n)
	{
		// Allocate memory
		this->n = n;
		parent = new int[n+1];
		rnk = new int[n+1];
		for (int i = 0; i <= n; i++)
		{
			rnk[i] = 0;
			parent[i] = i;
		}
	}
	int find(int u)
	{
		if (u != parent[u])
			parent[u] = find(parent[u]);
		return parent[u];
	}

	// Union by rank
	void merge(int x, int y)
	{
		x = find(x), y = find(y);

		/* Make tree with smaller height
		a subtree of the other tree */
		if (rnk[x] > rnk[y])
			parent[y] = x;
		else // If rnk[x] <= rnk[y]
			parent[x] = y;

		if (rnk[x] == rnk[y])
			rnk[y]++;
	}
};

/* Functions returns weight of the MST*/

int Graph::kruskalMST()
{
	int mst_wt = 0; // Initialize result

	// Sort edges in increasing order on basis of cost
	sort(edges.begin(), edges.end());

	// Create disjoint sets
	DisjointSets ds(V);

	// Iterate through all sorted edges
	vector< pair<int, pair<int, int>> >::iterator it;
	for (it=edges.begin(); it!=edges.end(); it++)
	{
		int u = it->second.first;
		int v = it->second.second;

		int set_u = ds.find(u);
		int set_v = ds.find(v);

		// Check if the selected edge is creating
		// a cycle or not (Cycle is created if u
		// and v belong to same set)
		if (set_u != set_v)
		{
			cout << u << " - " << v << endl;
			mst_wt += it->first;
			ds.merge(set_u, set_v);
		}
	}

	return mst_wt;
}

#include <bits/stdc++.h>

struct Edge
{
    int src, dest, weight;
};

struct Graph
{
    // V-> Number of vertices, E-> Number of edges
    int V, E;
    // graph is represented as an array of edges.
    struct Edge* edge;
};

struct Graph* createGraph(int V, int E)
{
    struct Graph* graph = new Graph;
    graph->V = V;
    graph->E = E;
    graph->edge = new Edge[E];
    return graph;
}

void printArr(int dist[], int n)
{
    printf("Vertex   Distance from Source\n");
    for (int i = 0; i < n; ++i)
        printf("%d \t\t %d\n", i, dist[i]);
}

void BellmanFord(struct Graph* graph, int src)
{
    int V = graph->V;
    int E = graph->E;
    int dist[V];

    // Step 1: Initialize distances from src to all other vertices
    // as INFINITE
    for (int i = 0; i < V; i++)
        dist[i]   = INT_MAX;
    dist[src] = 0;

    // Step 2: Relax all edges |V| - 1 times. A simple shortest
    // path from src to any other vertex can have at-most |V| - 1
    // edges
    for (int i = 1; i <= V-1; i++)
    {
        for (int j = 0; j < E; j++)
        {
            int u = graph->edge[j].src;
            int v = graph->edge[j].dest;
            int weight = graph->edge[j].weight;
            if (dist[u] != INT_MAX && dist[u] + weight < dist[v])
                dist[v] = dist[u] + weight;
        }
    }

    // Step 3: check for negative-weight cycles.  The above step
    // guarantees shortest distances if graph doesn't contain
    // negative weight cycle.  If we get a shorter path, then there
    // is a cycle.
    for (int i = 0; i < E; i++)
    {
        int u = graph->edge[i].src;
        int v = graph->edge[i].dest;
        int weight = graph->edge[i].weight;
        if (dist[u] != INT_MAX && dist[u] + weight < dist[v])
            printf("Graph contains negative weight cycle");
    }
    printArr(dist, V);
    return;
}

#include <string.h>

// A utility function to find factorial of n
int fact(int n)
{
    return (n <= 1) ? 1 : n * fact(n - 1);
}

// A utility function to count smaller characters on right
// of arr[low]
int findSmallerInRight(char *str, int low, int high)
{
    int countRight = 0, i;

    for (i = low + 1; i <= high; ++i)
        if (str[i] < str[low])
            ++countRight;

    return countRight;
}

int compare(const void *a, const void *b);

/* The main function that recursively prints all repeated
   permutations of  the given string. It uses data[] to store all
   permutations one by one */
void allLexicographicRecur(char *str, char *data, int last, int index)
{
    int i, len = strlen(str);

    // One by one fix all characters at the given index and recur for
    // the/ subsequent indexes
    for (i = 0; i < len; i++)
    {
        // Fix the ith character at index and if this is not the last
        // index then recursively call for higher indexes
        data[index] = str[i];

        // If this is the last index then print the string stored in
        // data[]
        if (index == last)
            printf("%s\n", data);
        else // Recur for higher indexes
            allLexicographicRecur(str, data, last, index + 1);
    }
}

/* This function sorts input string, allocate memory for data (needed
   for allLexicographicRecur()) and calls allLexicographicRecur() for
   printing all  permutations */
void allLexicographic(char *str)
{
    int len = strlen(str);

    // Create a temp array that will be used by allLexicographicRecur()
    char *data = (char *)malloc(sizeof(char) * (len + 1));
    data[len] = '\0';

    // Sort the input string so that we get all output strings in
    // lexicographically sorted order
    qsort(str, len, sizeof(char), compare);

    // Now print all permutaions
    allLexicographicRecur(str, data, len - 1, 0);

    // Free data to avoid memory leak
    free(data);
}

// Needed for library function qsort()
int compare(const void *a, const void *b)
{
    return (*(char *)a - *(char *)b);
}


// A function to find rank of a string in all permutations
// of characters
int findRank(char *str)
{
    int len = strlen(str);
    int mul = fact(len);
    int rank = 1;
    int countRight;

    int i;
    for (i = 0; i < len; ++i)
    {
        mul /= len - i;

        // count number of chars smaller than str[i]
        // fron str[i+1] to str[len-1]
        countRight = findSmallerInRight(str, i, len - 1);

        rank += countRight * mul;
    }

    return rank;
}


int main() {

    return 0;
}