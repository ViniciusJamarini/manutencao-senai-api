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

@Component
public class TelaCadastroDeTipo extends JFrame {

	private JPanel contentPane;
	private JTextField edtId;
	private JTextField edtDescricao;

	@Autowired
	private PecaService service;
	private JLabel lblQtde;
	private JTextField edtQtde;
	
	
	public TelaCadastroDeTipo() {
		setTitle("Cadastro de Tipo de Peca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 149);
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
				Peca novaPeca = new Peca();
				novaPeca.setDescricao(edtDescricao.getText());
				novaPeca.setQtdeEmEstoque(Integer.parseInt(edtQtde.getText()));
				Peca pecaSalva = service.inserir(novaPeca);
				edtId.setText(pecaSalva.getId().toString());
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}
			
			}
		});
		
		lblQtde = new JLabel("Qtde");
		
		edtQtde = new JTextField();
		edtQtde.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(edtId, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(edtDescricao, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(edtQtde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblId)
							.addGap(36)
							.addComponent(lblNewLabel)
							.addGap(50)
							.addComponent(lblQtde))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(331, Short.MAX_VALUE)
							.addComponent(btnSalvar)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(lblNewLabel)
						.addComponent(lblQtde))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(edtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(edtDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(edtQtde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
					.addComponent(btnSalvar)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}