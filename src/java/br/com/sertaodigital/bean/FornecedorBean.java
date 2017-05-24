
package br.com.sertaodigital.bean;

import br.com.sertaodigital.entity.Fornecedor;
import br.com.sertaodigital.dao.FornecedorDao;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FornecedorBean implements Serializable{

    private Fornecedor fornecedor = new Fornecedor();
    private FornecedorDao Fornecedordao =new FornecedorDao();
    private List<Fornecedor> listaFornecedor;
    
    public FornecedorBean() {
    }
    
    
       public String adicionarFornecedor(){
           Fornecedordao.addFornecedor(fornecedor);
           fornecedor.setNome(fornecedor.getNome());
           fornecedor.setCnome(fornecedor.getCnome());
           fornecedor.setCnpj(fornecedor.getCnpj());
           fornecedor.setTelefone(fornecedor.getTelefone());
           fornecedor.setEndereco(fornecedor.getEndereco());
           
        return "index.jsf";
       }
            
        public String removerFornecedor(){
            Fornecedordao.removeFornecedor(fornecedor);
            return "Removido com Sucesso!";
        }
        public Fornecedor getListarFornecedor(String nome){
          
        //listacliente = clienteDao.getList();
        FornecedorDao fornecedorDao = new FornecedorDao();
        List lista = fornecedorDao.getListJQL(nome);
        
        return (Fornecedor) lista.get(0);
    }
        public List<Fornecedor> getListaFornecedor(String nome){
        
          
        //listacliente = clienteDao.getList();
        return this.Fornecedordao.getList();
    }
    
    
    

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public FornecedorDao getFornecedordao() {
        return Fornecedordao;
    }

    public void setFornecedordao(FornecedorDao Fornecedordao) {
        this.Fornecedordao = Fornecedordao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.fornecedor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FornecedorBean other = (FornecedorBean) obj;
        return Objects.equals(this.fornecedor, other.fornecedor);
    }
        
        
    
    
}
