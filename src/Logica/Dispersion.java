package Logica;

public class Dispersion {
	
	public String midSquare(int numero, int bits){
		int d=numero*numero;
		if(bits<2){
			return "No se puede operar";
		}
		String bin=Integer.toBinaryString(d);
		if(bin.length()<bits){
			return "No se puede operar";
		}
		int l1=((bin.length()-bits+1)/2);
		int l2=((bin.length()+bits+1)/2);
		bin=bin.substring(l1, l2);
		return Integer.parseInt(bin, 2)+"";
	}
	
	public String division(int numero, int primo){
		if(primo>1 || isPrimo(primo)){
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
		if(separacion<8){
			String bin=Integer.toBinaryString(numero);
			System.out.println(bin);
			String sum="";
			for(int i=0; i<separacion;i++){
				sum+="0";
			}
			System.out.println("Suma inicial: "+sum);
			String ayuda="";
			while(bin.length()>=separacion){
				ayuda=bin.substring(bin.length()-separacion, bin.length());
				System.out.println("Valor a sumar: "+ayuda);
				sum=suma(sum, ayuda);
				System.out.println("Suma actual: "+sum);
				bin=bin.substring(0, bin.length()-separacion);
			}
			for(int i=bin.length(); i<separacion;i++){
				bin="0"+bin;
			}
			System.out.println("Valor a sumar: "+bin);
			sum=suma(sum, bin);
			System.out.println("Suma final: "+sum);
			return Integer.parseInt(sum,2)+"";
		}
		return "Digite una separacion menor";
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
