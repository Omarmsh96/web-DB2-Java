
/**
Aufgabe Nr./Task No.: H5
Nachname/Last,Family Name:Hassan
Vorname/First,Given Name: Omar
Matrikelnummer/Matriculation number: 3071001
Uni-Email: hassan.omar@stud.uni-due.de
Studiengang/Course of Studies: ISE software engineering
*************************************************/
#include <iostream>
#include <string>
using namespace std;

class Date {

    private :
        unsigned int day, mounth , year ;
        const int dayInMounth[12]={31,28,31,30,31,30,31,31,30,31,30,31};
    public :
        void set_Date(int D ,int M, int Y ){
        D= day;
        M=mounth;
        Y=year ;
        }
        int get_day(){
        return day ;
        }
        int get_mounth(){
        return mounth ;
        }
        int get_year(){
        return year ;
        }
        Date operator+(int n)
        {
           if(n>28){
             cout<<"error must less than 28 " ;}
           if((day+n)>(dayInMounth-1))
           if(mounth==12){
              return Date((day+n)-dayInMounth(mounth-1),1,year+1);}
           else
              {return Date((day+n)-dayInMounth(mounth-1),mounth+1,year);}

        }

        friend ostream& operator<<(ostream & out , Date& d);
        friend istream& operator>>(istram&in , Date& d);
};
        ostream& operator<<(ostream & out ,Date& d)
        {
        return out
          << setw(4) << setfill('0') << d.get_year()
          << '-' << setw(2) << setfill('0') <<d.get_month()
          << '-' << setw(2) << setfill('0') <<d.get_day()<<endl;
        }
        istream& operator>>(istram&in ,Date& d){
        char a;

        return in >>d.day>>a >>d.mounth >>a >>d.year ;}


enum struct Board {noMeals,breakfast,halfBoard,allinclusive};
ostream & operator<<(ostream & out ,Board& b);
{
    if(b==Board::noMeals)
        return out<<"no Meals";
    else
        if(b==Board::breakfast)
        return out<<"break fast";
    else
        if(b==Board::halfboard)
        return out<<"half board";
    else
        if(b==Board::allinclsive)
        return out<<"all inclusive";
}

istream &operator>>(istream &in,Board &b)
{
    char c ;
    cout<<"(noMeals,breakfast,halfBoard,allinclusive)";
    cin>>c;

        switch(c)
         {
        case 'a':b=Board::allinclsive;
        break;
        case 'b':b=Board::breakfast;
        break;
        case 'h':b=Board::halfBoard;
        break;
        case 'n':b=Board::noMeals;
        break;
        default:
        break;
        }
return in ;
            }

class Hotal {

    private:
        string name ;
        Date arrival ;
        int nights;
        int singles,doubles ;
        Board board ;
        double priceNightSingle ;
        double priceNightDouble ;
        double totalprice;
        bool parking ;
    public:
        Hotal(string m,Date a ,int n,int s=1 ,int d=2 ,Board b ,double ps,double pd,double t ,bool p){
        name=m;
        arrival=a;
        nights=n ;
        singles=s;
        doubles=d;
        board=b;
        priceNightSingle=ps;
        priceNightDouble=pd;
        totalprice=t;
        parking=p;
        }
        ~Hotal(){
        cout<<"destructor hotel"<<name<<"at"<<arrival<<"for"<<get_guests()<<"guest(s)"<<"done" <<endl;
        }
        double get_price(){
        if(parking == true){
           return totalprice =((nights *(priceNightSingle+priceNightDouble)) + 10)
        }
        else
        {
          return totalprice =((nights *(priceNightSingle+priceNightDouble))
        }
        }
        Date get_arrival(){
           return arrival ;
        }
        Date get_checkout(){
           return depaturedate =(arrival+nights);
        }
        int get_guests(){
           return guests=(singles+doubles);
        }
        void print(){
        cout<<"hotel"<<departure<<hotel<<"for"<<nights<<doubles<<singles<<"bed room(s)"<<board;
        if(parking==true){
            cout<<"parking included";
        }
        }
};
class Transport{
    public:
       virtual~Transport()
        {
           cout<<"destructor Transport done"<<endl;
        }

        virtual bool withTransfer()=0;
        virtual double get_price()=0;
        virtual void print()=0;
};
class SelfOrganised : public Transport {
    public:
        SelfOrganised();
       ~SelfOrganised(){
            cout<<"destructor SelfOrganised done"<<endl;  }
        virtual bool withTransfer(){return (false);}
        virtual double get_price(){ return 0.00 ;}
        virtual void print()
        {
        cout<<"self organised transport"
            <<"no transfer\n";
        }
};
class PublicTransport : public Transport
{
    protected:
        Date departure ;
        string code ;
        string from ;
        string to;
        double priceOneSeat ;
        bool firstClass ;
    public:
        PublicTransport(Date d,string c,string f,string t,double p,bool first=false){
        departure=d;
        code=c;
        from=f;
        to=t;
        priceOneSeat=p;
        fistClass=fist;
        }
    virtual~PublicTransport(){
    cout<<"destructor PublicTransport"<<code <<"at"<<departure<<"done"<<endl;}
    virtual void print(){
    cout<<departure<<code<<"from"<<from<<"to"<<to<<endl;
    if(fistClass==true){

    }
    }
};
class Flight : public PublicTransport {
    private:
       bool transfer;
    public:
            Flight(Date d,string c,string f ,string t,double p,bool fisrt=false ,bool tra=true):
            PublicTransport(d,c,f,to,t,p,fist),
            transfer(tra)
                {}
        virtual~Flight(){
        cout<<"destructor flight done"<<endl;
        }
        virtual bool withTransfer();
        virtual double get_price(){return priceOnSeat,fistClass=(priceOnSeat * 2);}
        virtual print(void){
        cout<<"flight"<<endl;
        PublicTransport::print();}
    };
class Train : public PublicTransport{
        public:
            Train(Date d,string c,string f ,string t,double p,bool fisrt=false):
                PublicTransport(d,c,from,t,p,fist)
                {}
       virtual ~Train(){
       cout<<"destructor Train done"<<endl;
       }
       virtual bool withTransfer(){return false ;}
       virtual double get_price(){return priceOnSeat,firstClass=(priceOnSeat * 1,5)}
       virtual void print(){
       cout<<"Train"<<endl;
       PublicTransport::print();}
};
class Trip
{
    private:
        unsigned const int no;
        static unsigned int lastNo;
        unsigned int travellers;
        Hotel *hotel;
        Transport *transportOutward;
        Transpoert *transportBack;
        Trip *next;

    public:
        Trip(unsigned int t,Hotel *h,Transport *outward,Transport *Back ,Trip *n=nullptr)
          {
           travellers=t;
           hotel=h;
           transportOutward=outward;
           transportBack=Back;
           next=n;
           no=lastNo;
           ++lastNo;
          }
          virtual ~Trip()
          {
              hotel->~Hotal();
              transportOutward->~Transport();
              transportBack->Transport();
              cout<<"Trip done"<<endl;
          }
          int get_no()
          {
            return no;
          }
          Trip* get_next()
          {
            return next;
          }
          void set_next(Trip *nexttrip)
          {
               next=nexttrip;
          }
          double get_price(){

          return (Hotal::get_price() +transportOutward->get_price()+transportBack->get_price()) ;
          }
          void print()
          cout<<"trip inquiry"<<get_no()<<"for"<<travellers<<"person(s)"<<"check-in:\n"<<"hotel\n"<< <<hotel->Hotel::print()
              <<"outward journey:"<<transportOutward->Transport::print();
              <<"journey back:\n"<<transportBack->Transport::print()<<"price:\n"<<get_price()<<endl;
};

unsigned int Trip::lastNo=0;
class TravelAgency
{
    private:
      Trip *trips;
    public:
       TravelAgency(Trip *tr=nullptr){
       trips=tr;
       }
       void add(Trip *a){
        if(trips==nullptr)
        {
          a->set_next(nullptr);
          trips=a;
        }
        else
        {
          a->set_next(trips);
          trips = a;
        }

        void remove(Trip *r);
        {
          Trip *r=trips;
          Trip *temp;
          cout<<"delete:"
          while(r!=nullptr)
         {
           temp=r->set_next();
           delete(r);
           r=temp;
         }
        }
   Trip* searchtrip(unsigned int n)
   {
       while(trips!=nullptr)
        {
        if(trips->get_no())==n)
        {
         return trips;
        }
        else
        {
          Trips *t=new Trips;
           t->set_next(trips);
            while(t!=nullptr)
            {
              if(t->get_no()==n)
                {
                 return t;
                }
               else
                {
                  t=t->set_next();
                }
            }
        }
        break;
        }
    }
   void printAllTrips()
   {
      Trip* t=trips;
      while(t!=nullptr)
        {
            t->print();
            t=t->get_next();
        }
};

int main()
{
    TravelAgency Travel;
    Tain *Ptr= nullptr ;
    SelfOrganised *self;
    Hotel ho;
    Flight *fl;
    int choice,t;
    string namehotel,Code,From,To;
    Date arrive,Departure ;
    int Nights,Singles,Doubles;
    char b,y,n,de;
    double pricesingle;
    double priceddouble;
    bool park;
    double priceOne ;
    bool firstC ,trans;
    Board B;

    while(1)
    {
        cout<<"HOTLINE TRAVEL AGENCY"
            <<"0 end \n"<<"1 new trip\n "<<"2 search trip\n"<< "3 show all trip offers\n";
        cout<<"your choice is:"<<endl;
        cin>>choice;
         switch(choice)
         {
             case 0:
                 break;
             case 1:

                cout<<"name of hotel:"
                cin>>namehotel;
                cout<<"arrival on" ;
                cin>>arr;
                cout<<"how many nights: \n";
                cin >>Nights;
                cout<<"how many single bed rooms : \n";
                cin>>Singles;
                cout<<"how many double bed rooms: " <<endl;
                cin>>Doubles;
                cout<<"a all inclusive"
                    <<"b breakfast\n"
                    <<"h half board\n"
                    <<"w without meals\n"<<endl;
                cin >>B;
                cout<<B;
                cout<<"price one night in single bed room:\n";
                cin>>pricesingle;
                cout<<"price one night in double bed room:\n";
                cin>>pricedouble;
                cout<<"(with parking ";
                if(parking==ture)
                cout<<"enter y" ;
                cin>>y;
                else
                cout<<"enter n";
                cin>>n;


                cout<<"please choose transport for outward journey"
                    <<"0 self organised\n"
                    <<"1 by flight\n"
                    <<"2 by train\n"
                    <<"your choice:"<<endl;
                cin >>t;
                if(!t)
                {
                Ptr = new SelfOrganized();
                }
                else if (t==1)
                {
                    fl = new Flight(date Departure,string Code,string From,string To,double priceOne,bool firstC,bool trans=true);
                }
                else if (t==2)
                {
                    Ptr = new Train(date Departure,string Code,string From,string To,double priceOne,bool firstC);
                }
                cout<<"code of train"
                cin >>Code;
                cout<<"main train station of departure:\n";
                cin >>From;
                    <<"main train station of arrival:\n";
                cin >>To;
                cout<<"price for one passenger:"<<priceOne<<endl;

                cout<<"please choose transport for journey back\n"
                    <<"0 self organised\n"
                    <<"1 by flight\n"
                    <<"2 by train\n"
                    <<"your choice:"<<endl;
                cin >>t;
                if(!t)
                {
                self = new SelfOrganized();
                }
                else if (t==1){
                    fl = new Flight(date Departure,string Code,string From,string To,double priceOne,bool firstC,bool trans=true);
                }
                else if (t==2){
                    Ptr = new Train(date Departure,string Code,string From,string To,double priceOne,bool firstC);
                }
                cout<<"code of train"
                cin >>Code;
                cout<<"main train station of departure:\n"
                cin>>From;
                cout<<"main train station of arrival:\n";
                cin>>To;
                cout<<"price for one passenger:"<<priceOne<<endl;

             ho=new Hotel(string namehotel,Date arrive,int Nights,int Singles,int Doubles,double pricesingle,double priceddouble,bool park);
             break;
             case 2:
                 Travel.searchtrip()
             case 3:
                Travel.printAllTrips();
                cout<<"(d)elete or (n)ot:"endl;
                cin>>de;
                switch(de)
                {
                  case d:
                        Travel.~Trip();
                    break;
                  case n:
                    break;
               }

            }
    }
    return 0;
}
