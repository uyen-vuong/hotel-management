#include <iostream>
#include <queue>
using namespace std;

int main() {
	ios_base::sync_with_stdio(NULL);
	cin.tie(NULL);
	int n, m, x, y;
	cin>>n>>m;
	priority_queue < int, vector <int>, greater<int> > q[n+5];
	while( m-- ){
		cin>>x>>y;
		q[x].push(y);
		q[y].push(x);
	}
	for(int i=1; i<=n; i++){
		while( !q[i].empty() ){
			cout<<q[i].top()<<" ";
			q[i].pop();
		}
		cout<<endl;
	}
}
