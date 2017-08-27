package br.com.avaliacao.util;



import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

public class UfUtil {

	public static List<SelectItem> getUfList(){
		
		List<SelectItem> ufList = new ArrayList<>();
		 
		ufList.add(new SelectItem(null,"Selecione..."));
		ufList.add(new SelectItem("Acre - AC","Acre - AC"));
		ufList.add(new SelectItem("Alagoas	- AL","Alagoas	- AL"));
		ufList.add(new SelectItem("Amapá - AP","Amapá - AP"));
		ufList.add(new SelectItem("Amazonas - AM","Amazonas - AM"));
		ufList.add(new SelectItem("Bahia -	BA","Bahia -	BA"));
		ufList.add(new SelectItem("Ceará -	CE","Ceará -	CE"));
		ufList.add(new SelectItem("Distrito Federal - DF","Distrito Federal - DF"));
		ufList.add(new SelectItem("Espírito Santo - ES","Espírito Santo - ES"));
		ufList.add(new SelectItem("Goiás - GO","Goiás - GO"));
		ufList.add(new SelectItem("Maranhão - MA","Maranhão - MA"));
		ufList.add(new SelectItem("Mato Grosso	- MT","Mato Grosso	- MT"));
		ufList.add(new SelectItem("Mato Grosso do Sul - MS","Mato Grosso do Sul - MS"));
		ufList.add(new SelectItem("Minas Gerais - MG","Minas Gerais - MG"));
		ufList.add(new SelectItem("Pará - PA","Pará - PA"));
		ufList.add(new SelectItem("Paraíba - PB","Paraíba - PB"));
		ufList.add(new SelectItem("Paraná - PR","Paraná - PR"));
		ufList.add(new SelectItem("Pernambuco - PE","Pernambuco - PE"));
		ufList.add(new SelectItem("Piauí - PI","Piauí - PI"));
		ufList.add(new SelectItem("Rio de Janeiro - RJ","Rio de Janeiro - RJ"));
		ufList.add(new SelectItem("Rio Grande do Norte - RN","Rio Grande do Norte - RN"));
		ufList.add(new SelectItem("Rio Grande do Sul - RS","Rio Grande do Sul - RS"));
		ufList.add(new SelectItem("Rondônia - RO","Rondônia - RO"));
		ufList.add(new SelectItem("Santa Catarina - SC","Santa Catarina - SC"));
		ufList.add(new SelectItem("São Paulo - SP","São Paulo - SP"));
		ufList.add(new SelectItem("Sergipe	 - SE","Sergipe	 - SE"));
		ufList.add(new SelectItem("Tocantins -TO","Tocantins -TO"));
		return ufList;
	}

}
