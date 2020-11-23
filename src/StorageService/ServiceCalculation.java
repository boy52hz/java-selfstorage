package StorageService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/***
* This is class about service calculation
* @author Chinnawat Kaewnongsang
* @version 1.0
*/
public class ServiceCalculation {
    private double serviceRate;
    /***
    * create service calculation 
    * @param serviceRate
    */
    public ServiceCalculation (double serviceRate){
        this.serviceRate = serviceRate;
    }
    /***
    * Get service fee
    * @param storageArea
    * @return service fee calculated from service rate multiply storage area
    */
    public double getServiceFee(double storageArea){
        return (serviceRate * storageArea);
    }
    /***
     * To get service invoice of the storage
     * @param rentTime
     * @param storageArea
     * @return service fee multiply by rented month
     */
    public double getInvoice(LocalDateTime rentTime, double storageArea) {
        long months = ChronoUnit.MONTHS.between(rentTime, LocalDateTime.now());
        double fee = getServiceFee(storageArea);
        
        if (months <= 0) {
            return fee;
        }
        
        return (fee * months);
    }
} 
