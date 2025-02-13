
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Cadastro {   // v�rios contatos(quantidade, lista)
	private List<Contato> contatos;        //  array de contato      
	private static BufferedReader br;
	
	public Cadastro () { // construtor cadastro
		this.contatos = new ArrayList<>();     //cria Lista de contatos
		this.recuperaContatos();
	}
	public void recuperaContatos() {//pega lista de nome do arquivo cria
		//cada contato e coloca na lista contato
		this.contatos = new ArrayList<>();
		try {
			List<String>dados = this.lerLinhasDeArquivo();
			
			/*for(String s : dados) {
				Contato c =  new Contato(s);
				this.contatos.add(c);
			}*/
			
			for (String linha : dados) {
				String[] dadosLinha = linha.split("#");
				Contato c = new Contato(dadosLinha[0], dadosLinha[1], dadosLinha[2], dadosLinha[3], dadosLinha[4],
						dadosLinha[5], dadosLinha[6], dadosLinha[7], dadosLinha[8], dadosLinha[9]);
				this.contatos.add(c);
			}
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public boolean cadastraContato(Contato c) { //cadastro
		if(this.pesquisaContato(c.getNome())==null) {//se pesquisa contato passando o nome for igual nulo
			this.contatos.add(c);                    //se n�o tiver o nome adicione e retorne true 
			return true;
		} else {
			return false;
		}
		
	}
	public Contato pesquisaContato(String nomeContato) { //pesquisa
		for (int k=0; k<this.contatos.size(); k++) { // varre os n�meros de elementos
			Contato c = this.contatos.get(k);
			if(c.getNome().equalsIgnoreCase(nomeContato)) {
				return c;
			}
		}
		return null;
		
	} 
	
	public List<String> lerLinhasDeArquivo() throws IOException {
		List<String> linhasLidas = new ArrayList<String>();
		try {
			FileInputStream criadorDeArquivos = new FileInputStream("arquivo.txt");
			InputStreamReader input = new InputStreamReader(criadorDeArquivos);
			br = new BufferedReader(input);
			
			String linha;
			
			do {
				linha = br.readLine();
				if(linha == null) {
					
					
					
				}else {
					linhasLidas.add(linha);
					//System.out.println(linha);//se tiver nome
				}
			}while (linha!=null);
			
		}finally {
			if (br != null) {
				br.close();
			}
		}
		return linhasLidas;
	}
		
	public void salvarDados()  throws IOException{
		List<String> dadosContatos = new LinkedList<String>();
		for(Contato c:this.contatos) {
			//dadosContatos.add(c.getNome());
			String linha = c.getNome() + "#" + c.getTelefone() + "#" + c.getCpf() + "#" + c.getCep() + "#"
					+ c.getLogradouro() + "#" + c.getNumero() + "#" + c.getBairro() + "#" + c.getSenha() + "#"
					+ c.getDataNascimento() + "#" + c.getDataInstalacao();
	
			dadosContatos.add(linha);
		}
		gravarTexto(dadosContatos);
	}

	
	                 // nome m�todo         nome do arquivo        texto
	public void gravarTexto(List<String> pTextoAEscrever) throws IOException {
		BufferedWriter escritor = null;
		try {						
				FileWriter criadorDeArquivos = new FileWriter("arquivo.txt");//
				escritor = new BufferedWriter(criadorDeArquivos);
				for(String s:pTextoAEscrever ) {
					escritor.write(s+"\n");					
				}		
		}
		finally {
			if(escritor != null) {
				escritor.close();
			}
		}
	
	}
	
}
