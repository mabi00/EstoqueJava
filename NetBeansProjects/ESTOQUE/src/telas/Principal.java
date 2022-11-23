/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import conexao.Banco;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author fabricio
 */
public class Principal extends javax.swing.JFrame {

  /**
   * Creates new form Principal
   */
  public Principal() {
    initComponents();
    btnCadastrar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String nome = txtNome.getText();
	String cor = txtCor.getText();
	String codigo = txtCodigo.getText();
	String lugarx = txtLugarx.getText();
	String lugary = txtLugary.getText();
	int quantidade = Integer.parseInt(txtQuantidade.getText());
        
        boolean cadastrado = cadastrarProduto(nome, cor, codigo, lugarx, lugary, quantidade);
        if (cadastrado) {
          JOptionPane.showMessageDialog(Principal.this, "erro");
        } else {
          JOptionPane.showMessageDialog(Principal.this, "Novo produto cadastrado");
        }
      }
    });
    
        btnExcluir.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String nome = txtNome.getText();
        
        boolean deletado = deletarProduto(nome);
        if (deletado) {
          JOptionPane.showMessageDialog(Principal.this, "erro");
        } else {
          JOptionPane.showMessageDialog(Principal.this, "Excluido com sucesso");
        }
      }
    });
        
         btnAlterar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String nome = txtNome.getText();
	String cor = txtCor.getText();
	String codigo = txtCodigo.getText();
	String lugarx = txtLugarx.getText();
	String lugary = txtLugary.getText();
	int quantidade = Integer.parseInt(txtQuantidade.getText());
        
        boolean alterado = modificarProduto(nome, cor, codigo, lugarx, lugary, quantidade);
        if (alterado) {
          JOptionPane.showMessageDialog(Principal.this, "erro");
        } else {
          JOptionPane.showMessageDialog(Principal.this, "Um produto existente foi alterado");
        }
      }
    });
         
             btnAtualizartabela.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
      try {
      Connection conexao = Banco.getConexao();
      String sql = "SELECT * FROM produtos";
      PreparedStatement ps = conexao.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();{
             tabela.setModel(DbUtils.resultSetToTableModel(rs));
        }
      } catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
       
      }
    });
  }
                 

private boolean cadastrarProduto(String nome, String cor, String codigo, String lugarx, String lugary, int quantidade) {
    try {
      // Cadastro de produto
      Connection conexao = Banco.getConexao();
      String sql = "INSERT INTO produtos (nome, cor, codigo, lugarx, lugary, quantidade) VALUES (?, ?, ?, ?, ?, ?)";
      PreparedStatement ps = conexao.prepareStatement(sql);
      ps.setString(1, nome);
      ps.setString(2, cor);
      ps.setString(3, codigo);
      ps.setString(4, lugarx);
      ps.setString(5, lugary);
      ps.setInt(6, quantidade);

    	int rowsInserted = ps.executeUpdate();
		if (rowsInserted > 0) {
		System.out.println("Novo produto cadastrado");
                }
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
                              return false;
		}
      return false;
}

private boolean deletarProduto(String nome) {
    try {
        // Excluir produto
         Connection conexao = Banco.getConexao();
                 String sql = "DELETE FROM produtos WHERE nome=?";
			
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, nome);
			
		int rowsDeleted = ps.executeUpdate();
                if (rowsDeleted > 0) {
		System.out.println("O produto foi excluido com sucesso");
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
                              return false;
		}
              return false;
	}

private boolean modificarProduto(String nome, String cor, String codigo, String lugarx, String lugary, int quantidade) {
    try {
      // alteração de produto existente
      Connection conexao = Banco.getConexao();
      String sql = "UPDATE produtos SET cor=?, codigo=?, lugarx=?, lugary=?, quantidade=? WHERE nome=?";
      PreparedStatement ps = conexao.prepareStatement(sql);
      ps.setString(6, nome);
      ps.setString(1, cor);
      ps.setString(2, codigo);
      ps.setString(3, lugarx);
      ps.setString(4, lugary);
      ps.setInt(5, quantidade);

    	int rowsInserted = ps.executeUpdate();
		if (rowsInserted > 0) {
		System.out.println("Um produto existente foi alterado");
                }
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
                              return false;
		}
      return false;
}

  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCadastrar = new javax.swing.JButton();
        btnAtualizartabela = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        janelaTabela = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        abas = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        galeria2122 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        galeria2324 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCor = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtQuantidade = new javax.swing.JTextField();
        txtLugarx = new javax.swing.JTextField();
        txtLugary = new javax.swing.JTextField();
        Nome = new javax.swing.JLabel();
        Cor = new javax.swing.JLabel();
        Codigo = new javax.swing.JLabel();
        Quantidade = new javax.swing.JLabel();
        ajudax = new javax.swing.JLabel();
        ajuday = new javax.swing.JLabel();
        lugarx1 = new javax.swing.JLabel();
        lugary1 = new javax.swing.JLabel();
        imagemFundoPrincipal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar);
        btnCadastrar.setBounds(20, 360, 130, 25);

        btnAtualizartabela.setText("Atualizar tabela");
        btnAtualizartabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizartabelaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizartabela);
        btnAtualizartabela.setBounds(20, 450, 270, 25);

        btnAlterar.setText("Alterar");
        getContentPane().add(btnAlterar);
        btnAlterar.setBounds(170, 360, 120, 25);

        btnExcluir.setText("Excluir");
        getContentPane().add(btnExcluir);
        btnExcluir.setBounds(20, 410, 270, 25);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "nome", "cor", "codigo", "lugarx", "lugary", "quantidade"
            }
        ));
        janelaTabela.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setHeaderValue("nome");
            tabela.getColumnModel().getColumn(1).setHeaderValue("cor");
            tabela.getColumnModel().getColumn(2).setHeaderValue("codigo");
            tabela.getColumnModel().getColumn(3).setHeaderValue("lugarx");
            tabela.getColumnModel().getColumn(4).setHeaderValue("lugary");
            tabela.getColumnModel().getColumn(5).setHeaderValue("quantidade");
        }

        getContentPane().add(janelaTabela);
        janelaTabela.setBounds(330, 270, 500, 330);

        galeria2122.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/GALERIA21-22_resized.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addComponent(galeria2122, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(galeria2122, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        abas.addTab("Galeria 1", jPanel1);

        galeria2324.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/GALERIA23-24_resized.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(142, Short.MAX_VALUE)
                .addComponent(galeria2324, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(galeria2324, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        abas.addTab("Galeria 2", jPanel2);

        getContentPane().add(abas);
        abas.setBounds(330, 10, 500, 210);

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        getContentPane().add(txtNome);
        txtNome.setBounds(130, 80, 170, 20);

        txtCor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorActionPerformed(evt);
            }
        });
        getContentPane().add(txtCor);
        txtCor.setBounds(130, 110, 170, 19);

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCodigo);
        txtCodigo.setBounds(130, 140, 170, 19);

        txtQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantidadeActionPerformed(evt);
            }
        });
        getContentPane().add(txtQuantidade);
        txtQuantidade.setBounds(130, 170, 170, 20);

        txtLugarx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLugarxActionPerformed(evt);
            }
        });
        getContentPane().add(txtLugarx);
        txtLugarx.setBounds(130, 210, 170, 19);

        txtLugary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLugaryActionPerformed(evt);
            }
        });
        getContentPane().add(txtLugary);
        txtLugary.setBounds(130, 240, 170, 19);

        Nome.setText("Nome");
        getContentPane().add(Nome);
        Nome.setBounds(20, 80, 70, 20);

        Cor.setText("Cor");
        getContentPane().add(Cor);
        Cor.setBounds(20, 110, 70, 20);

        Codigo.setText("Código");
        getContentPane().add(Codigo);
        Codigo.setBounds(20, 140, 70, 20);

        Quantidade.setText("Quantidade");
        getContentPane().add(Quantidade);
        Quantidade.setBounds(20, 170, 100, 20);

        ajudax.setText("Lugar X = números da esquerda à direita");
        getContentPane().add(ajudax);
        ajudax.setBounds(450, 230, 330, 15);

        ajuday.setText("Lugar y = números de cima para baixo");
        getContentPane().add(ajuday);
        ajuday.setBounds(450, 250, 300, 15);

        lugarx1.setText("LugarX");
        getContentPane().add(lugarx1);
        lugarx1.setBounds(20, 210, 50, 20);

        lugary1.setText("LugarY");
        getContentPane().add(lugary1);
        lugary1.setBounds(20, 240, 50, 20);

        imagemFundoPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo_menor.png"))); // NOI18N
        getContentPane().add(imagemFundoPrincipal);
        imagemFundoPrincipal.setBounds(0, 0, 860, 620);

        setSize(new java.awt.Dimension(862, 649));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizartabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizartabelaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAtualizartabelaActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void txtCorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidadeActionPerformed

    private void txtLugaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLugaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLugaryActionPerformed

    private void txtLugarxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLugarxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLugarxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Codigo;
    private javax.swing.JLabel Cor;
    private javax.swing.JLabel Nome;
    private javax.swing.JLabel Quantidade;
    private javax.swing.JTabbedPane abas;
    private javax.swing.JLabel ajudax;
    private javax.swing.JLabel ajuday;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAtualizartabela;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel galeria2122;
    private javax.swing.JLabel galeria2324;
    private javax.swing.JLabel imagemFundoPrincipal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane janelaTabela;
    private javax.swing.JLabel lugarx1;
    private javax.swing.JLabel lugary1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCor;
    private javax.swing.JTextField txtLugarx;
    private javax.swing.JTextField txtLugary;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}