package com.infoobjects.dto;

public class HotelDto extends BaseDto {
    private String staff;
    private String rooms;
    private String available;

    public HotelDto(String code, String name, String staff, String rooms, String available) {
        super(code, name);
        this.staff = staff;
        this.rooms=rooms;
        this.available = available;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "(" +
                "code='" + getCode() + '\'' +
                ", name='" + getName() + '\'' +
                ", rooms='" + getRooms() + '\'' +
                ", staff='" + getStaff() + '\'' +
                ", availability='" + getAvailable() + '\'' +
                ')'+"\n";
    }
}
