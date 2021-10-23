package gradiente;

public class Helper {

    public Helper(){
        
    }
    
    public double Error(int x[],int y[], double bta0, double bta1){
        
        double error = 0;
        double n = 9;
        
        for(int i=0; i<n; i++){    
            error = error + (Math.pow((y[i]-bta0-(bta1*x[i])),2));
        }
        error = error / n;
        return error;
    } 
    
    public double Beta0(int n, int x[], int y[], double bta0, double bta1){
        
        double beta0 = 0;
        
        for(int i = 0; i < n; i++){   
            beta0 = beta0 + (y[i]-(bta0+(bta1*x[i])));
        }
        beta0 = 2*(beta0 / n);
        return beta0;
    } 
    
    public double Beta1(int n, int x[], int y[], double bta0, double bta1){
    
        double beta1 = 0;
        
        for(int i=0; i<n; i++){
            beta1 = beta1 + (x[i]*(y[i]-(bta0+(bta1*x[i]))));
        } 
        beta1 = (-2 * beta1) / n;
        return beta1;
    }  
    
}
