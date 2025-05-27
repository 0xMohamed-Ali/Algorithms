#include <iostream>
using namespace std;

class Queue{
    private:
        int *arr;
        int capacity;
        int front;
        int rear;
    public:
        Queue(int size){
            capacity = size;
            arr = new int[size];
            front = -1;
            rear = -1;
        }
        void push(int data){
            if(front == -1){
                front++;
                rear++;
                arr[front] = data;
                cout<<data<<" Is inserted"<<endl;
            }
            else{
                rear++;
                arr[rear] = data;
                cout<<data<< " Is inserted"<<endl;
            }
        }
        bool isFull(){
            return front == -1;
        }
};

int main(){
    Queue q(5);
    q.push(10);
    q.push(3);
    q.push(55);
    q.push(12);
    q.push(99);
    return -1;
}