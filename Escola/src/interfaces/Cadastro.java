package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import contas.Aluno;
import implemento.Implementacao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;

public class Cadastro {

	private Implementacao imp;
	private Aluno aluno;

	private JFrame frame;

	private JTextField cmpID;
	private JTextField cmpNome;
	private JFormattedTextField cmpNascimento;
	private JTextField cmpEndereco;
	private JTextField cmpN;
	private JTextField cmpEmail;
	private JFormattedTextField cmpTelefone;
	private JFormattedTextField cmpCPF;
	private JTable table;

	Object[] options = {"Sim" , "Não"};

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					Cadastro window = new Cadastro();
					window.frame.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});

	}

	public Cadastro() {

		initialize();
		listarUsuarios();

	}

	private void initialize() {

		imp = new Implementacao();
		aluno = new Aluno();

		frame = new JFrame("CADASTRO DE ALUNOS");
		frame.setBounds(500, 200, 485, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//***********************************************

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(59, 15, 16, 14);
		frame.getContentPane().add(lblNewLabel_1);

		cmpID = new JTextField();
		cmpID.setEditable(false);
		cmpID.setBounds(85, 12, 34, 20);
		frame.getContentPane().add(cmpID);
		cmpID.setColumns(10);

		//***********************************************

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(20, 58, 55, 14);
		frame.getContentPane().add(lblNewLabel);

		cmpNome = new JTextField();
		cmpNome.setBounds(85, 55, 236, 20);
		frame.getContentPane().add(cmpNome);
		cmpNome.setColumns(10);

		//***********************************************

		JLabel lblNewLabel_7 = new JLabel("Nascimento");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setBounds(0, 91, 75, 14);
		frame.getContentPane().add(lblNewLabel_7);

		try {

			cmpNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));

		} catch (ParseException e2) {

			e2.printStackTrace();

		}

		cmpNascimento.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {}});

		cmpNascimento.setBounds(85, 88, 93, 20);
		frame.getContentPane().add(cmpNascimento);
		cmpNascimento.setColumns(10);

		//***********************************************

		JLabel lblNewLabel_8 = new JLabel("Sexo");
		lblNewLabel_8.setBounds(195, 91, 34, 14);
		frame.getContentPane().add(lblNewLabel_8);

		JComboBox cmpSexo = new JComboBox();
		cmpSexo.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Masculino", "Feminino", "Outro"}));
		cmpSexo.setBounds(229, 88, 92, 22);
		frame.getContentPane().add(cmpSexo);


		//***********************************************

		JLabel lblNewLabel_2 = new JLabel("Endere\u00E7o");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(20, 126, 55, 14);
		frame.getContentPane().add(lblNewLabel_2);

		cmpEndereco = new JTextField();
		cmpEndereco.setBounds(85, 123, 156, 20);
		frame.getContentPane().add(cmpEndereco);
		cmpEndereco.setColumns(10);

		//***********************************************

		JLabel lblNewLabel_5 = new JLabel("N\u00BA");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(251, 126, 16, 14);
		frame.getContentPane().add(lblNewLabel_5);

		cmpN = new JTextField();
		cmpN.setBounds(277, 123, 44, 20);
		frame.getContentPane().add(cmpN);
		cmpN.setColumns(10);

		//***********************************************

		JLabel lblNewLabel_3 = new JLabel("E-mail");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(20, 161, 55, 14);
		frame.getContentPane().add(lblNewLabel_3);

		cmpEmail = new JTextField();
		cmpEmail.setBounds(85, 158, 236, 20);
		frame.getContentPane().add(cmpEmail);
		cmpEmail.setColumns(10);

		//***********************************************

		JLabel lblNewLabel_4 = new JLabel("Telefone");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(20, 195, 55, 14);
		frame.getContentPane().add(lblNewLabel_4);

		try {

			cmpTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));

		} catch (ParseException e1) {

			e1.printStackTrace();

		}

		cmpTelefone.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {}});

		cmpTelefone.setBounds(85, 192, 107, 20);
		frame.getContentPane().add(cmpTelefone);
		cmpTelefone.setColumns(10);

		//***********************************************

		JLabel lblNewLabel_6 = new JLabel("CPF");
		lblNewLabel_6.setBounds(202, 195, 27, 14);
		frame.getContentPane().add(lblNewLabel_6);

		try {

			cmpCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));

		} catch (ParseException e1) {

			e1.printStackTrace();

		}

		cmpCPF.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {}});

		cmpCPF.setBounds(228, 192, 93, 20);
		frame.getContentPane().add(cmpCPF);
		cmpCPF.setColumns(10);

		//***********************************************

		JButton btnLimpar = new JButton("Limpar campos");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cmpSexo.setSelectedIndex(0);
				limpar();

			}

		});

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadastrar.setIcon(new ImageIcon(Cadastro.class.getResource("/img/Adicionar.png")));
		btnCadastrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {	

					if(verificar() == false) {

						return;

					}else {

						if(cmpSexo.getSelectedItem().equals("Selecione")) {

							JOptionPane.showMessageDialog(null, "Selecione o sexo do aluno");
							return;

						}else {

							int n = JOptionPane.showOptionDialog(frame,"Tem certeza que deseja cadastrar ?","Confirmação de Cadastro",
									JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

							if(n==0) {

								setarInfo();

								if(cmpSexo.getSelectedItem().equals("Masculino")){

									aluno.setSexo("M");

								}else if(cmpSexo.getSelectedItem().equals("Feminino")){

									aluno.setSexo("F");

								}else if(cmpSexo.getSelectedItem().equals("Outro")){

									aluno.setSexo("O");

								}

								imp.cadastrar(aluno);
								limpar();
								cmpSexo.setSelectedIndex(0);
								listarUsuarios();

								JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");				

							}

						}	

					}

				}catch(Exception a) {

					JOptionPane.showMessageDialog(null, "Erro : " + a.toString());

				}


			}

		});

		//**********************************************************************************************

		JButton btnEditar = new JButton("Editar");
		btnEditar.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditar.setIcon(new ImageIcon(Cadastro.class.getResource("/img/Editar.png")));
		btnEditar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {

					if(cmpID.getText().isEmpty()) {

						JOptionPane.showMessageDialog(null, "Você não selecionou um aluno da lista!");

					}else if(verificar() == false) {

						return;

					}else {

						if(cmpSexo.getSelectedItem().equals("Selecione")) {

							JOptionPane.showMessageDialog(null, "Selecione o sexo do aluno");
							return;

						}else {

							int n = JOptionPane.showOptionDialog(frame,"Deseja alterar as informações do ID : " + cmpID.getText() + " ?","Confirmação de Edição",
									JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

							if(n == 0) {

								setarInfo();

								if(cmpSexo.getSelectedItem().equals("Masculino")){

									aluno.setSexo("M");

								}else if(cmpSexo.getSelectedItem().equals("Feminino")){

									aluno.setSexo("F");

								}else if(cmpSexo.getSelectedItem().equals("Outro")){

									aluno.setSexo("O");

								}

								imp.alterar(aluno);
								limpar();
								cmpSexo.setSelectedIndex(0);
								listarUsuarios();

								JOptionPane.showMessageDialog(null, "Dados do ID : " + cmpID.getText() + " foram editados com Sucesso");					

							}

						}

					}

				}catch(Exception a) {

					JOptionPane.showMessageDialog(null, "Erro" + a.toString());

				}

			}

		});

		//**********************************************************************************************

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setHorizontalAlignment(SwingConstants.LEFT);
		btnDeletar.setIcon(new ImageIcon(Cadastro.class.getResource("/img/Excluir.png")));
		btnDeletar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if(cmpID.getText().isEmpty()) {

					JOptionPane.showMessageDialog(null, "Você não selecionou um aluno da lista!");

				}else {

					int n = JOptionPane.showOptionDialog(frame,"Deseja deletar as informações do ID : " + cmpID.getText() + " ?","Confirmação para Deletar Dados",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

					if(n==0) {

						imp.remover(Long.parseLong(cmpID.getText()));
						
						listarUsuarios();
						JOptionPane.showMessageDialog(null,"Os dados do ID : " + cmpID.getText() + " foram deletados com Sucesso!");			

					}

					limpar();
					cmpSexo.setSelectedIndex(0);

				}

			}

		});

		//**********************************************************************************************

		JButton btnSair = new JButton("Sair");
		btnSair.setHorizontalAlignment(SwingConstants.LEFT);
		btnSair.setIcon(new ImageIcon(Cadastro.class.getResource("/img/Sair.png")));
		btnSair.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int n = JOptionPane.showOptionDialog(frame,"Tem certeza que deseja sair ?","Confirmação",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

				if(n==0) {

					System.exit(0);

				}

			}

		});

		//**********************************************************************************************

		btnLimpar.setBounds(331, 10, 123, 23);
		frame.getContentPane().add(btnLimpar);

		btnCadastrar.setBounds(331, 53, 123, 23);
		frame.getContentPane().add(btnCadastrar);

		btnEditar.setBounds(331, 87, 123, 23);
		frame.getContentPane().add(btnEditar);


		btnDeletar.setBounds(331, 122, 123, 23);
		frame.getContentPane().add(btnDeletar);

		btnSair.setBounds(331, 156, 123, 23);
		frame.getContentPane().add(btnSair);

		//***********************************************

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 236, 444, 147);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				int chamar = table.getSelectedRow();

				aluno = imp.getLista().get(chamar);

				cmpID.setText(String.valueOf(aluno.getId()));
				cmpNome.setText(aluno.getNome());
				cmpNascimento.setText(aluno.getNascimento());
				cmpEndereco.setText(aluno.getEndereco());
				cmpN.setText(String.valueOf(aluno.getN()));
				cmpEmail.setText(aluno.getEmail());
				cmpTelefone.setText(aluno.getTelefone());
				cmpCPF.setText(aluno.getCpf());

				switch (aluno.getSexo()){

				case "M": cmpSexo.setSelectedIndex(1);
				break;

				case "F": cmpSexo.setSelectedIndex(2);
				break;

				case "O": cmpSexo.setSelectedIndex(3);
				break;

				default: return;

				}

			}

		});

		table.setModel(new DefaultTableModel(

				new Object[][] {

					{null, null, null, null},

				},

				new String[] {

						"ID", "Nome", "Sexo", "CPF"

				}

				));

		table.getColumnModel().getColumn(0).setPreferredWidth(35);
		table.getColumnModel().getColumn(0).setMaxWidth(35);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(1).setMaxWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(2).setMaxWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setMaxWidth(120);

		scrollPane.setViewportView(table);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(0, 46, 469, 1);
		frame.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(0, 224, 469, 1);
		frame.getContentPane().add(separator_1);

		//***********************************************

	}

	private void listarUsuarios(){

		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);

		try {

			for(Aluno a: imp.getLista()) {

				modelo.addRow(new Object[] {

						a.getId(),
						a.getNome(),
						a.getSexo(),
						a.getCpf()

				});

			}

		}catch(Exception e) {

			JOptionPane.showMessageDialog(null,"Erro ao listar" + e.toString());

		}

	}

	//**********************************************************************************************

	private boolean somenteLetras(String text) {

		return text.matches("[^\\d]+");

	}

	//***********************************************

	private void setarInfo() {

		aluno.setNome(cmpNome.getText());
		aluno.setNascimento(cmpNascimento.getText());
		aluno.setEndereco(cmpEndereco.getText());
		aluno.setN(Integer.parseInt(cmpN.getText()));;
		aluno.setEmail(cmpEmail.getText());
		aluno.setEmail(cmpEmail.getText());
		aluno.setTelefone(cmpTelefone.getText());
		aluno.setCpf(cmpCPF.getText());

	}

	//***********************************************

	private void limpar(){

		cmpID.setText("");
		cmpNome.setText("");
		cmpNascimento.setText("");
		cmpEndereco.setText("");
		cmpN.setText("");
		cmpEmail.setText("");
		cmpEndereco.setText("");
		cmpTelefone.setText("");
		cmpCPF.setText("");

	}

	//**********************************************************************************************

	private boolean verificar() {

		if(cmpNome.getText().isEmpty() || cmpEndereco.getText().isEmpty() || cmpN.getText().isEmpty() || cmpEmail.getText().isEmpty()) {

			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			return false;

		}else if(!somenteLetras(cmpNome.getText())) {

			JOptionPane.showMessageDialog(null, "Você não pode inserir números no nome!");
			return false;


		}else if(!somenteLetras(cmpEndereco.getText())) {

			JOptionPane.showMessageDialog(null, "Você não pode inserir números no Endereço!");
			return false;

		}else if(!cmpEmail.getText().contains("@")) {

			JOptionPane.showMessageDialog(null, "O E-mail que você digitou não é valido!");
			return false;

		}

		switch(cmpNascimento.getText()) {

		case "  /  /    " : JOptionPane.showMessageDialog(null, "Preencha corretamente o campo do Nascimento!");
		return false;

		}

		switch(cmpTelefone.getText()) {

		case "(  )      -    " : JOptionPane.showMessageDialog(null, "Preencha corretamente o campo do Telefone!") ;
		return false;

		}

		switch(cmpCPF.getText()) {

		case "   .   .   -  " : JOptionPane.showMessageDialog(null, "Preencha corretamente o campo do CPF!");
		return false;

		}

		if(!cmpN.getText().matches("-?\\d+")) {

			JOptionPane.showMessageDialog(null, "O N\u00BA da casa deve ser um numero inteiro" );
			return false;

		}

		return true;

	}

}