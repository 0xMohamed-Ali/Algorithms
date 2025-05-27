    #include <iostream>
    using namespace std;

    class Node{
        public:
            Node * next;
            int data;
            Node(int val){
                next = nullptr;
                data = val;
            }
    };
    class queue{
        public:
            Node *front;
            Node *rear;
            queue(){
                front = nullptr;
                rear = nullptr;
            }
            void push(int data){
                Node *newNode = new Node(data);
                if(rear == nullptr){
                    front = rear = newNode;
                    cout<<rear->data<<" Is inserted"<<endl;
                    return;
                }
                else{
                    rear->next = newNode;
                    rear = newNode;
                    cout<<rear->data<<" Is inserted"<<endl;
                }
            }
            void dequeue() {
            if (front == nullptr) {
                cout << "Queue Underflow\n";
                return;
            }
            Node* temp = front;
            front = front->next;

            if (front == nullptr) {
                rear = nullptr;
            }

            delete temp;
        }
        // void getFront(){
        //     if(front == nullptr){
        //         cout<<"queue is empty";
        //         return
        //     }
        //     else{
        //         cout<<"front element is "<<front->data<<endl;
        //     }
        // }
    };
        int main() {
        queue q;
        q.push(1);
        q.push(2);
        q.push(3);

        // cout << "Front element: " << q.getFront() << endl;

        q.dequeue();
        // cout << "Front element after dequeue: " << q.getFront() << endl;

        return 0;
    }
