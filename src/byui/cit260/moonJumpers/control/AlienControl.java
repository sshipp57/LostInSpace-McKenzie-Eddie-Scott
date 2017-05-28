/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.moonJumpers.control;

/**
 *
 * @author sshipp57
 * 
 * 
 */
public class AlienControl {
    
    public static double calcRunningAway (double finalVelocity, double initialVelocity, double time){
    
        if (finalVelocity <= 0) {
                return -1;
                        }
        if (initialVelocity <= 0 || initialVelocity > 15) {
                return -1;
                        }
        if (time <= 0) {
                return -1;
        }
        
        
         double acceleration = (finalVelocity - initialVelocity) / time;
         
         
         return acceleration;
    }
    public double calcFigthingAlien(double alienAttack, double playerLife){
        if (alienAttack < 0 || alienAttack > 5){
            return -1;
        }
        if (playerLife < 0){
            return -1;
        }
        
        double playerLifeFinal = (playerLife - alienAttack);
        
        if (playerLifeFinal < 0){
            playerLifeFinal = 0;
    }
        
        return playerLifeFinal;
    }
}