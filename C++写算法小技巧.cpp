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
//		mp[x] = i; // ����ӳ�䣬mp��ֵ�͵�ǰ����λ��
//		s.insert(x);
//	}
//	// map,set �ı�����ʽ
//	for (auto v: s) cout << v << endl;
//
//	for (auto v: mp) cout << v.first<<" "<<v.second << endl;
//	//����
//	set<int>::iterator it;
//	for (it = s.begin(); it != s.end(); it++)
//		cout << *it << endl; // ͨ��ָ������ȡ����
//	map<int, int>::iterator itl;
//	for (itl = mp.begin(); itl != mp.end(); itl++)
//		cout << itl->first << " " << itl->second << endl;
//	//map,set ���õ�һЩ����
//	int x;
//	s.erase(x); //ɾ��
//	s.clear();//���
//	s.size();//����
//	s.empty();//�пգ�����ǿգ�����1�����ǿշ���0
//	return 0;
//}