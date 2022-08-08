public class MyTime {
    private int hour=0;
    private int minute=0;
    private int second=0;

    public MyTime(){}

    public MyTime(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    public void setTime(int hour, int minute , int second){
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) throws IllegalArgumentException{
        if (hour<0||hour>23){
            throw new IllegalArgumentException();
        }
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) throws IllegalArgumentException {
        if (minute<0||minute>59){
            throw new IllegalArgumentException();
        }
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) throws IllegalArgumentException {
        if (second<0||second>59){
            throw new IllegalArgumentException();
        }
        this.second = second;
    }

    @Override
    public String toString() {
        String leadingHour= String.format("%02",hour);
        String leadingMinute= String.format("%02",minute);
        String leadingSecond= String.format("%02",second);
        return leadingHour+leadingMinute+leadingSecond;
    }

    public MyTime nextSecond(){
        if(this.second==59){
            this.second=0;
            nextMinute();
        }else {
            this.second+=1;
        }
        return this;
    }

    public MyTime nextMinute(){
        if(this.minute==59){
            this.minute=0;
            nextHour();
        }else {
            this.minute+=1;
        }
        return this;
    }

    public MyTime nextHour(){
        if(this.hour==23){
            this.hour=0;
        }else {
            this.hour+=1;
        }
        return this;
    }

    public MyTime previousSecond(){
       if (this.second==0) {
           this.second = 59;
           previousMinute();
       }else {
           this.second-=1;
       }
       return this;
    }

    public MyTime previousMinute(){
        if (this.minute==0) {
            this.minute = 59;
            previousHour();
        }else {
            this.minute-=1;
        }
        return this;
    }

    public MyTime previousHour(){
        if (this.hour==0) {
            this.hour = 23;
        }else {
            this.hour-=1;
        }
        return this;
    }



}
