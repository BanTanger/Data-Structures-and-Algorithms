//#define _CRT_SECURE_NO_WARNINGS 1
//#include<iostream>
//#include<map>
//#include<set>
//#include<vector>
//using namespace std;
//set<int> s;
//map<int, int> mp;
//int main() {
//	int n;
//	cin >> n;
//	for (int i = 1; i <= n; i++) {
//		int x;
//		cin >> x;
//		mp[x] = i; // 创造映射，mp的值和当前它的位置
//		s.insert(x);
//	}
//	// map,set 的遍历方式
//	for (auto v: s) cout << v << endl;
//
//	for (auto v: mp) cout << v.first<<" "<<v.second << endl;
//	//或者
//	set<int>::iterator it;
//	for (it = s.begin(); it != s.end(); it++)
//		cout << *it << endl; // 通过指针来读取数据
//	map<int, int>::iterator itl;
//	for (itl = mp.begin(); itl != mp.end(); itl++)
//		cout << itl->first << " " << itl->second << endl;
//	//map,set 常用的一些操作
//	int x;
//	s.erase(x); //删除
//	s.clear();//清空
//	s.size();//计数
//	s.empty();//判空，如果是空，返回1，不是空返回0
//	return 0;
//}