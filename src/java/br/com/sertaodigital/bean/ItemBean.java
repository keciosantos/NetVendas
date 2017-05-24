package br.com.sertaodigital.bean;

import br.com.sertaodigital.dao.ItemDao;
import br.com.sertaodigital.entity.Item;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ItemBean {
    
    private Item item = new Item();
    private ItemDao itemDao = new ItemDao();
    private List<Item> listaitem;
    
            
    public ItemBean() {
    }
    
    public String adicinoarCliente(){
        
        item.setId(item.getId());
        item.setProduto(item.getProduto());
        item.setQuant(item.getQuant());
        item.setValor(item.getValor());
        item.setTvalor(item.getTvalor());
        itemDao.addItem(item);
        return "index.jsf";
    }
    public String removercliente(){
        itemDao.removeItem(item);
        return "Removido com Sucesso!";
    }
  
      public List getListarItem(){
          
        return this.itemDao.getList();
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ItemDao getItemDao() {
        return itemDao;
    }

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public List<Item> getListaitem() {
        return listaitem;
    }

    public void setListaitem(List<Item> listaitem) {
        this.listaitem = listaitem;
    }
    
    
}
