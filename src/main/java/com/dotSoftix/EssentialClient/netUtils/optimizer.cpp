#include<iostream>

using namespace std;

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

int main() {

    return 0;
}