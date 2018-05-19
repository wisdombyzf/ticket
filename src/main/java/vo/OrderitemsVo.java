package vo;

import javax.persistence.*;
import java.sql.Timestamp;

public class OrderitemsVo
{
    private String id;
    private String flightId;
    private Timestamp date;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getFlightId()
    {
        return flightId;
    }

    public void setFlightId(String flightId)
    {
        this.flightId = flightId;
    }

    public Timestamp getDate()
    {
        return date;
    }

    public void setDate(Timestamp date)
    {
        this.date = date;
    }


}
