
package br.com.sertaodigital.bean;

import br.com.sertaodigital.entity.Fornecedor;
import br.com.sertaodigital.entity.Cliente;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FornecedorBean implements Serializable{

    private Fornecedor fornecedor = new Fornecedor();
    //private FornecedorDao Fornecedordao =new FornecedorDao();
    private List<Fornecedor> listaFornecedor;
    
    public FornecedorBean() {
    }
    
    
       public String adicionarFornecedor(){
           //Fornecedordao.addFornecedor(fornecedor);
           fornecedor.setNome(fornecedor.getNome());
           fornecedor.setCnome(fornecedor.getCnome());
           fornecedor.setCnpj(fornecedor.getCnpj());
           fornecedor.setTelefone(fornecedor.getTelefone());
           fornecedor.setEndereco(fornecedor.getEndereco());
           
        return "index.jsf";
       }
            
        public String removerFornecedor(){
           //Fornecedordao.removeFornecedor(fornecedor);
            return "Removido com Sucesso!";
        }
        public List getListarFornecedor(){
            Client c= Client.create();
            WebResource wr = c.resource("http://localhost:8080/WS_NetVendas/webresources/NetVEndas/Fornecedor/list");
            String json = wr.get(String.class);

           Gson gson = new Gson();
           return gson.fromJson(json, new TypeToken<List<Fornecedor>>(){}.getType()); 
    } 
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    //public FornecedorDao getFornecedordao() {
      //  return Fornecedordao;
   // }

    //public void setFornecedordao(FornecedorDao Fornecedordao) {
    //    this.Fornecedordao = Fornecedordao;
    //}

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
