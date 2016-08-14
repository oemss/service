
namespace java me.eax.examples.thrift.game

struct rt {
    1: string id
    2: string name
}


typedef list<rt> seq
typedef map<rt,list<rt>> tagRec

struct other {
    1: tagRec tagRecMap
    2: seq recTag
}


service MyServ {
  
    void add(1: string idR,2: string idT)

    void delete(1: string idR,2: string idT)

    void listT(1: string idR)

    void listR(1: list<string> lstT)

    void put(1: i16 where)
	
}



