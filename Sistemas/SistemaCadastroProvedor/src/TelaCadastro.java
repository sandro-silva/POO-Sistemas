
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;


public class TelaCadastro extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cadastro sisCadastro ;
	
	JMenuBar menuBar = new JMenuBar(); //barra menu 
	JMenu arquivo = new JMenu("Arquivo");
	JMenuItem menuSalvar = new JMenuItem("Salvar");
	
	JLabel txCodigo= new JLabel("C�digo");	
	JLabel txNome = new JLabel("Nome:");// texto
	JLabel txTelefone =new JLabel("Telefone de Contato:");// texto
	JLabel txCpf =new JLabel("CPF:");
	JLabel txCep =new JLabel("Cep:");
	JLabel txRua =new JLabel("Rua:");
	JLabel txNumero =new JLabel("N�mero:");
	JLabel txBairro =new JLabel("Bairro:");
	JLabel txSenha =new JLabel("Senha Wi-fi:");
	JLabel txDataNascimento =new JLabel("Data de Nascimento:");
	JLabel txDataInstalacao =new JLabel("Data de Instala��o:");
	
	JTextField cxCodigo = new JTextField();
	JTextField cxNome = new JTextField(); //caixa de texto
	JFormattedTextField cxTelefone = new JFormattedTextField();
	JFormattedTextField cxCpf = new JFormattedTextField();
	JFormattedTextField cxCep = new JFormattedTextField();	
	JTextField cxRua = new JTextField();
	JFormattedTextField cxNumero = new JFormattedTextField();
	JTextField cxBairro = new JTextField();
	JTextField cxSenha = new JTextField();
	JFormattedTextField cxDataNascimento = new JFormattedTextField();
	JFormattedTextField cxDataInstalacao = new JFormattedTextField();
	
	JButton botaoCadastrar = new JButton("Adicionar Novo "); // nome no bot�o (ok)
	
	JButton botaoNovo = new JButton("Guardar");
	
	JPanel panel = new JPanel();
	
	public TelaCadastro  (Cadastro sisCadastro) { // menu ou caixa  construtor
		setTitle("cadastro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//fecha s� a janela atual
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fecha tudo
		//setBounds(50,300,600,630);//posi��o, (size)tamanho(largura , altura); da janela
		setSize(610,450);//s� tamanho
		setLocation(350,150);//s� posi��o da janela
		//setLocationRelativeTo(null);//centralizar posi��o da janela
		
		this.sisCadastro =  sisCadastro;
		//----------------------------------------------------
		getContentPane().setLayout(new BorderLayout(0, 0));//borderLayoutborderLayout
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);//JTabbedPane
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		
		//------------------abas-Dados Pessoais---------------------------------		
		
		tabbedPane.addTab("Dados Pessoais", null, panel, null);// abas
		panel.setLayout(null); //deixa solto cx texto
		//----------------------------------------------------
		
		//               ED  SD  TH  TV	
		txCodigo.setBounds(80, 30,146, 14);// "Digite seu nome"
		panel.add(txCodigo);
		cxCodigo.setBounds(70,50,100,23);//tamanho e posi��o caixa de texto 
		panel.add(cxCodigo);
		
		txNome.setBounds(195, 30,146, 14);// "Digite seu nome"
		panel.add(txNome);// faz aparecer o texto aacima da caixa de texto
		cxNome.setBounds(190,50,330,23);//tamanho e posi��o caixa de texto 
		panel.add(cxNome);
		
		txTelefone.setBounds(80,80,146, 14);//Digite nome a consultar
		panel.add(txTelefone);
		cxTelefone.setBounds(70,100,200,23);//tamanho e posi��o caixa de texto 
		panel.add(cxTelefone);
		
		txCpf.setBounds(330,80,146, 14);//Digite nome a consultar
		panel.add(txCpf);	
		cxCpf.setBounds(320,100,200,23);
		panel.add(cxCpf);
		
		txCep.setBounds(80,130,146, 14);
		panel.add(txCep);
		cxCep.setBounds(70,150,120,23);
		panel.add(cxCep);
		
		txRua.setBounds(80,180,146, 14);//Digite nome a consultar
		panel.add(txRua);
		cxRua.setBounds(70,200,350,23);
		panel.add(cxRua);
		
		txNumero.setBounds(440,180,146,14);//Digite nome a consultar
		panel.add(txNumero);
		cxNumero.setBounds(430,200,90,23);//tamanho e posi��o caixa de texto 
		panel.add(cxNumero);
		
		txBairro.setBounds(80,230,140, 14);//Digite nome a consultar
		panel.add(txBairro);
		cxBairro.setBounds(70,250,165,23);
		panel.add(cxBairro);
		
		txSenha.setBounds(410,130,146,14);//Digite nome a consultar
		panel.add(txSenha);
		cxSenha.setBounds(370,150,150,23);//tamanho e posi��o caixa de texto 
		panel.add(cxSenha);

		txDataNascimento.setBounds(280,230,146, 14);//Digite nome a consultar
		panel.add(txDataNascimento);
		cxDataNascimento.setBounds(270,250,110,23);
		panel.add(cxDataNascimento);
		
		txDataInstalacao.setBounds(410,230,146, 14);//Digite nome a consultar
		panel.add(txDataInstalacao);
		cxDataInstalacao.setBounds(410,250,110,23);
		panel.add(cxDataInstalacao);

		

		botaoCadastrar.setBounds(385,300, 130, 23);//
		panel.add(botaoCadastrar);
		botaoCadastrar.addActionListener(this);
				
		
		menuBar.add(arquivo);         //aparece na barra
		setJMenuBar(menuBar);
		arquivo.add(menuSalvar);
		menuSalvar.addActionListener(new ActionListener() {
		
			
			
			public void actionPerformed(ActionEvent e) {
				try {
					sisCadastro.salvarDados();
					JOptionPane.showMessageDialog(null,"dados salvo com sucesso");
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null,"problema ao salvar dados");
					e1.printStackTrace();
				}
			}
		});
		botaoNovo.setBounds(75,299,90,23);//cria bot�o pesquisar
		panel.add(botaoNovo);
		botaoNovo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					sisCadastro.salvarDados();
					JOptionPane.showMessageDialog(null,"dados salvo com sucesso");
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null,"problema ao salvar dados");
					e1.printStackTrace();
				}
				cxNome.requestFocus();
			}
			
		});
		
		
		
		
//---------------------------m�todo para m�scara----------------------------------	
	formatarCampo(cxCep);	//dentro do construtor	
	
	}
	@SuppressWarnings("unused")//fora do construtor
	private void formatarCampo(JFormattedTextField cxCep) {
		try {
			MaskFormatter maskCep = new MaskFormatter("         #####-###");
			maskCep.install(cxCep);
			
			MaskFormatter maskTelefone = new MaskFormatter("  (##) ####-####");
			maskTelefone.install(cxTelefone);
			
			MaskFormatter maskCpf = new MaskFormatter("              ###.###.###-##");
			maskCpf.install(cxCpf);
			
			MaskFormatter maskNumero = new MaskFormatter("       #####");
			maskNumero.install(cxNumero);
			
			MaskFormatter maskDataInstalacao = new MaskFormatter("      ##-##-####");
			maskDataInstalacao.install(cxDataInstalacao);
			
			MaskFormatter maskDataNascimento = new MaskFormatter("      ##-##-####");
			maskDataNascimento.install(cxDataNascimento);
					
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//-------------------------------------------------------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {
				
		Contato contato = new Contato(cxNome.getText());//contato
		contato.setTelefone(cxTelefone.getText());
		contato.setCpf(cxCpf.getText()); 
		contato.setCep(cxCep.getText());
		contato.setLogradouro(cxRua.getText());
		contato.setNumero(cxNumero.getText());
		contato.setBairro(cxBairro.getText());
		contato.setSenha(cxSenha.getText());
		contato.setDataNascimento(cxDataNascimento.getText());
		contato.setDataInstalacao(cxDataInstalacao.getText());
		
		boolean cadastrou = this.sisCadastro.cadastraContato(contato);//cadastro
		if (cadastrou == true) { 
			JOptionPane.showMessageDialog(null,"Foi adicionado " + contato.getNome());
			
		}else {
			JOptionPane.showMessageDialog(null, contato.getNome()+" J� Existe");
		}
		cxNome.setText("");//limpa caixa
		cxTelefone.setText("");
		cxCpf.setText("");
		cxCep.setText("");
		cxRua.setText("");
		cxNumero.setText("");
		cxBairro.setText("");
		cxSenha.setText("");
		cxDataNascimento.setText("");
		cxDataInstalacao.setText("");
		
		cxNome.requestFocus();
	}
	

}

