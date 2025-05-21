/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package deletebd;

import javax.swing.JOptionPane;
import java.sql.*;

public class DeleteBD {

    static final String banco = "jdbc:mysql://localhost:3306/agenciaviagens";
    
    public static void main(String[] args) {
        Connection conexao = null;
        Statement consulta = null;
        ResultSet resultados = null;
        PreparedStatement minhainclusao = null;
        PreparedStatement minharemocao = null; // Para a remoção
        PreparedStatement minhabusca = null; // Para a busca
        
        try {
            conexao = DriverManager.getConnection(banco, "root", "");
            boolean continuar = true;

            while (continuar) {
                // Tela de diálogo para escolher a ação
                String[] opcoes = {"Inserir", "Excluir", "Buscar", "Sair"};
                int escolha = JOptionPane.showOptionDialog(null, "Escolha uma ação:", "Menu",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
                
                switch (escolha) {
                    case 0: // Inserir
                        minhainclusao = conexao.prepareStatement("Insert into turista(nome, origem, destino) values(?,?,?)");
                        
                        String nome = JOptionPane.showInputDialog(null, "Informe o nome do turista");
                        String origem = JOptionPane.showInputDialog(null, "Informe a sua origem");
                        String destino = JOptionPane.showInputDialog(null, "Informe o seu destino");
                        
                        minhainclusao.setString(1, nome);
                        minhainclusao.setString(2, origem);
                        minhainclusao.setString(3, destino);
                        minhainclusao.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Turista inserido com sucesso!");
                        break;

                    case 1: // Excluir
                        String idParaRemover = JOptionPane.showInputDialog(null, "Informe o ID do turista que deseja excluir");
                        if (idParaRemover != null && !idParaRemover.trim().isEmpty()) {
                            minharemocao = conexao.prepareStatement("DELETE FROM turista WHERE id = ?");
                            minharemocao.setInt(1, Integer.parseInt(idParaRemover));
                            int linhasAfetadas = minharemocao.executeUpdate();
                            
                            if (linhasAfetadas > 0) {
                                JOptionPane.showMessageDialog(null, "Turista excluído com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Nenhum turista encontrado com esse ID.");
                            }
                        }
                        break;

                    case 2: // Buscar
                        String idParaBuscar = JOptionPane.showInputDialog(null, "Informe o ID do turista que deseja buscar");
                        if (idParaBuscar != null && !idParaBuscar.trim().isEmpty()) {
                            minhabusca = conexao.prepareStatement("SELECT * FROM turista WHERE id = ?");
                            minhabusca.setInt(1, Integer.parseInt(idParaBuscar));
                            ResultSet resultadoBusca = minhabusca.executeQuery();
                            
                            if (resultadoBusca.next()) {
                                String dados = "ID: " + resultadoBusca.getInt("id") + "\n" +
                                               "Nome: " + resultadoBusca.getString("nome") + "\n" +
                                               "Origem: " + resultadoBusca.getString("origem") + "\n" +
                                               "Destino: " + resultadoBusca.getString("destino");
                                JOptionPane.showMessageDialog(null, dados);
                            } else {
                                JOptionPane.showMessageDialog(null, "Nenhum turista encontrado com esse ID.");
                            }
                        }
                        break;

                    case 3: // Sair
                        continuar = false;
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                }
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido. Por favor, insira um número.");
        } finally {
            try {
                if (resultados != null) resultados.close();
                if (consulta != null) consulta.close();
                if (conexao != null) conexao.close();
            } catch (Exception erronovo) {
                erronovo.printStackTrace();
            }
        }
    }
}