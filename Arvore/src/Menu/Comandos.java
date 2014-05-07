package Menu;

public enum Comandos {
	ADICIONAR("adicionar"),
	REGISTRAR("registrar"),
	POSFIXA("posfixa"),
	INFIXA("infixa"),
	PREFIXA("prefixa"),
	ALTURA("altura"),
	SAIR("sair");
	
	String opc;
	
	Comandos(String opc){
		this.opc = opc;
	}

	public String getOpc() {
		return opc;
	}

	public void setOpc(String opc) {
		this.opc = opc;
	}
	
	
	
}
