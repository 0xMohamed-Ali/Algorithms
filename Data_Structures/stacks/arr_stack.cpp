#include <iostream>
using namespace std;

class Stack{
    private:
        int topIdx;
        int cap;
        int *arr;
    public:
        Stack(int capacity){
            cap = capacity;
            arr = new int[cap];
            topIdx = -1;
        }
        void push(int data)
        {
            if(isFull()){
                cout<<"Stack is full(0verflow)"<<endl;
                return;
            }
            topIdx++;
            arr[topIdx] = data;
            cout<<data<<" Is inserted"<<endl;
        }
        bool isFull(){
            return topIdx == cap-1;
        }
        void peek(){
            if(isEmpty()){
                cout<<"Stack underflow !";
                return;
            }
            cout<<arr[topIdx];
        }
        void pop(){
            if(isEmpty()){
                cout<<"Stack underflow cannot pop !";
                return;
            }
            cout<<arr[topIdx]<<"popped from the stack";
            arr[topIdx] = 0;
            topIdx--;
        }
        bool isEmpty(){
            return topIdx == -1;
        }
};

int main(){
    Stack s(5);
    s.push(10);
    s.push(5);
    s.push(4);
    s.push(3);
    return -1;
}