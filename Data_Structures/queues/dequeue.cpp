#include <iostream>
#include <algorithm>
using namespace std;

#define size 10

class Dq
{
    int dq[size];
    int f, r;

public:
    Dq()
    {
        f = r = -1;
    }
    void insrear();
    void insfront();
    void delrear();
    void delfront();
    void display();
};

void Dq::insrear() // Three cases : full { f == (r + 1) % size }, empty ,normal case { r = (r + 1 )%size }
{
    int v;
    if ((f == (r + 1) % size))
        cout << "Overflow" << endl;

    else if (f == -1 && r == -1)
    {
        f = r = 0;
        cout << "Enter the inserted value !!" << endl;
        cin >> v;
        dq[r] = v;
    }

    else
    {
        cout << "Enter the inserted value !!" << endl;
        cin >> v;
        r = (r + 1) % size;
        dq[r] = v;
    }
}
void Dq::insfront()
{ // Cases : full { f == (r + 1) % size } , empty , normal case { f = (f-1+size)% size }

    int v;

    if ((f == (r + 1) % size))
        cout << "Overflow" << endl;

    else if (f == -1 && r == -1)
    {
        f = r = 0;
        cout << "Enter the inserted value (*** Insert front sir ***) " << endl;
        cin >> v;
        dq[f] = v;
    }
    else
    {
        cout << "Enter the inserted value (*** Insert front sir ***) " << endl;
        cin >> v;
        f = (f - 1 + size) % size;
        dq[f] = v;
    }
}

void Dq::delfront()
{
    // Cases : Empty (f = -1), front = rear (last element) , normal case : F = (F + 1 ) % size
    if (f == -1)
        cout << "Underflow" << endl;
    else if (f == r)
    {
        dq[f] = 0; // delete
        cout << "D-Queue become empty now !!" << endl;
        f = r = -1;
    }
    else
    {
        dq[f] = 0;
        f = (f + 1) % size;
    }
}
void Dq::delrear()
{
    // Cases : empty (f = -1 ) , front = rear (last element) , normal case : r = (r - 1 + size) %size
    if (f == -1)
        cout << "Underflow" << endl;
    else if (f == r)
    {
        dq[r] = 0; // delete
        cout << "D-Queue become empty now !!" << endl;
        f = r = -1;
    }
    else
    {
        dq[r] = 0; // delete
        r = (r - 1 + size) % size;
    }
}

void Dq::display()
{
    // for (int i = f; i <= r ; i++)
    // {
    //     cout << dq[i] << "\t";
    // }
    for (int i = f;; i = (i + 1) % size)
    {
        cout << dq[i] << "\t";
        if (i == r)
            break;
    }
    cout << endl;
    cout << "Rear = " << r << endl;
    cout << "Front = " << f << endl;
}
main()
{
    Dq s;
    s.insrear();
    s.insrear();
    s.insrear();
    s.insrear();
    s.insrear();
    s.display();
    cout << "################" << endl;

    s.delfront();
    s.display();

    cout << "################" << endl;

    s.insfront();
    s.display();

    return 0;
}