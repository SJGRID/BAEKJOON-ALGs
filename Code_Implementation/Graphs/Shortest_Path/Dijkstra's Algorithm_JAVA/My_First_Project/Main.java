import java.io.*;
import java.util.*;
public class Main {
	//���ͽ�Ʈ�󿡼� ����� �켱���� ť
	static PriorityQueue<Pair> q = new PriorityQueue<Pair>();
	
	//���� ����Ʈ
	static ArrayList<ArrayList<Pair>> adj;
	
	//�Ÿ� ��� �迭
	static int[] distance;
	
	static boolean[] processed;
	public static void main(String[] args) {
		int n = 5;
		AdjInit(n);
		Add(1,2,5);
		Add(1,4,9);
		Add(1,5,1);
		Add(2,3,2);
		Add(3,4,6);
		Add(4,5,2);
		
		//INF(���Ѵ�)�� ���� �����Ƿ� ������ ū ���� �ִ´�.
		for(int i = 1; i <= n; i++) {
			distance[i] = 20;
		}
		
		Dijkstra();
		
		for(int i = 1; i <= n; i++) {
			System.out.println(i + " : " + distance[i]);
		}
	}
	
	public static void Dijkstra() {
		//���۰����� 1�� ����
		distance[1] = 0;
		//1���� ���� ������ ���̰� 0�̶�� �ǹ�
		q.add(new Pair(1,0));
		
		while(!q.isEmpty()) {
			int a = q.poll().index;
			if(processed[a]) continue;
			processed[a] = true;
			for(Pair p : adj.get(a)) {
				int b = p.index; int w = p.distance;
				if(distance[a] + w < distance[b]) {
					distance[b] = distance[a] + w;
					q.offer(new Pair(b, distance[b]));
				}
			}
		}
	}
	
	public static void Add(int a, int b, int w) {
		adj.get(a).add(new Pair(b, w));
		adj.get(b).add(new Pair(a, w));
	}
	
	public static void AdjInit(int n) {
		adj = new ArrayList<ArrayList<Pair>>();
		distance = new int[n+1];
		processed = new boolean[n+1];
		for(int i = 0; i < n+1; i++) {
			adj.add(new ArrayList<Pair>());
		}
	}
}