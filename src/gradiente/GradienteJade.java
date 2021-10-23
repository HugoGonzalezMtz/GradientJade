package gradiente;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class GradienteJade extends Agent{

    protected void setup(){
        
        int x[] = {23,26,30,34,43,48,52,57,58};
        int y[] = {651,762,856,1063,1190,1298,1421,1440,1518};
        
        int n = 9;
        double b0=0, b1=0, a=0.003, Error=0;
        double bta0aux = 0, bta1aux = 0;
        
        Helper beta0 = new Helper();
        Helper beta1 = new Helper();
        Helper error = new Helper();
          
        Error = error.Error(x, y, b0, b1);
        b0 = beta0.Beta0(n, x, y, b0, b1);
        b1 = beta1.Beta1(n, x, y, b0, b1);
        
        while(Error>0){  
            bta0aux = b0; 
            bta1aux = b1; 
            b0 = b0-(a*(beta0.Beta0(n, x, y, b0, b1)));  
            b1 = b1-(a*(beta1.Beta1(n, x, y, b0, b1)));
            Error = error.Error(x, y, b0, b1);
            System.out.println("El resultado es");
            System.out.println(Error+"\n");
        }  
        addBehaviour(new MyOneShotBehaviour());
    }
    
    public class MyOneShotBehaviour extends OneShotBehaviour {
        
        @Override
        public void action() {
            System.out.println("Agent activated");
        }
        
        @Override
        public int onEnd() {
            System.out.println("Agent killed");
            myAgent.doDelete();
            return super.onEnd();
        }
        
    } 
    
}
