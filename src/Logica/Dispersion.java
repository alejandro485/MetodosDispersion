package Logica;

public class Dispersion {
	
	public String midSquare(int numero, int bits){
		int d=numero*numero;
		if(bits<2){
			return "No se puede operar";
		}
		String bin=Integer.toBinaryString(d);
		int l1=((bin.length()-bits+1)/2);
		int l2=((bin.length()+bits+1)/2);
		bin=bin.substring(l1, l2);
		return Integer.parseInt(bin, 2)+"";
	}
	
	public String division(int numero, int primo){
		if(isPrimo(primo)){
			return (numero%primo)+"";
		}
		else{
			return "No se puede operar";
		}
	}
	
	public String tLlaves(int numero, int primo, int arreglo){
		if(isPrimo(arreglo)){
			if(primo>2){
				String cam=Integer.toString(numero, primo);
				String bin="";
				for(int i=0;i<cam.length();i++){
					bin+=Integer.toBinaryString(Integer.parseInt(cam.charAt(i)+"", primo));
				}
				int i=Integer.parseInt(bin,2);
				return (i%arreglo)+"";
			}
			return "La base debe ser mayor a 2";
		}
		return "El arreglo debe de ser primo";
	}
	
	public String plegamiento(int numero, int separacion){
		String bin=Integer.toBinaryString(numero);
		String sum="";
		for(int i=0; i<separacion;i++){
			sum+="0";
		}
		String ayuda="";
		while(bin.length()>=separacion){
			ayuda=bin.substring(bin.length()-separacion, bin.length());
			sum=suma(sum, ayuda);
			bin=bin.substring(0, bin.length()-separacion);
		}
		for(int i=bin.length(); i<separacion;i++){
			bin="0"+bin;
		}
		sum=suma(sum, bin);
		return Integer.parseInt(sum,2)+"";
	}
	
	private boolean isPrimo(int num){
		int raiz=(int)Math.sqrt(num);
		for(int i=2;i<=raiz;i++){
			if(num%i==0){
				return false;
			}
		}
		return true;
	}
	
	private String suma(String v1, String v2){
		String suma="";
		for(int i=0;i<v1.length();i++){
			if(v1.charAt(i)!=v2.charAt(i)){
				suma+="1";
			}
			else{
				suma+="0";
			}
		}
		return suma;
	}
	
}
