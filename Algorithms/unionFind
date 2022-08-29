public class LeetCode547UF {
	public int findCircleNum(int[][] isConnected) {
		int N = isConnected.length;
		UnionFind uf = new UnionFind(N);
		for(int i = 0;i < N;i++) {
			for(int j = i + 1;j < N;j++) {
				if (isConnected[i][j] == 1) {
					uf.union(i,j);
				}

			}
		}
		return uf.size;
	}
}

class UnionFind{
	int[] roots;
	int size; //集合数量
	public UnionFind(int n) {
		roots = new int[n];
		for(int i = 0;i < n;i++)
			roots[i] = i;
		size = n;
	}
	//递归寻找根节点
	int find(int x) {
		int r = x;
		while(roots[r] != r) {
			r = roots[r];
		}
		while(roots[x] != x) {
			int t = roots[x];
			roots[x] = r;
			x = t;
		}
		return x;
	}
	//迭代寻找根节点
	public int findroot(int x) {
		while(roots[x] != x) {
			x = roots[x];
		}
		return x;
	}
	
	//比较根节点，合并操作
	public void union(int p,int q) {
		int pRoot = findroot(p);
		int qRoot = findroot(q);
		if(pRoot != qRoot) {
			roots[pRoot] = qRoot;
			size--;
		}
	}
}
