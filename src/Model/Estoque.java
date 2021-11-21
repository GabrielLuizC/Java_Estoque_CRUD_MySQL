package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Estoque {
    private int idInsumo;
    private String nomeInsumo;
    private int qntInsumo;
    private double precoInsumo;
    private String data;
    private String recebeData;

    public Estoque(int idInsumo, String nomeInsumo, int qntInsumo, double precoInsumo, String data, String recebeData) {
        this.idInsumo = idInsumo;
        this.nomeInsumo = nomeInsumo;
        this.qntInsumo = qntInsumo;
        this.precoInsumo = precoInsumo;
        this.data = data;
        this.recebeData = recebeData;
    }

    public Estoque() {
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getNomeInsumo() {
        return nomeInsumo;
    }

    public void setNomeInsumo(String nomeInsumo) {
        this.nomeInsumo = nomeInsumo;
    }

    public int getQntInsumo() {
        return qntInsumo;
    }

    public void setQntInsumo(int qntInsumo) {
        this.qntInsumo = qntInsumo;
    }

    public double getPrecoInsumo() {
        return precoInsumo;
    }

    public void setPrecoInsumo(double precoInsumo) {
        this.precoInsumo = precoInsumo;
    }

    public String getData() throws ParseException {
        Scanner scan = new Scanner(System.in);
        String datas = "";
        try{
            System.out.println("Digite a Data de Validade(Formato dd/mm/yyyy - Utilize as Barras): ");
            datas = scan.nextLine();

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            Date dataFormatada = format.parse(datas);

            data = format.format(dataFormatada);
        }catch (Exception e){
            e.printStackTrace();
        }
        return datas;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getRecebeData() {
        return recebeData;
    }

    public void setRecebeData(String recebeData) {
        this.recebeData = recebeData;
    }
}
