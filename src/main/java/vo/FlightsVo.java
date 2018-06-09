package vo;


import po.FlightsPo;

import javax.persistence.Basic;
import javax.persistence.Column;

public class FlightsVo
{
    private String id;
    private String flightNo;
    private String startPlace;
    private String endPlace;
    private String time;
    private double price;
    private int seatLeft;
    private String endTime;
    private String discount;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getFlightNo()
    {
        return flightNo;
    }

    public void setFlightNo(String flightNo)
    {
        this.flightNo = flightNo;
    }

    public String getStartPlace()
    {
        return startPlace;
    }

    public void setStartPlace(String startPlace)
    {
        this.startPlace = startPlace;
    }

    public String getEndPlace()
    {
        return endPlace;
    }

    public void setEndPlace(String endPlace)
    {
        this.endPlace = endPlace;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public int getSeatLeft()
    {
        return seatLeft;
    }

    public void setSeatLeft(int seatLeft)
    {
        this.seatLeft = seatLeft;
    }

    public String getEndTime()
    {
        return endTime;
    }

    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }

    public String getDiscount()
    {
        return discount;
    }

    public void setDiscount(String discount)
    {
        this.discount = discount;
    }

}

