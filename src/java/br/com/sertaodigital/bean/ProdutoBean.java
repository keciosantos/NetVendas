
package br.com.sertaodigital.bean;


import br.com.sertaodigital.entity.Produto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ProdutoBean {
    
    private Produto produto = new Produto();
   // private ProdutoDao produtoDao = new ProdutoDao();
    private List<Produto> listaProduto;
    
    public ProdutoBean(){
    }
    public String adicionarProduto(){
        //produtoDao.addProduto(produto);
        produto.setNome(produto.getNome());
        produto.setDescricao(produto.getDescricao());
        produto.setValor(produto.getValor());
        produto.setQuantidade(produto.getQuantidade());
        
        return "index.jsf";
    }
    /*
    public List listaProduto(){
        //listaProduto = produtoDao.getList();
        return this.listaProduto;
    }*/
    public List getListarProduto(){
            Client c= Client.create();
            WebResource wr = c.resource("http://localhost:8080/WS_NetVendas/webresources/NetVEndas/Produto/list");
            String json = wr.get(String.class);

           Gson gson = new Gson();
           return gson.fromJson(json, new TypeToken<List<Produto>>(){}.getType()); 
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
/*
    public ProdutoDao getProdutoDao() {
        return produtoDao;
    }

    public void setProdutoDao(ProdutoDao produtoDao) {
        this.produtoDao = produtoDao;
    }
*/
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.produto);
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
        final ProdutoBean other = (ProdutoBean) obj;
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
}