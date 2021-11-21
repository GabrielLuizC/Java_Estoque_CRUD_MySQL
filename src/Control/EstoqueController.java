package Control;

import DAO.EstoqueDAO;
import Model.Estoque;

import java.text.ParseException;
import java.util.List;

public class EstoqueController{
    public void cadastrarEstoque(Estoque estoque) throws ParseException{
        EstoqueDAO estoqueDAO = new EstoqueDAO();
        estoqueDAO.cadastrarEstoque(estoque);
    }

    public List<Estoque> listarEstoque(){
        EstoqueDAO estoqueDAO = new EstoqueDAO();
        return estoqueDAO.listarBanco();
    }

    public void editarEstoque(Estoque estoque, int escolhe) throws ParseException{
        EstoqueDAO estoqueDAO = new EstoqueDAO();
        switch (escolhe){
            case 1:
                estoqueDAO.editarNome(estoque);
                break;
            case 2:
                estoqueDAO.editarQuantidade(estoque);
                break;
            case 3:
                estoqueDAO.editarPreco(estoque);
                break;
            case 4:
                estoqueDAO.editarValidade(estoque);
                break;
            case 5:
                estoqueDAO.editarEstoque(estoque);
                break;
        }
    }

    public void excluirEstoque(Estoque estoque){
        EstoqueDAO estoqueDAO = new EstoqueDAO();
        estoqueDAO.excluirEstoque(estoque);
    }
}
