/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Grupo Salinas 170828
 */
public class Cliente extends Persona {
    
    
    private String registroFederalContribuyentes;

    @Override
    public String display(){
        return "";
    }

    public String getRegistroFederalContribuyentes() {
        return registroFederalContribuyentes;
    }

    public void setRegistroFederalContribuyentes(String registroFederalContribuyentes) {
        this.registroFederalContribuyentes = registroFederalContribuyentes;
    }
    
    
    
}
