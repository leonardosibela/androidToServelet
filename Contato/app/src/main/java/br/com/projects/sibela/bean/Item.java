package br.com.projects.sibela.bean;

import org.json.JSONException;
import org.json.JSONObject;

public class Item {

    private int idItem;
    private int idLista;
    private long quantidade;
    private Produto produto;
    private boolean checado;

    public Item() {
        produto = new Produto();
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(long quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public boolean isChecado() {
        return checado;
    }

    public void setChecado(boolean checado) {
        this.checado = checado;
    }

    @Override
    public String toString() {
        return produto.getNome() + " Apolo viado";
    }

    public JSONObject toJSON() throws JSONException {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("idItem" , idItem);
        jsonObject.put("idLista" , idLista);
        jsonObject.put("checado" , checado);
        jsonObject.put("quantidade" , quantidade);
        jsonObject.put("produtoCodigoBarras" , produto.getCodigoBarras());
        jsonObject.put("produtoNome" , produto.getNome());

        return jsonObject;
    }

    public String toStringJSON() throws JSONException {

        StringBuilder json = new StringBuilder();

        json.append("{  idItem      : \"" + idItem + "\",");
        json.append("   idLista     : \"" + idLista + "\",");
        json.append("   quantidade  : \"" + quantidade + "\",");
        json.append("   checado : \"" + checado + "\",");
        json.append("   Produto {   codigoBarras    : \"" + produto.getCodigoBarras() + "\",");
        json.append("               nome            : \"" + produto.getNome() + "\",");
        json.append("               decimal            : \"" + produto.isDecimal() + "\"");
        json.append("           }");
        json.append("}");

        JSONObject jsonObject = new JSONObject(json.toString());

        return json.toString();
    }

}
