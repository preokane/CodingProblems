#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);

int utopianTree(int n) {
    
    int tree = 1;
    
    for (int i = 1; i <= n; ++i) {
        if (i % 2 == 0)  ++tree;
        else  tree*=2;        
    }

    return tree;
}

int utopianTreeRecursive(int n) {
    if (n == 0) return 1;

    if (n % 2 == 0) 
        return 1 + utopianTreeRecursive(n-1);
    else 
        return 2 * utopianTreeRecursive(n-1);
}

int main()
{
    string t_temp;
    getline(cin, t_temp);

    int t = stoi(ltrim(rtrim(t_temp)));

    for (int t_itr = 0; t_itr < t; t_itr++) {
        string n_temp;
        getline(cin, n_temp);

        int n = stoi(ltrim(rtrim(n_temp)));

        int result = utopianTree(n);

        cout << result << "\n";
    }

    return 0;
}

string ltrim(const string &str) {
    string s(str);

    s.erase(
        s.begin(),
        find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace)))
    );

    return s;
}

string rtrim(const string &str) {
    string s(str);

    s.erase(
        find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(),
        s.end()
    );

    return s;
}
