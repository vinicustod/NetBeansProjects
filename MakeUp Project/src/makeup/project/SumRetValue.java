/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makeup.project;

import java.util.Stack;

/**
 *
 * @author lucasmarques
 */
public class SumRetValue {
    private boolean success;
    private String result;
    private String error_message;

    
    /**
     * @return the success
     */
    
    public boolean isSucess() {
        return success;
    }

    /**
     * @param sucess the success to set
     */
    public void setSucess(boolean sucess) {
        this.success = sucess;
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @return the error_message
     */
    public String getError_message() {
        return error_message;
    }

    /**
     * @param error_message the error_message to set
     */
    public void setError_message(String error_message) {
        this.error_message = error_message;
    }
    
}
