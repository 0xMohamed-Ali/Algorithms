#include <iostream>
using namespace std;

class Node{
    public:
        int data;
        Node * next;

        Node(int val)
        {
            data = val;
            next = NULL;
        }
};

class Stack{
    private:
        Node *top;
    public:
        Stack()
        {
            top = NULL;
        }
    
        void push(int data)
        {
            Node *newNode = new Node(data);
            newNode->next = top;
            top = newNode;
            cout<<newNode->data<<" is inserted"<<endl;
        }
        void pop()
        {
            if(top == NULL)
                cout<<"Stack is empty";
            Node *temp = top;
            top = top->next;
            cout<<temp->data<<" is deleted"<<endl;
            delete temp;
        }
        void print()
        {
            Node *ptr = top;
            while(ptr != NULL)
            {
                cout<<ptr->data<<" , ";
                ptr = ptr->next;
            }
        }
};

int main()
{
    Stack s;
        s.push(10);
    s.push(20);
    s.push(30);
    s.pop();
    s.push(10);
    s.push(20);
    s.push(30);
    s.pop();
    s.print();
}