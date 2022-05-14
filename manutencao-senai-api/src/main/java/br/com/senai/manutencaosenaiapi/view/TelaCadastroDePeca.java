package br.com.senai.manutencaosenaiapi.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.manutencaosenaiapi.entity.Peca;
import br.com.senai.manutencaosenaiapi.service.PecaService;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.SystemColor;

@Component
public class TelaCadastroDePeca extends JFrame {

	private JPanel contentPane;
	private JTextField edtId;
	private JTextField edtDescricao;
	private JLabel lblEspecificacoes;
	private JTextArea jtaEspecificacoes;

	@Autowired
	private PecaService service;
	private JLabel lblQtde;
	private JTextField edtQtde;

	public TelaCadastroDePeca() {
		setBackground(SystemColor.inactiveCaptionBorder);
		setTitle("Cadastro de Peça");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblId = new JLabel("ID");

		edtId = new JTextField();
		edtId.setEditable(false);
		edtId.setBackground(new Color(255, 255, 255));
		edtId.setColumns(10);

		JLabel lblNewLabel = new JLabel("Descrição");

		edtDescricao = new JTextField();
		edtDescricao.setColumns(10);

		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(edtId.getText() != null && edtId.getText().length() > 0) {
						Peca pecaSalva = new Peca();
						pecaSalva.setDescricao(edtDescricao.getText());
						pecaSalva.setQtdeEmEstoque(Integer.parseInt(edtQtde.getText()));
						pecaSalva.setEspecificacao(jtaEspecificacoes.getText());
						pecaSalva.setId(Integer.parseInt(edtId.getText()));
						service.alterar(pecaSalva);
						JOptionPane.showMessageDialog(contentPane, "Peça alterada com sucesso");
						
					}else {
					Peca novaPeca = new Peca();
					novaPeca.setDescricao(edtDescricao.getText());
					novaPeca.setQtdeEmEstoque(Integer.parseInt(edtQtde.getText()));
					novaPeca.setEspecificacao(jtaEspecificacoes.getText());
					Peca pecaSalva = service.inserir(novaPeca);
					edtId.setText(pecaSalva.getId().toString());
					JOptionPane.showMessageDialog(contentPane, "Peça Inserida com sucesso");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}

			}
		});

		lblQtde = new JLabel("Qtde");

		edtQtde = new JTextField();
		edtQtde.setColumns(10);

		lblEspecificacoes = new JLabel("Especificações");

		jtaEspecificacoes = new JTextArea();

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(331, Short.MAX_VALUE)
								.addComponent(btnSalvar))
						.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblId).addGap(36)
										.addComponent(lblNewLabel))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(edtId, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(edtDescricao, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(edtQtde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblQtde)))
						.addComponent(lblEspecificacoes)
						.addComponent(jtaEspecificacoes, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblId).addComponent(lblNewLabel))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(edtId, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(edtDescricao, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblQtde)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(edtQtde,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblEspecificacoes)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jtaEspecificacoes, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE).addGap(18)
						.addComponent(btnSalvar).addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}

	public void colocarEmEdicao(Peca pecaSalva) {
		edtId.setText(pecaSalva.getId().toString());
		edtDescricao.setText(pecaSalva.getDescricao());
		jtaEspecificacoes.setText(pecaSalva.getEspecificacao());
		edtQtde.setText(pecaSalva.getQtdeEmEstoque().toString());
	}
}
