package po;

import javax.persistence.*;

@Entity
@Table(name = "flights", schema = "orderticket", catalog = "")
public class FlightsPo
{
    private String id;
    private String flightNo;
    private String startPlace;
    private String endPlace;
    private String time;
    private double price;
    private int seatLeft;

    @Id
    @Column(name = "ID", nullable = false, length = 20)
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "FLIGHT_NO", nullable = false, length = 20)
    public String getFlightNo()
    {
        return flightNo;
    }

    public void setFlightNo(String flightNo)
    {
        this.flightNo = flightNo;
    }

    @Basic
    @Column(name = "START_PLACE", nullable = false, length = 20)
    public String getStartPlace()
    {
        return startPlace;
    }

    public void setStartPlace(String startPlace)
    {
        this.startPlace = startPlace;
    }

    @Basic
    @Column(name = "END_PLACE", nullable = false, length = 20)
    public String getEndPlace()
    {
        return endPlace;
    }

    public void setEndPlace(String endPlace)
    {
        this.endPlace = endPlace;
    }

    @Basic
    @Column(name = "TIME", nullable = false, length = 11)
    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    @Basic
    @Column(name = "PRICE", nullable = false, precision = 0)
    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    @Basic
    @Column(name = "seatLeft", nullable = false)
    public int getSeatLeft()
    {
        return seatLeft;
    }

    public void setSeatLeft(int seatLeft)
    {
        this.seatLeft = seatLeft;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightsPo flightsPo = (FlightsPo) o;

        if (Double.compare(flightsPo.price, price) != 0) return false;
        if (seatLeft != flightsPo.seatLeft) return false;
        if (id != null ? !id.equals(flightsPo.id) : flightsPo.id != null) return false;
        if (flightNo != null ? !flightNo.equals(flightsPo.flightNo) : flightsPo.flightNo != null) return false;
        if (startPlace != null ? !startPlace.equals(flightsPo.startPlace) : flightsPo.startPlace != null) return false;
        if (endPlace != null ? !endPlace.equals(flightsPo.endPlace) : flightsPo.endPlace != null) return false;
        if (time != null ? !time.equals(flightsPo.time) : flightsPo.time != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (flightNo != null ? flightNo.hashCode() : 0);
        result = 31 * result + (startPlace != null ? startPlace.hashCode() : 0);
        result = 31 * result + (endPlace != null ? endPlace.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + seatLeft;
        return result;
    }
}
