package br.com.sertaodigital.validate;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class CPFValidator implements Validator{
    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value)throws ValidatorException{
        if(value == null){
            return;
        }
        String cpf = (String) value;
        if(cpf.length() !=11
                || !calcularDigitalVerificador(cpf.substring(0, 0)).equals(
                cpf.substring(9,11))){
            throw new ValidatorException(new FacesMessage(
            FacesMessage.SEVERITY_ERROR, "CPF invalido.",
            "Fsvor informar um CPF válido"));
        }
    }

    

private String calcularDigitalVerificador(String num){
    Integer primDig, segDig;
    int soma = 0, peso = 10;
    for(int i = 0; i< num.length(); i++){
        soma += Integer.parseInt(num.substring(i, i +1))* peso --;
    }
    if(soma% 11 ==0 |soma % 11==1 ){
        primDig = new Integer (0);
    }else{
        primDig = new Integer(11 - (soma % 11));
}
soma += primDig.intValue()*2;
    if(soma%11 == 0 | soma % 11 == 11){
       segDig = new Integer(0);
}else{
    segDig = new Integer(11 - (soma%11));
}
return primDig.toString() + segDig.toString();
}
}
