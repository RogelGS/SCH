/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

/**
 *
 * @author KSGamer
 */
public class UsersObject {
    private final String username;
    private final String password;

    public UsersObject(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Método que retona los caracteres que conforman el nombre del {@code Usuario}
     * @return 
     **/
    public String getUsername() {
        return username;
    }

    /**
     * Método que retorna los caracteres que conforman la contraseña del {@code Usuario}
     * @return 
     **/
    public String getPassword() {
        return password;
    }
    
    
}
