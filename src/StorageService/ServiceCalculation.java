package StorageService;
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

} 
