package labs.lab_2;


public class time {
    public double hour_min(double time){
        return time*60;
    }
    public double hour_sec(double time){
        return time*3600;
    }
    public double min_hour(double time){
        return time*0.016;
    }
    public double sec_hour(double time){
        return time *0.0002;
    }
}

