package StorageService;

public class ServiceCalculation {
    private double serviceRate;

    public ServiceCalculation (double serviceRate){
        this.serviceRate = serviceRate;
    }

    public double getServiceFee(double storageArea){
        return (serviceRate * storageArea);
    }

} 
