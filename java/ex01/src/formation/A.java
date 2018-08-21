package formation;

public class A {
	static int idUnique =0;
	public int idLocal;
	public A(){
		this.idLocal = A.idUnique;
		A.idUnique ++;
	}
    public String getInfo(){
        return("coucou");
    }
    public int getId() {
    	return this.idLocal;
    }
}
